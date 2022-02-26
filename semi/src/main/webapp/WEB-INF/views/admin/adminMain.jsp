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
	img {
		width: 250px;
		height: 250px;
	}
	
	#empty {
		width: 100px;
	}
	
	#menu {
		border-collapse : collapse;
		margin-left: auto; 
		margin-right: auto;
		
	}
	
	#menu_1 > .member, .reservation {
		border-radius: 10px 10px 0px 0px;
		height: 350px;
	}
	
	#menu_1 > td {
		border: 1px solid black;
		border-bottom: 0;
	}
	
	#menu_1 > .member {
		width: 400px;
		table-layout: fixed;
	}
	
	#menu_1 > .reservation {
		width: 400px;
	}
	
	#menu_1 > .none {
		border: 0;
		width: 100px;
	}
	
	#menu_2 {
		height: 40px;
		color: white;
		background-color: gray;
	}
	
	#menu_2 > .none {
		width: 100px;
		background-color: white;
	}
	
	#menu_2 > #text {
		font-size: 20px;
		border-radius: 0px 0px 10px 10px;
	}
	
	
	#menu_2 > td > a {
		text-decoration: none;
		color: white;
	}
	
</style>
<title>헤더</title>
</head>
<body>
	<table id="menu">
        <tr id="menu_1">
            <td class="member"><a href="${contextPath}/admin/memlist"><img src="/img/admin/team.png"/></a></td>
            <td class="none"></td>
            <td class="reservation"><a href="${contextPath}/admin/reservList"><img src="/img/admin/online-reservation.png"/></a></td>
        </tr>
        <tr id="menu_2">
            <td id="text"><a href="${contextPath}/admin/memlist">회원 관리</a></td>
            <td class="none"></td>
            <td id="text"><a href="${contextPath}/admin/reservList">면회 관리</a></td>
        </tr>
	</table>
</body>
</html>
