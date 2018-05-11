package org.pussinboots.morning.support.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.pussinboots.morning.support.common.enums.CloudServiceEnum;
import org.pussinboots.morning.support.common.exception.OSSException;
import org.pussinboots.morning.support.entity.ImageLog;

/**
 * 
* 项目名称：morning-support-facade   
* 类名称：IBaseCloudStorageService   
* 类描述：IBaseCloudStorageService 云存储上传文件基类接口   
* 创建人：陈星星   
* 创建时间：2017年7月30日 下午10:19:37   
*
 */
public interface IBaseCloudStorageService {
	
	/**
	 * 获取处理器类型
	 * @return
	 */
	CloudServiceEnum getCloudServiceType();
	
	/**
	 * 获取上传凭证
	 * 
	 * @return 上传凭证
	 * @throws OSSException
	 */
	String getUploadToken() throws OSSException;

    /**
     * 字节数组上传,可以支持将内存中的字节数组上传到空间中
     * 
     * @param data         文件字节数组
     * @param belong       文件所属类
     * @param fileName     原文件名字
     * @return ImageLog    云存储图片记录表
     * @throws OSSException 
     */
	ImageLog upload(byte[] data, String belong, String fileName) throws OSSException;


    /**
     * 数据流上传,InputStream对象的上传
     * 
     * @param inputStream   文件字节流
     * @param belong        文件所属类
     * @param fileName     原文件名字     
     * @return ImageLog     云存储图片记录表
     * @throws UnsupportedEncodingException 
     */
	ImageLog upload(InputStream inputStream, String belong, String fileName) throws OSSException;

}
