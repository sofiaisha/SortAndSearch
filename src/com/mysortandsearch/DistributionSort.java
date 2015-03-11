package com.mysortandsearch;

import java.util.ArrayList;
import java.util.List;

import com.mysortandsearch.utils.HasAnIntegerKey;
import com.mysortandsearch.utils.MyHashTable;

public class DistributionSort<T extends HasAnIntegerKey> {

	//
	// Count sort : sort a list of n elements with k integer keys (k<<n)
	// Best case o(n), median case o(n), worst case o(n)
	//
	public static <T extends HasAnIntegerKey> List<T> countSort(List<T> list,
			int maxValue) {
		if (maxValue < 0) {
			return null;
		}
		// Walk through the list and count occurrences
		int[] counters = new int[maxValue + 1];
		for (int i = 0; i < list.size(); i++) {
			T element = list.get(i);
			counters[((HasAnIntegerKey) element).getKey()]++;
		}
		// Compute the start index of each key
		int total = 0;
		for (int i = 0; i <= maxValue; i++) {
			int counter = counters[i];
			counters[i] = total;
			total += counter;
		}
		// Walk through the list, build a new list and put each element at the
		// correct index based on its key
		// Note: the initial order of elements with the same key will be
		// preserved (stable search)
		List<T> newList = new ArrayList<T>(list);
		for (int i = 0; i < list.size(); i++) {
			int key = ((HasAnIntegerKey) list.get(i)).getKey();
			newList.set(counters[key], list.get(i));
			counters[key]++;
		}
		return newList;
	}

	//
	// Bucket sort
	// Best case o(n), median case o(n), worst case o(n)
	//
	@SuppressWarnings("unchecked")
	public static <T extends HasAnIntegerKey> void bucketSort(List<T> list,
			int nbElements, int maxValue) {
		MyHashTable<HasAnIntegerKey> ht = new MyHashTable<>(nbElements,
				maxValue);
		// Hash all elements on their key
		for (int i = 0; i < list.size(); i++) {
			ht.add(list.get(i));
		}
		// Sort each bucket
		int index = 0;
		for (int i = 0; i < ht.getNbBuckets(); i++) {
			ArrayList<HasAnIntegerKey> bucket = ht.getBucket(i);
			InsertionSort.insertionSort(bucket);
			// Add each sorted bucket to the list
			for (int j = 0; j < bucket.size(); j++) {
				list.set(index + j, (T) bucket.get(j));
			}
			index += bucket.size();
		}
	}
}
