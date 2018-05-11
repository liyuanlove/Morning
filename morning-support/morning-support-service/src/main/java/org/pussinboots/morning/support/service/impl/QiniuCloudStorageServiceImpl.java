package org.pussinboots.morning.support.service.impl;

import java.io.InputStream;
import java.util.Date;

import org.pussinboots.morning.support.common.constant.OSSReturnCode;
import org.pussinboots.morning.support.common.enums.CloudServiceEnum;
import org.pussinboots.morning.support.common.exception.OSSException;
import org.pussinboots.morning.support.common.util.FileUtils;
import org.pussinboots.morning.support.entity.ImageLog;
import org.pussinboots.morning.support.entity.QiniuPutRet;
import org.pussinboots.morning.support.mapper.ImageLogMapper;
import org.pussinboots.morning.support.service.IQiniuCloudStorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * 
* 项目名称：morning-support-service   
* 类名称：QiniuCloudStorageServiceImpl   
* 类描述：QiniuCloudStorageServiceImpl 七牛云云存储上传文件接口实现
* 创建人：陈星星   
* 创建时间：2017年7月11日 下午11:52:23   
*
 */
@Service
public class QiniuCloudStorageServiceImpl implements IQiniuCloudStorageService {
	
	@Value("${qiniu.accessKey}")
	private String accessKey;

	@Value("${qiniu.secretKey}")
	private String secretKey;

	@Value("${qiniu.address}")
	private String address;

	@Value("${qiniu.bucketName}")
	private String bucketName;

	private UploadManager uploadManager;
	
	@Autowired
	private ImageLogMapper imageLogMapper;
	
	private void init() {
		// 构造一个带指定Zone对象的配置类
		Configuration configuration = new Configuration(Zone.autoZone());
		// 创建上传对象
		uploadManager = new UploadManager(configuration);
	}
	
	@Override
	public CloudServiceEnum getCloudServiceType() {
		return CloudServiceEnum.QINIU;
	}
	
	public String getUploadToken() throws OSSException {
		String upToken;
		try {
			StringMap putPolicy = new StringMap();
			putPolicy.put("returnBody",
					"{\"name\":\"$(key)\",\"etag\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fileSize\":$(fsize),"
							+ "\"mimeType\":\"$(mimeType)\",\"width\":\"$(imageInfo.width)\","
							+ "\"width\":\"$(imageInfo.width)\",\"height\":\"$(imageInfo.height)\"}");
			long expireSeconds = 3600;
			// 密钥配置
			Auth auth = Auth.create(accessKey, secretKey);
			// 生成上传凭证，然后准备上传
			upToken = auth.uploadToken(bucketName, null, expireSeconds, putPolicy);
		} catch (Exception e) {
			throw new OSSException(OSSReturnCode.CONFIGURATION_INFORMATION_ERROR.getCode(), e.getMessage());
		}
		return upToken;
	}

	public ImageLog upload(byte[] data, String belong, String sourceFileName) throws OSSException {
		ImageLog imageLog;
		try {
			// 获取上传凭证
			String upToken = getUploadToken();
			// 初始化上传对象
			init();
			// 上传文件,默认不指定key的情况下，以文件内容的hash值作为文件名
			Response response = uploadManager.put(data, FileUtils.getFileName(belong, sourceFileName), upToken);
			// 解析上传成功的结果
			QiniuPutRet qiniuPutRet = new Gson().fromJson(response.bodyString(), QiniuPutRet.class);
			if (!response.isOK()) {
				// 上传错误,向上抛出响应的文本信息
				throw new OSSException(OSSReturnCode.UPLOADING_ERROR.getCode(), response.toString());
			} else {
				// 对上传的文件进行记录
				imageLog = new ImageLog();
				BeanUtils.copyProperties(qiniuPutRet, imageLog);
				imageLog.setCreateTime(new Date());
				imageLog.setImageUrl(FileUtils.getImageUrl(address, qiniuPutRet.getName()));
				imageLog.setCloudName(CloudServiceEnum.QINIU.getName());
				imageLog.setBelong(belong);
				imageLogMapper.insert(imageLog);
			}
		} catch (Exception e) {
			// 抛出一个配置出错的异常
			throw new OSSException(OSSReturnCode.CONFIGURATION_INFORMATION_ERROR.getCode(), e.getMessage());
		}
		return imageLog;
	}
	
	@Override
	public ImageLog upload(InputStream inputStream, String belong, String sourceFileName) throws OSSException {
		ImageLog imageLog;
		try {
			// 获取上传凭证
			String upToken = getUploadToken();
			// 初始化上传对象
			init();
			// 上传文件,默认不指定key的情况下，以文件内容的hash值作为文件名
			Response response = uploadManager.put(inputStream, FileUtils.getFileName(belong, sourceFileName), upToken,
					null, null);
			// 解析上传成功的结果
			QiniuPutRet qiniuPutRet = new Gson().fromJson(response.bodyString(), QiniuPutRet.class);
			if (!response.isOK()) {
				// 上传错误,向上抛出响应的文本信息
				throw new OSSException(OSSReturnCode.UPLOADING_ERROR.getCode(), response.toString());
			} else {
				// 对上传的文件进行记录
				imageLog = new ImageLog();
				BeanUtils.copyProperties(qiniuPutRet, imageLog);
				imageLog.setCreateTime(new Date());
				imageLog.setImageUrl(FileUtils.getImageUrl(address, qiniuPutRet.getName()));
				imageLog.setCloudName(CloudServiceEnum.QINIU.getName());
				imageLog.setBelong(belong);
				imageLogMapper.insert(imageLog);
			}
		} catch (Exception e) {
			// 抛出一个配置出错的异常
			throw new OSSException(OSSReturnCode.CONFIGURATION_INFORMATION_ERROR.getCode(), e.getMessage());
		}
		return imageLog;
	}
}
