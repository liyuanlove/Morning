package org.pussinboots.morning.system.service;

import org.pussinboots.morning.common.base.BasePageDTO;
import org.pussinboots.morning.common.support.page.PageInfo;
import org.pussinboots.morning.system.entity.Log;
import com.baomidou.mybatisplus.service.IService;

/**
 * 
* 项目名称：morning-system-facade   
* 类名称：ILogService   
* 类描述：Log / 日志记录表 业务逻辑层接口      
* 创建人：陈星星   
* 创建时间：2017年6月9日 上午10:26:12   
*
 */
public interface ILogService extends IService<Log> {
	
	/**
	 * 根据分页信息/搜索内容查找日志记录列表
	 * @param pageInfo 分页信息
	 * @param search 搜索内容
	 * @return
	 */
	BasePageDTO<Log> listByPage(PageInfo pageInfo, String search);
	
}
