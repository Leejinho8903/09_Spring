package com.greedy.parameter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/first/*")
@SessionAttributes("id")
public class FirstController {
	
	@GetMapping("/regist")
	public void regist() {}
	
	/* 핸들러 메소드에 파라미터로 특정 몇 가지 타입을 선언하게 되면 핸들러 메소드 호출 시 인자로 값을 전달해 준다. */
	
	/* 1. HttpServletRequest를 매개변수로 선언하여 파라미터로 전달 받은 값 꺼내기 
	 *    핸들러 메소드 매개변수로 HttpServletResponse도 사용 가능하다.
	 *    상위 타입인 ServletRequest, ServletResponse도 사용 가능하다. 
	 * */
	@PostMapping("/regist")
	public String registMenu(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
		
		String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록하였습니다.";
		model.addAttribute("message", message);
		
		return  "first/messagePrinter";
	}

	@GetMapping("modify")
	public void modify() {}
	
	/* 2. @RequestParam으로 값 꺼내기
	 * 요청 파라미터를 매핑하여 호출 시 값을 넣어주는 어노테이션으로 @PathVariable처럼 변수 앞에 작성한다.
	 * form name 속성 값과 매개변수의 이름이 다른 경우에는 @RequestParam("name")을 설정하면 된다.
	 * 또한 어노테이션은 생략 가능하지만 명시적으로 작성하는 것이 의미 파악에 쉬우며 그 외의 설정을 작성할 경우에도 어노테이션이 필요하다.
	 * 
	 * 전달하는 form의 name 속성이 일치하는 것이 없는 경우 400 - 잘못 된 요청 에러가 발생하는데
	 * required 속성을 false로 설정하면 해당 name 값이 존재하지 않아도 null로 처리하며 에러가 발생하지 않는다.
	 * (기본 값이 true이기 때문에 설정하지 않으면 에러가 발생한다.)  
	 * 
	 * 값을 입력하지 않고 넘겼을 때 modifyPrice=""와 같이 빈 문자열이 넘어오게 되면, parsing 관련 에러가 발생할 수 있다. (400 - 잘못 된 요청)
	 * 값이 넘어오지 않는 경우 defaultValue를 이용해 기본 값을 설정할 수 있다.
	 * */
	@PostMapping("modify")
	public String modifyMenuPrice(@RequestParam(required=false) String modifyName, 
			@RequestParam(defaultValue="0") int modifyPrice, Model model) {
		
		String message = modifyName + " 메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다.";
		model.addAttribute("message", message);
		
		return "first/messagePrinter";
	}
	
	/* 파라미터가 여러 개인 경우 Map으로 한 번에 처리할 수도 있다. 이 때 Map의 key는 form의 name 속성이 된다. */
	@PostMapping("modifyAll")
	public String modifyMenu(@RequestParam Map<String, String> parameters, Model model) {
		
		String modifyName = parameters.get("modifyName");
		int modifyPrice = Integer.parseInt(parameters.get("modifyPrice"));
		
		String message = "메뉴의 이름을 " + modifyName + "(으)로, 가격을 " + modifyPrice + "원으로 변경하였습니다.";
		model.addAttribute("message", message);
		
		return "first/messagePrinter";
	}
	
	@GetMapping("search")
	public void search() {}
	
	/* 3. @ModelAttribute를 이용하는 방법
	 * DTO와 같은 모델을 커맨드 객체로 전달 받을 수 있다. 
	 * 커맨드 객체를 생성하여 매개변수로 전달해 준뒤 해당 인스턴스를 Model에 담는다. 
	 * 경우에 따라서 form에 입력한 값을 다음 화면으로 바로 전달해야 하는 경우가 발생하는데 이 때 유용하게 사용할 수 있다.
	 * @ModelAttribute("모델에 담을 key값")을 지정할 수 있으며 지정하지 않으면 타입의 앞 글자를 소문자로 네이밍한 규칙을 따른다.
	 * 어노테이션 생략 가능하지만 명시적으로 작성하는 것이 알아보기에 좋다. */
	@PostMapping("search")
	public String searchMenu(@ModelAttribute("menu") MenuDTO menu) {
		
		System.out.println(menu);
		
		return "first/searchResult";
	}
	
	@GetMapping("login")
	public void login() {}
	
	/* 4-1. HttpSession 매개변수 선언 
	 * 핸들러 메소드 호출 시 세션 객체를 넣어서 호출한다. */
	@PostMapping("login1")
	public String sessionTest1(@RequestParam String id, HttpSession session) {
		
		session.setAttribute("id", id);
		
		return "first/loginResult";
	}
	
	@GetMapping("logout1")
	public String logoutTest1(HttpSession session) {
		
		/* 세션 객체 만료로 세션에 저장 된 값이 모두 사라짐 */
		session.invalidate();
		
		return "first/loginResult";
	}
	
	/* 4-2. @SessionAttributes를 이용하여 session에 값 담기 
	 * 클래스 레벨에 @SessionAttributes 어노테이션을 이용하여 세션에 값을 담을 key 값을 설정해두면
	 * Model에 해당 key 값이 추가 되는 경우 session 영역에 자동으로 등록한다. */
	@PostMapping("login2")
	public String sessionTest2(@RequestParam String id, Model model) {
			
		model.addAttribute("id", id);
		
		return "first/loginResult";
	}
	
	/* @SessionAttributes로 등록 된 값은 session의 상태를 관리하는 SessionStatus 의 setComplete 메소드를
	 * 호출 해야 사용이 만료 된다. */
	@GetMapping("logout2")
	public String logoutTest2(SessionStatus sessionStatus) {
		
		sessionStatus.setComplete();
		
		return "first/loginResult";
	}
	
	@GetMapping("body")
	public void body() {}
	
	/* 5. @RequestBody 이용하기 
	 * HTTP 요청 본문 자체를 모델로 변환시켜주는 어노테이션으로 출력해보면 쿼리 스트링 형태의 문자열이 전송 된다. 
	 * JSON으로 전달하는 경우 Jackson 컨버터로 자동 파싱하여 사용할 수 있어 주로 Rest API 구현 시 많이 사용한다. */
	@PostMapping("body")
	public String bodyTest(@RequestBody String body,
			@RequestHeader("content-type") String contentType,
			@CookieValue("JSESSIONID") String sessionId) {
		
		System.out.println(body);
		System.out.println(contentType);
		System.out.println(sessionId);
		
		return "first/bodyResult";
	}
	
	
	
}










