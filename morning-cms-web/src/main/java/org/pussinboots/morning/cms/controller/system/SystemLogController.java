package org.pussinboots.morning.cms.controller.system;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.pussinboots.morning.cms.common.result.CmsPageResult;
import org.pussinboots.morning.common.base.BaseController;
import org.pussinboots.morning.common.base.BasePageDTO;
import org.pussinboots.morning.common.support.page.PageInfo;
import org.pussinboots.morning.system.entity.Log;
import org.pussinboots.morning.system.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
* 项目名称：morning-cms-web Maven Webapp   
* 类名称：SystemLogController   
* 类描述：日记记录表示层控制器         
* 创建人：陈星星   
* 创建时间：2017年6月9日 下午12:50:26   
*
 */
@Controller
@RequestMapping(value = "/system/log")
@Api(value = "日记记录", description = "日记记录")
public class SystemLogController extends BaseController {
	
	
	@Autowired
	private ILogService logService;
	
	/**
	 * GET 日记记录
	 * @return
	 */
	@ApiOperation(value = "获取日记记录", notes = "获取日记记录")
	@RequiresPermissions("system:log:view")
	@GetMapping(value = "/view")
	public String list(Model model) {
		return "/modules/log/system_log_list";
	}
	
	/**
	 * GET 日记记录
	 * @return
	 */
	@ApiOperation(value = "获取日记记录", notes = "根据分页信息/搜索内容获取日记记录")  
	@RequiresPermissions("system:log:view")
	@GetMapping(value = "/")
	@ResponseBody
	public Object listUser(PageInfo pageInfo, @RequestParam(required = false, value = "search") String search) {
		BasePageDTO<Log> basePageDTO = logService.listByPage(pageInfo, search);
		return new CmsPageResult(basePageDTO.getList(), basePageDTO.getPageInfo().getTotal());
	}
}
