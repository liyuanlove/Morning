package org.pussinboots.morning.support.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.pussinboots.morning.support.common.constant.OSSReturnCode;
import org.pussinboots.morning.support.common.enums.CloudServiceEnum;
import org.pussinboots.morning.support.common.exception.OSSException;
import org.pussinboots.morning.support.common.util.FileUtils;
import org.pussinboots.morning.support.entity.ImageLog;
import org.pussinboots.morning.support.mapper.ImageLogMapper;
import org.pussinboots.morning.support.service.IAliyunCloudStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;

/**
 * 
* 项目名称：morning-support-service   
* 类名称：AliyunCloudStorageServiceImpl   
* 类描述：AliyunCloudStorageServiceImpl 阿里云云存储上传文件接口实现   
* 修改人：南蛮麟爷
*
 */
@Service
public class AliyunCloudStorageServiceImpl implements IAliyunCloudStorageService {
	
	@Value("${aliyun.accessKeyId}")
	private String accessKeyId;
	
	@Value("${aliyun.accessKeySecret}")
	private String accessKeySecret;
	
	@Value("${aliyun.bucketName}")
	private String bucketName;	

	@Value("${aliyun.endpoint}")
	private String endpoint;	
	
	private OSSClient ossClient;
	
	@Autowired
	private ImageLogMapper imageLogMapper;
	
	private void init() {
		ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}
	
	@Override
	public CloudServiceEnum getCloudServiceType() {
		return CloudServiceEnum.ALIYUN;
	}

	@Override
	public String getUploadToken() throws OSSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageLog upload(byte[] data, String belong, String sourceFileName) throws OSSException {
		ImageLog imageLog;
		try {
			// 初始化上传对象
			init();
			// 上传文件
			String fileName = FileUtils.getFileName(belong, sourceFileName);
			ossClient.putObject(bucketName, fileName, new ByteArrayInputStream(data));
			// 获取文件的全部元信息
			ObjectMetadata metadata = ossClient.getObjectMetadata(bucketName, fileName);
			// 对上传的文件进行记录
			imageLog = new ImageLog();
			imageLog.setCreateTime(new Date());
			imageLog.setBucket(bucketName);
			imageLog.setEtag(metadata.getETag());
			imageLog.setName(fileName);
			imageLog.setFileSize(metadata.getContentLength());
			imageLog.setMimeType(metadata.getContentType());
			imageLog.setImageUrl(FileUtils.getImageUrl(endpoint, fileName));
			imageLog.setCloudName(CloudServiceEnum.ALIYUN.getName());
			imageLog.setBelong(belong);
			imageLogMapper.insert(imageLog);
		} catch (Exception e) {
			// 抛出一个配置出错的异常
			throw new OSSException(OSSReturnCode.CONFIGURATION_INFORMATION_ERROR.getCode(), e.getMessage());
		}finally {
			// 关闭client
			ossClient.shutdown();
		}
		return imageLog;
	}

	@Override
	public ImageLog upload(InputStream inputStream, String belong, String sourceFileName) throws OSSException {
		ImageLog imageLog;
		try {
			// 初始化上传对象
			init();
			// 上传文件
			String fileName = FileUtils.getFileName(belong, sourceFileName);
			ossClient.putObject(bucketName, fileName, inputStream);
			// 获取文件的全部元信息
			ObjectMetadata metadata = ossClient.getObjectMetadata(bucketName, fileName);
			// 对上传的文件进行记录
			imageLog = new ImageLog();
			imageLog.setCreateTime(new Date());
			imageLog.setBucket(bucketName);
			imageLog.setEtag(metadata.getETag());
			imageLog.setName(fileName);
			imageLog.setFileSize(metadata.getContentLength());
			imageLog.setMimeType(metadata.getContentType());
			imageLog.setImageUrl(FileUtils.getImageUrl(endpoint, fileName));
			imageLog.setCloudName(CloudServiceEnum.ALIYUN.getName());
			imageLog.setBelong(belong);
			imageLogMapper.insert(imageLog);
		} catch (Exception e) {
			// 抛出一个配置出错的异常
			throw new OSSException(OSSReturnCode.CONFIGURATION_INFORMATION_ERROR.getCode(), e.getMessage());
		}finally {
			// 关闭client
			ossClient.shutdown();
		}

		return imageLog;

	}
}
