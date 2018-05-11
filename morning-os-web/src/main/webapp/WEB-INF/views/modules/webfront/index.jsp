<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>猫宁商城</title>
<link rel="stylesheet" href="${ctxsta}/os/css/index.css">
</head>
<body>
<!-- 轮播top菜单导航引入 -->
<jsp:include page="/WEB-INF/views/modules/common/site_header.jsp" />
<!-- 轮播top菜单导航引入 -->

<!--热销商品-->

<!--热销商品结束-->

<!--     轮播begin       -->
<div class="home-hero-container container-fluid">
  <div class="home-hero">
    <div class="home-hero-slider">
      <div class="row">
        <div class="col-md-12 col-sm-12">
          <div class="box">
            <ul class="ull">
              <c:forEach items="${indexCarouselImgs}" var="indexCarouselImg">
                <li><a href="${indexCarouselImg.href}" title="${indexCarouselImg.title}" target="_blank"><img src="${imageServer}/${indexCarouselImg.picImg}" alt="${indexCarouselImg.title }"></a></li>
              </c:forEach>
            </ul>
            <ol class="oll">
            </ol>
            <span class="right btnL glyphicon glyphicon-menu-right"></span> <span class="left btnL glyphicon glyphicon-menu-left"></span> </div>
        </div>
      </div>
    </div>
    <div class="home-hero-sub row">
      <div class="row">
        <div class="col-md-12 col-sm-12">
          <div class="span4">
            <ul class="home-channel-list clearfix">
              <!--小广告-->
              <c:forEach items="${indexAdvertLeft}" var="indexAdvertLeft">
                <li><a href="${indexAdvertLeft.href }" target="${indexAdvertLeft.target}" title="${indexAdvertLeft.name}">${indexAdvertLeft.name}</a></li>
              </c:forEach>
            </ul>
          </div>
          <div class="span16" id="J_homePromo" data-stat-title="焦点图下方小图">
            <ul class="home-promo-list clearfix">
              <c:forEach items="${indexHotAdvertImgs}" var="indexHotAdvertImg" varStatus="indexHotAdvertImgStat">
              <c:if test="${indexHotAdvertImgStat.first}">
                 <li class="first"><a class="item" href="${indexHotAdvertImg.href }" title="${indexHotAdvertImg.title}"><img src="${ctx}/${indexHotAdvertImg.picImg}" alt="${indexHotAdvertImg.title }"></a></li>
              </c:if>
              <c:if test="${!indexHotAdvertImgStat.first}">
                 <li><a class="item" href="${indexHotAdvertImg.href }" title="${indexHotAdvertImg.title}"><img src="${ctx}/${indexHotAdvertImg.picImg}" alt="${indexHotAdvertImg.title }"></a></li>
              </c:if>
              </c:forEach>
            </ul>

          </div>
        </div>
      </div>
    </div>
  </div>









  <div class="home-star-goods xm-carousel-container" id="J_homeStar">
    <div class="xm-plain-box">
      <div class="box-hd">
        <h2 class="title">小米明星单品</h2>
        <!-- <h2 class="title">祝大家圣诞快乐！一起来唱圣诞歌吧  (＾O＾☆♪ ) </h2> -->
        <div class="more"><div class="xm-controls xm-controls-line-small xm-carousel-controls"></div></div>
      </div>
      <div class="box-bd">


        <div class="xm-carousel-wrapper" style="height: 340px; overflow: hidden;"><ul class="xm-carousel-list xm-carousel-col-5-list goods-list rainbow-list clearfix J_carouselList" style="width: 2480px; margin-left: 0px; transition: margin-left 0.5s ease;">
          <li class="rainbow-item-1">
            <a class="thumb exposure" href="" data-stat-aid="AA19467" data-stat-pid="2_17_1_80" data-log_code="31pchomestar001004#rid=ab3a39a6164f34b7e21ab1e14df164c2&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.1&amp;pid=1173500015&amp;adm=4532" target="_blank" data-stat-id="AA19467+2_17_1_80" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA19467+2_17_1_80', 'https://item.mi.com/product/10000070.html', 'pcpid', '31pchomestar001004#rid=ab3a39a6164f34b7e21ab1e14df164c2&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.1&amp;pid=1173500015&amp;adm=4532']);"><img src="//i1.mifile.cn/a4/xmad_15117763019255_STRfj.png" srcset="//i1.mifile.cn/a4/xmad_15117763039715_jXbCQ.png 2x" alt="小米MIX 2"></a>
            <h3 class="title"><a href="" data-stat-aid="AA19467" data-stat-pid="2_17_1_80" data-log_code="31pchomestar001004#rid=ab3a39a6164f34b7e21ab1e14df164c2&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.1&amp;pid=1173500015&amp;adm=4532" target="_blank" data-stat-id="AA19467+2_17_1_80" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA19467+2_17_1_80', 'https://item.mi.com/product/10000070.html', 'pcpid', '31pchomestar001004#rid=ab3a39a6164f34b7e21ab1e14df164c2&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.1&amp;pid=1173500015&amp;adm=4532']);">小米MIX 2</a></h3>
            <p class="desc">全面屏2.0，5.99"大屏</p>
            <p class="price">3299元起</p>
          </li>
          <li class="rainbow-item-2">
            <a class="thumb exposure" href="" data-stat-aid="AA19528" data-stat-pid="2_17_2_81" data-log_code="31pchomestar002004#rid=d4193868014218500b2056c1e6303fb8&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.2&amp;pid=1173800019&amp;adm=4591" target="_blank" data-stat-id="AA19528+2_17_2_81" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA19528+2_17_2_81', 'https://item.mi.com/product/6874.html', 'pcpid', '31pchomestar002004#rid=d4193868014218500b2056c1e6303fb8&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.2&amp;pid=1173800019&amp;adm=4591']);"><img src="//i1.mifile.cn/a4/xmad_15125569508853_uWAIK.png" srcset="//i1.mifile.cn/a4/xmad_15125569539761_YeIBb.png 2x" alt="红米5A"></a>
            <h3 class="title"><a href="" data-stat-aid="AA19528" data-stat-pid="2_17_2_81" data-log_code="31pchomestar002004#rid=d4193868014218500b2056c1e6303fb8&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.2&amp;pid=1173800019&amp;adm=4591" target="_blank" data-stat-id="AA19528+2_17_2_81" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA19528+2_17_2_81', 'https://item.mi.com/product/6874.html', 'pcpid', '31pchomestar002004#rid=d4193868014218500b2056c1e6303fb8&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.2&amp;pid=1173800019&amp;adm=4591']);">红米5A</a></h3>
            <p class="desc">8天超长待机，137g轻巧机身</p>
            <p class="price">599元</p>
          </li>
          <li class="rainbow-item-3">
            <a class="thumb exposure" href="" data-stat-aid="AA19585" data-stat-pid="2_17_3_82" data-log_code="31pchomestar003004#rid=02f493fc5e400f4b59241056f45cf06d&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.3&amp;adm=4328" target="_blank" data-stat-id="AA19585+2_17_3_82" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA19585+2_17_3_82', 'https://item.mi.com/product/10000069.html', 'pcpid', '31pchomestar003004#rid=02f493fc5e400f4b59241056f45cf06d&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.3&amp;adm=4328']);"><img src="//i1.mifile.cn/a4/xmad_15117899982255_yNLAY.png" srcset="//i1.mifile.cn/a4/xmad_15117900016587_SqPvc.png 2x" alt="小米Note 3"></a>
            <h3 class="title"><a href="" data-stat-aid="AA19585" data-stat-pid="2_17_3_82" data-log_code="31pchomestar003004#rid=02f493fc5e400f4b59241056f45cf06d&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.3&amp;adm=4328" target="_blank" data-stat-id="AA19585+2_17_3_82" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA19585+2_17_3_82', 'https://item.mi.com/product/10000069.html', 'pcpid', '31pchomestar003004#rid=02f493fc5e400f4b59241056f45cf06d&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.3&amp;adm=4328']);">小米Note 3</a></h3>
            <p class="desc">1600万美颜自拍，2倍变焦双摄</p>
            <p class="price">1999元起</p>
          </li>
          <li class="rainbow-item-4">
            <a class="thumb exposure" href="" data-stat-aid="AA18439" data-stat-pid="2_17_4_83" data-log_code="31pchomestar004004#rid=a505c033a65e83b2d644482c0ba72acc&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.4&amp;pid=2173300008&amp;adm=3703" target="_blank" data-stat-id="AA18439+2_17_4_83" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA18439+2_17_4_83', '//item.mi.com/1173300019.html', 'pcpid', '31pchomestar004004#rid=a505c033a65e83b2d644482c0ba72acc&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.4&amp;pid=2173300008&amp;adm=3703']);"><img src="//i1.mifile.cn/a1/pms_1503909150.67293503!220x220.png" srcset="//i1.mifile.cn/a1/pms_1503909150.67293503!220x220.png 2x" alt="小米电视4A 43英寸 标准版"></a>
            <h3 class="title"><a href="" data-stat-aid="AA18439" data-stat-pid="2_17_4_83" data-log_code="31pchomestar004004#rid=a505c033a65e83b2d644482c0ba72acc&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.4&amp;pid=2173300008&amp;adm=3703" target="_blank" data-stat-id="AA18439+2_17_4_83" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA18439+2_17_4_83', '//item.mi.com/1173300019.html', 'pcpid', '31pchomestar004004#rid=a505c033a65e83b2d644482c0ba72acc&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.4&amp;pid=2173300008&amp;adm=3703']);">小米电视4A 43英寸 标准版</a></h3>
            <p class="desc">全高清HDR  四核高性能处理器 </p>
            <p class="price">1999元</p>
          </li>
          <li class="rainbow-item-5">
            <a class="thumb exposure" href="" data-stat-aid="AA17079" data-stat-pid="2_17_5_84" data-log_code="31pchomestar005004#rid=64f45ecb97eec5cf6d1330355c976c13&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.5&amp;adm=2457" target="_blank" data-stat-id="AA17079+2_17_5_84" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA17079+2_17_5_84', '//item.mi.com/product/10000032.html', 'pcpid', '31pchomestar005004#rid=64f45ecb97eec5cf6d1330355c976c13&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.5&amp;adm=2457']);"><img src="//i1.mifile.cn/a4/725a37e3-78b7-4298-8098-c40097bf179d" srcset="//i1.mifile.cn/a4/073b5ddc-9117-4668-adbe-878c928a79da 2x" alt="小米笔记本"></a>
            <h3 class="title"><a href="" data-stat-aid="AA17079" data-stat-pid="2_17_5_84" data-log_code="31pchomestar005004#rid=64f45ecb97eec5cf6d1330355c976c13&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.5&amp;adm=2457" target="_blank" data-stat-id="AA17079+2_17_5_84" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA17079+2_17_5_84', '//item.mi.com/product/10000032.html', 'pcpid', '31pchomestar005004#rid=64f45ecb97eec5cf6d1330355c976c13&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.5&amp;adm=2457']);">小米笔记本</a></h3>
            <p class="desc">更轻更薄，像杂志一样随身携带</p>
            <p class="price">3599元起</p>
          </li>
          <li class="rainbow-item-6">
            <a class="thumb exposure" href="" data-stat-aid="AA18956" data-stat-pid="2_17_6_85" data-log_code="31pchomestar006004#rid=909cfe3f87d27ab1932b5ce3389e99e5&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.6&amp;pid=2163900001&amp;adm=2038" target="_blank" data-stat-id="AA18956+2_17_6_85" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA18956+2_17_6_85', '//www.mi.com/shouhuan2/', 'pcpid', '31pchomestar006004#rid=909cfe3f87d27ab1932b5ce3389e99e5&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.6&amp;pid=2163900001&amp;adm=2038']);"><img src="//i1.mifile.cn/a4/6ef55907-bbed-49be-a2bb-be0821b5f7b8" srcset="//i1.mifile.cn/a4/858c77b0-4a70-411f-bb1e-9b600c5897a6 2x" alt="小米手环 2"></a>
            <h3 class="title"><a href="" data-stat-aid="AA18956" data-stat-pid="2_17_6_85" data-log_code="31pchomestar006004#rid=909cfe3f87d27ab1932b5ce3389e99e5&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.6&amp;pid=2163900001&amp;adm=2038" target="_blank" data-stat-id="AA18956+2_17_6_85" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA18956+2_17_6_85', '//www.mi.com/shouhuan2/', 'pcpid', '31pchomestar006004#rid=909cfe3f87d27ab1932b5ce3389e99e5&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.6&amp;pid=2163900001&amp;adm=2038']);">小米手环 2</a></h3>
            <p class="desc">OLED 显示屏幕，升级计步算法</p>
            <p class="price">149元</p>
          </li>
          <li class="rainbow-item-7">
            <a class="thumb exposure" href="" data-stat-aid="AA18946" data-stat-pid="2_17_7_86" data-log_code="31pchomestar007004#rid=e710a5d6ac1e68c6ca82e1a5ddb8f8d1&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.7&amp;pid=2160800022&amp;adm=1808" target="_blank" data-stat-id="AA18946+2_17_7_86" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA18946+2_17_7_86', '//www.mi.com/water2/', 'pcpid', '31pchomestar007004#rid=e710a5d6ac1e68c6ca82e1a5ddb8f8d1&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.7&amp;pid=2160800022&amp;adm=1808']);"><img src="//i1.mifile.cn/a4/T1KvdjBX_v1RXrhCrK.jpg" srcset="//i1.mifile.cn/a4/T14iKgBXZv1RXrhCrK.jpg 2x" alt="小米净水器 厨下式"></a>
            <h3 class="title"><a href="" data-stat-aid="AA18946" data-stat-pid="2_17_7_86" data-log_code="31pchomestar007004#rid=e710a5d6ac1e68c6ca82e1a5ddb8f8d1&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.7&amp;pid=2160800022&amp;adm=1808" target="_blank" data-stat-id="AA18946+2_17_7_86" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA18946+2_17_7_86', '//www.mi.com/water2/', 'pcpid', '31pchomestar007004#rid=e710a5d6ac1e68c6ca82e1a5ddb8f8d1&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.7&amp;pid=2160800022&amp;adm=1808']);">小米净水器 厨下式</a></h3>
            <p class="desc">直出纯净水，隐藏式安装</p>
            <p class="price">1999元</p>
          </li>
          <li class="rainbow-item-8">
            <a class="thumb exposure" href="" data-stat-aid="AA18966" data-stat-pid="2_17_8_87" data-log_code="31pchomestar008004#rid=4c52d2e1f285fecb935d571a8c714b65&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.8&amp;pid=2164300008&amp;adm=3683" target="_blank" data-stat-id="AA18966+2_17_8_87" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA18966+2_17_8_87', '//www.mi.com/earphonepro/', 'pcpid', '31pchomestar008004#rid=4c52d2e1f285fecb935d571a8c714b65&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.8&amp;pid=2164300008&amp;adm=3683']);"><img src="//i1.mifile.cn/a4/302f2608-655a-489c-a0c5-a3b9172defd1" srcset="//i1.mifile.cn/a4/302f2608-655a-489c-a0c5-a3b9172defd1 2x" alt="小米圈铁耳机Pro"></a>
            <h3 class="title"><a href="" data-stat-aid="AA18966" data-stat-pid="2_17_8_87" data-log_code="31pchomestar008004#rid=4c52d2e1f285fecb935d571a8c714b65&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.8&amp;pid=2164300008&amp;adm=3683" target="_blank" data-stat-id="AA18966+2_17_8_87" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA18966+2_17_8_87', '//www.mi.com/earphonepro/', 'pcpid', '31pchomestar008004#rid=4c52d2e1f285fecb935d571a8c714b65&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.8&amp;pid=2164300008&amp;adm=3683']);">小米圈铁耳机Pro</a></h3>
            <p class="desc">独创双动圈+动铁，三单元发声</p>
            <p class="price">149元</p>
          </li>
          <li class="rainbow-item-9">
            <a class="thumb exposure" href="" data-stat-aid="AA18958" data-stat-pid="2_17_9_88" data-log_code="31pchomestar009004#rid=65257424be493558a5af973b5ac44d5f&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.9&amp;pid=2163400004&amp;adm=2615" target="_blank" data-stat-id="AA18958+2_17_9_88" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA18958+2_17_9_88', '//www.mi.com/roomrobot/', 'pcpid', '31pchomestar009004#rid=65257424be493558a5af973b5ac44d5f&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.9&amp;pid=2163400004&amp;adm=2615']);"><img src="//i1.mifile.cn/a4/848def18-47d9-4ca0-8822-c2ac61b83779" srcset="//i1.mifile.cn/a4/d70bc596-524b-4a05-996b-ceccc072fc5e 2x" alt="米家扫地机器人"></a>
            <h3 class="title"><a href="" data-stat-aid="AA18958" data-stat-pid="2_17_9_88" data-log_code="31pchomestar009004#rid=65257424be493558a5af973b5ac44d5f&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.9&amp;pid=2163400004&amp;adm=2615" target="_blank" data-stat-id="AA18958+2_17_9_88" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA18958+2_17_9_88', '//www.mi.com/roomrobot/', 'pcpid', '31pchomestar009004#rid=65257424be493558a5af973b5ac44d5f&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.9&amp;pid=2163400004&amp;adm=2615']);">米家扫地机器人</a></h3>
            <p class="desc">爱干净，高效完成清扫任务</p>
            <p class="price">1699元</p>
          </li>
          <li class="rainbow-item-10">
            <a class="thumb exposure" href="" data-stat-aid="AA19048" data-stat-pid="2_17_10_89" data-log_code="31pchomestar010004#rid=e0c5f9494dddaaaf7259ce605c0ac318&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.10&amp;pid=2161200063&amp;adm=3664" target="_blank" data-stat-id="AA19048+2_17_10_89" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA19048+2_17_10_89', '//www.mi.com/miwifi3/', 'pcpid', '31pchomestar010004#rid=e0c5f9494dddaaaf7259ce605c0ac318&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.10&amp;pid=2161200063&amp;adm=3664']);"><img src="//i1.mifile.cn/a4/de35852a-1be5-4ef5-846f-dcdd2efcfea6" srcset="//i1.mifile.cn/a4/de35852a-1be5-4ef5-846f-dcdd2efcfea6 2x" alt="小米路由器3"></a>
            <h3 class="title"><a href="" data-stat-aid="AA19048" data-stat-pid="2_17_10_89" data-log_code="31pchomestar010004#rid=e0c5f9494dddaaaf7259ce605c0ac318&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.10&amp;pid=2161200063&amp;adm=3664" target="_blank" data-stat-id="AA19048+2_17_10_89" onclick="_msq.push(['trackEvent', '81190ccc4d52f577-AA19048+2_17_10_89', '//www.mi.com/miwifi3/', 'pcpid', '31pchomestar010004#rid=e0c5f9494dddaaaf7259ce605c0ac318&amp;t=normal&amp;page=home&amp;act=other&amp;bid=3030337.10&amp;pid=2161200063&amp;adm=3664']);">小米路由器3</a></h3>
            <p class="desc">更快更强，不止四天线</p>
            <p class="price">149元</p>
          </li>
        </ul></div>
      </div>
    </div>
  </div>

  <div class="home-star-goods xm-carousel-container" id="J_starProduct"> 
    <!-- <h2 class="title">冲破大风雪，我们坐在雪橇上  (๑•̀ㅂ•́)و✧ </h2> --> 
  </div>
</div>
<!--     轮播end         --> 

<!--     主产品  begin    -->
<div class="page-main home-main">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
        <div class="container-fluid">
          <div id="J_topCategory" class="home-recm-box home-brick-box xm-plain-box"> 
            <!-- <h2 class="title">快奔驰过田野，我们欢笑又歌唱   φ(゜▽゜*)♪</h2> --> 
          </div>
          <div id="J_hotCategory" class="home-recm-box home-brick-box xm-plain-box"> 
            <!-- <h2 class="title">叮叮当，叮叮当，铃儿响叮当   (」o^∀^)」*゜</h2> --> 
          </div>
          <div id="J_popularPrudoct" class="home-recm-box home-brick-box home-brick-row-1-box xm-plain-box J_itemBox J_recommendBox is-visible"> 
            <!-- <h2 class="title">马儿铃声响叮当，令人精神多欢畅   ヾ(≧▽≦*)o</h2> --> 
          </div>
          <div id="J_commentPrudoct" class="home-review-box xm-plain-box J_itemBox J_reviewBox is-visible"> 
            <!-- <h2 class="title">我们今晚滑雪真快乐，把滑雪歌儿唱  (♥◠‿◠)ﾉ  ʅ(‾◡◝)</h2> --> 
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!--     主产品end       -->
<myfooter> 
  <script src="${ctxsta}/os/js/index.js"></script> 
</myfooter>
</body>
</html>