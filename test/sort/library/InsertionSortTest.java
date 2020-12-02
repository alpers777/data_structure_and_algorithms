package sort.library;

import sort.library.AbstractSort;
import sort.library.InsertionSort;

public class InsertionSortTest extends AbstractSortTest {
	
	@Override
	public AbstractSort<Integer> createIntegerSortClass() {
		return new InsertionSort<Integer>();
	}

	@Override
	public AbstractSort<String> createStringSortClass() {
		return new InsertionSort<String>();
	}
	
}
