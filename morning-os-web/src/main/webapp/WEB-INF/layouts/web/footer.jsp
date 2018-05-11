<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!--     底部信息  begin       -->
<div class="site-footer">
  <div class="container-fluid">
    <div class="footer-service">
      <ul class="list-service clearfix">
        <li> <a rel="nofollow" href="#"><span class="glyphicon glyphicon-wrench"></span>麟爷1小时快修服务</a> </li>
        <li> <a rel="nofollow" href="#"><span class="glyphicon glyphicon-phone-alt"></span>7天不准退货</a> </li>
        <li> <a rel="nofollow" href="#"><span class="glyphicon glyphicon-usd"></span>15天禁止换货</a> </li>
        <li> <a rel="nofollow" href="#"><span class="glyphicon glyphicon-gift"></span>满150元不包邮</a> </li>
        <li> <a rel="nofollow" href="#"><span class="glyphicon glyphicon-map-marker"></span>无售后服务</a> </li>
      </ul>
    </div>
    <div class="footer-links clearfix">
      <!--
      <dl class="col-links col-links-first">
        <dt>帮助中心</dt>
        <dd><a rel="nofollow" href="#">购物指南</a></dd>
        <dd><a rel="nofollow" href="#">支付方式</a></dd>
        <dd><a rel="nofollow" href="#">配送方式</a></dd>
      </dl>
      <dl class="col-links ">
        <dt>服务支持</dt>
        <dd><a rel="nofollow" href="#">售后政策</a></dd>
        <dd><a rel="nofollow" href="#">自助服务</a></dd>
        <dd><a rel="nofollow" href="#">相关下载</a></dd>
      </dl>
      <dl class="col-links ">
        <dt>猫宁之家</dt>
        <dd><a rel="nofollow" href="#">猫宁之家</a></dd>
        <dd><a rel="nofollow" href="#">服务网点</a></dd>
        <dd><a rel="nofollow" href="#">预约服务</a></dd>
      </dl>
      <dl class="col-links ">
        <dt>关于猫宁</dt>
        <dd><a rel="nofollow" href="#">了解猫宁</a></dd>
        <dd><a rel="nofollow" href="#">加入猫宁</a></dd>
        <dd><a rel="nofollow" href="#">联系我们</a></dd>
      </dl>
      <dl class="col-links ">
        <dt>关注我们</dt>
        <dd><a rel="nofollow" href="#">新浪微博</a></dd>
        <dd><a rel="nofollow" href="#">猫宁部落</a></dd>
        <dd><a rel="nofollow" href="#">官方微信</a></dd>
      </dl>
      <dl class="col-links ">
        <dt>特色服务</dt>
        <dd><a rel="nofollow" href="#">F 码通道</a></dd>
        <dd><a rel="nofollow" href="#">猫宁移动</a></dd>
        <dd><a rel="nofollow" href="#">防伪查询</a></dd>
      </dl>
      -->
      <div class="col-contact">
        <p class="phone"> 159-2080-5337 </p>
        <p> <span class="J_serviceTime-normal" style="">无营业时间</span> <span class="J_serviceTime-holiday" style="display: none;"></span><br>
        </p>
        <a rel="nofollow" class="btn btn-line-primary btn-small" href="#"><span class="glyphicon glyphicon-earphone"></span>永远不会在线</a> </div>

    </div>
  </div>
</div>
<!--     底部信息  end         --> 

<!--     公司链接  begin       -->
<div class="site-info">
  <div class="container-fluid">
    <div class="logo"> <img src="${ctxsta}/os/images/logo.png"> </div>
    <div class="info-text">
      <p class="sites">
        <c:forEach items="${indexBottom}" var="indexBottom"> <a href="${indexBottom.href}" target="${indexBottom.target}">${indexBottom.name}</a><span class="sep">|</span> </c:forEach>
      </p>
      <p> © 2018<a href="https://git.oschina.net/Morning_/Morning" target="_blank"> 南蛮麟爷 </a>/ <span id="showsectime"></span> / <span id="TimeShow"></span>
      <p>
      <p> © <a href="#">mi.com</a> ICP <a href="#">粤网文[2014]0059-0009号</a> 违法和不良信息举报电话：110 </p>
    </div>
    <div class="info-links"> <a href="#"><img src="${ctxsta}/os/images/v-logo-2.png" alt="诚信网站"></a> <a href="#"><img src="${ctxsta}/os/images/v-logo-1.png" alt="可信网站"></a> <a href="#"><img src="${ctxsta}/os/images/v-logo-3.png" alt="网上交易保障中心"></a> </div>
  </div>
</div>
<!--     公司链接  end         --> 

<!--     返回顶部  begin       -->
<div class="back-to-top">
  <div class="container-fluid">
    <p id="back-to-top"><a href="#top"><span class="glyphicon glyphicon-menu-up" style="font-size:30px;color:#ff6700;"></span>回到顶部</a></p>
  </div>
</div>
<!--     返回顶部  end         --> 