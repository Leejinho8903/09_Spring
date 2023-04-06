package com.greedy.section01.advice.xmlconfig.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAttendingAdvice {
	
	public Object aroundAttending(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("===== Around Attending Advice =====");
		System.out.println("오늘도 학원에 가서 열심히 공부해야지!!! 라는 마음으로 아침 일찍 일어납니다.");
		
		/* 공부 시간을 체크하기 위해 스탑워치를 켠다. */
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		/* 원본 조인 포인트를 실행 후 반환한다. */
		Object result = joinPoint.proceed();
		
		/* 스탑워치를 종료한다. */
		stopWatch.stop();
		
		System.out.println("총 공부 소요 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");
		System.out.println("================================");
		
		/* 원본 조인 포인트를 호출한 쪽 혹은 다른 어드바이스가 다시 실행할 수 있도록 리턴 값을 이어서 반환한다. */
		return result;
	}
	
}








