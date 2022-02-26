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
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/css/memberMain.css" />
    <script defer src="/js/memberMain.js"></script>
    <title>헤더</title>
	<link href='/css/fontawesome/all.css' rel='stylesheet' />
	<link href='/css/common.css' rel='stylesheet' />
	<script src='/css/fontawesome/all.js'></script>
  </head>
  <body>
        <div class="slide_wrapper">
        <ul class="slides">
          <li><img src="/img/member/senior.jpg" alt="senior" /></li>
          <li><img src="/img/member/senior2.jpg" alt="senior2" /></li>
          <li><img src="/img/member/senior3.png" alt="senior3" /></li>
          <li><img src="/img/member/senior.jpg" alt="senior" /></li>
        </ul>
      </div>

      <div class="controls">
        <button class="prev">
          <i class="fas fa-caret-left fa-2x"></i>
        </button>
        <button class="next">
          <i class="fas fa-caret-right fa-2x"></i>
        </button>
      </div>
    <table>
      <!--  
            	session = request.getSession();
            	out.print("admin_id : " + session.getAttribute("admin_id") + "<br>");
           -->

      <tr>
       	<td><a href="${contextPath}/member/memberFacilities"><img src="/img/member/hospital.jpg" /></a></td>
        <td id="empty"></td>
        <td><a href="${contextPath}/member/memberStaff"><img src="/img/member/caregiver.jpg" /></a></td>
        <td id="empty"></td>
        <td><a href="${contextPath}/member/memberCovid"><img src="/img/member/front.jpg" /></a></td>
        <td id="empty"></td>
        <td><a href="${contextPath}/member/memberCreateReservation"><img src="/img/member/note.jpg" /></a></td>
      </tr>
      <tr>
        <td id="radius">시설 소개</td>
        <td></td>
        <td id="radius">직원 안내</td>
        <td></td>
        <td id="radius">코로나19 안내</td>
        <td></td>
        <td id="radius">면회 예약</td>
      </tr>
    </table>
  </body>
</html>

