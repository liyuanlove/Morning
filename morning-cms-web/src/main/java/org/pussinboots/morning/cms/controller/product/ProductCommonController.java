package org.pussinboots.morning.cms.controller.product;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import org.pussinboots.morning.cms.common.result.CmsPageResult;
import org.pussinboots.morning.cms.common.result.CmsResult;
import org.pussinboots.morning.cms.common.security.AuthorizingUser;
import org.pussinboots.morning.cms.common.util.SingletonLoginUtils;
import org.pussinboots.morning.common.base.BaseController;
import org.pussinboots.morning.product.entity.CategoryTree;
import org.pussinboots.morning.product.entity.Product;
import org.pussinboots.morning.product.pojo.vo.ProductVO;
import org.pussinboots.morning.product.service.IProductService;
import org.pussinboots.morning.product.service.impl.CategoryServiceImpl;
import org.pussinboots.morning.product.service.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Random;


/**
 * Create by ZengShiLin on 2018-02-07
 * 商品管理常用控制器
 */
@Controller
@RequestMapping(value = "/product/common")
public class ProductCommonController extends BaseController {


    @Autowired
    private IProductService productService;

    @Autowired
    private FileServiceImpl fileService;

    @Autowired
    private CategoryServiceImpl categoryService;


    @GetMapping(value = "/list")
    public String listOrder(Model model) {
        return "/modules/product/productlist";
    }



    @GetMapping(value = "/imageView")
    public String getImageView(Model model,String picImg){
        model.addAttribute("imageUrl",picImg);
        return "/modules/util/imageUtil";
    }


    @ApiOperation(value = "获取所有产品", notes = "获取订单json")
    @GetMapping(value = "/json")
    @ResponseBody
    public Object jsonProduct(Integer offset,Integer limit) {
        System.out.println(offset+"   "+limit);
        return new CmsPageResult(productService.getAllProduct(offset,limit),productService.getAllProductTotal());
    }

    //图片文件上传
    @PostMapping(value = "/describeImages")
    @ResponseBody
    public CmsResult iMageFilesUpload(MultipartFile[] imagefiles){
        if(imagefiles != null){
            if(imagefiles.length >5){
                return new CmsResult(0,"一次最多只能上传5个文件");
            }
            AuthorizingUser user = SingletonLoginUtils.getUser();
            if(user != null){
                try {
                    if(fileService.saveFile(user.getLoginName(),imagefiles)){
                        return new CmsResult(1,"文件上传成功");
                    }
                }catch (RuntimeException e){
                    return new CmsResult(0,"不能上传重复文件");
                }
            }
        }else{
            return new CmsResult(0,"没有选择文件");
        }
        return new CmsResult(500,"服务器出现错误");
    }


    @RequestMapping(value = "/selectImages")
    public String selectImages(Model model){
        return "/modules/product/selectImages";
    }

    @GetMapping(value = "/getImagesList")
    @ResponseBody
    public CmsPageResult getImagesListByLoginName(Model model, Integer offset,Integer limit){
        AuthorizingUser user = SingletonLoginUtils.getUser();
        return new CmsPageResult(
                fileService.getImageListByLoginName(user.getLoginName(),offset,limit),
                fileService.getListTotal(user.getLoginName()));
    }

    //异步获取富文本内容
    @GetMapping(value = "/productDescription")
    @ResponseBody
    public CmsResult getProductDescription(@RequestParam("productNumber") String productNumber){
        return new CmsResult(1,productService.getProductDescription(productNumber));

    }


    //跳转到商品创建
    @GetMapping(value = "/tocreate")
    public String createPView(Model model){
        return "/modules/product/productCreate";
    }

    //跳转到商品更新页面
    @GetMapping(value = "/todetail")
    public String updateProduct(Model model,@RequestParam("productNumber") String productNumber){
        ProductVO productvo = productService.getProductByNumber(productNumber);
        model.addAttribute("product",productvo);
        return "/modules/product/productUpdate";
    }

    /**
     *
     * @param product 商品信息
     * @param description 商品描述
     * @param categoryID 分类ID
     * @param stock 库存量
     * @return
     */
    @PostMapping(value = "/createProduct")
    @ResponseBody
    public CmsResult insertProduct(Product product,
                                   String description,
                                   Integer categoryID,
                                   Integer stock,
                                   MultipartFile imgFile){
        if(imgFile != null){
            System.out.println("当前的category是："+categoryID);
            //因为mvc的保护机制，先替换掉这些内容，但是后续还是要进行一定程度的过滤保护
            description = description.replace("&quot;", "\"");
            description = description.replace("&lt;", "<");
            description = description.replace("&gt;", ">");
            //这里应该进行进一步字符过滤

            //获取当前用户
            AuthorizingUser user = SingletonLoginUtils.getUser();
            try{
                productService.insertProduct(product,description,user.getRealName(),categoryID,stock,imgFile);
            }catch (RuntimeException e){
                e.printStackTrace();
                return new CmsResult(0,"商品保存失败");
            }
            return new CmsResult(1,"商品保存成功");
        }else {
            return new CmsResult(0,"商品图片不能为空");
        }
    }







    @GetMapping(value = "/treedata")
    @ResponseBody
    public List<CategoryTree> getCategoryTree(String test){
        return categoryService.getCategoryTree();
    }

    /**
     * 冻结和解冻商品
     * @return
     */
    @PostMapping(value = "/frozen")
    @ResponseBody
    public CmsResult frozenProduct(String productNumber,Integer type){

        System.out.println("商品编码是："+productNumber);

        try {
            productService.updateProductFrozen(productNumber,type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new CmsResult(0,"进入冻结控制器");
    }







}
