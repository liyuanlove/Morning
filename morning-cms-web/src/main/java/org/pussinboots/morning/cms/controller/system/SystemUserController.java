package org.pussinboots.morning.cms.controller.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.pussinboots.morning.administrator.service.impl.UserServiceImpl;
import org.pussinboots.morning.cms.common.result.CmsPageResult;
import org.pussinboots.morning.cms.common.result.CmsResult;
import org.pussinboots.morning.common.constant.CommonReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Create by ZengShiLin on 2018-03-12
 */
@Controller
@RequestMapping(value = "/system/user")
@Api(value = "会员管理", description = "会员模块")
public class SystemUserController {

    @Autowired
    UserServiceImpl userService;

    /**
     * 跳转到页面
     * @param model
     * @return
     */
    @GetMapping(value = "/list/view")
    public String listUserView(Model model) {
        return "/modules/user/userlist";
    }


    /**
     * 获取用户列表
     */
    @ApiOperation(value = "分页获取用户列表", notes = "分页获取用户列表json")
    @GetMapping(value = "/json")
    @ResponseBody
    public Object getUserListByPager(Integer offset, Integer limit){
        return new CmsPageResult(userService.listUserByPager(offset, limit),userService.countTotalUsers());
    }


    /**
     * 冻结解冻账户 type 1 冻结 2解冻 3冻结邮箱 4解冻邮箱
     */
    @ApiOperation(value = "冻结解冻账户 type 1 冻结 2解冻 3冻结邮箱 4解冻邮箱", notes = "冻结解冻账户 type 1 冻结 2解冻 3冻结邮箱 4解冻邮箱")
    @PostMapping(value = "/frozenuser")
    @ResponseBody
    public Object frozenUser(String userNumber, Integer type){
        try {
            if(userService.frozenUser(userNumber, type)==true){
                return new CmsResult(CommonReturnCode.SUCCESS);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new CmsResult(CommonReturnCode.FAILED);
    }

}
