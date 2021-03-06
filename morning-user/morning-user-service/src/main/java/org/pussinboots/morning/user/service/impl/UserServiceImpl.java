package org.pussinboots.morning.user.service.impl;

import java.util.Date;
import java.util.List;

import org.pussinboots.morning.common.constant.CommonReturnCode;
import org.pussinboots.morning.common.enums.StatusEnum;
import org.pussinboots.morning.common.exception.ValidateException;
import org.pussinboots.morning.user.common.util.PasswordUtils;
import org.pussinboots.morning.user.common.util.UserUtils;
import org.pussinboots.morning.user.entity.User;
import org.pussinboots.morning.user.entity.UserLoginLog;
import org.pussinboots.morning.user.mapper.UserLoginLogMapper;
import org.pussinboots.morning.user.mapper.UserMapper;
import org.pussinboots.morning.user.pojo.vo.UserVO;
import org.pussinboots.morning.user.service.IUserService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
* 项目名称：morning-user-service   
* 类名称：UserServiceImpl   
* 类描述：User / 用户表 业务逻辑层接口实现   
* 修改人：南蛮麟爷
*
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserLoginLogMapper userLoginLogMapper;

	/**
	 * 添加用户
	 * @param user 用户信息
	 * @return
	 * @throws ValidateException
	 */
	@Override
	public Integer insertUser(User user) throws ValidateException {
		// 邮箱唯一性验证（邮箱存在且已经被激活）
		User queryUser = new User();
		queryUser.setEmail(user.getEmail());
		User emailUser = userMapper.selectOne(queryUser);
		if (emailUser != null && StatusEnum.ACTIVATED.getStatus().equals(emailUser.getEmailIsActive())) {
			throw new ValidateException(CommonReturnCode.BAD_REQUEST.getCode(), "该电子邮箱已被注册了");
		}
		if (emailUser != null && StatusEnum.NONACTIVATED.getStatus().equals(emailUser.getEmailIsActive())) {
			userMapper.deleteById(emailUser.getUserId()); // 如果未被激活则删除用户
		}
		user.setUserNumber(UserUtils.getUserNumber());
		user.setSalt(PasswordUtils.getSalt());
		user.setPicImg(UserUtils.getPicImg());
		user.setRegeistTime(new Date());
		user.setCreateBy(user.getUserName());
		user.setLoginPassword(PasswordUtils.getMd5(user.getLoginPassword(), user.getUserNumber(), user.getSalt()));
		return userMapper.insert(user);
	}

	/**
	 *
	 * @param loginName 手机号码/邮箱
	 * @return
	 */
	@Override
	public User getByLoginName(String loginName) {
		return userMapper.getByLoginName(loginName);
	}

	/**
	 *
	 * @param email 电子邮箱
	 * @return
	 */
	@Override
	public User getByEmail(String email) {
		User user = new User();
		user.setEmail(email);
		return userMapper.selectOne(user);
	}

	/**
	 *
	 * @param userId 用户ID
	 * @return
	 */
	@Override
	public UserVO getById(Long userId) {
		UserVO userVO = userMapper.getById(userId);
		userVO.setTelephone(UserUtils.encryptTelephone(userVO.getTelephone()));
		userVO.setEmail(UserUtils.encryptEmail(userVO.getEmail()));
		return userVO;
	}

	/**
	 *
	 * @param userId 用户ID
	 * @param userLoginLog 用户登录日志
	 * @return
	 */
	@Override
	public Integer updateLogById(Long userId, UserLoginLog userLoginLog) {

		// 创建用户登录日志
		userLoginLogMapper.insert(userLoginLog);
		
		// 更新用户登录日志
		User user = new User();
		user.setUserId(userId);
		user.setLastLoginIp(userLoginLog.getUserIp());
		user.setLastLoginTime(new Date());
		return userMapper.updateById(user);
	}

	/**
	 *
	 * @param email 邮箱号码
	 * @return
	 */
	@Override
	public Integer updateEmailActive(String email) {
		User user = new User();
		user.setEmailIsActive(StatusEnum.ACTIVATED.getStatus());
		user.setUpdateTime(new Date());
		user.setUpdateBy(email);

		User queryUser = new User();
		queryUser.setEmail(email);
		return userMapper.update(user, new EntityWrapper<User>(queryUser));
	}

	/**
	 *
	 * @param email 邮箱
	 * @param telephone 手机号码
	 * @param realName 真实姓名
	 * @return
	 * @throws ValidateException
	 */
	@Override
	public Integer updatePerfectUser(String email, String telephone, String realName) throws ValidateException {
		// 判断手机唯一性
		User user = new User();
		user.setTelephone(telephone);
		if (userMapper.selectCount(new EntityWrapper<User>(user)) > 0) {
			throw new ValidateException(CommonReturnCode.BAD_REQUEST.getCode(), "该手机号码已被注册了!");
		}
		// 完善个人信息
		user.setRealName(realName);
		user.setUpdateTime(new Date());
		user.setUpdateBy(email);
		
		User queryUser = new User();
		queryUser.setEmail(email);
		return userMapper.update(user, new EntityWrapper<User>(queryUser));
	}

	/**
	 *
	 * @param loginPassword 登录密码
	 * @param email 电子邮箱
	 * @return
	 */
	@Override
	public Integer updatePasswordByEmail(String loginPassword, String email) {
		User user = userMapper.getByLoginName(email);
		user.setLoginPassword(PasswordUtils.getMd5(loginPassword, user.getUserNumber(), user.getSalt()));
		user.setUpdateTime(new Date());
		user.setUpdateBy(user.getUserName());
		return userMapper.updateById(user);
	}

}
