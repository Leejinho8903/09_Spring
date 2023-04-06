package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class AroundAttendingAdvice {
	
	/* AroundAdvice는 가장 강력한 어드바이스로 조인 포인트를 완전히 장악하기 때문에 
	 * 이전에 살펴본 어드바이스를 모두 around 어드바이스로 구현할 수 있다. 
	 * 원본 조인 포인트를 언제 실행할지, 실행 자체를 안 할지 여부도 제어할 수 있다.
	 * 조인 포인트의 진행 호출을 잊는 경우가 발생할 수도 있어 주의가 필요하며
	 * 최소한의 요건을 충족하면서도 가장 기능이 약한 어드바이스를 선택해서 쓰는 것이 바람직하다. */
	
	/* 동일한 클래스 내의 포인트 컷을 사용하는 것이라면 클래스명을 생략할 수 있다. 
	 * 다른 클래스에서 가져와서 사용하는 경우에는 클래스명을 기재해야 하며 다른 패키지라면 패키지를 포함한 클래스명을 기재한다. */
	@Around("studentAroundPointcut()")
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
	
	/* void형 메소드로 작성하고 표현식을 작성한다. 메소드의 이름이 포인트 컷의 이름이 된다. */
	@Pointcut("execution(* com.greedy.section01.advice.annotation..*(..))")
	private void studentAroundPointcut() {}

}








