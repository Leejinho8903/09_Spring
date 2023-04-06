package com.greedy.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleStringController {

	@GetMapping("/simple-string")
	public String showSimpleString() {
		
		return "ajax/1_simple-string";
	}
	
	/* @ResponseBody 
	 * view 페이지를 반환하는 것이 아니라 반환 값을 클라이언트에게 그대로 반환하고자 할 때 사용하는 어노테이션
	 * 위치는 메소드 레벨, 반환 값 레벨 모두 가능하다. 
	 * 한글 값 인코딩 문제는 Mapping 어노테이션의 설정을 추가하여 해결한다.
	 * */
	@ResponseBody
	@GetMapping(value="/xmlhttprequest/simple-string", produces="text/html; charset=UTF-8")
	public String xmlhttprequestTest(@RequestParam String keyword) {
		
		System.out.println(keyword);
		String responseText = "서버로 전달 된 문자열은 " + keyword + "입니다.";
		
		return responseText;
	}
	
	@ResponseBody
	@GetMapping(value="/jquery/simple-string", produces="text/html; charset=UTF-8")
	public String jqueryTest(@RequestParam String keyword) {
		
		System.out.println(keyword);
		String responseText = "서버로 전달 된 문자열은 " + keyword + "입니다.";
		
		return responseText;
	}
	
	@ResponseBody
	@GetMapping(value="/fetch/simple-string", produces="text/html; charset=UTF-8")
	public String fetchTest(@RequestParam String keyword) {
		
		System.out.println(keyword);
		String responseText = "서버로 전달 된 문자열은 " + keyword + "입니다.";
		
		return responseText;
	}
	
	@ResponseBody
	@GetMapping(value="/axios/simple-string", produces="text/html; charset=UTF-8")
	public String axiosTest(@RequestParam String keyword) {
		
		System.out.println(keyword);
		String responseText = "서버로 전달 된 문자열은 " + keyword + "입니다.";
		
		return responseText;
	}
	
}










