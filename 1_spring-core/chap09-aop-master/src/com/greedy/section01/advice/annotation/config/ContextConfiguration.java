package com.greedy.section01.advice.annotation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
/* AspectJ의 AutoProxy 사용에 관한 설정을 해주어야만 Advice가 동작한다. 
 * JoinPoint에 Advice를 끼워 넣는 행위를 weaving이라고 하고 위빙을 지원해주는 weaver 라이브러리도 추가해야 한다. */
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ContextConfiguration {

}
