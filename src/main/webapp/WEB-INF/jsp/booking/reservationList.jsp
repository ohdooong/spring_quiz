<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 목록</title>
<!-- BootStrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<!-- AJAX를 사용하려면 반드시 jQuery 원본 필요 -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<!-- 내가 만든 스타일시트 -->
<link rel="stylesheet" type="text/css" href="/css/booking/booking_style.css">
</head>
<body>
	<div id="wrap" class="container">
		<header class="d-flex justify-content-center align-items-center">
			<div class="display-4"><a id="logo" class="text-dark" href="/booking/booking-main">통나무 펜션</a></div>
		</header>
		<nav>
			<ul class="nav nav-fill">
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">팬션소개</a></li>
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
				<li class="nav-item"><a href="/booking/add-booking-view" class="nav-link text-white font-weight-bold">예약하기</a></li>
				<li class="nav-item"><a href="/booking/reservation-List" class="nav-link text-white font-weight-bold">예약목록</a></li>
			</ul>
		</nav>
		
		
		<section class="contents">
			<table class="table text-center">
				<thead>
					<tr>
						<th>이름</th>
						<th>예약날짜</th>
						<th>숙박일수</th>
						<th>숙박인원</th>
						<th>전화번호</th>
						<th>예약상태</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${bookingList}" var="booking">
				<tr>
					<td>${booking.name}</td>
					<td><fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 dd일" /></td>
					<td>${booking.day}</td>
					<td>${booking.headcount}</td>
					<td>${booking.phoneNumber}</td>
					<c:choose>
						<c:when test="${booking.state eq '대기중'}">
							<td class="text-primary">${booking.state}</td>
						</c:when>
						<c:when test="${booking.state eq '확정'}">
							<td class="text-success">${booking.state}</td>
						</c:when>
						<c:when test="${booking.state eq '취소'}">
							<td class="text-danger">${booking.state}</td>
						</c:when>
						<c:when test="${booking.state}">
							<td>${booking.state}</td>
						</c:when>
					
					
					</c:choose>
					<td><button type="button" class="del-btn btn btn-danger" data-booking-id="${booking.id}">삭제</button></td>
				<tr>
				</c:forEach>
				</tbody>
			</table>
		</section>
		
		<footer >
			<small class="text-secondary">제주특별자치도 제주시 애월읍</small><br>
			<small class="text-secondary">사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목</small><br>
			<small class="text-secondary">Copyright 2025 tongnamu.All right reserved.</small>
		</footer>
	</div>

<script>

	$(document).ready(function() {
		
		$('.del-btn').on("click", function() {
			
			let id = $(this).data('booking-id');
			
			$.ajax({
				
				type:"delete"
				,url:"/booking/delete-booking"      // 뷰 요청이 아님
				,data:{"id":id}
				
				
				,success:function(data) {   // JSON    OR   Dictionary
					// {"code":200, "result":"success"}
					if (data.result == "success") {
						alert("삭제 되었습니다.");
						location.reload(true);
					}
				}
				,error:function(request, status, error) {
					alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.")
				}
				
				
				
				
			});
			
		});
	});



</script>


</body>
</html>