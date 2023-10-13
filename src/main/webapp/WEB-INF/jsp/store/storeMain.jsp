<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의 민족</title>

<!-- BootStrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>


<!-- 내가 만든 스타일시트 -->
<link rel="stylesheet" type="text/css" href="/css/store/store_style.css">

</head>
<body>
	<div id="wrap" class="container bg-light p-0">
	
	
		<header class="bg-info d-flex align-items-center">
			<h3 class="font-weight-bold text-white ml-3">배탈의 민족</h3>
		</header>
		
		
		<section class="contents ">
			<div><h1 class="my-2">우리동네 가게</h1></div>
			<c:forEach items="${stores}" var="store">
				<a id="link" class="text-dark" href="/store/review-list?storeId=${store.id}&storeName=${store.name}">
					<div class="card border-info mb-3 mx-2">
						<div class="m-3">
							<h5 class="font-weight-bold">${store.name}</h5>
							전화 번호 : ${store.phoneNumber}<br>
							주소 : ${store.address}
						</div>
					</div>
				</a>
			</c:forEach>
		</section>		
		
		
		<hr>
		
		
		<footer>
			<div class="mx-3 mb-3">
				<h5 class="font-weight-bold">(주)우와한형제</h5>
				<span class="text-secondary">고객센터 : 1500-1500</span>
			</div>
		</footer>
	</div>

</body>
</html>