package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/* 베이스 패키지에 등록 되지 않은 패키지는 스캔에서 제외하고 등록 된 패키지 내의 @Component 탐색
 * 등록하지 않으면 현 설정 클래스가 존재하는 패키지가 자동으로 베이스 패키지가 된다. */
//@Configuration
//@ComponentScan(basePackages="com.greedy.section01.javaconfig")
public class ContextConfiguration1 {

}
