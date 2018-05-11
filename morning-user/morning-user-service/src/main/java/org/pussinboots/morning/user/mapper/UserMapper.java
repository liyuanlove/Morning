package org.pussinboots.morning.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.pussinboots.morning.user.entity.User;
import org.pussinboots.morning.user.pojo.vo.UserVO;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 
* 项目名称：morning-user-service   
* 类名称：UserMapper   
* 类描述：User / 用户表 数据访问层接口       
* 创建人：南蛮麟爷
*
 */
public interface UserMapper extends BaseMapper<User> {
	
	/**
	 * 根据登录名查找用户信息
	 * @param loginName 手机号码/邮箱
	 * @return
	 */
	User getByLoginName(String loginName);
	
	/**
	 * 根据用户ID查找用户显示信息
	 * @param userId 用户ID
	 * @return
	 */
	UserVO getById(Long userId);


}