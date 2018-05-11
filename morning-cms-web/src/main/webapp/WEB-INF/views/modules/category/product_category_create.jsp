<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>创建类目 - 猫宁Morning</title>
<link rel="stylesheet" href="${ctxsta}/common/icheck/flat/green.css" />
<link rel="stylesheet" href="${ctxsta}/common/switchery/switchery.min.css" />
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>创建类目<small> 类目信息时应当遵循合法、正当、必要的原则，明示目的、方式和范围。</small></h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <form id="form" class="form-horizontal" action="${ctx}/product/category" data-method="post">
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">上级类目：</label>
              <div class="col-sm-7">
                <input type="text" class="form-control" disabled="" placeholder="${category.name}">
                <input type="hidden" class="form-control" name="parentId" value="${category.categoryId}">  
                <input type="hidden" class="form-control" name="type" value="${category.type eq 0 ? '1':'2'}">              
              </div>
            </div>  
            <div class="hr-line-dashed"></div>                    
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">类目名称：</label>
              <div class="col-sm-7">
                <input type="text" class="form-control" name="name">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
              <label class="col-sm-2 col-xs-offset-1 control-label">排序：</label>
              <div class="col-sm-7">
                <input type="text" class="form-control" name="sort">
              </div>
            </div>
            <div class="hr-line-dashed"></div>                        
            <div class="form-group">
              <label class="col-sm-2 col-xs-offset-1 control-label">设置：</label>
              <div class="col-sm-9">
                <label class="radio-inline">
                	<input type="checkbox" class="js-switch" name="status" value="1" />
                  是否显示</label>              
                <label class="radio-inline">
                	<input type="checkbox" class="js-switch" name="showInNav" value="1"/>
                  是否导航</label>
                 <label class="radio-inline">
                	<input type="checkbox" class="js-switch" name="showInTop" value="1"/>
                  是否置顶</label>
                 <label class="radio-inline">
                	<input type="checkbox" class="js-switch" name="showInHot" value="1"/>
                  是否热门</label>
              </div>
            </div>
            <div class="hr-line-dashed"></div>                      
            <div class="form-group">
              <label class="col-sm-2 col-xs-offset-1 control-label">页面关键词：</label>
              <div class="col-sm-7">
                <input type="text" class="form-control" name="pageTitle">
              </div>
            </div>            
            <div class="hr-line-dashed"></div>            
            <div class="form-group">
              <label class="col-sm-2 col-xs-offset-1 control-label">页面关键词：</label>
              <div class="col-sm-7">
                <input type="text" class="form-control" name="pageKeyword">
              </div>
            </div>
            <div class="hr-line-dashed"></div>      
            <div class="form-group">
              <label class="col-sm-2  col-xs-offset-1 control-label">页面描述：</label>
              <div class="col-sm-7">
                <textarea class="form-control" rows="2" name="pageDescription" placeholder="请输入消息..."></textarea>
              </div>
            </div>
            <div class="hr-line-dashed"></div>                  
            <div class="form-group">
              <label class="col-sm-2  col-xs-offset-1 control-label">类目备注：</label>
              <div class="col-sm-7">
                <textarea class="form-control" rows="2" name="remarks" placeholder="请输入消息..."></textarea>
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
              <div class="col-sm-12 text-center">
                <button class="btn btn-primary" type="submit">提交</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<myfooter> 
  <script src="${ctxsta}/common/switchery/switchery.min.js"></script> 
  <!-- 自定义js --> 
  <script src="${ctxsta}/cms/js/productCategory.js"></script> 
</myfooter>
</body>
</html>
