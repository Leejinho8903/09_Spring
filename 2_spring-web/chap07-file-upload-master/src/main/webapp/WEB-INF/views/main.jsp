<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<h1 align="center">파일 업로드 하기</h1>
	
	<h3>single file upload</h3>
	<form action="single-file" method="post" enctype="multipart/form-data">
		파일 : <input type="file" name="singleFile"> <br>
		파일 설명 : <input type="text" name="singleFileDescription"> <br>
		<input type="submit">
	</form>
	
	<h3>multi file upload</h3>
	<form action="multi-file" method="post" enctype="multipart/form-data">
		파일 : <input type="file" name="multiFiles" multiple> <br>
		파일 설명 : <input type="text" name="multiFileDescription"> <br>
		<input type="submit">
	</form>
	
</body>
</html>