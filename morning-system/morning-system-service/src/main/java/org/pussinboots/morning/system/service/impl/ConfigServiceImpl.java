package org.pussinboots.morning.system.service.impl;

import org.pussinboots.morning.system.entity.Config;
import org.pussinboots.morning.system.mapper.ConfigMapper;
import org.pussinboots.morning.system.service.IConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *
 * 项目名称：morning-system-facade
 * 类名称：Config
 * 类描述：Config / 系统配置表 业务逻辑层接口实现
 * 创建人：陈星星
 * 创建时间：2017年7月10日 上午10:08:49
 *
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {
	
}
