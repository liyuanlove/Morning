<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
  <title>导航管理 - 猫宁Morning</title>
  <link rel="stylesheet" href="${ctxsta}/common/bootstrap-table/bootstrap-table.min.css" />
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>订单管理</h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <div class="row row-lg">
            <div class="col-sm-12">
              <div class="example-wrap">
                <div class="example">
                  <table id="table">
                  </table>
                  <div id="toolbar"></div>
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
  <script src="${ctxsta}/common/bootstrap-table/bootstrap-table.min.js"></script>
  <script src="${ctxsta}/common/bootstrap-table/extensions/export/bootstrap-table-export.js"></script>
  <script src="${ctxsta}/common/bootstrap-table/tableExport.js"></script>
  <script src="${ctxsta}/common/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
  <!--Jbox-->
  <script src="${ctxsta}/cms/jbox/Source/jBox.js"></script>
  <script src="${ctxsta}/cms/jbox/Source/plugins/Notice/jBox.Notice.js"></script>
  <script src="${ctxsta}/cms/jbox/Source/plugins/Confirm/jBox.Confirm.js"></script>
  <script src="${ctxsta}/cms/jbox/Source/plugins/Image/jBox.Image.js"></script>

  <!--个人js代码-->
  <script src="${ctxsta}/cms/js/orderList.js"></script>

</myfooter>
</body>
</html>