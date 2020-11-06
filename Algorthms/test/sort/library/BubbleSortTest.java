package sort.library;

import sort.library.AbstractSort;
import sort.library.BubbleSort;

public class BubbleSortTest extends AbstractSortTest {

	@Override
	public AbstractSort<Integer> createIntegerSortClass() {
		return new BubbleSort<Integer>();
	}

	@Override
	public AbstractSort<String> createStringSortClass() {
		return new BubbleSort<String>();
	}

}
