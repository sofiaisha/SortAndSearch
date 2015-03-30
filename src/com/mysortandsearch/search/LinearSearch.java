package com.mysortandsearch.search;

import java.util.Collections;
import java.util.List;

import com.mysortandsearch.search.utils.LinearSearchMode;

public class LinearSearch<T> {

	//
	// Linear search
	// Best case o(1), median case o(n), worst case o(n)
	//

	// Iterative version
	public static <T> boolean linearSearch(List<T> list, T t) {
		return linearSearch(list, t, null);
	}

	// Iterative version with mode (move to front, move to back, move up).
	// The mode can either be created using LinearSearchModeFactory,
	// or be passed as a lambda expression (see methods below).
	public static <T> boolean linearSearch(List<T> list, T t,
			LinearSearchMode<T> mode) {
		if ((list == null) || (t == null)) {
			return false;
		}
		for (int i = 0; i < list.size(); i++) {
			T current = list.get(i);
			if (current.equals(t)) {
				if (mode != null) {
					mode.moveElement(list, i);
				}
				return true;
			}
		}
		return false;
	}

	// Iterative versions with mode passed as a lambda expression

	// This is equivalent to: linearSearchMove(list, t,
	// LinearSearchModeFactory.build(LinearSearchModeFactory.modeMoveFirst))
	public static <T> boolean linearSearchMoveFirst(List<T> list, T t) {
		return linearSearch(list, t, ((List<T> l, int index) -> {
			T elem = l.remove(index);
			l.add(0, elem);
		}));
	}

	// This is equivalent to: linearSearchMove(list, t,
	// LinearSearchModeFactory.build(LinearSearchModeFactory.modeMoveLast))
	public static <T> boolean linearSearchMoveLast(List<T> list, T t) {
		return linearSearch(list, t, ((List<T> l, int index) -> {
			T elem = l.remove(index);
			l.add(elem);
		}));
	}

	// This is equivalent to: linearSearchMove(list, t,
	// LinearSearchModeFactory.build(LinearSearchModeFactory.modeMoveUp))
	public static <T> boolean linearSearchMoveUp(List<T> list, T t) {
		return linearSearch(list, t, ((List<T> l, int index) -> {
			if (index != 0) {
				Collections.swap(list, index-1, index);
			}
		}));
	}

	// Recursive version
	public static <T> boolean linearSearchRecursive(List<T> list, T t) {
		if ((list == null) || (t == null)) {
			return false;
		}
		return linearSearchRecursive_internal(list, t, 0);
	}

	private static <T> boolean linearSearchRecursive_internal(List<T> list,
			T t, int index) {
		if (index >= list.size()) {
			return false;
		}
		if (list.get(index).equals(t)) {
			return true;
		}
		return linearSearchRecursive_internal(list, t, index + 1);
	}
}
