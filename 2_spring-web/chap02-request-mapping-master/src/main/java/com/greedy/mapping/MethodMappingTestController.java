package com.greedy.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* DispatcherServlet은 웹 요청을 받으면 @Controller가 달린 컨트롤러 클래스에 처리를 위임한다. 
 * 그 과정은 컨트롤러 클래스의 핸들러 메소드에 선언 된 다양한 @RequestMapping 설정 내용에 따른다. 
 * */
@Controller
public class MethodMappingTestController {
	
	/* RequestMapping 설정에 method 방식을 지정하지 않으면 get/post 요청을 둘 다 처리한다. */
	@RequestMapping("/menu/regist")
	public String registMenu(Model model) {
		
		model.addAttribute("message", "메뉴 등록용 핸들러 메소드 호출함");
		
		return "mappingResult";
	}
	
	/* POST 방식으로 정의 된 메소드가 없는데 호출하는 경우에는 405 - 허용하지 않는 메소드라는 오류가 발생한다. */
	@RequestMapping(value="/menu/modify", method=RequestMethod.GET)
	public String modifyMenu(Model model) {
		
		model.addAttribute("message", "GET 방식의 메뉴 수정용 핸들러 메소드 호출함");
		
		return "mappingResult";
	}
	
	/* 요청 메소드별 전용 어노테이션 (since 4.3) 
	 * 핸들러 메소드를 보다 간결하게 작성할 수 있다.
	 * 요청 메소드		어노테이션
	 * GET			@GetMapping
	 * POST			@PostMapping	
	 * */
	@GetMapping("/menu/delete")
	public String getDeleteMenu(Model model) {
		
		model.addAttribute("message", "GET 방식의 메뉴 삭제용 핸들러 메소드 호출함");
		
		return "mappingResult";
	}
	
	@PostMapping("/menu/delete")
	public String postDeleteMenu(Model model) {
		
		model.addAttribute("message", "POST 방식의 메뉴 삭제용 핸들러 메소드 호출함");
		
		return "mappingResult";
	}
	
	
	
	
	

}






