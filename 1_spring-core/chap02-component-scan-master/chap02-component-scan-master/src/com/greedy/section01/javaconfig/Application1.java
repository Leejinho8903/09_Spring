package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration1;

public class Application1 {
	
	public static void main(String[] args) {
		
		/* ComponentScan 기능을 이용한 bean 등록 설정 */
		
		/* ComponentScan이란?
		 * base-package로 설정 된 하위 경로에 특정 어노테이션을 가지고 있는 클래스를 bean으로 등록하는 기능
		 * @Component 어노테이션이 작성 된 클래스를 인식하여 bean으로 등록하게 되며
		 * 특수 목적에 따라 세부 기능을 제공하는 @Controller, @Service, @Repository, @Configuration 등을 인식한다. 
		 * */
		
		ApplicationContext context 
			= new AnnotationConfigApplicationContext(ContextConfiguration1.class);
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("beanName : " + beanName);
		}
		
		MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
		
		System.out.println(memberDAO.selectMember(1));
		System.out.println(memberDAO.insertMember(new MemberDTO(3, "user03", "pass03", "뉴멤버")));
		System.out.println(memberDAO.selectMember(3));
		
	}

	
}










