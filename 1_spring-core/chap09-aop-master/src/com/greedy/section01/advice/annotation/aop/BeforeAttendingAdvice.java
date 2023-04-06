package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.greedy.section01.advice.annotation.Passion;

@Component
@Aspect
public class BeforeAttendingAdvice {
	
	/* 포인트 컷으로 패치한 실행 시점을 조인 포인트라고 한다.
	 * 포인트 컷은 여러 조인 포인트를 매치하기 위해 지정한 표현식이고, 이렇게 매치 된 조인 포인트에서 해야 할 일이 어드바이스이다. */
	@Before("execution(* com.greedy.section01.advice.annotation..*(..))")
	public void beforeAttending(JoinPoint joinPoint) {
		
		System.out.println("===== Before Attending =====");
		System.out.println("오늘도 신나게 등원해서 입실 카드를 찍는다~!");
		System.out.println("수강생 타입 : " + joinPoint.getTarget().getClass());   //타겟 클래스의 정보
		System.out.println("수강생의 행위 : " + joinPoint.getSignature());			//리턴 타입을 포함한 시그니처
		System.out.println("행위 요약 : " + joinPoint.getSignature().getName());  //메소드 이름만 
		System.out.println("수강생의 열정 : " + ((Passion)joinPoint.getArgs()[0]).getScore());
		System.out.println("============================");
		
	}
	
}












