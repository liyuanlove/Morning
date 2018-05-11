package org.pussinboots.morning.support.factory;

import org.pussinboots.morning.support.common.enums.CloudServiceEnum;
import org.pussinboots.morning.support.service.IBaseCloudStorageService;

/**
 * 
* 项目名称：morning-support-facade   
* 类名称：CloudStorageFactory   
* 类描述：CloudStorageFactory 云存储工厂类接口   
* 创建人：陈星星   
* 创建时间：2017年7月30日 下午10:11:59   
*
 */
public interface CloudStorageFactory {
	
	/**
	 * 获取云存储处理器
	 * 
	 * @param cloudServiceEnum				云存储名称
	 * @return IBaseCloudStorageService		云存储上传文件基类接口
	 */
	IBaseCloudStorageService getBaseCloudStorageService(CloudServiceEnum cloudServiceEnum);

}
