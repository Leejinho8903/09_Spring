<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 메뉴 등록</title>
</head>
<body>

	<h1>신규 메뉴 등록하기</h1>
	<form action="regist" method="post">
		등록할 메뉴 이름 : <input type="text" name="name"><br>
		등록할 메뉴 가격 : <input type="number" name="price"><br>
		등록할 메뉴 카테고리 : 
		<select name="categoryCode">
			<option value="1">식사</option>
			<option value="2">음료</option>
			<option value="3">디저트</option>
		</select> <br>
		<input type="submit">
	</form>

</body>
</html>