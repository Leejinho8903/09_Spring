package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.greedy.section01.advice.annotation.AchievementResult;

@Component
@Aspect
public class AfterReturningAttendingAdvice {

	/* @AfterReturning은 메소드 정상 수행 후 반환이므로 반환 값을 참조할 수 있다. 
	 * returning 속성에 작성한 이름으로 매개변수에 Object 객체를 선언한다. 
	 * JointPoint는 반드시 첫번째 매개변수로 선언해야 한다. */
	@AfterReturning(pointcut="execution(* com.greedy.section01.advice.annotation..*(..))", returning="result")
	public void afterReturningAttending(JoinPoint joinPoint, Object result) {
		
		System.out.println("===== AfterReturning Attending =====");
		System.out.println("오늘의 이해도 : " + ((AchievementResult)result).getUnderstandingScore());
		System.out.println("오늘의 만족도 : " + ((AchievementResult)result).getSatisfactionScore());
		System.out.println("취업률 : " + ((AchievementResult)result).getEmployeementRate());
		
		/* 정상 수행 후 반환하는 반환 값을 가공해서 넘겨줄 수도 있다. */
		double employeementRate = ((AchievementResult)result).getEmployeementRate();
		double percent = employeementRate / 1000.0 * 100;
		((AchievementResult)result).setEmployeementRate(percent);
		
		System.out.println("===================================");
	}
	
}









