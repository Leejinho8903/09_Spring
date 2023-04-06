package com.greedy.section01.advice.xmlconfig.aop;

import org.aspectj.lang.JoinPoint;

import com.greedy.section01.advice.xmlconfig.AchievementResult;

public class AfterReturningAttendingAdvice {

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









