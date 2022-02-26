<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<!DOCTYPE html>
<html>
<head>



<meta charset="UTF-8">
<style type="text/css">
	img {
		width: 200px;
		height: 200px;
	}
	table {
		margin: auto;
	}
	#empty {
		width: 100px;
	}
	#radius {
	height: 40px;
	color: white;
	background-color: gray;
	border-radius: 0px 0px 10px 10px;
	}
	
	
</style>
<title>헤더</title>
</head>
<body>
<table>
	
  
			<!--  
            	session = request.getSession();
            	out.print("admin_id : " + session.getAttribute("admin_id") + "<br>");
           -->
	
	 
	
        <tr>
            <td><img src="/img/admin/team.png"/></td>
            <td id="empty"></td>
            <td><img src="/img/admin/team.png"/></td>
            <td id="empty"></td>
            
            
        </tr>
        <tr>
            
            <td></td>
            <td id="radius"><a href="${contextPath}/member/memberUpdate">개인 정보 수정</a></td>
			<td></td>
            <td id="radius"><a href="${contextPath}/member/memberUpdatePassword">비밀번호 수정</a></td>
			   	
        </tr>
	</table>


</body>
</html>