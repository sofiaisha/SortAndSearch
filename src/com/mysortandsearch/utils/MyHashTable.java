package com.mysortandsearch.utils;

import java.util.ArrayList;

public class MyHashTable<T extends HasAnIntegerKey> {

	private final int maxValue;
	private final int nbBuckets;
	private final ArrayList<ArrayList<T>> hashtable;
	private final static int maxElementsPerBucket = 8;

	public MyHashTable(int capacity, int maxValue) {
		if (capacity < maxElementsPerBucket) {
			capacity = maxElementsPerBucket;
		}
		this.maxValue = maxValue;
		this.nbBuckets = capacity / maxElementsPerBucket;
		this.hashtable = new ArrayList<ArrayList<T>>(nbBuckets);
		for (int i = 0; i < nbBuckets; i++) {
			this.hashtable.add(new ArrayList<T>());
		}
	}

	public int getNbBuckets() {
		return nbBuckets;
	}

	public ArrayList<T> getBucket(int i) {
		return hashtable.get(i);
	}

	private int hashFunc(int i) {
		float h1 = ((float) i) / maxValue;
		int h2 = (int) (h1 * maxElementsPerBucket);
		assert (h2 <= this.nbBuckets);
		return h2;
	}

	public boolean add(T t) {
		if (t == null) {
			return false;
		}
		hashtable.get(hashFunc(t.getKey())).add(t);
		return true;
	}
}
