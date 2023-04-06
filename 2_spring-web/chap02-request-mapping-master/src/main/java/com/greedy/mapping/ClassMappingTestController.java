package com.greedy.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* 클래스 레벨에 @RequestMapping 어노테이션 사용이 가능하다. 
 * 클래스 레벨에 URL 공통 부분을 이용해서 설정하면 매번 핸들러 메소드 URL에 중복 되는 내용을 작성하지 않아도 된다. */
@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {
	
	@GetMapping("/regist")
	public String registOrder(Model model) {
		
		model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메소드 호출함");
		
		return "mappingResult";
	}
	
	/* 여러 개의 패턴을 매핑할 수 도 있다. */
	@RequestMapping(value= {"/modify", "/delete"}, method=RequestMethod.POST)
	public String modifyAndDelete(Model model) {
		
		model.addAttribute("message", "POST 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메소드 호출함");
		
		return "mappingResult";
		
	}
	
	/* PathVariable로 전달 되는 값은 반드시 매개변수와 이름이 동일해야 하며 동일하지 않을 경우 @PathVariable("이름")을 설정해주어야 한다.
	 * 핸들러 메소드에서 요청 객체를 들춰서 전달 된 값을 꺼내 볼 필요 없이 url 경로에 위치한 값을 value로 인식하는 방식으로
	 * REST 형 웹 서비스를 설계할 때 유용하다. */
	@GetMapping("/detail/{orderNo}")
	public String selectOrderDetail(@PathVariable("orderNo") int orderNo, Model model) {
		
		/* parsing 불가능한 PathVariable이 전달 되면 400 - 잘못 된 요청 에러가 발생한다. */
		model.addAttribute("message", orderNo + "번 주문 상세 내용 조회용 핸들러 메소드 호출함");
		
		return "mappingResult";
	}
	
	/* 클래스에 설정 된 매핑 설정과 일치하면서 다른 요청 처리에 대한 핸들러 메소드가 준비 되지 않았다면 해당 메소드를 요청한다. */
	@RequestMapping
	public String otherRequest(Model model) {
		
		model.addAttribute("message", "order 요청이긴 하지만 다른 기능은 아직 준비 되지 않음");
		
		return "mappingResult";
	}
	
	
	

}
















