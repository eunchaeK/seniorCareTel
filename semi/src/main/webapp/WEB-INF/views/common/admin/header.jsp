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
<link href='/css/fontawesome/all.css' rel='stylesheet' />
<script src='/css/fontawesome/all.js'></script>
<style type="text/css">
.headerTbl {
	padding-left: 150px;
}
.header_menu>a {
	color: black;
	text-decoration: none;
	padding-right: 20px;
	font-size: 20px;
}

.menu1 {
	text-align: right;
}

.menu2 {
	width: 300px;
	text-align: left;
}

.menu3 {
	width: 900px;
}

.menu3 > a {
	margin-right: 50px;
}

.icon {
	font-size: 100px;
}

#login>a {
	color: gray;
	text-decoration: none;
}
</style>
<title>헤더</title>
</head>
<body>


	<table class="headerTbl">
		<tr>
			<td class="header_menu menu1">
				<a href="${contextPath}/admin/adminMain"><i class="fas fa-plus-square icon"></i></a>
			</td>
			<td class=" header_menu menu2">
				<a href="${contextPath}/admin/adminMain">시니어 케어텔</a>
			</td>
			
			<td class="header_menu menu3">
				<a href="/admin/memlist">회원 관리</a>
				<a href="/admin/emplist">요양사 관리</a>
				<a href="/admin/reservList">면회 관리</a>
				<c:if test="${isLogOn eq true}">
					<a href="/admin/logout">로그아웃</a>
				</c:if>
			</td>
			
		</tr>
	</table>

</body>
</html>