# SortAndSearch

Various sort and search algorithms for generic lists, implemented in Java.

<b>Sort algorithms (com.mysortandsearch.sort)</b>
- Insertion sorts
  * <code>static \<T> void insertionSort(List\<T> list)</code>
- Exchange sorts
  * <code>static \<T> void bubbleSort(List\<T> list)</code>
  * <code>static \<T> void quickSort(List\<T> list)</code>
- Selection sorts
  * <code>static \<T> void selectionSort(List\<T> list)</code>
- Distribution sorts
  * <code>static \<T> List\<T> countSort(List\<T> list)</code>
  * <code>static \<T> bucketSort(List\<T> list)</code>

<b>Search algorithms (com.mysortandsearch.search)</b>
- <code>static \<T> boolean linearSearch(List\<T> list, T t)</code>
- <code>static \<T> boolean linearSearch(List\<T> list, T t, LinearSearchMode mode)</code>
- <code>static \<T> boolean linearSearchRecursive(List\<T> list, T t)</code>
- <code>static \<T> boolean binarySearch(List\<T> list, T t)</code>
- <code>static \<T> boolean binarySearchRecursive(List\<T> list, T t)</code>

<b>Utility classes (com.mysortandsearch.utils)</b>
- <code>ListGenerator</code>: generate random lists of Integers.
- <code>HasAnIntegerKey</code> : interface required by countSort().
- <code>MyInteger</code> : wrapper class for integers. Used to test distribution sorts.

<b>Utility classes for sorts (com.mysortandsearch.sort.utils)</b>
- <code>Sort</code> : common utility methods.
- <code>MyHashTable</code> : specific hash table for bucketSort().

<b>Utility classes for searches (com.mysortandsearch.search.utils)</b>
- <code>LinearSearchMode</code>
- <code>LinearSearchModeFactory</code>

<b>Test classes (com.mysortandsearch.test)</b>
- <code>TestXXX</code>: unit tests for class XXX.

References: 
- "Algorithms in a nutshell", O'Reilly, 2009
- Wikipedia
