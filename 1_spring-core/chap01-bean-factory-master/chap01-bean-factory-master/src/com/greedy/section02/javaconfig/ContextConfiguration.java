package com.greedy.section02.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.greedy.section01.xmlconfig.MemberDTO;

/* 이 클래스가 설정 메타 정보를 가지고 있다는 의미의 어노테이션 
 * 컨테이너를 생성할 시 해당 어노테이션이 달린 클래스를 먼저 인식하여 컨테이너를 설정한다. */
@Configuration
public class ContextConfiguration {
	
	/* bean을 등록하기 위해서는 메소드 위에 @Bean 어노테이션을 작성한다. 
	 * 이름을 별도로 지정하지 않으면 메소드 이름을 bean의 id로 자동 인식한다.
	 * @Bean("myName") or @Bean(name="myName")의 형식으로 bean의 id를 설정할 수 있다. */
	@Bean(name="member")
	public MemberDTO getMember() {
		
		return new MemberDTO(1, "user01", "pass01", "홍길동");
	}

}







