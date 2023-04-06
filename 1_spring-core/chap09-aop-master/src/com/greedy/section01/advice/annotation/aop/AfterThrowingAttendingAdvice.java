package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowingAttendingAdvice {
	
	@AfterThrowing(pointcut="execution(* com.greedy.section01.advice.annotation..*(..))", throwing="exception")
	public void afterThrowingAttending(JoinPoint joinPoint, Throwable exception) {
		
		System.out.println("===== AfterThrowing Attending =====");
		System.out.println(exception.getMessage());
		System.out.println("===================================");
		
	}

}
