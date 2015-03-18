package com.mysortandsearch.search.utils;

import java.util.List;

// Implementation of the Strategy pattern for search modes used in LinearSearch.linearSearch()

@FunctionalInterface
public interface LinearSearchMode<T> {
	public void moveElement(List<T> list, int index);
}

class LinearSearchModeMoveFirst<T> implements LinearSearchMode<T> {
	@Override
	public void moveElement(List<T> list, int index) {
		// Both are checked by linearSearch()
		assert (list != null);
		assert ((index >= 0) && (index < list.size()));
		// Move element to the front of the list
		T t = list.remove(index);
		list.add(0, t);
	}
}

class LinearSearchModeMoveLast<T> implements LinearSearchMode<T> {
	@Override
	public void moveElement(List<T> list, int index) {
		// Both are checked by linearSearch()
		assert (list != null);
		assert ((index >= 0) && (index < list.size()));
		// Move element to the end of the list
		T t = list.remove(index);
		list.add(t);
	}

}

class LinearSearchModeMoveUp<T> implements LinearSearchMode<T> {
	@Override
	public void moveElement(List<T> list, int index) {
		// Both are checked by linearSearch()
		assert (list != null);
		assert ((index >= 0) && (index < list.size()));
		// Move element up, unless it's already at the front of the list
		if (index != 0) {
			// TODO: slow, need to do better
			T current = list.get(index);
			T previous = list.get(index - 1);
			list.set(index - 1, current);
			list.set(index, previous);
		}
	}
}



