<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>商品已经被冻结</title>
	<link rel="shortcut icon" href="${ctx}/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${ctxsta}/common/error/css/main.css" /> <!-- main stylesheet -->
	<link rel="stylesheet" href="${ctxsta}/common/error/css/tipsy.css" /> <!-- Tipsy implementation -->
	<script src="${ctxsta}/common/error/scripts/jquery-1.7.2.min.js"></script> <!-- uiToTop implementation -->
	<script src="${ctxsta}/common/error/scripts/custom-scripts.js"></script>
	<script src="${ctxsta}/common/error/scripts/jquery.tipsy.js"></script> <!-- Tipsy -->
	<script>
	$(document).ready(function(){
		universalPreloader();
	});
	$(window).load(function(){
		//remove Universal Preloader
		universalPreloaderRemove();
		rotate();
	    dogRun();
		dogTalk();
		//Tipsy implementation
		$('.with-tooltip').tipsy({gravity: $.fn.tipsy.autoNS});
	});
	</script>
  </head>
<body>
<!-- Universal preloader -->
<div id="universal-preloader">
    <div class="preloader">
        <img src="${ctxsta}/common/error/images/universal-preloader.gif" alt="universal-preloader" class="universal-preloader-preloader" />
    </div>
</div>
<!-- Universal preloader -->

<div id="wrapper">
<!-- 400 graphic -->
	<br><br>
	<h1>商品已经冻结</h1>
<!-- 400 graphic -->
<!-- Not found text -->
	<div class="not-found-text">
		<h1 class="not-found-text">您搜索的商品已被冻结</h1>
		<h1 class="not-found-text">您可要联系管理员咨询该商品冻结原因</h1>
    </div>
<!-- Not found text -->

<!-- search form
<div class="search">
	<form name="search" method="get" action="#" >
        <input type="text" name="search" value="Search ..." />
        <input class="with-tooltip" title="Search!" type="submit" name="submit" value="" />
    </form>
</div>-->
<!-- search form -->

<!-- top menu -->
<div class="top-menu">
	<a href="#" class="with-tooltip" title="返回首页">返回首页</a> | <a href="javascript:history.back(-1)" class="with-tooltip" title="返回上一页">返回上页</a> | <a href="#" class="with-tooltip" title="帮助中心">帮助中心</a> | <a href="#" class="with-tooltip" title="联系我们">联系我们</a>
</div>
<!-- top menu -->

<div class="dog-wrapper">
<!-- dog running -->
	<div class="dog"></div>
<!-- dog running -->
	
<!-- dog bubble talking -->
	<div class="dog-bubble">
    	
    </div>
    
    <!-- The dog bubble rotates these -->
    <div class="bubble-options">
    	<p class="dog-bubble">
        	Are you lost, bud? No worries, I'm an excellent guide!
        </p>
    	<p class="dog-bubble">
	        <br />
        	Arf! Arf!
        </p>
        <p class="dog-bubble">
        	<br />
        	Don't worry! I'm on it!
        </p>
        <p class="dog-bubble">
        	I wish I had a cookie<br /><img style="margin-top:8px" src="${ctxsta}/common/error/images/cookie.png" alt="cookie" />
        </p>
        <p class="dog-bubble">
        	<br />
        	Geez! This is pretty tiresome!
        </p>
        <p class="dog-bubble">
        	<br />
        	Am I getting close?
        </p>
        <p class="dog-bubble">
        	Or am I just going in circles? Nah...
        </p>
        <p class="dog-bubble">
        	<br />
            OK, I'm officially lost now...
        </p>
        <p class="dog-bubble">
        	I think I saw a <br /><img style="margin-top:8px" src="${ctxsta}/common/error/images/cat.png" alt="cat" />
        </p>
        <p class="dog-bubble">
        	What are we supposed to be looking for, anyway? @_@
        </p>
    </div>
    <!-- The dog bubble rotates these -->
<!-- dog bubble talking -->
</div>

<!-- planet at the bottom -->
	<div class="planet"></div>
<!-- planet at the bottom -->
</div>

</body>
</html>