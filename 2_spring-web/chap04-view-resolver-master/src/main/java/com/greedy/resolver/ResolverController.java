package com.greedy.resolver;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResolverController {
	
	@GetMapping("/string")
	public String stringReturning(Model model) {
		
		model.addAttribute("message", "문자열로 뷰 이름 반환함");
		
		/* forward 방식 */
		return "result";
	}
	
	@GetMapping("/string-redirect")
	public String stringRedirect(Model model) throws UnsupportedEncodingException {
		
		/* redirect시 기본 데이터 타입을 model에 추가하면 url의 parameter가 된다. */
		model.addAttribute("message", URLEncoder.encode("문자열로 redirect함", "UTF-8"));
		
		/* redirect 방식 
		 * 접두사로 redirect: 을 하면 redirect 처리가 되며 main을 다시 요청하도록 한다. */
		return "redirect:main";
	}
	
	@GetMapping("/string-redirect-attr")
	public String stringRedirectFlashAttribute(RedirectAttributes rttr) {
		
		/* RedirectAttributes에 addFlashAttribute를 하면 redirect 했을 경우에도 requestScope에서 값을 꺼내 쓸 수 있다. 
		 * 원리는 세션에 임시로 값을 담고 소멸시키는 방식이므로 세션에 동일한 키 값이 존재하면 덮어쓰기 할 수 있음에 유의한다. */
		rttr.addFlashAttribute("flashMessage", "redirect attr 사용하여 redirect함");
		
		return "redirect:main";
	}
	
	@GetMapping("/modelandview")
	public ModelAndView modelAndView(ModelAndView mv) {
		
		/* 모델과 뷰를 합친 개념이다. 
		 * 핸들러 어댑터가 핸들러 메소드를 호출하고 반환 받은 문자열을 ModelAndView로 만들어 DispatcherServlet에 반환하는데
		 * 이 때 문자열을 반환해도 되지만 ModelAndView를 미리 만들어서 반환할 수도 있다. */
		mv.addObject("message", "ModelAndView를 이용한 모델과 뷰 반환");
		mv.setViewName("result");
		
		return mv;
	}
	
	@GetMapping("/modelandview-redirect")
	public ModelAndView modelAndViewRedirect(ModelAndView mv) throws UnsupportedEncodingException {
		
		mv.addObject("message", URLEncoder.encode("ModelAndView를 이용한 redirect", "UTF-8"));
		mv.setViewName("redirect:main");
		
		return mv;
	}
	
	@GetMapping("/modelandview-redirect-attr")
	public ModelAndView modelAndViewRedirectFlashAttribute(ModelAndView mv, RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("flashMessage", "ModelAndView를 이용한 redirect에 flash attribute 담기");
		mv.setViewName("redirect:main");
		
		return mv;
	}
}













