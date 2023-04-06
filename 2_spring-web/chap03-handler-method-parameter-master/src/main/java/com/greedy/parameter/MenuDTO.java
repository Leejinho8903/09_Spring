package com.greedy.parameter;

/* DTO 클래스를 작성할 때 커맨드 객체(핸들러 메소드의 파라미터로 전달 받는 객체)로 이용하기 위해서는 
 * form의 name 값과 필드명이 일치하게 만들어야 한다. */
public class MenuDTO {
	
	private String name;
	private int price;
	private int categoryCode;
	private String orderableStatus;
	
	public MenuDTO() {}

	public MenuDTO(String name, int price, int categoryCode, String orderableStatus) {
		super();
		this.name = name;
		this.price = price;
		this.categoryCode = categoryCode;
		this.orderableStatus = orderableStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getOrderableStatus() {
		return orderableStatus;
	}

	public void setOrderableStatus(String orderableStatus) {
		this.orderableStatus = orderableStatus;
	}

	@Override
	public String toString() {
		return "MenuDTO [name=" + name + ", price=" + price + ", categoryCode=" + categoryCode + ", orderableStatus="
				+ orderableStatus + "]";
	}
	
	

}
