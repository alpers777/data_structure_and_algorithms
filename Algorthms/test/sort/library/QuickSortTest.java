package sort.library;

public class QuickSortTest extends AbstractSortTest {
	
	@Override
	public AbstractSort<Integer> createIntegerSortClass() {
		return new QuickSort<Integer>();
	}

	@Override
	public AbstractSort<String> createStringSortClass() {
		return new QuickSort<String>();
	}

}
