package com.greedy.section02.xmlconfig;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/* MemberDAO를 상속 받은 MemberDAOImpl 클래스를 사용하면
 * 1. 인터페이스에 기재 된 기능에 대한 오버라이딩이 강제화 된다.
 * 2. MemberDAO 인터페이스를 다른 클래스에서 이용하게 되면 MemberDAOImpl이라는 구현체를 직접
 * 사용하지 않기 때문에 서로의 클래스 간의 결합이 느슨해진다. (결합도 낮춤)
 * */

/* 스프링 컨테이너가 스캐닝 기능을 이용하여 해당 클래스를 bean으로 등록할 수 있는 어노테이션을 설정 
 * value 속성을 이용하면 bean id를 설정할 수 있고 생략하면 class 앞 글자를 소문자로 하여 bean id를 생성 */
@Component(value="memberDAO")
public class MemberDAOImpl implements MemberDAO{

	private final Map<Integer, MemberDTO> memberMap;
	
	public MemberDAOImpl() {
		memberMap = new HashMap<>();
		
		memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
		memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
	}

	/* 매개변수로 전달 받은 회원 번호를 map에서 조회 후 회원 정보를 리턴해주는 용도의 메소드 */
	@Override
	public MemberDTO selectMember(int sequence) {
		return memberMap.get(sequence);
	}

	/* 매개변수를 전달 받은 회원 정보를 map에 추가하고 성공 실패 여부를 boolean으로 리턴하는 메소드 */
	@Override
	public boolean insertMember(MemberDTO newMember) {
		
		int before = memberMap.size();
		
		memberMap.put(newMember.getSequence(), newMember);
		
		int after = memberMap.size();
		
		return after > before ? true : false;
	}

}
