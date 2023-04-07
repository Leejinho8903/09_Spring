package com.greedy.crud.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greedy.crud.model.dto.CategoryDTO;
import com.greedy.crud.model.dto.MenuDTO;
import com.greedy.crud.model.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	private MenuService menuService;
	private MessageSource messageSource;
	
	@Autowired
	public MenuController(MenuService menuService, MessageSource messageSource) {
		this.menuService = menuService;
		this.messageSource = messageSource;
	}
	
	@GetMapping("/list")
	public String findMenuList(Model model) {
		
		List<MenuDTO> menuList = menuService.findAllMenu();
		model.addAttribute("menuList", menuList);
		
		return "menu/list";
	}
	
	/* Spring web에서는 jackson databind 등의 의존성이 모두 추가 되어 있으므로 비동기 통신에서
	 * JSON 타입의 응답을 하기 위해서는 @ResponseBody 어노테이션만 추가하면 자동으로 변환 된다. */
	@GetMapping(value = "/category", produces = "application/json; charset=UTF-8")
	public @ResponseBody List<CategoryDTO> findCategoryList() {
		return menuService.findAllCategory();
	}
	
	/* 메뉴 등록용 화면 이동 */
	@GetMapping("/regist")
	public void registPage() {
		
		
		
	}
	
	@PostMapping("/regist")
	public String registMenu(@ModelAttribute MenuDTO menu, RedirectAttributes rttr, Locale locale) throws Exception {
		
		menuService.registMenu(menu);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("registMenu", null, locale));
		
		return "redirect:/menu/list";
	}
	
	
	
	
	
	
	
	

}






