package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.greedy.section01.javaconfig.Account;
import com.greedy.section01.javaconfig.MemberDTO;
import com.greedy.section01.javaconfig.PersonalAccount;

@Configuration
public class ContextConfiguration {
	
	@Bean
	public Account accountGenerator() {
		
		return new PersonalAccount(20, "110-234-567890", "1234");
	}
	
	@Bean
	public MemberDTO memberGenerator() {
		
		/* 생성자를 통해 Account를 생성하는 메소드를 호출한 리턴 값을 사용하여 bean을 조립할 수 있다. */
//		return new MemberDTO(1, "홍길동", "010-1234-5678", "hong123@gmail.com", accountGenerator());
		
		/* setter 메소드를 사용한 의존성 주입 */
		MemberDTO member = new MemberDTO();
		member.setSequence(1);
		member.setName("홍길동");
		member.setPhone("010-1234-5678");
		member.setEmail("hong123@gmail.com");
		member.setPersonalAccount(accountGenerator());
		
		return member;
	}

	
	
	
	
	
	
	
	
	
	
}
