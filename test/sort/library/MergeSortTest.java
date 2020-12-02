package sort.library;

public class MergeSortTest extends AbstractSortTest {
	
	@Override
	public AbstractSort<Integer> createIntegerSortClass() {
		return new MergeSort<Integer>();
	}

	@Override
	public AbstractSort<String> createStringSortClass() {
		return new MergeSort<String>();
	}

}
