package com.greedy.section02.prototype.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.greedy.section02.prototype.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		
		/* 기본적인 bean scope는 singleton으로 설정 되어 있다.
		 * singleton은 IoC 컨테이너 당 하나의 인스턴스만 생성한다.
		 * prototype으로 설정을 변경하면 요청할 때마다 빈 인스턴스를 새롭게 생성하게 된다. */

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
		
	}

}




