package com.greedy.thymeleaf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greedy.thymeleaf.model.dto.MemberDTO;
import com.greedy.thymeleaf.model.dto.SelectCriteria;

@Controller
@RequestMapping("/lecture")
public class LectureController {
	
	@GetMapping("/expression")
	public String expression(Model model) {
		
		model.addAttribute("member", new MemberDTO("유관순", 16, '여', "서울시 서대문구"));
		model.addAttribute("hello", "hello!<h2>Thymeleaf</h2>");
		
		return "lecture/expression";
	}
	
	@GetMapping("/conditional")
	public String conditional(Model model) {
		
		model.addAttribute("num", 1);
		model.addAttribute("str", "바나나");
		
		List<MemberDTO> memberList = new ArrayList<>();
		memberList.add(new MemberDTO("유관순", 16, '여', "서울시 서대문구"));
		memberList.add(new MemberDTO("홍길동", 20, '남', "서울시 마포구"));
		memberList.add(new MemberDTO("신사임당", 30, '여', "서울시 종로구"));
		memberList.add(new MemberDTO("장보고", 40, '남', "서울시 서초구"));
		
		model.addAttribute("memberList", memberList);
		
		return "lecture/conditional";
	}
	
	@GetMapping("etc")
	public String etc(Model model) {
		
		SelectCriteria selectCriteria = new SelectCriteria(1, 10, 3);
		model.addAttribute("selectCriteria", selectCriteria);
		
		// Object
		model.addAttribute("member", new MemberDTO("유관순", 16, '여', "서울시 서대문구"));
		
		// List
		List<MemberDTO> memberList = new ArrayList<>();
		memberList.add(new MemberDTO("유관순", 16, '여', "서울시 서대문구"));
		memberList.add(new MemberDTO("홍길동", 20, '남', "서울시 마포구"));
		memberList.add(new MemberDTO("신사임당", 30, '여', "서울시 종로구"));
		memberList.add(new MemberDTO("장보고", 40, '남', "서울시 서초구"));
		
		model.addAttribute("memberList", memberList);
		
		// Map
		Map<String, MemberDTO> memberMap = new HashMap<>();
		memberMap.put("m01", new MemberDTO("유관순", 16, '여', "서울시 서대문구"));
		memberMap.put("m02", new MemberDTO("홍길동", 20, '남', "서울시 마포구"));
		memberMap.put("m03", new MemberDTO("신사임당", 30, '여', "서울시 종로구"));
		memberMap.put("m04", new MemberDTO("장보고", 40, '남', "서울시 서초구"));
		
		model.addAttribute("memberMap", memberMap);
		
		return "lecture/etc";
	}
	
	
	
	
	
	

}








