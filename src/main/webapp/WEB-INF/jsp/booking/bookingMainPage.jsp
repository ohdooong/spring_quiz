<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션</title>

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
		
		<section class="contents bg-primary">
			<article>
				<img src="/img/booking/test06_banner1.jpg" class="w-100">
			</article>
			<article class="reservation d-flex">
				<div class="col-4 bg-dark d-flex justify-content-center align-items-center">
					<div>
						<div class="display-4 text-white">실시간</div>
						<div class="display-4 text-white">예약하기</div>
					</div>
				</div>
				<div class="col-5">
					<h3 class="mt-3">예약 확인</h3>
					<div>
						<div class="form-inline">
							<label for="name">이름: </label>
							<input type="text" class="form-control col-7" id="name" name="name">
						</div>
						
						
						<div class="form-inline">
							<label for="name">전화번호: </label>
							<input type="text" class="form-control col-7" id="phoneNumber" name="phoneNumber">
						</div>
						
						<button type="button" id="search" class="btn btn-success">조회하기</button>
					</div>
				</div>
				<div class="col-3 bg-primary d-flex justify-content-center align-items-center">
					<div>
						<h2 class="font-weight-bold text-white">예약문의</h2>
						<h2 class="font-weight-bold text-white">010-</h2>
						<h2 class="font-weight-bold text-white">0000-1111</h2>
					</div>
				</div>
			</article>
		</section>
		
		<footer >
			<small class="text-secondary">제주특별자치도 제주시 애월읍</small><br>
			<small class="text-secondary">사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목</small><br>
			<small class="text-secondary">Copyright 2025 tongnamu.All right reserved.</small>
		</footer>
	</div>
</body>
</html>