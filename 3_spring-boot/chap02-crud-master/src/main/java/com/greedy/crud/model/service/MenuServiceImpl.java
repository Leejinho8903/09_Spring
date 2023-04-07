package com.greedy.crud.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.crud.model.dao.MenuMapper;
import com.greedy.crud.model.dto.CategoryDTO;
import com.greedy.crud.model.dto.MenuDTO;

@Service("menuService")
@Transactional
/* @Transactional 어노테이션이 붙은 클래스 내부의 메소드는 모두 transaction 관리가 된다.
 * @Transactional 어노테이션은 메소드 레벨로 분리해서 작성할 수도 있다.
 * 메소드 동작시 Exception이 발생하면 전체 트랜잭션을 rollback하고 정상 수행 시에는 commit하는 동작이 일어난다. */
public class MenuServiceImpl implements MenuService {
	
	private final MenuMapper menuMapper;
	
	@Autowired
	public MenuServiceImpl(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}

	@Override
	public List<MenuDTO> findAllMenu() {
		return menuMapper.findAllMenu();
	}

	@Override
	public List<CategoryDTO> findAllCategory() {
		return menuMapper.findAllCategory();
	}

	@Override
	public boolean registMenu(MenuDTO menu) throws Exception {
		
		int result = menuMapper.registMenu(menu);
		
		if(result <= 0) {
			throw new Exception("메뉴 등록에 실패하였습니다.");
		}
		
		return result > 0 ? true : false;
	}

}
