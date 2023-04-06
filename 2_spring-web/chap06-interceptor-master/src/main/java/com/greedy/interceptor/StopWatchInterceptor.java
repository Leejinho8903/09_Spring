package com.greedy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/* 핸들러 인터셉터 구현 
 * default 메소드 이전에는 인터페이스에 정의 된 모든 메소드를 오버라이딩 해야 하는 책임을 가지기 때문에
 * HandlerInterceptorAdapter를 이용하여 부담을 줄여서 사용하였으나
 * default 메소드가 인터페이스에서 사용 가능하게 된 이후부터는 인터페이스만 구현하여 필요한 메소드만 오버라이딩해서
 * 사용할 수 있다. */
public class StopWatchInterceptor implements HandlerInterceptor {
	
	private final MenuService menuService;
	
	@Autowired
	public StopWatchInterceptor(MenuService menuService) {
		this.menuService = menuService;
	}

	/* 전처리 메소드 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandle 호출함");
		
		long startTime = System.currentTimeMillis();
		
		request.setAttribute("startTime", startTime);
		
		/* true를 리턴하면 핸들러 메소드를 이어서 호출하고 false를 리턴하면 핸들러 메소드를 호출하지 않는다. */
		return true;
	}

	/* 후처리 메소드 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("postHandler 호출함");
		
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		request.removeAttribute("startTime");
		
		modelAndView.addObject("interval", endTime - startTime);
		
	}

	/* 가장 마지막에 호출 되는 메소드로 오류 상황에도 호출 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("afterCompletion 호출함");
		
		/* 인터셉터는 스프링 웹 컨테이너 내부에 존재하므로 스프링 컨테이너 빈을 주입 받아 사용할 수 있다. */
		menuService.method();
	}

	
	
}
