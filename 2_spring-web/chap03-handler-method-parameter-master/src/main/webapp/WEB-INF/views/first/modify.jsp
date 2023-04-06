<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
</head>
<body>
	<h1>메뉴 수정하기</h1>
	
	<form action="modify" method="post">
		수정할 메뉴의 이름 : <input type="text" name="name"><br>
		수정할 메뉴의 가격 : <input type="number" name="modifyPrice"><br>
		<button type="submit">수정하기</button>
	</form>
	
	<form action="modifyAll" method="post">
		수정할 메뉴의 이름 : <input type="text" name="modifyName"><br>
		수정할 메뉴의 가격 : <input type="number" name="modifyPrice"><br>
		<button type="submit">수정하기</button>
	</form>

</body>
</html>