package com.greedy.section02.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.xmlconfig.MemberDTO;

public class Application {
	
	public static void main(String[] args) {
		
		/* AnnotationConfigApplicationContext 라고 하는 어노테이션 설정 정보를 읽어서 컨테이너 설정을 하는
		 * 구현체를 이용한다. 인자로 @Configuration 어노테이션이 달린 설정 클래스의 메타 정보를 전달한다. */
		ApplicationContext context
			= new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		MemberDTO member = context.getBean("member", MemberDTO.class);
		
		System.out.println(member);
	}

}








