package com.mysortandsearch;

public class MyInteger implements HasAnIntegerKey, Comparable<MyInteger> {

	private final int i;

	MyInteger(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return "" + i;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MyInteger)) {
			return false;
		}
		MyInteger other = (MyInteger) obj;
		if (i != other.i) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + i;
		return result;
	}

	@Override
	public int getKey() {
		return i;
	}

	@Override
	public int compareTo(MyInteger myInt) {
		if (i == myInt.i) {
			return 0;
		}
		if (i > myInt.i) {
			return 1;
		} else {
			return -1;
		}
	}
}