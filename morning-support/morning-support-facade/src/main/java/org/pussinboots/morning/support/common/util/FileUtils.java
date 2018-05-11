package org.pussinboots.morning.support.common.util;

import java.util.Date;

import org.pussinboots.morning.common.util.DateUtils;
import org.pussinboots.morning.common.util.RandomUtils;


/**
 * 
* 项目名称：morning-support-facade   
* 类名称：FileUtils   
* 类描述：FileUtils工具类：提供一些文件操作的方法   
* 修改人：南蛮麟爷
*
 */
public class FileUtils {
	
	/**
	 * 分割符号
	 */
	public static final String SPLIT_SYMBOL = "_";
	
	private FileUtils() {
		throw new AssertionError();
	}
	
    /**
     * 根据文件所属类获取文件名称
     * @param belong          文件存放归属
     * @param sourceFileName  原文件名字
     * @return                返回上传路径
     */
	public static String getFileName(String belong, String sourceFileName) {
		StringBuilder fileName = new StringBuilder();
		// 文件存放归属
		fileName.append(belong);
		// 文件时间
		fileName.append(SPLIT_SYMBOL);
		fileName.append(DateUtils.format(new Date(), "yyyyMMdd"));
		// 文件随机名称
		fileName.append(SPLIT_SYMBOL);
		fileName.append(RandomUtils.uuid());
		// 获取文件类型
		fileName.append(sourceFileName.substring(sourceFileName.lastIndexOf('.')));
		return fileName.toString();
	}
	
	/**
	 * 根据云存储系统域名以及文件名获取文件外链地址
	 * @param address		云存储系统域名
	 * @param fileName      文件名
	 * @return              文件外链地址
	 */
	public static String getImageUrl(String address, String fileName) {
		StringBuilder imageUrl = new StringBuilder();
		// 云存储系统域名
		imageUrl.append(address);
		// 分隔符
		imageUrl.append("/");
		// 资源名字
		imageUrl.append(fileName);
		return imageUrl.toString();
	}
}
