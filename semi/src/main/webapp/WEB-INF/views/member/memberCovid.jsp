<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	h4{
		margin: 0 auto;
	}
	img {
		margin-top: 50px;
		width: 1500px;
	}
</style>
<title>헤더</title>
</head>
<body>
	<div id='guide'>
		<img src="/img/guide/covidemergency.png"/>
	</div>
</body>
</html>