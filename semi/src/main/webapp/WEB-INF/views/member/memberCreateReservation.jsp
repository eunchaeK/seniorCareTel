<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>면회 예약 신청</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link href='/css/common.css' rel='stylesheet' />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<style>
* {
	box-sizing: border-box;
}

input {
	width: 384;
	height: 57;
	border-radius: 10px;
	border: 1px solid #c4c4c4;
	font-size: 18px;
	padding: 10px 15px;
	margin: 8px 0px;
}

.control>input {
	background-color: white;
	border: 1px solid #c4c4c4;
	border-radius: 5px;
	margin-top: 30px;
}

.text_center {
	text-align: center;
}

label {
	font-size: 18px;
}
</style>
</head>
<body>
	<form action="/member/reservationInsert" method="post">
		<h1 class="text_center">면회 예약 신청</h1>
		<table align="center">
			<tr class="tblRow">
				<td width="200"><label for="visit_meeting">면회방법<span class="req">*</span></label></td>
				<td width="400"><input type="text" id="visit_meeting" name="visit_meeting" value="${reservation.visit_meeting}"	placeholder="영상 또는 대면"></td>
			</tr>
			<tr>
				<td width="200"><label for="visit_date">면회날짜<span	class="req">*</span></label></td>
				<td width="400"><input type="text" id="visit_date" name="visit_date" value="" placeholder="ex) 2022-01-01"></td>
			</tr>
			<tr>
				<td width="200"><label for="visit_time">면회시간<span class="req">*</span></label></td>
				<td width="400"><input type="" text"" id="visit_time" name="visit_time" value="" placeholder="ex) 12:00:00"></td>
			</tr>
			<tr>
				<td width="200"><label for="member_name">보호자이름<span class="req">*</span></label></td>
				<td width="400"><input type="text" id="member_name"	name="member_name" readonly="readonly" 
						value="<%session = request.getSession(); out.print(session.getAttribute("member_name"));%>"></td>
			</tr>
			<tr>
				<td width="200"><label for="patient_name">환자이름<span class="req">*</span></label></td>
				<td width="400"><input type="text" id="patient_name" name="patient_name" readonly="readonly"
					value="<%session = request.getSession(); out.print(session.getAttribute("patient_name"));%>"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">
					<input id="singIn" type="submit" value="면회예약">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>