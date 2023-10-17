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
					<td><button type="button" class="deleteBtn btn btn-danger" value="${bookmark.id}">삭제</button></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
<script>
	$(document).ready(function() {
		
		$('.deleteBtn').on("click", function(e) {
			
			let id = $(this).val();
			
			$.ajax({
			
				type:"POST"
				,url:"/lesson06/quiz02/delete-data"
				,data:{"id":id}
				,success:function(data) {
					
					if (data.is_delete == "success")
					{
						location.href = "/lesson06/quiz01/add-result";
					}
					else
					{
						alert("삭제 실패")
					}
					
				}
				,error:function(request, status, error) {
					alert("삭제할때 에러발생");
				}
				
			})
			
			
		});
		
		
		
		
	});



</script>

</body>
</html>