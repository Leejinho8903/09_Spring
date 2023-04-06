package com.greedy.section01.properties.javaconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.greedy.section01.properties.javaconfig.Beverage;
import com.greedy.section01.properties.javaconfig.Bread;
import com.greedy.section01.properties.javaconfig.Product;
import com.greedy.section01.properties.javaconfig.ShoppingCart;


@Configuration
/* 클래스 패스 하위 경로를 기술한다. 폴더의 구분은 슬래쉬 또는 역슬래쉬로 한다. */
@PropertySource("product-info.properties")
public class ContextConfiguration {
	
	/* 치환자 문법을 이용하여 properties에 저장 된 key를 입력하면 value에 해당하는 값을 꺼내온다. 
	 * 내부에 공백을 사용하면 값을 읽어오지 못하므로 주의한다.
	 * : 뒤의 값은 값을 읽어오기 못했을 경우 사용하는 대체 값이다. */
	@Value("${bread.carpbread.name:슈크림붕어빵}")
	private String carpBreadName;
	@Value("${bread.carpbread.price:0}")
	private int carpBreadPrice;
	
	@Value("${beverage.milk.name}")
	private String milkName;
	@Value("${beverage.milk.price}")
	private int milkPrice;
	@Value("${beverage.milk.capacity}")
	private int milkCapacity;
	
	@Bean
	public Product carpBread() {
		
		return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
		
	}
	
	@Bean
	public Product milk() {
		
		return new Beverage(milkName, milkPrice, milkCapacity);
		
	}
	
	@Bean
	public Product water(@Value("${beverage.water.name}") String waterName, 
			@Value("${beverage.water.price}") int waterPrice,
			@Value("${beverage.water.capacity}") int waterCapacity) {
		
		return new Beverage(waterName, waterPrice, waterCapacity);
		
	}
	
	@Bean
	@Scope("prototype")		// 기본 값 singleton에서 prototype으로 변경
	public ShoppingCart cart() {
		
		return new ShoppingCart();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
