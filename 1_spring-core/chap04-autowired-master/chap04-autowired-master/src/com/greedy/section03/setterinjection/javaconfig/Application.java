package com.greedy.section03.setterinjection.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		/* @Autowired setter 의존성 주입 테스트 */
		
		// AnnotationConfigApplicationContext 생성자에 basePackages 문자열을 전달하며 생성
		ApplicationContext context
			= new AnnotationConfigApplicationContext("com.greedy.section03.setterinjection.javaconfig");
		
		BookService bookService = context.getBean("bookService", BookService.class);
		
		/* 전체 목록 */
		for(BookDTO book : bookService.selectAllBooks()) {
			System.out.println(book);
		}
		
		/* 시퀀스로 검색 */
		System.out.println(bookService.searchBookBySequence(1));
		System.out.println(bookService.searchBookBySequence(2));
		
	}

}
