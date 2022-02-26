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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<style type="text/css">
 
 	/* 말머리 부분*/
 	#head{
 		text-align:left;
 	}
 
 
  	.wrapper{height: 100vh;}
  	
  	/* 검색부분 */
  	.searchArea{margin: 15px 0px;}
  	.leftAlign{text-align: left;}
  	
  	/* 검색부분 (https://wazacs.tistory.com/34) */
  	/* 검색타입 */
 	 /* IE */
	 #searchType::-ms-expand { 
		display: none;
	 }
	 #searchType {
	  -o-appearance: none;
	  -webkit-appearance: none;
	  -moz-appearance: none;
	  appearance: none;
	  
	  width: 110px;
	  height: 30px;
	  background: url('https://image.flaticon.com/icons/png/512/1174/1174405.png') calc(100% - 5px) center no-repeat;
	  background-size: 18px;
	  padding: 6px 30px 5px 10px;
	  border-radius: 4px;
	  outline: 0 none;
	}
	#searchType option {
	  background: #ebebeb;
	  padding: 3px 3px;
	}
  	 
  	/* input 태그 */ 
  	.searchText{
  	  width: 140px;
	  height: 28px;
	  border: 1px solid #454545;
  	  border-radius: 4px;
  	  padding: 0px 10px;
  	  outline: 0 none;
  	}
  	
  	/* 버튼 클래스(검색, 회원삭제) */
  	.btn{
  	  margin:0;
  	  padding:0;
      border: 0;
  	  border-radius: 4px;
  	  height: 30px;
  	}
  	
  	/* 검색 버튼 */
  	#searchBtn{
  	  width: 42px;
  	  background-color: orange;
  	  cursor: pointer;
  	}
  	
  	/* 삭제 버튼 */
  	#memDelBtn{
  	  width: 65px;
  	  background-color: black;
  	  color: white;
  	  margin: 15px 0px;
  	}
  	
  	/* 테이블 css */
	#memTable,#creatingTable{
  	  border: 1px solid black;
  	  text-align: center;
  	  width: 100%;
  	}
  	#memTable,,#setTable tr{text-align: center;}
  	#tableHead{background-color: #c4c4c4}
  	
  	
  	
  </style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<title>헤더</title>
</head>
<body>
	
	<div id="head">
		<h1>호실 관리</h1>
	</div>

           <div class="wrapper">
	<div class="searchArea leftAlign">
		<form name="search-form" autocomplete="off">
		   <select name="type" id="searchType">
		     <option selected value="">전체보기</option>
		     <option value="visit_number">방 번호</option>
		     <option value="visit_meeting">직원 번호</option>
		     <option value="member_name">직원 이름</option>
		     <option value="patient_number">환자 번호</option>
		     <option value="patient_name">환자 이름</option>
		   </select>
		   <input type="text" name="keyword" id="searchKey" value=""></input>
		   <input type="button" id="searchBtn"  class="btn" value="검색"/>
   		</form>
   </div>
   
    
   <div id="pastTable">
	   <table id="memTable">
	  	 	<thead>
			   	<tr id="tableHead"> 
			   	  <td><input type="checkbox" id="delCheckAll"/></td>
			   	  <td><b>방 번호</b></td>
				  <td><b>직원 번호</b></td>
				  <td><b>직원 이름</b></td>
				  <td><b>환자 번호</b></td>
				  <td><b>환자 이름</b></td>
				  <td><b>수정</b></td>
			   	  
			   	</tr>
		   </thead>
	   	
	   	  <tbody>
	   	
			   	<tr>
			   			<td><input type="checkbox" class="delCheck" name="delete_numbers" value="${reservation.visit_number}"/></td>
						<td>1</td>
						<td>1</td>
						<td>care1</td>
						<td>1</td>
						<td>paient1</td>
						<td><a href="#">수정</a></td>
				</tr>
				
				<tr>
						<td><input type="checkbox" class="delCheck" name="delete_numbers" value="${reservation.visit_number}"/></td>
						<td>2</td>
						<td>1</td>
						<td>care1</td>
						<td>2</td>
						<td>paient2</td>
						<td><a href="#">수정</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="delCheck" name="delete_numbers" value="${reservation.visit_number}"/></td>
						<td>3</td>
						<td>1</td>
						<td>care1</td>
						<td>2</td>
						<td>paient3</td>
						<td><a href="#">수정</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="delCheck" name="delete_numbers" value="${reservation.visit_number}"/></td>
						<td>4</td>
						<td>1</td>
						<td>care1</td>
						<td>2</td>
						<td>paient4</td>
						<td><a href="#">수정</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="delCheck" name="delete_numbers" value="${reservation.visit_number}"/></td>
						<td>5</td>
						<td>2</td>
						<td>care2</td>
						<td>2</td>
						<td>paient5</td>
						<td><a href="#">수정</a></td>
					</tr>
					<tr>
						<td><input type="checkbox" class="delCheck" name="delete_numbers" value="${reservation.visit_number}"/></td>
						<td>6</td>
						<td>2</td>
						<td>care2</td>
						<td>2</td>
						<td>paient6</td>
						<td><a href="#">수정</a></td>
					</tr>
		 </tbody>
	   </table>
   </div>
   
   <div class="bottom">
	   <ul class="paging">
		  	<c:if test="${paging.prev}">
		  		<span><a href='<c:url value="/employee/searchReservations?page=${paging.startPage-1}"/>'>이전</a></span>
		  	</c:if>
		  	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
		        <span><a href='<c:url value="/employee/searchReservations?page=${num}"/>'>${num}</a></span>
		    </c:forEach>
		    <c:if test="${paging.next && paging.endPage>0}">
		        <span><a href='<c:url value="/employee/searchReservations?page=${paging.endPage+1}"/>'>다음</a></span>
		    </c:if>
	    </ul>
    </div>
  
</div>   
	
</body>


</html>