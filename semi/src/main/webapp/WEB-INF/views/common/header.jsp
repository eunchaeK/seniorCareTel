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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/79fd19de4b.js" crossorigin="anonymous"></script>
<style type="text/css">
.headerTbl {
	padding-left: 150px;
}

#header_menu>a {
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
	width: 1000px;
}

.menu3 > a {
	margin-right: 30px;
}

.icon {
	font-size: 100px;
}

#login>a {
	color: gray;
	text-decoration: none;
}
a:hover{font-weight:bolder;}


</style>
<title>헤더</title>
</head>
<body>
	<table class="headerTbl">
		<tr>
			<td id="header_menu" class="menu1">
				<a href="${contextPath}/member/memberMain"><i class="fa-solid fa-square-plus fa-2x"></i></a>
			</td>
			<td id="header_menu" class="menu2">
				<a href="${contextPath}/member/memberMain">시니어 케어텔</a>
			</td>
			<td id="header_menu" class="menu3">
				<a class="dropdown" href="#" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">요양원 소개</a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item" href="${contextPath}/member/memberFacilities">시설소개</a></li>
						<li><a class="dropdown-item" href="${contextPath}/member/memberStaff">직원소개</a></li>
						<li><a class="dropdown-item" href="${contextPath}/member/memberMap">오시는길</a></li>
					</ul>
				<a href="${contextPath}/member/memberCovid">코로나19</a>
				<a class="dropdown" href="#" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">알림마당</a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item" href="${contextPath}/member/memberMenu">식단표</a></li>
						<li><a class="dropdown-item" href="${contextPath}/member/memberGuideInfo">입소절차</a></li>
						<li><a class="dropdown-item" href="${contextPath}/member/memberGuideInfoCost">입소비용</a></li>
					</ul>
				<a class="dropdown" href="#" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">면회</a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item" href="${contextPath}/member/memberCreateReservation">예약</a></li>
						<li><a class="dropdown-item" href="${contextPath}/member/searchReservations">조회</a></li>
					</ul>
				<c:choose>
					<c:when test="${isLogOn eq true}">
						<a href="${contextPath}/member/logout">로그아웃</a>
					</c:when>
					<c:otherwise>
						<a href="${contextPath}/member/memberLogin">로그인</a> <br>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>


</body>
</html>