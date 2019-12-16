package com.bean;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		list.add(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
