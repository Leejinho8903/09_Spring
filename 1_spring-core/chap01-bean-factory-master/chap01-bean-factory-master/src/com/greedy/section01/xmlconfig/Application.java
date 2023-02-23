package com.greedy.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		/* BeanFactory란? 
		 * 스프링 컨테이너의 최상위 컨테이너이며 ApplicationContext와 함께 스프링 컨테이너라고 한다.
		 * Bean의 생성과 설정, 관리 등의 역할을 맡고 있다.
		 * */
		
		/* MemberDTO(POJO) 클래스와 spring-context(Configuration) XML 설정 정보를 이용해서 
		 * 빈을 등록하고 생성하는 예제 */
		
		/* ApplicationContext의 하위 구현체인 GenericXmlApplicationContext는
		 * XML 설정 메타 정보를 읽어와서 BeanFactory를 동작시킨다. */
		ApplicationContext context 
			= new GenericXmlApplicationContext("com/greedy/section01/xmlconfig/spring-context.xml");
		
		/* 1. bean의 id를 이용해서 bean을 가져오는 방법 
		 * id를 이용하는 경우 bean의 타입 유추가 불가능해서 Object로 반환하므로 다운 캐스팅 필요 */
//		MemberDTO member = (MemberDTO) context.getBean("member");
		
		/* 2. bean의 클래스 메타 정보를 전달하여 가져오는 방법 */
//		MemberDTO member = context.getBean(MemberDTO.class);
		
		/* 3.bean의 id와 클래스 메타 정보를 전달하여 가져오는 방법 */
		MemberDTO member = context.getBean("member", MemberDTO.class);
		
		System.out.println(member);
		
	}

}
