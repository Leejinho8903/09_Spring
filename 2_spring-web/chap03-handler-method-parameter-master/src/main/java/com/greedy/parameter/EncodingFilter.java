package com.greedy.parameter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
@WebFilter("/*")
public class EncodingFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		if("POST".equals(hrequest.getMethod())) {
			hrequest.setCharacterEncoding("UTF-8");
		}
		
		chain.doFilter(hrequest, response);
		
	}

}











