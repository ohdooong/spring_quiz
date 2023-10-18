<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<header>
			<div class="h-75 d-flex justify-content-center align-items-center">
				<h1 class="display-4">통나무 펜션</h1>
			</div>
			<nav class="h-25 bg-warning">
				<div class="pt-2">
					<ul class="nav nav-fill">
						<li class="nav-item">
							<a href="#" class="text-white font-weight-bold">펜션소개</a>
						</li>
						<li class="nav-item">
							<a href="#" class="text-white font-weight-bold">객실보기</a>
						</li>
						<li class="nav-item">
							<a href="#" class="text-white font-weight-bold">예약하기</a>
						</li>
						<li class="nav-item">
							<a href="/booking/reservation-List" class="text-white font-weight-bold">예약목록</a>
						</li>
					</ul>
				</div>
			</nav>
		</header>
		
		
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
				<%-- <c:forEach>
					
					
					
				</c:forEach>	 --%>
				</tbody>
			</table>
		</section>
		
		<footer >
			<small class="text-secondary">제주특별자치도 제주시 애월읍</small><br>
			<small class="text-secondary">사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목</small><br>
			<small class="text-secondary">Copyright 2025 tongnamu.All right reserved.</small>
		</footer>
	</div>




</body>
</html>