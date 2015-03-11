package com.mysortandsearch.utils;

import java.util.ArrayList;
import java.util.Random;

public class ListGenerator {

	private final Random rand;

	public ListGenerator() {
		rand = new Random(System.currentTimeMillis());
	}

	public ArrayList<Integer> build(int count, int maxValue) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) {
			list.add(rand.nextInt(maxValue + 1));
		}
		return list;
	}

	public ArrayList<MyInteger> buildMyIntegerList(int count, int maxValue) {
		ArrayList<MyInteger> list = new ArrayList<MyInteger>();
		for (int i = 0; i < count; i++) {
			list.add(new MyInteger(rand.nextInt(maxValue + 1)));
		}
		return list;
	}
}
