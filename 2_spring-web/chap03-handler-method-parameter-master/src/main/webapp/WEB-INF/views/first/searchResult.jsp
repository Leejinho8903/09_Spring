<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchResult</title>
</head>
<body>
	
	<h1 align="center">Model에 담긴 커맨드 객체의 정보 출력 </h1>
	<h3>메뉴의 이름 : ${ menu.name }</h3>
	<h3>메뉴의 가격 : ${ menu.price }</h3>
	<h3>메뉴의 카테고리 : ${ menu.categoryCode }</h3>
	<h3>메뉴의 판매상태 : ${ menu.orderableStatus }</h3>
	
</body>
</html>