package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration2;

public class Application2 {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration2.class);
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("beanName : " + beanName);
		}
		
		MemberDAO memberDAO = context.getBean(MemberDAO.class);
		
		System.out.println(memberDAO.selectMember(1));
		System.out.println(memberDAO.insertMember(new MemberDTO(3, "user03", "pass03", "새로운 멤버")));
		System.out.println(memberDAO.selectMember(3));
			
	}

}
