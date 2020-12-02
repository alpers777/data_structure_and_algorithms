package sort.generic;

public class GenInsertionSort {
	public static <T extends Comparable<T>> void insertionSort(T[] list) {
		for (int i = 1; i < list.length; i++) {
			/**
			 * insert list[i] into a sorted sublist list[0..i-1] so that list[0..i] is
			 * sorted.
			 */
			T currentElement = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k].compareTo(currentElement) > 0; k--) {
				list[k + 1] = list[k];
			}

			// Insert the current element into list[k+1]
			list[k + 1] = currentElement;
		}
	}

}
