package com.mysortandsearch;

import java.util.ArrayList;
import java.util.Random;

public class ListGenerator {
	
	private Random rand;
	
	ListGenerator() {
		this.rand = new Random(System.currentTimeMillis());
	}
	
	public ArrayList<Integer> build (int count, int maxValue) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0;i<count;i++) {
			list.add(rand.nextInt(maxValue+1));
		}
		return list;
	}
}
