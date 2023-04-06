<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>simple string</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
	
	<h1>simple string 서버 전송 테스트</h1>
	
	전달 값 : <input type="text" name="keyword" id="param"> <br>
	응답 값 : <p id="result"></p>
	
	<button onclick="sendXmlHttpRequest();">XMLHttpRequest로 전송</button>
	<button onclick="sendJquery();">jQuery로 전송</button>
	<button onclick="sendFetch();">fetch로 전송</button>
	<button onclick="sendAxios();">axios로 전송</button>
	
	<h1>1. XMLHttpRequest</h1>
	<ul>
		<li>XMLHttpRequest 객체를 이용해서 비동기 요청을 처리할 수 있다.</li>
		<li>하지만 일반적으로 XMLHttpRequest를 직접 이용하기 보다는 Ajax 기능이 내장 되어 있는 라이브러리를 사용하는 편이다.</li>
	</ul>
	
	<script>
		function sendXmlHttpRequest() {
			
			const httpRequest = new XMLHttpRequest();
			const serverAddress = '${pageContext.servletContext.contextPath}/xmlhttprequest/simple-string';
			
			/* 서버의 응답 상태가 변화하면 호출 되는 이벤트 */
			httpRequest.onreadystatechange = function(){
				/* 0 : request가 초기화 되지 않음
				   1 : 서버와의 연결이 성사 됨
				   2 : 서버가 request를 받음
				   3 : request 요청을 처리하는 중
				   4 : request에 대한 처리가 끝났으며 응답할 준비가 완료 됨(DONE)
				*/
				
				/* 서버의 응답 준비가 완료 되면 수행할 코드 */
				if(httpRequest.readyState === XMLHttpRequest.DONE) {
					
					if(httpRequest.status === 200) {	
						/* 응답 상태가 성공인 경우*/
						document.querySelector("#result").innerText = httpRequest.responseText;
					} else {
						/* 응답 상태가 성공이 아닌 경우 */
						document.querySelector("#result").innerText = '요청 응답에 실패하였습니다.';
					}
				}
			};
			
			const keyword = document.querySelector("#param").value;
			
			/* open 메소드 전달 인자 : 요청 방식, 요청 url, 비동기 여부(default : true) */
			httpRequest.open('GET', serverAddress + "?keyword=" + keyword);
			
			httpRequest.send();
		}
	</script>
	
	<h1>2. jQuery</h1>
	
	<ul>
		<li>2006년에 등장한 자바스크립트 라이브러리로 이전까지 다루기 번거롭던 DOM을 쉽게 제어할 수 있게 해주었고,
		크로스 브라우징 이슈에도 많은 도움을 주었다.</li>
		<li>한 때는 높은 점유율을 보였으나 웹 표준 API의 확장, 가상 돔을 사용하는 라이브러리의 등장으로 오늘 날에는
		점유율이 점차 줄어들고 있다.</li>
		<li>jQuery에서 제공하는 ajax 메소드를 사용하면 통신에 필요한 설정을 간편하게 객체로 전달할 수 있고,
		크로스 브라우징 이슈도 손쉽게 해결할 수 있다.</li>
	</ul>
	
	<script>
		function sendJquery() {
			
			const keyword = document.querySelector('#param').value;
			
			$.ajax({
				url : '${pageContext.servletContext.contextPath}/jquery/simple-string',
				data : { keyword },
				method : 'GET',
				success : function(data, status, xhr) {
					console.log(data, status, xhr);
					document.querySelector("#result").innerText = data;
				},
				error : function(xhr, status) {
					console.log(xhr, status);
					document.querySelector("#result").innerText = '요청 응답에 실패하였습니다.';
				}
			});
		}
	</script>
	
	<h1>3. fetch</h1>
	<ul>
		<li>Promise 기반으로 만들어진 기능으로 ES6부터 JavaScript 내장 라이브러리가 되어 별도의 라이브러리 추가가 필요하지는 않다.</li>
		<li>대부분의 모던 웹 브라우저에서는 사용 가능하지만 구 버전 브라우저에서는 동작하지 않는 문제가 있을 수 있다.</li>
	</ul>
	
	<script>
		function sendFetch() {
			
			const keyword = document.querySelector("#param").value;
			
			fetch('${pageContext.servletContext.contextPath}/fetch/simple-string?keyword='+keyword)
				.then(res => res.text())
				.then(text => document.querySelector("#result").innerText = text);
			
			console.log('test');
		}
	</script>
	
	<h1>4. axios</h1>
	<ul>
		<li>Promise 기반으로 만들어진 기능으로 응답 데이터를 다루기 쉽게(JSON 데이터 자동 변환) 되어 있다.</li>
	</ul>
	
	<script>
		function sendAxios() {
			
			const keyword = document.querySelector("#param").value;
			
			axios('${pageContext.servletContext.contextPath}/axios/simple-string?keyword='+keyword)
				.then(res => document.querySelector("#result").innerText = res.data);
		}
	</script>
	
</body>
</html>







