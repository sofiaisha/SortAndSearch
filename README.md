# SortAndSearch

Various sort and search algorithms for generic lists, implemented in Java.

<b>Sort algorithms</b>
- Insertion sorts
  * <code>static \<T> void insertionSort(List\<T> list)</code>
- Exchange sorts
  * <code>static \<T> void bubbleSort(List\<T> list)</code>
  * <code>static \<T> void quickSort(List\<T> list)</code>
- Selection sorts
  * <code>static \<T> void selectionSort(List\<T> list)</code>
- Distribution sorts
  * <code>static \<T> List\<T> countSort(List\<T> list)</code>
- more to come

<b>Search algorithms</b>
- TBD

<b>Utility classes</b>
- <code>ListGenerator</code>: generate random lists of Integers.
- <code>HasAnIntegerKey</code> : interface required by countSort().

<b>Test classes</b>
- <code>TestXXX</code>: unit tests for class XXX.
- <code>MyInteger</code> : wrapper class for integers. Used to test countSort().

References: 
- "Algorithms in a nutshell", O'Reilly, 2009
- Wikipedia
