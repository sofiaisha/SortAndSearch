package com.mysortandsearch.search.utils;

// Factory pattern, building search modes for LinearSearch.linearSearch()

public class LinearSearchModeFactory<T> {

	public static final int modeMoveFirst = 1;
	public static final int modeMoveLast = 2;
	public static final int modeMoveUp = 3;

	public static <T> LinearSearchMode<T> build(int mode) {
		switch (mode) {
		case 1:
			return new LinearSearchModeMoveFirst<T>();
		case 2:
			return new LinearSearchModeMoveLast<T>();
		case 3:
			return new LinearSearchModeMoveUp<T>();
		default:
			return null;
		}
	}
}
