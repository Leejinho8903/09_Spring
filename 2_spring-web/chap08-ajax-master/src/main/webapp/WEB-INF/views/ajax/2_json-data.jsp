<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json data</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>

	<h1>JSON 데이터 서버 전송 테스트</h1>
	
	<h3>회원 정보 입력</h3>
	<table>
		<tr>
			<td>닉네임</td>
			<td><input type="text" name="nickname" id="nickname"></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="number" name="age" id="age"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" name="email" id="email"></td>
		</tr>
		<tr>
			<td>가입일</td>
			<td><input type="date" name="registDate" id="registDate"></td>
		</tr>
	</table>
	
	<button onclick="sendJquery();">jQuery로 전송</button>
	<button onclick="sendFetch();">fetch로 전송</button>
	
	<script>
		function sendJquery() {
			
			const nickname = document.querySelector("#nickname").value;
			const age = document.querySelector("#age").value;
			const email = document.querySelector("#email").value;
			const registDate = document.querySelector("#registDate").value;
			
			const userInfo = { nickname, age, email, registDate };
			/* user data를 1명 전송하는 경우 */
			//const json = JSON.stringify(userInfo);
			/* user data를 여러명 전송하는 경우 */
			const userInfoList = [ userInfo, userInfo, userInfo ];
			const json = JSON.stringify(userInfoList);
			
			console.log(userInfo);
			console.log(userInfoList);
			console.log(json);
			
			const onError = xhr => console.log(xhr);
			const onSuccess = data => console.log(data);
			
 			$.ajax({
				url : '${pageContext.servletContext.contextPath}/jquery/json',
				method : 'POST',
				data : json,
				contentType : 'application/json; charset=UTF-8',
				error : onError,
				success : onSuccess
			}); 
			
		}
		
		async function sendFetch() {
			
			const nickname = document.querySelector("#nickname").value;
			const age = document.querySelector("#age").value;
			const email = document.querySelector("#email").value;
			const registDate = document.querySelector("#registDate").value;
			
			const userInfo = { nickname, age, email, registDate };
			/* user data를 1명 전송하는 경우 */
			//const json = JSON.stringify(userInfo);
			/* user data를 여러명 전송하는 경우 */
			const userInfoList = [ userInfo, userInfo, userInfo ];
			const json = JSON.stringify(userInfoList);
			
			const response = await fetch('${pageContext.servletContext.contextPath}/fetch/json', {
				method : 'POST',
				headers : {
					'Content-Type' : 'application/json; charset=UTF-8'
				},
				body : json
			});
			
			const result = await response.text();
			console.log(result);
			
		}
	</script>
	
	<h1>JSON 데이터 서버 응답 테스트</h1>
	
	<h3>테이블로 회원 정보 불러오기</h3>
	<table class="userInfo"></table>
	
	<button onclick="receiveJquery()">jQuery로 전송 후 응답 처리</button>
	<button onclick="receiveFetch()">fetch로 전송 후 응답 처리</button>
	
	<script>
	
		function createTrString(user) {
			/* 템플릿 리터럴(``) 내의 달러 기호가 EL로 해석되어 서버에서 처리 되어 빈 값으로 리턴되는 문제가 있을 수 있다. 
			기본적으로는 js 파일을 JSP에서 분리해서 별도의 파일로 작성하는 것이 좋으나
			여기에서는 간단하게 역슬래쉬를 붙여 EL 해석을 막고 템플릿 리터럴 내의 변수 표기로 인식할 수 있게 한다. */
			return `
			<tr>
				<td>아이디 : \${user.id}</td>
				<td>닉네임 : \${user.nickname}</td>
				<td>나이 : \${user.age}</td>
				<td>이메일 : \${user.email}</td>
				<td>가입일 : \${user.registDate}</td>
			</tr>
			`;		
		}
	
		function receiveJquery() {
			
			$.ajax({
				url : '${pageContext.servletContext.contextPath}/jquery/json',
				method : 'GET',
				error : xhr => console.log(xhr),
				success : responseJson => {
					const table = document.querySelector(".userInfo");
					table.innerHTML = responseJson.map(item => createTrString(item)).join('');
				}
			});
			
		}
		
		async function receiveFetch() {
			
			const response = await fetch('${pageContext.servletContext.contextPath}/fetch/json');
			const responseJson = await response.json();
			const table = document.querySelector(".userInfo");
			table.innerHTML = responseJson.map(item => createTrString(item)).join('');
			
			/*
			fetch('${pageContext.servletContext.contextPath}/fetch/json')
			.then(res => res.json())
			.then(responseJson => {
				const table = document.querySelector(".userInfo");
				table.innerHTML = responseJson.map(item => createTrString(item)).join('');
			})
			*/
		}
		
		
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>