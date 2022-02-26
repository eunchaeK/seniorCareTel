<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>면회 예약 수정</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
	<form method="post">
	<h1 class="text_center">예약 정보 수정창</h1>
	<table  align="center">
		<tr class="tblRow">
	      <td width="200"><label for="number">예약번호</label></td>
	      <td width="400"><input type="number" id="visit_number" name="visit_number" readonly="readonly" value="${reservation.visit_number}"></td>
	   </tr>
	   <tr>
	      <td width="200"><label for="visit_meeting">면회방법</label></td>
	      <td width="400"><input type="text" id="visit_meeting" name="visit_meeting" value="${reservation.visit_meeting}"></td>
	   </tr>
	   <tr>
	      <td width="200"><label for="visit_date">면회날짜</label></td>
	      <td width="400"><input type="text" id="visit_date" name="visit_date" value="${reservation.visit_date}"></td>
	   </tr>
	   <tr>
	      <td width="200"><label for="visit_time">면회시간</label></td>
	      <td width="400"><input type="text" id="visit_time" name="visit_time" value="${reservation.visit_time}"></td>
	   </tr>
	   <tr>
	      <td width="200"><label for="member_name">보호자이름</label></td>
	      <td width="400"><input type="text" id="member_name" name="member_name" readonly="readonly" value="${reservation.member_name}"></td>
	   </tr>
	   <tr>
	      <td width="200"><label for="patient_name">환자이름</label></td>
	      <td width="400"><input type="text" id="patient_name" name="patient_name" readonly="readonly" value="${reservation.patient_name}"></td>
	   </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="수정하기">
	       					<input type="reset" value="다시입력"></td>
	    </tr>
	</table>
	</form>
</body>
</html>