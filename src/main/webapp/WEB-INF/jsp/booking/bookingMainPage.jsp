<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<!-- jquery 원본 -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

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
		<section class="banner bg-info">
			<img id="bannerImage" class="w-100" src="/img/booking/test06_banner1.jpg" alt="banner"  height="500">
		</section>
		<section class="reserve d-flex">
			<section class="real-time-reserved col-4 d-flex justify-content-center align-items-center">
			    <div class="display-4 text-white">실시간<br>예약하기</div>
			</section>
			<section class="confirm col-4">
			    <div class="m-3">
			        <span class="reserve-confirm mr-3">예약 확인</span>
			    </div>
			
			    <!-- 예약 확인 -->
			    <div id="memberInputBox" class="m-2">
			        <div class="d-flex justify-content-end mr-3">
			            <span class="text-white">이름:</span>
			            <input type="text" id="name" class="form-control input-form">
			        </div>
			        <div class="d-flex mt-2 justify-content-end mr-3">
			            <span class="text-white">전화번호:</span>
			            <input type="text" id="phoneNumber" class="form-control input-form">
			        </div>
			
			        <!-- 버튼 -->
			        <div class="text-right mt-3 mr-3">
			            <button type="button" class="btn btn-success submit-btn">조회 하기</button>
			        </div>
			    </div>
			</section>
			<section class="inquiry col-4 d-flex justify-content-center align-items-center">
			    <div class="text-white">
			        <h4 class="font-weight-bold">예약문의:</h4>
			        <h1>010-<br>0000-1111</h1>
			    </div>
			</section>
		</section>
		<footer>
		    <small class="text-secondary">
		        제주특별자치도 제주시 애월읍<br>
		        사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목<br>
		        Copyright 2025 tongnamu. All right reserved.
		    </small>
		</footer>
	</div>
	
	<script>
	
		$(document).ready(function() {
			
			$('.submit-btn').on("click", function(e) {
				
				let name = $('#name').val().trim();
				let phoneNumber = $('#phoneNumber').val().trim();
				
				if (!name)
				{
					alert("이름을 입력해주세요.");
					return;
				}
				if (!phoneNumber)
				{
					alert("전화번호를 입력해주세요.");
					return;
				}
				
			
				// ajax 통신			
				 $.ajax({
					
					// request
					type:"POST"
					,url:"/booking/search-reservation"
					,data : {"name":name, "phoneNumber":phoneNumber}
				
					// response
					,success:function(data) {
						// {"code":400, "error_message":"데이터가 존재하지 않습니다."} 혹은
						// {"code":200, "result":{"id":1, "name":...}}
							
						if (data.code == 200) {
							console.log(data.result)
							alert
							(
									"이름 : " + data.result.name + "\n" +
									"날짜 : " + data.result.date.substring(0,10) + "\n" +
									"일수 : " + data.result.day + "\n" +
									"인원 : " + data.result.headcount + "\n" +
									"상태 : " + data.result.state
							 );
						} else if (data.code == 400) {
							alert(data.error_message);
							return;
						}
					}
					,error:function(request, status, error){
						alert("조회에 실패했습니다. 관리자에게 문의해주세요");
					}
				
				
				
				 }); 
				
				
				
				
			
			});
		});
	
		
	</script>

	
	
	
	
</body>
</html>