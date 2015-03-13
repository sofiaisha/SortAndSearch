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
	
	public ArrayList<Integer> buildUnique(int count, int maxValue) {
		if (maxValue < count) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		int counter = 0;
		while (counter != count) {
			int value = rand.nextInt(maxValue + 1);
			if (!list.contains(value)) {
				list.add(value);
				counter++;
			}
		}
		return list;
	}
	
	public ArrayList<HasAnIntegerKey> buildMyIntegerList(int count, int maxValue) {
		ArrayList<HasAnIntegerKey> list = new ArrayList<HasAnIntegerKey>();
		for (int i = 0; i < count; i++) {
			list.add(new MyInteger(rand.nextInt(maxValue + 1)));
		}
		return list;
	}
}
