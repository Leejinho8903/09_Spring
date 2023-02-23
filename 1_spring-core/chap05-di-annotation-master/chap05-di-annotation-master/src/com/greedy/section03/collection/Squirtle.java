package com.greedy.section03.collection;

import org.springframework.stereotype.Component;

@Component
public class Squirtle implements Pokemon {

	@Override
	public void attack() {
		System.out.println("꼬부기 물대포 발사~~~ 쏴~~~");
	}

}
