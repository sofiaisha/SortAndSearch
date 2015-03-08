package com.mysortandsearch;

public class MyInteger implements HasAnIntegerKey, Comparable<Object> {

	private Integer i;
	
	MyInteger(int i) {
		this.i = i;
	}
	
	public String toString() {
		return ""+i;
	}
	
	public boolean equals(Object o) {
		MyInteger myInt = (MyInteger)o;
		return (this.i == myInt.i);
	}
	
	@Override
	public int getKey() {
		return i;
	}

	@Override
	public int compareTo(Object o) {
		MyInteger myInt = (MyInteger)o;
		if (this.i == myInt.i) return 0;
		if (this.i > myInt.i) return 1;
		else return -1;
	}	
}