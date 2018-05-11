package org.pussinboots.morning.support.service.impl;

import org.pussinboots.morning.support.entity.ImageLog;
import org.pussinboots.morning.support.mapper.ImageLogMapper;
import org.pussinboots.morning.support.service.IImageLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
* 项目名称：morning-support-service   
* 类名称：ImageLogServiceImpl   
* 类描述：ImageLogServiceImpl / 云存储图片记录表 业务逻辑层接口实现   
* 创建人：陈星星   
* 创建时间：2017年7月11日 下午8:15:57   
*
 */
@Service
public class ImageLogServiceImpl extends ServiceImpl<ImageLogMapper, ImageLog> implements IImageLogService {
	
}
