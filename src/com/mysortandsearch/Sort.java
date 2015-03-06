package com.mysortandsearch;

import java.util.List;

public class Sort<T> {

	public static <T> void insertionSort(List<T> list) {
		for (int i=1;i<list.size();i++) {
			insert(list, i, list.get(i));
		}
	}
	
	private static <T> void insert(List<T> list, int index, T element) {
		int position = index-1;
		// For each element, start from its original position
		while ( (position>=0) && ( ((Comparable<T>)list.get(position)).compareTo(element) > 0) ) {
			list.set(position+1, list.get(position));
			position--;
		}
		list.set(position+1, element);
	}
}
