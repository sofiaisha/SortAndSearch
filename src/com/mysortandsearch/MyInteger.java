package com.mysortandsearch;

public class MyInteger implements HasAnIntegerKey, Comparable<MyInteger> {

	private Integer i;
	
	MyInteger(int i) {
		this.i = i;
	}
	
	public String toString() {
		return ""+i;
	}
	
	public boolean equals(MyInteger myInt) {
		return (this.i == myInt.i);
	}
	
	@Override
	public int getKey() {
		return i;
	}

	@Override
	public int compareTo(MyInteger myInt) {
		if (this.i == myInt.i) return 0;
		if (this.i > myInt.i) return 1;
		else return -1;
	}	
}