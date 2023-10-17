<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨 찾기 추가</title>

<!-- BootStrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<!-- AJAX를 사용하려면 반드시 jQuery 원본 필요 -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<div class="form-group">	
			<label for="title">제목</label>
			<input id="title" type="text" class="form-control">
			
				<label for="address">URL</label>
			<div class="d-flex">
				<input id="address" type="text" class="form-control col-9">
				<button id="dupCheckBtn" type="button" class="btn btn-info ml-3">중복확인</button>
			</div>
			
			<small id="nameStatus"></small>
			<button id="submitBtn" class="my-3 btn btn-success w-100" type="button">추가</button>
		</div>
	</div>

<script>
	$(document).ready(function () {
		
		$('#dupCheckBtn').on("click", function(e) {
			//<span class="text-danger">안녕</span>
			
			let title = $("#title").val().trim();
			if (!title)
			{
				$("#nameStatus").append('<span class="text-danger">제목이 비었습니다.</span>')
				return;
			}
			
			let address = $("#address").val().trim();
			if (address == "")
			{
				$("#nameStatus").append('<span class="text-danger">주소가 비었습니다.</span>')
				return;
			}
			
			$.ajax({
				
				url:"/lesson06/quiz02/is-duplication"
				, data:{"url":address}
				, success:function(data) {
					
				}
				
				
			})
			
			
			
		});
		
		$("#submitBtn").on("click", function(e) {
			
			let title = $("#title").val().trim();
			let address = $("#address").val().trim();
			
			console.log(title);
			console.log(address);
			
			if (!title)
			{
				alert("제목을 입력하세요.");
				return;
			}
			
			if (address == "")
			{
				alert("주소를 입력하세요.");
				return;
			}
			
			if (address.startsWith("http://") == false && address.startsWith("https://") == false)
			{
				alert("주소 형식이 잘못되었습니다.");
				return;
			}
			
			
			$.ajax({
				
				type:"POST"
				, url:"/lesson06/quiz01/add-bookmark"
				, data:{"name" : title, "url" : address}
				, success : function(data) { // data : response 응답값(JSON String) => Dictionary => js에선 String 형태로 넘어와 parsing을 해주어야 하지만, jQuery에선 자동으로 해준다.
					
					// data는 JSON String => Object 변환된 형태로 사용할 수 있다.
					// jquery의 ajax 함수 기능
					
					alert(data.code);
					
					
					if (data.result == "success") // 실무에서는 JSON 으로 응답값 날라온다. 페이스북, 인스타, ...
					{
						location.href = "/lesson06/quiz01/add-result"	
					}
				}
				, error:function(request, status, error) {
					alert(request);
					alert(status);
					alert(error);
				}
				
				
			});
			
			
			
		});
		
		
		
	});



</script>

</body>
</html>