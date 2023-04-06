package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		
		/* init(초기화), destroy(폐기) 메소드 설정
		 * IoC 컨테이너가 Bean 객체를 생성할 때 bean 초기화가 필요하면 initMethod를 설정하고,
		 * IoC 컨테이너가 Bean 객체를 소멸시킬 때 자원 반납 등의 처리가 필요하면 destroyMethod를 설정한다. 
		 * */

		ApplicationContext context 
			= new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		Product carpBread = context.getBean("carpBread", Bread.class);
		Product milk = context.getBean("milk", Beverage.class);
		Product water = context.getBean("water", Beverage.class);
		
		ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
		cart1.addItem(carpBread);
		cart1.addItem(milk);
		
		System.out.println("cart1에 담긴 내용 : " + cart1.getItem());
		
		ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
		cart2.addItem(water);
		
		System.out.println("cart2에 담긴 내용 : " + cart2.getItem());
		
		/* cart1,2의 hashCode */
		System.out.println("cart1 : " + cart1.hashCode());
		System.out.println("cart2 : " + cart2.hashCode());
		
		/* 가비지 컬렉터에서 해당 빈을 메모리에서 지울 때 destroyMethod가 동작하게 되는데 
		 * 지금은 메모리에서 지우기 전에 main 메소드의 프로세스가 종료 되어 호출 되고 있지 않다. 
		 * 강제로 컨테이너를 종료 시키는 메소드를 호출하면 폐기 메소드가 동작한다. */
		((AnnotationConfigApplicationContext)context).close();
	}

}




