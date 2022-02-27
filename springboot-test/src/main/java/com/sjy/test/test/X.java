package com.sjy.test.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class X {

	@Autowired
	Y y;

	public X(){
		System.out.println("X create");
	}

	@Override
	public String toString() {
		return "X{" +
				"y=" + y +
				'}';
	}
}
