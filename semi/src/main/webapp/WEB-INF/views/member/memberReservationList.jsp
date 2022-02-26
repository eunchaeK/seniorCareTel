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

    <title>예약 확인</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <link href='/css/common.css' rel='stylesheet' />
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
  	
  	/* 면회 예약 신청 버튼*/
  	#memberCreateReservBtn{
  		background-color: orange;
	    cursor:pointer;
	    border:none;
	    outline:none;
	    width: 110px;
  		float: right;
  		padding: 5px;
  	}
  	
  	
  	#memberCreateReservBtn:hover{
  		opacity: 0.7;
  	}
  	
  	
  </style>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

	//검색리스트 요청 ajax
	
	$(document).ready(function(){
		
		$("#searchBtn").click(function searchList(){
			
			const type = $("#searchType").val();
			const keyword = $("#searchKey").val().trim(); // trim():앞뒤 공백지워줌.
			
			//검색 내용 없을 시 alert(전체보기 검색 제외)
			if(type !="" && keyword ==""){
				alert('검색할 내용을 입력하세요!');
				return false;
			}
			$.ajax({
				
				type:'GET',
				url: "/member/getMemberReservList", //클라이언트가 HTTP 요청을 보낼 서버의 URL 주소( GetMapping과 연동)
				data: {
					"type": type,
					"keyword": keyword
				},// 요청과 함께 보낼 데이터 -> Controller 에서 requestParam으로 받을 것.
				error: function(error){
					alert("Error!");
				},
				success: function(result){
					//Controller에서 받은 List<AdminDTO> 형식의 list를 result로 받는다.
					
					
					$('#memTable > tbody').empty();//테이블 초기화
					if(result.length>=1){
						result.forEach(function(item){
							str="<tr>";
							str +="<td><input type='checkbox' class='delCheck' name='delete_numbers' value="+item.visit_number+"/></td>";
							str +="<td>"+item.visit_number+"</td>";
							str +="<td>"+item.visit_meeting+"</td>";
							str +="<td>"+item.visit_date+"</td>";
							str +="<td>"+item.visit_time+"</td>";
							str +="<td>"+item.member_name+"</td>";
							str +="<td>"+item.patient_number+"</td>";
							str +="<td>"+item.patient_name+"</td>";
							str +="</tr>"
							$('#memTable').append(str);
						})
					}else{
						str = "<tr>";
						str += "<td colspan='7'><div>해당 회원의 데이터가 없습니다.</div></td>"
						str = "</tr>";
						$('#memTable').append(str);
					}
				}
			});
		});
	});

</script>
  </head>
  <body>
    <div id="head">
		<h1>면회 예약 조회</h1>
	</div>

	
           <div class="wrapper">
	<div class="searchArea leftAlign">
		<form name="search-form" autocomplete="off">
		   <select name="type" id="searchType">
		     <option selected value="">전체보기</option>
		     <option value="visit_number">예약 번호</option>
		     <option value="visit_meeting">면회 종류</option>
		     <option value="member_name">신청 보호자</option>
		     <option value="patient_number">환자 번호</option>
		     <option value="patient_name">환자 이름</option>
		   </select>
		   <input type="text" name="keyword" id="searchKey" value=""></input>
		   <input type="button" id="searchBtn"  class="btn" value="검색"/>
		   <button id= "memberCreateReservBtn" type="button" onclick="location.href='${contextPath}/member/memberCreateReservation'">면회 예약 신청</button>
   		</form>
   </div>
   
    
   <div id="pastTable">
	   <table id="memTable">
	  	 	<thead>
			   	<tr id="tableHead"> 
			   	  <td><input type="checkbox" id="delCheckAll"/></td>
			   	  <td><b>예약번호</b></td>	
			   	  <td><b>면회 종류</b></td>	
			   	  <td><b>면회 날짜</b></td>	
			   	  <td><b>면회 시간</b></td>	
			   	  <td><b>신청 보호자</b></td>	
			   	  <td><b>환자 번호</b></td>	
			   	  <td><b>환자 이름</b></td>	
			   	  <td><b>수정</b></td>
				  <td><b>삭제</b></td>
			   	  
			   	</tr>
		   </thead>
	   	
	   	  <tbody>
	   	
			   	<c:forEach var="reservation" items="${reservationList}">
			   	
			   		<tr id="${reservation.patient_name}">
			   		
				   			<td><input type="checkbox" class="delCheck" name="delete_numbers" value="${reservation.visit_number}"/></td>
				   			<td>${reservation.visit_number}</td>
				   			<td>${reservation.visit_meeting}</td>
				   			<td>${reservation.visit_date}</td>
				   			<td>${reservation.visit_time}</td>
				   			<td>${reservation.member_name}</td>
				   			<td>${reservation.patient_number}</td>
				   			<td>${reservation.patient_name}</td>
				   			<td><a href="${contextPath}/member/reservUpdate?visit_number=${reservation.visit_number}">수정</a></td>
							<td><a href="${contextPath}/member/reservDelete?visit_number=${reservation.visit_number}">삭제</a></td>
				   			
				   	</tr>
			   	</c:forEach>
			   	
		 </tbody>
	   </table>
	   <div class="bottom">
	   <ul class="paging">
		  	<c:if test="${paging.prev}">
		  		<span><a href='<c:url value="/member/searchReservations?page=${paging.startPage-1}"/>'>이전</a></span>
		  	</c:if>
		  	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
		        <span><a href='<c:url value="/member/searchReservations?page=${num}"/>'>${num}</a></span>
		    </c:forEach>
		    <c:if test="${paging.next && paging.endPage>0}">
		        <span><a href='<c:url value="/member/searchReservations?page=${paging.endPage+1}"/>'>다음</a></span>
		    </c:if>
	    </ul>
    </div>
   </div>
  
</div>   
	
  </body>
</html>
