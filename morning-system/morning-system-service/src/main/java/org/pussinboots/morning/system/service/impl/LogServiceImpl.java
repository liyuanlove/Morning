package org.pussinboots.morning.system.service.impl;

import java.util.List;

import org.pussinboots.morning.common.base.BasePageDTO;
import org.pussinboots.morning.common.support.page.PageInfo;
import org.pussinboots.morning.system.entity.Log;
import org.pussinboots.morning.system.mapper.LogMapper;
import org.pussinboots.morning.system.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * 
* 项目名称：morning-system-service   
* 类名称：LogServiceImpl   
* 类描述：Log / 日志记录表 业务逻辑层接口实现   
* 创建人：陈星星   
* 创建时间：2017年6月9日 上午10:26:58   
*
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {
	
	@Autowired
	private LogMapper logMapper;

	@Override
	public BasePageDTO<Log> listByPage(PageInfo pageInfo, String search) {
		Page<Log> page = new Page<>(pageInfo.getCurrent(), pageInfo.getLimit());
		List<Log> adverts = logMapper.listByPage(pageInfo, search, page);
		pageInfo.setTotal(page.getTotal());
		return new BasePageDTO<Log>(pageInfo, adverts);
	}
	
}
