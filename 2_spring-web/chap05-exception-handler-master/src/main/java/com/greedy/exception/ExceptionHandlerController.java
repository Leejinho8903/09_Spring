package com.greedy.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {
	
	@GetMapping("/simple-null")
	public String simpleNullPointerExceptionTest() {
		
		/* default 에러 뷰를 확인하기 위해 에러를 발생시키는 구문 */
		System.out.println(10 / 0);
		
		String str = null;
		System.out.println(str.charAt(0));
		
		return "main";
	}
	
	@GetMapping("/simple-user")
	public String simpleUserExceptionTest() throws MemberRegistException {
		
		boolean check = true;
		
		if(check) {
			throw new MemberRegistException("당신 같은 사람은 회원으로 받을 수 없습니다!");
		}
		
		return "main";
	}
	
	@GetMapping("annotation-null")
	public String annotationNullPointerExceptionTest() {
		
		String str = null;
		System.out.println(str.charAt(0));
		
		return "main";
		
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerExceptionHandler(NullPointerException exception) {
		
		System.out.println("@ExceptionHandler 메소드 호출");
		System.out.println(exception.getMessage());
		
		return "error/nullPointer";
	}
	
	@GetMapping("annotation-user")
	public String annotationUserExceptionTest() throws MemberRegistException {
		
		boolean check = true;
		
		if(check) {
			throw new MemberRegistException("당신 같은 사람은 회원으로 받을 수 없습니다!");
		}
		
		return "main";
		
	}
	
	@ExceptionHandler(MemberRegistException.class)
	public String userExceptionHandler(MemberRegistException exception, Model model) {
		
		System.out.println("@ExceptionHandler 메소드 호출");
		System.out.println(exception.getMessage());
		model.addAttribute("exception", exception);
		
		return "error/memberRegist";
	}
	
}
