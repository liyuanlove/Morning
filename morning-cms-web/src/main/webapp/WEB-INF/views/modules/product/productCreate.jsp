<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
  <title>创建商品</title>
  <link rel="stylesheet" href="${ctxsta}/common/bootstrap-table/bootstrap-table.min.css" />
  <link rel="stylesheet" href="${ctxsta}/zTree/css/zTreeStyle/zTreeStyle.css" />

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>商品创建</h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <div class="row row-lg">
            <div class="col-sm-6 center-block">
              <div class="ibox float-e-margins">

                  <form id="createProduct" class="form-horizontal">
                    <div class="form-group">
                      <label class="col-sm-3 control-label">商品名称：</label>
                      <div class="col-sm-6">
                        <input name="name" type="text" class="form-control" value="${user.userName}">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-3 control-label">商品购买分数：</label>
                      <div class="col-sm-6">
                        <input name="showScore" type="number" class="form-control" value="${user.realName}">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-3 control-label">商品展现价格：</label>
                      <div class="col-sm-6">
                        <input name="showPrice" type="number" class="form-control"  value="${user.age}">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-3 control-label">商品简介：</label>
                      <div class="col-sm-6">
                        <input name="introduce" type="text" class="form-control"  value="${user.telephone}">
                      </div>
                    </div>

                    <div class="form-group">
                      <label class="col-sm-3 control-label">商品初始存量：</label>
                      <div class="col-sm-6">
                        <input name="stock" type="number" class="form-control"  value="${user.telephone}">
                      </div>
                    </div>

                    <div class="form-group">
                      <label class="col-sm-3 control-label">商品简介图片：</label>
                      <div class="col-sm-6">
                        <input name="imgFile" type="file" class="form-control" >
                      </div>
                    </div>

                    <div class="form-group">
                      <label class="col-sm-5 control-label">是否置顶</label>
                      <div class="col-sm-5">
                        <input name="showInTop" type="checkbox" value="1" class="form-control">
                      </div>
                    </div>

                    <div class="form-group">
                      <label class="col-sm-5 control-label">是否展现在导航栏</label>
                      <div class="col-sm-5">
                        <input name="showInNav" type="checkbox" value="1" class="form-control">
                      </div>
                    </div>

                    <div class="form-group">
                      <label class="col-sm-5 control-label">是否为热门产品</label>
                      <div class="col-sm-5">
                        <input name="showInHot" type="checkbox" value="1" class="form-control">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-5 control-label">是否上架</label>
                      <div class="col-sm-5">
                        <input name="showInShelve" type="checkbox" value="1" class="form-control">
                      </div>
                    </div>


                  </form>

                    <div id="menuContent" class="menuContent" style="width:95%;border:1px solid rgb(170,170,170);z-index:10;">
                      <ul id="ztree" class="ztree" style="margin-top:0; width:100%; height:auto;"></ul>
                    </div>


                    <div id="imagesDeUpload" class="form-group">
                        <input id="filecheck" type="file" name="imagefiles" multiple /><br>
                        <div id="uploadtoserver" class="btn btn-warning btn-sm" onclick="uploadImages()">上传图片</div>
                        <div class="btn btn-success btn-sm" onclick="selectImages()">选择图片</div>
                    </div>

                    <div class="form-group">
                      <label class="col-sm-3 control-label">商品描述</label>
                      <div class="col-sm-12">
                        <div id="editor">
                        </div>
                      </div>
                    </div>

                    <div class="form-group">
                      <div class="col-sm-8 col-sm-offset-3">
                          <button type="button" class="btn btn-primary pull-left m-r-md" onclick="modify()">提交</button>
                      </div>
                    </div>

                </div>
              </div>


            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<myfooter>
  <!-- Bootstrap table -->
  <script src="${ctxsta}/cms/wangEditor/wangEditor.min.js"></script>
  <script src="https://cdn.bootcss.com/jquery.form/4.2.2/jquery.form.js"></script>
  <!-- bootstrapvalidator-master前端验证框架 -->
  <script src="${ctxsta}/common/bootstrapvalidator/js/bootstrapValidator.min.js"></script>

  <script src="${ctxsta}/cms/js/product/productCreate.js"></script>
  <script src="${ctxsta}/zTree/js/jquery.ztree.core.js"></script>
  <script src="${ctxsta}/zTree/js/jquery.ztree.excheck.js"></script>

</myfooter>
</body>
</html>