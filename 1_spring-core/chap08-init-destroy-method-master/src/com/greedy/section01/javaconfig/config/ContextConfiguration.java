package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.greedy.section01.javaconfig.Beverage;
import com.greedy.section01.javaconfig.Bread;
import com.greedy.section01.javaconfig.Owner;
import com.greedy.section01.javaconfig.Product;
import com.greedy.section01.javaconfig.ShoppingCart;

@Configuration
public class ContextConfiguration {
	
	@Bean
	public Product carpBread() {
		
		return new Bread("붕어빵", 2000, new java.util.Date());
		
	}
	
	@Bean
	public Product milk() {
		
		return new Beverage("딸기우유", 1500, 500);
		
	}
	
	@Bean
	public Product water() {
		
		return new Beverage("지리산암반수", 1000, 500);
		
	}
	
	@Bean
	@Scope("prototype")		// 기본 값 singleton에서 prototype으로 변경
	public ShoppingCart cart() {
		
		return new ShoppingCart();
		
	}
	
	
	@Bean(initMethod = "openShop", destroyMethod = "closeShop")
	public Owner owner() {
		
		return new Owner();
	}
	
	
	
	
	
	
	
	
	
}