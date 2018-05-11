package org.pussinboots.morning.cms.controller.system;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.pussinboots.morning.cms.common.result.CmsPageResult;
import org.pussinboots.morning.cms.common.util.ServletUtils;
import org.pussinboots.morning.common.base.BaseController;
import org.pussinboots.morning.common.base.BasePageDTO;
import org.pussinboots.morning.common.support.page.PageInfo;
import org.pussinboots.morning.order.entity.OrderListBack;
import org.pussinboots.morning.order.entity.OrderShipment;
import org.pussinboots.morning.order.service.impl.OrderProductServiceImpl;
import org.pussinboots.morning.order.service.impl.OrderShipmentServiceImpl;
import org.pussinboots.morning.product.service.IProductService;
import org.pussinboots.morning.system.common.enums.CommonConstantEnum;
import org.pussinboots.morning.system.entity.Log;
import org.pussinboots.morning.system.entity.VersionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

/**
 * Create by ZengShiLin on 2017-12-18
 * 这个类又给写坏了，原本应该是把订单功能和商品功能分开，结果写到一起
 *
 */
@Controller
@RequestMapping(value = "/system/order")
@Api(value = "版本日志", description = "版本日志")
public class SystemOrderController extends BaseController {

    @Autowired
    private OrderProductServiceImpl orderProductService;
    @Autowired
    private OrderShipmentServiceImpl orderShipmentService;

    @Autowired
    private IProductService productService;

    @ApiOperation(value = "版本日志", notes = "版本日志")
    @RequiresPermissions("system:version:view")
    @GetMapping(value = "/list")
    public String listOrder(Model model) {

        return "/modules/order/orderlist";
    }

    @ApiOperation(value = "获取所有订单", notes = "获取订单json")
    @RequestMapping(value = "/json")
    @ResponseBody
    public Object jsonOrder(Integer offset,Integer limit) {

        return new CmsPageResult(orderProductService.listAllOrder(offset, limit), orderProductService.getAllOrderTotal());
    }


    @GetMapping(value = "/shipment")
    public String listShipment(Long id,Model model) {
        OrderShipment orderShipment = orderShipmentService.getByOrderId(id);
        model.addAttribute("orderShipment",orderShipment);
        return "/modules/order/orderShipment";
    }




    @RequestMapping(value = "/getQRcode")
    @ResponseBody
    public ModelAndView getQRcode(Long id, HttpServletRequest request, HttpServletResponse response){
        int width = 100;
        int height = 100;
        String format = "png";
        //内容
        String content = new String("二维码测试，占时还没有数据");
        //定义二维码的参数
        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8"); //设置编码字符格式
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);  //设置纠错等级
        hints.put(EncodeHintType.MARGIN,2);  //边距设置
        try {
            ServletOutputStream out =  response.getOutputStream();
            //BarcodeFormat.QR_CODE这块设置的是二维码标准
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            MatrixToImageWriter.writeToStream(bitMatrix,format,out);
            try{
                out.flush();
            }finally {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
