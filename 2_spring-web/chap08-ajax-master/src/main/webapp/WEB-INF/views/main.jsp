<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<h1 align="center">Ajax</h1>

	<h3>Ajax란?</h3>
	<ul>
		<li>Asynchronous JavaScript And XML - 비동기 자바스크립트와 XML이라는 의미로 JavaScript 기술이다.</li>
		<li>서버와 통신하기 위해 XMLHttpRequest 객체를 사용하여 XML 뿐만 아니라 JSON, HTML, 일반 텍스트 형식등을 포함한
		다양한 포맷으로 통신할 수 있다.</li>
		<li>페이지 전체를 새로고침 하지 않고도 수행되는 비동기 통신으로 서버로부터 데이터를 받아 전체 페이지가 아닌 일부분만을
		업데이트 할 수 있게 한다.</li>
		<li>EX. 아이디 중복 확인 요청 후 결과를 응답 받아 페이지 일부를 갱신하여 중복 여부를 알린다. </li>
		<li>EX. 페이지 스크롤을 내렸을 때 데이터를 추가 요청하여 응답 받은 데이터를 화면에 추가한다. </li>
	</ul>
	
	<h3>Ajax 그 이후</h3>
	<ul>
		<li>Ajax 이외에도 서버에 네트워크 요청을 보내고 정보를 받아올 수 있는 방법은 다양하다.</li>
		<li>JavaScript 내장 메소드인 fetch 메소드, axios 라이브러리 등이 대표적이다.</li>
	</ul>
	
	<h3>1. 문자열 데이터 요청과 응답</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/simple-string'">문자열 데이터 요청과 응답</button>

	<h3>2. JSON 데이터 요청과 응답</h3>
	<button onclick="location.href='${pageContext.servletContext.contextPath}/json-data'">JSON 데이터 요청과 응답</button>

</body>
</html>















