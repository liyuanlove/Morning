<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
  <title>图片工具</title>
  <link rel="stylesheet" href="${ctxsta}/common/bootstrap-table/bootstrap-table.min.css" />
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-content">
          <div class="row row-lg">
            <div class="col-sm-12">
              <div class="example-wrap">
                <div class="example">
                  <div class="well well-lg">
                    <center><img src="${imageServer}${imageUrl}"/></center>
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
  <script src="${ctxsta}/common/bootstrap-table/bootstrap-table.min.js"></script>
  <script src="${ctxsta}/common/bootstrap-table/extensions/export/bootstrap-table-export.js"></script>
  <script src="${ctxsta}/common/bootstrap-table/tableExport.js"></script>
  <script src="${ctxsta}/common/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

  <script src="${ctxsta}/cms/js/productList.js"></script>

</myfooter>
</body>
</html>