package org.pussinboots.morning.cms.controller.common;

import org.pussinboots.morning.cms.common.result.CmsResult;
import org.pussinboots.morning.cms.common.util.ServletUtils;
import org.pussinboots.morning.common.base.BaseController;
import org.pussinboots.morning.common.constant.CommonReturnCode;
import org.pussinboots.morning.common.enums.WebSiteFileBelongEnum;
import org.pussinboots.morning.common.support.upload.UploadManager;
import org.pussinboots.morning.common.support.upload.UploadResult;
import org.pussinboots.morning.support.common.enums.CloudServiceEnum;
import org.pussinboots.morning.support.factory.CloudStorageFactory;
import org.pussinboots.morning.support.service.IBaseCloudStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import io.swagger.annotations.Api;

/**
 * 
* 项目名称：morning-cms-web Maven Webapp   
* 类名称：UploadController   
* 类描述：文件上传表示层控制器   
* 修改：南蛮麟爷
*
 */
@Controller
@RequestMapping(value="/uploads")
@Api(value = "文件上传", description = "文件上传")
public class UploadController extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Autowired
	private CloudStorageFactory cloudStorageFactory;
	
	/**
	 * POST 广告图片上传
	 * @return
	 */
	@PostMapping(value = "/demo", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object uploadDemo(MultipartFile multipartFile) {
		if (!multipartFile.isEmpty()) {
			try {
				// 判断文件的MIMEtype
				String type = multipartFile.getContentType();
				if (type == null || !type.toLowerCase().startsWith("image/")) {
					return new CmsResult(CommonReturnCode.BAD_REQUEST.getCode(), "不支持的文件类型，仅支持图片!");
				}
				IBaseCloudStorageService baseCloudStorageService = cloudStorageFactory
						.getBaseCloudStorageService(CloudServiceEnum.QINIU);
				baseCloudStorageService.upload(multipartFile.getBytes(), "morning",
						multipartFile.getOriginalFilename());

			} catch (Exception e) {
				logger.error("ImageUploadController.uploadHeadPortrait={}", e);
				return new CmsResult(CommonReturnCode.UNKNOWN_ERROR);
			}
		}
		return new CmsResult(CommonReturnCode.BAD_REQUEST.getCode(), "图片不存在,请确认图片地址重新上传!");
	}

	/**
	 * POST 广告图片上传
	 * @return
	 */
	@PostMapping(value = "/advert", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object uploadAdvert(MultipartFile advert_file) {

		if (!advert_file.isEmpty()) {
			try {
				// 判断文件的MIMEtype
				String type = advert_file.getContentType();
				if (type == null || !type.toLowerCase().startsWith("image/")) {
					return new CmsResult(CommonReturnCode.BAD_REQUEST.getCode(), "不支持的文件类型，仅支持图片!");
				}
				//采用FastDFS的模式
				/*UploadResult uploadResult = UploadManager.upload(ServletUtils.getRequest(), advert_file,
						WebSiteFileBelongEnum.IMAGES.getBelong(), WebSiteFileBelongEnum.ADVERT.getBelong());*/
				UploadResult uploadResult = UploadManager.uploadFastDFS(ServletUtils.getRequest(), advert_file,
						WebSiteFileBelongEnum.IMAGES.getBelong(), WebSiteFileBelongEnum.ADVERT.getBelong());

				if (uploadResult.getResult() || uploadResult != null) {
					return new CmsResult(CommonReturnCode.SUCCESS, uploadResult.getSavaPath());
				}else {
					return new CmsResult(CommonReturnCode.UNKNOWN_ERROR);
				}
			} catch (Exception e) {
				logger.error("ImageUploadController.uploadHeadPortrait={}", e);
				return new CmsResult(CommonReturnCode.UNKNOWN_ERROR);
			}
		}

		return new CmsResult(CommonReturnCode.BAD_REQUEST.getCode(), "图片不存在,请确认图片地址重新上传!");
	}	
	
	
	/**
	 * POST 用户头像上传
	 * @return
	 */
	@PostMapping(value = "/avatar", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object uploadAvatar(MultipartFile multipartFile, String avatar_src, String avatar_data) {
		if (!multipartFile.isEmpty()) {
			try {

				// 判断文件的MIMEtype
				String type = multipartFile.getContentType();
				if (type == null || !type.toLowerCase().startsWith("image/")) {
					return new CmsResult(CommonReturnCode.BAD_REQUEST.getCode(), "不支持的文件类型，仅支持图片!");
				}

				UploadResult uploadResult = UploadManager.upload(ServletUtils.getRequest(), multipartFile,
						HtmlUtils.htmlUnescape(avatar_data), WebSiteFileBelongEnum.IMAGES.getBelong(),
						WebSiteFileBelongEnum.AVATAR.getBelong());

				if (uploadResult.getResult()) {
					return new CmsResult(CommonReturnCode.SUCCESS, uploadResult.getSavaPath());
				}
			} catch (Exception e) {
				logger.error("ImageUploadController.uploadHeadPortrait={}", e);
				return new CmsResult(CommonReturnCode.UNKNOWN_ERROR);
			}
		}
		return new CmsResult(CommonReturnCode.BAD_REQUEST.getCode(), "图片不存在,请确认图片地址重新上传!");
	}
}
