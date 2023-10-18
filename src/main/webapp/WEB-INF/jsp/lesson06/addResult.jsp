<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨 찾기 목록</title>

<!-- BootStrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<!-- AJAX를 사용하려면 반드시 jQuery 원본 필요 -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 목록</h1>
		<table class="table text-center">
			<thead>
				<tr>
					<th>No.</th>				
					<th>이름</th>				
					<th>주소</th>				
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${bookmarks}" var="bookmark" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${bookmark.name}</td>
					<td><a href="${bookmark.url}" target="_blank">${bookmark.url}</a></td>
					<td>
						<!-- 1) value속성을 이용한 값 세팅 -->
						<!--  <button type="button" class="deleteBtn btn btn-danger" value="${bookmark.id}">삭제</button> -->
						
						<!-- 2) data를 이용해서 태그에 값을 세팅 -->
						<!-- ★★★★★★★ 대문자 들어가면 안됨!!!!!!!!!!!!!!!!!!!!!!!! -->
						<button type="button" class="deleteBtn btn btn-danger" data-bookmark-id="${bookmark.id}" data-url>삭제</button>
					</td> 
					
					
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
<script>
	$(document).ready(function() {
		
		$('.deleteBtn').on("click", function(e) {
			
			
			// value 이용
			//let id = $(this).val(); // 지금 클릭된 버튼의 값
			//let id = e.target.value;    // 위의 것과 동일하다
			
			// data 이용
			//data-bookmark-id   // => data("bookmark-id") 함수 사용
			let id = $(this).data('bookmark-id');
			$.ajax({
			
				type:"DELETE"
				,url:"/lesson06/quiz02/delete-data"
				,data:{"id":id}
				,success:function(data) {
					
					if (data.code == 200)
					{
						// location.href = "/lesson06/quiz01/add-result";
						
						// 새로고침 방법
						location.reload(); // 스크롤 위치까지 그대로 
					}
					else  // 보통 dictionary에 오류코드 지정해서 보내고 각각 오류 코드마다 분기해서 코드 작성
					{
						alert("삭제 실패")
					}
					
				}
				,error:function(request, status, error) {
					alert("알 수 없는 에러가 발생했습니다. 관리자에게 문의해주세요.");
				}
				
			})
			
			
		});
		
		
		
		
	});



</script>

</body>
</html>