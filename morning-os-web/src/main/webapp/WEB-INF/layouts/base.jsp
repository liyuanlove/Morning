<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	String projectPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	String staticPath = projectPath + "/static";
	String imagePath = projectPath + "/uploads";
%>
<%--项目路径 --%>
<c:set var="basePath" value="<%=projectPath%>"></c:set>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!--占时写死，文件服务器-->
<c:set var="imageServer" value="//119.29.209.127"/>
<%--静态资源路径 --%>
<c:set var="ctxsta" value="${pageContext.request.contextPath}/static"/>
<%--页面显示图片的前缀路径--%>
<c:set var="ctximg" value="${pageContext.request.contextPath}/uploads"/>




