package com.greedy.thymeleaf.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/* Lombok
 * : DTO/VO 클래스의 constructor, getter/setter, toString 등을 어노테이션을 통해 자동 작성해주는 기능을 포함한 라이브러리 
 *   필드 수정 후 해당 코드에 대한 수정 작업이 별도로 필요하지 않다는 장점이 있다. 
 *   팀 프로젝트에서 활용 시 모든 팀원이 해당 라이브러리를 설치한 환경에서 사용해야 한다.
 *   구조와 무관하게 남용 될 수 있어 프로젝트에 따라서는 사용하지 않는 경우도 있음에 유의한다. */
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data	// 매개변수 생성자를 제외하고 위에 있는 어노테이션을 한 번에 처리할 수 있는 어노테이션
@AllArgsConstructor
public class MemberDTO {
	
	private String name;
	private int age;
	private char gender;
	private String address;

}
