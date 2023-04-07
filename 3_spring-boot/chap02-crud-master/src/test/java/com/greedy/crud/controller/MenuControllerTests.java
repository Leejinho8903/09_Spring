package com.greedy.crud.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.greedy.crud.config.Chap02CrudApplication;

@SpringBootTest
@ContextConfiguration(classes = {Chap02CrudApplication.class})
public class MenuControllerTests {
	
	@Autowired
	private MenuController menuController;
	/* 웹 어플리케이션을 어플리케이션 서버에 배포하지 않고도 Spring Web의 동작을 재현할 수 있는 클래스 
	 * 즉, WAS의 구동 없이 Controller에 request를 만들어 날리는 테스트 로직을 수행할 수 있다. */
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(menuController).build();
	}
	
	@Test
	public void 전체_메뉴_조회용_컨트롤러_테스트() throws Exception {
		
		// given
		
		// when & then
		mockMvc.perform(MockMvcRequestBuilders.get("/menu/list"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.forwardedUrl("menu/list"))
			.andDo(MockMvcResultHandlers.print());
		
	}
	
	@Test
	public void 전체_카테고리_조회용_컨트롤러_테스트 () throws Exception {
		
		//given
		
		//when & then
		mockMvc.perform(MockMvcRequestBuilders.get("/menu/category"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType("application/json; charset=UTF-8"))
			.andDo(MockMvcResultHandlers.print());
		
	}
	
	@Test
	public void 신규_메뉴_등록용_컨트롤러_테스트 () throws Exception {
		
		//given
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("name", "테스트메뉴");
		params.add("price", "20000");
		params.add("categoryCode", "5");
		params.add("orderableStatus", "Y");
		
		//when & then
		mockMvc.perform(MockMvcRequestBuilders.post("/menu/regist").params(params))
			.andExpect(MockMvcResultMatchers.status().is3xxRedirection())
			.andExpect(MockMvcResultMatchers.flash().attributeCount(1))
			.andExpect(MockMvcResultMatchers.redirectedUrl("/menu/list"))
			.andDo(MockMvcResultHandlers.print());
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}








