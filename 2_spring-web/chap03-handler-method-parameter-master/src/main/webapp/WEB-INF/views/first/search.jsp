<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search</title>
</head>
<body>
	<h1 align="center">@ModelAttribute 사용하여 파라미터 값 전달 받기</h1>
	
	<form action="search" method="post">
		검색할 메뉴 이름 : <input type="text" name="name"><br>
		검색할 메뉴 가격 : <input type="number" name="price"><br>
		검색할 메뉴 카테고리 : 
		<select name="categoryCode">
			<option value="1">식사</option>
			<option value="2">음료</option>
			<option value="3">디저트</option>
		</select> <br>
		검색할 판매 상태 : <input type="text" name="orderableStatus"><br>
		<input type="submit">
	</form>
	
</body>
</html>






