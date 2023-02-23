package com.greedy.section02.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
	
	public static void main(String[] args) {
		
		/* MemberDTO 클래스는 Account 클래스를 의존하고 있다. 
		 * 스프링 컨테이너에 두 타입의 객체를 bean으로 등록하고 의존성 주입을 테스트한다. */
		
		ApplicationContext context 
			= new GenericXmlApplicationContext("com/greedy/section02/xmlconfig/config/spring-context.xml");
		
		MemberDTO member = context.getBean(MemberDTO.class);
		
		System.out.println(member);
		System.out.println(member.getPersonalAccount().getBalance());
		System.out.println(member.getPersonalAccount().deposit(10000));
		System.out.println(member.getPersonalAccount().getBalance());
		System.out.println(member.getPersonalAccount().withDraw(5000));
		System.out.println(member.getPersonalAccount().getBalance());
		
	}
}











