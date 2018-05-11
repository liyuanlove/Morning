package org.pussinboots.morning.cms.controller.product;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.pussinboots.morning.cms.common.result.CmsPageResult;
import org.pussinboots.morning.cms.common.result.CmsResult;
import org.pussinboots.morning.cms.common.security.AuthorizingUser;
import org.pussinboots.morning.cms.common.util.SingletonLoginUtils;
import org.pussinboots.morning.common.base.BaseController;
import org.pussinboots.morning.common.base.BasePageDTO;
import org.pussinboots.morning.common.constant.CommonReturnCode;
import org.pussinboots.morning.common.support.page.PageInfo;
import org.pussinboots.morning.product.entity.Category;
import org.pussinboots.morning.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
* 项目名称：morning-cms-web Maven Webapp   
* 类名称：ProductCategoryController   
* 类描述：分类管理表示层控制器          
* 创建人：陈星星   
* 创建时间：2017年5月20日 下午3:08:25   
*
 */
@Controller
@RequestMapping(value = "/product/category")
@Api(value = "分类管理", description = "分类管理")
public class ProductCategoryController extends BaseController {
	
	@Autowired
	private ICategoryService categoryService;
	
	/**
	 * GET 分类管理页面
	 * @return
	 */
	@ApiOperation(value = "分类管理页面", notes = "分类管理页面")
	@RequiresPermissions("product:category:view")
	@GetMapping(value = "/view")
	public String getAdvertPage(Model model) {
		return "/modules/category/product_category_list";
	}
	
	/**
	 * GET 分类列表,根据父类目ID
	 * @return
	 */
	@ApiOperation(value = "获取分类列表", notes = "根据分页信息/搜索内容/父类目ID获取分类列表")  
	@RequiresPermissions("product:category:view")
	@GetMapping(value = "/gid/{parentId}")
	@ResponseBody
	public Object listAdvert(PageInfo pageInfo, @RequestParam(required = false, value = "search") String search,
			@PathVariable("parentId") Long parentId) {
		BasePageDTO<Category> basePageDTO = categoryService.listParentByPage(pageInfo, search, parentId);
		return new CmsPageResult(basePageDTO.getList(), basePageDTO.getPageInfo().getTotal());
	}
	
	/**
	 * PUT 启用/冻结类目
	 * @return
	 */
	@ApiOperation(value = "启用/冻结类目", notes = "根据url类目ID启动/冻结类目")
	@RequiresPermissions("product:category:audit")
	@PutMapping(value = "/{categoryId}/audit")
	@ResponseBody
	public Object audit(@PathVariable("categoryId") Long categoryId) {
		AuthorizingUser authorizingUser = SingletonLoginUtils.getUser();
		if (authorizingUser != null) {
			Integer count = categoryService.updateStatus(categoryId);
			return new CmsResult(CommonReturnCode.SUCCESS, count);
		} else {
			return new CmsResult(CommonReturnCode.UNAUTHORIZED);
		}
	}	
	
	
	/**
	 * GET 更新类目页面
	 * @return
	 */
	@ApiOperation(value = "更新类目页面", notes = "更新类目页面")
	@RequiresPermissions("product:category:edit")
	@GetMapping(value = "/{categoryId}/edit")
	public String getUpdatePage(Model model, @PathVariable("categoryId") Long categoryId) {
		// 类目信息
		Category category = categoryService.selectById(categoryId);
		model.addAttribute("category", category);
		// 上级类目信息
		Category parentCategory = categoryService.selectById(category.getParentId());
		model.addAttribute("parentCategory", parentCategory);
		
		return "/modules/category/product_category_update";
	}
	
	/**
	 * PUT 更新类目信息
	 * @return
	 */
	@ApiOperation(value = "更新类目信息", notes = "根据url类目ID来指定更新对象,并根据传过来的类目信息来更新类目信息")
	@RequiresPermissions("product:category:edit")
	@PutMapping(value = "/{categoryId}")
	@ResponseBody
	public Object update(Category category, @PathVariable("categoryId") Long categoryId,
			@RequestParam(value = "showInNav", defaultValue = "0") Integer showInNav,
			@RequestParam(value = "status", defaultValue = "0") Integer status,
			@RequestParam(value = "showInTop", defaultValue = "0") Integer showInTop,
			@RequestParam(value = "showInHot", defaultValue = "0") Integer showInHot) {

		AuthorizingUser authorizingUser = SingletonLoginUtils.getUser();
		if (authorizingUser != null) {
			// 更新用户及类目记录
			category.setShowInHot(showInHot);
			category.setStatus(status);
			category.setShowInNav(showInNav);
			category.setShowInTop(showInTop);
			Integer count = categoryService.updateCategory(category, authorizingUser.getUserName());
			return new CmsResult(CommonReturnCode.SUCCESS, count);
		} else {
			return new CmsResult(CommonReturnCode.UNAUTHORIZED);
		}
	}
	
	/**
	 * GET 创建类目页面
	 * @return
	 */
	@ApiOperation(value = "创建类目页面", notes = "创建类目页面")
	@RequiresPermissions("product:category:create")
	@GetMapping(value = "/{categoryId}/create")
	public String getCreatePage(Model model, @PathVariable("categoryId") Long categoryId) {
		// 类目信息
		Category category = categoryService.selectById(categoryId);
		model.addAttribute("category", category);
		return "/modules/category/product_category_create";
	}
	
	/**
	 * POST 创建类目
	 * @return
	 */
	@ApiOperation(value = "创建类目", notes = "创建类目")
	@RequiresPermissions("product:category:create")
	@PostMapping(value = "")
	@ResponseBody
	public Object insert(Category category) {
		AuthorizingUser authorizingUser = SingletonLoginUtils.getUser();
		if (authorizingUser != null) {
			// TODO 对类目名称进行唯一性校验
			Integer count = categoryService.insertAdvert(category, authorizingUser.getUserName());
			return new CmsResult(CommonReturnCode.SUCCESS, count);
		} else {
			return new CmsResult(CommonReturnCode.UNAUTHORIZED);
		}
	}
}
