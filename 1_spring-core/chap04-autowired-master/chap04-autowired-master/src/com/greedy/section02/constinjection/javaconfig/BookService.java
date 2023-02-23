package com.greedy.section02.constinjection.javaconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* @Component의 세분화 어노테이션의 한 종류로 Service 레이어에서 사용한다. */
@Service
public class BookService {
	
	/* 생성자 주입의 장점 
	 * 1. 필드에 final 키워드 사용이 가능해지므로 변경 불가능하게 사용할 수 있다. 
	 * 2. 순환 참조 방지 
	 * (필드 주입이나 세터 주입은 메소드 실행 시점에만 오류가 발생하지만 생성자 주입의 경우 어플리케이션 실행 시점에서 확인 가능)
	 * 3. DI 컨테이너와의 결합도가 낮기 때문에 테스트 하기 좋다. (스프링 컨테이너 없이 테스트를 할 수 있다.) 
	 * */
	
	private final BookDAO bookDAO;
	
//	public BookService() {}
	
	/* BookDAO 타입의 빈 객체를 생성자로 전달 받아 주입해준다. 
	 * @Autowired를 주석해도 정상 동작하는 이유는 스프링 4.3 버전 이후로는 생성자 주입 방식을 사용할 때
	 * 생성자가 한 개 뿐이라면 해당 생성자에 어노테이션을 생략해도 자동으로 주입해준다.
	 * 단, 기본 생성자를 추가하면 오류가 나므로 그 때는 명시적으로 작성을 해주어야 한다.*/
	// @Autowired
	public BookService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public List<BookDTO> selectAllBooks(){
		
		return bookDAO.selectBookList();
	}
	
	public BookDTO searchBookBySequence(int sequence) {
		
		return bookDAO.selectOneBook(sequence);
	}
	
}








