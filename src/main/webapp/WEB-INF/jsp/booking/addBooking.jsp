<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션</title>
<!-- BootStrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<!-- jquery 원본 -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<!-- 내가 만든 스타일시트 -->
<link rel="stylesheet" type="text/css" href="/css/booking/booking_style.css">
</head>
<body>
	<div id="wrap" class="container">
		<header class="d-flex justify-content-center align-items-center">
			<div  class="display-4"><a id="logo" href="/booking/booking-main" class="text-dark">통나무 펜션</a></div>
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
			<h2 class="text-center font-weight-bold m-4">예약 하기</h2>
			<div class="d-flex justify-content-center">
				<div class="reservation-box">
					<div class="subject-text my-2 font-weight-bold">이름</div>
					<input type="text" class="form-control" name="name">

					<div class="subject-text my-2 font-weight-bold">예약날짜</div>
					<input type="text" class="form-control" name="date">

					<div class="subject-text my-2 font-weight-bold">숙박일수</div>
					<input type="text" class="form-control" name="day">

					<div class="subject-text my-2 font-weight-bold">숙박인원</div>
					<input type="text" class="form-control" name="headcount">
					
					<div class="subject-text my-2 font-weight-bold">전화번호</div>
					<input type="text" class="form-control" name="phoneNumber">
					
					<button type="button" id="reservationBtn" class="btn btn-warning w-100 mt-3">예약하기</button>
				</div>
			</div>
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
		// 1) datepicker
		$('input[name=date]').datepicker({
			dateFormat:"yy-mm-dd"
			, minDate:0 // 오늘날짜부터 선택
		});
		
		$('#reservationBtn').on('click', function() {
			
			console.log("안녕")
			
			let name = $('input[name=name]').val().trim();
			let date = $('input[name=date]').val().trim();
			let day = $('input[name=day]').val().trim();
			let headcount = $('input[name=headcount]').val().trim();
			let phoneNumber = $('input[name=phoneNumber]').val().trim();
			
			if (!name)
			{
				alert("이름을 입력하세요.");
				return;
			}
			if (!date)
			{
				alert("예약날짜를 선택해주세요");
				return;
			}
			
			if(!day) 
			{
				alert("숙박일수를 입력해주세요.")
				return;
			}
			if (isNaN(day)) // 숫자가 아닐 때 true
			{
				alert("숙박일수는 숫자만 입력가능합니다.");
				return;
			}
			if (!headcount)
			{
				alert("숙박인원을 입력하세요.");
				return;
			}
			if (isNaN(headcount)) // 숫자가 아닐 때 true
			{
				alert("숙박인원은 숫자만 입력가능합니다.");
				return;
			}
			if (!phoneNumber)
			{
				alert("전화번호를 입력해주세요.");
				return;
			}
			
			$.ajax({
				
				type:"POST"
				,url:"/booking/add-booking"
				,data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
				
				,success:function(data) {
					if (data.code == 200){
						alert("예약되었습니다.");
						location.href = "/booking/reservation-List";
					} else {
						alert("예약에 실패했습니다."); // logic error
					}
				}
				, error (request, status, error) {
					alert("예약실패");
				}
				
				
			});
		});
		
		
		
	});


</script>
	
	
</body>
</html>