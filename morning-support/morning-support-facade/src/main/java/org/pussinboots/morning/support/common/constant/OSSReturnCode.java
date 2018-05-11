package org.pussinboots.morning.support.common.constant;

import org.pussinboots.morning.common.exception.ReturnCode;

/**
 * 
* 项目名称：morning-support-facade   
* 类名称：OSSReturnCode   
* 类描述：   
* 创建人：陈星星   
* 创建时间：2017年7月11日 下午7:06:51   
*
 */
public enum OSSReturnCode implements ReturnCode {
	
	/**
	 * 6001, "上传到云存储系统过程出错"
	 */
	UPLOADING_ERROR(6001, "上传到云存储系统过程出错."), 
	/**
	 * 6002, "云存储系统配置信息出错"
	 */
	CONFIGURATION_INFORMATION_ERROR(6002, "云存储系统配置信息出错.");

	/** 返回状态码 */
	private Integer code;

	/** 返回消息 */
	private String message;
	
	private OSSReturnCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
