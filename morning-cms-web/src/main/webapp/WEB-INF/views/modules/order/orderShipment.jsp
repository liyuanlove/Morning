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
          <h5>出货凭证</h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <div class="row row-lg">
            <div class="col-sm-12">
              <div class="example-wrap">
                <div class="example">
                  <div class="well well-lg">
                    <p>下单用户：${orderShipment.userName}</p>
                    <p>配送手机：${orderShipment.userPhone}</p>
                    <p>配送地址：${orderShipment.userAdress}</p>
                    <p>下单时间：${orderShipment.updateTime}</p>
                    <p>发货城市：${orderShipment.cityName}</p>
                    <p>配送城区：${orderShipment.districtName}</p>
                    <p>配送区域ID：${orderShipment.provinceId}</p>
                    <center><img src="${ctx}/system/order/getQRcode"></center>
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