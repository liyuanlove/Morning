package org.pussinboots.morning.support.common.exception;

import org.pussinboots.morning.common.exception.BaseException;
import org.pussinboots.morning.common.exception.ReturnCode;

/**
 * 
* 项目名称：morning-support-facade   
* 类名称：OSSException   
* 类描述：OSSException 云存储异常      
* 创建人：陈星星   
* 创建时间：2017年7月11日 下午6:54:25   
*
 */
public class OSSException extends BaseException {
	
	private static final long serialVersionUID = 1L;
	
	/** 返回状态码 */
	private Integer code;
	
	public OSSException() {
		super();
	}
	
	public OSSException(String message) {
		super(message);
	}
	
	public OSSException(Throwable cause) {
		super(cause);
	}
	
	public OSSException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public OSSException(Integer code, String message) {
		super(message);
		this.code = code;
	}
	
	public OSSException(ReturnCode returnCode) {
		super(returnCode.getMessage());
		this.code = returnCode.getCode();
	}
	
	public OSSException(ReturnCode returnCode, Throwable cause) {
		super(returnCode.getMessage(), cause);
		this.code = returnCode.getCode();
	}
	
	public OSSException(Integer code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
