package com.greedy.thymeleaf.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SelectCriteria {
	
	private int startPage;
	private int endPage;
	private int pageNo;

}
