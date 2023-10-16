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
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		
		<span>제목</span>
		<input id="title" type="text" class="form-control">
		
		<span>주소</span>
		<input id="address" type="text" class="form-control">
		
		<input id="submitBtn" class="my-3 btn btn-success" type="button" value="추가">
	
	</div>

<script>
	$(document).ready(function () {
		
		$("#submitBtn").on("click", function(e) {
			
			let title = $("#title").val().trim();
			if (title == false)
			{
				alert("제목을 입력하세요.")
				return;
			}
			
			let address = $("#address").val().trim();
			if (address == false)
			{
				alert("주소를 입력하세요.")
				return;
			}
			
			$.ajax({
				
				type:"POST"
				, url:"/lesson06/quiz01/add-bookmark"
				, data:{"title" : title, "address" : address}
				, success : function(data) {
					alert("추가 되었습니다.")
					if (data == "성공")
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