package org.pussinboots.morning.os.controller.webfront;



import org.pussinboots.morning.common.base.BaseController;
import org.pussinboots.morning.online.common.enums.NavigationBarTypeEnum;
import org.pussinboots.morning.online.entity.NavigationBar;
import org.pussinboots.morning.os.common.cache.index.IndexCacheAdDto;
import org.pussinboots.morning.os.common.cache.index.IndexCacheCaDto;
import org.pussinboots.morning.os.common.cache.index.IndexCacheNaDto;
import org.pussinboots.morning.os.common.cache.index.IndexCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * 
* 项目名称：morning-os-web Maven Webapp   
* 类名称：WebFrontController   
* 类描述：商城首页表示层控制器       
* 创建人：陈星星   
* 创建时间：2017年4月9日 下午4:59:20
 * 改进人：南蛮麟爷
*
 */
@Controller
@Api(value = "商城首页", description = "商城首页")
public class WebFrontController extends BaseController {

	private static final String imageServer="http://119.29.209.127";

	@Autowired
	private IndexCacheService indexCacheService;

	/**
	 * GET 商城首页
	 * @return
	 */
	@ApiOperation(value = "商城首页", notes = "商城首页展示页面")  
	@GetMapping(value = "/index")
	public String index(Model model) {
		// 首页-广告栏-左部导航栏
		//如果缓存没有则查询数据库
		try {
			IndexCacheAdDto indexCacheAdDto = indexCacheService.getIndexAdCache();
			IndexCacheNaDto indexCacheNaDto = indexCacheService.getIndexNaCache();
			IndexCacheCaDto indexCacheCaDto = indexCacheService.getIndexCaCache();

			//广告栏
			model.addAttribute("indexAdvertLeft",indexCacheAdDto.getIndexAdvertLeft());
			model.addAttribute("indexCarouselImgs",indexCacheAdDto.getIndexCarouselImgs());
			model.addAttribute("indexHotAdvertImgs",indexCacheAdDto.getIndexHotAdvertImgs());
			//分类栏
			model.addAttribute("categorys",indexCacheCaDto.getCategorys());
			//导航栏
			model.addAttribute("indexBottom",indexCacheNaDto.getIndexBottom());
			model.addAttribute("indexClassify",indexCacheNaDto.getIndexClassify());
			model.addAttribute("indexTop", indexCacheNaDto.getIndexTop());

		}catch (Exception e){
			e.printStackTrace();
		}

		return "/modules/webfront/index";
	}
}
