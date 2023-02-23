package com.greedy.section04.resource;

import org.springframework.stereotype.Component;

//@Component
public class Charmander implements Pokemon {

	@Override
	public void attack() {
		System.out.println("파이리 불꽃 공격~~~ 퐈이아~~~");
	}

}
