package sort.library;

public class SelectionSortTest extends AbstractSortTest {
	
	@Override
	public AbstractSort<Integer> createIntegerSortClass() {
		return new SelectionSort<Integer>();
	}

	@Override
	public AbstractSort<String> createStringSortClass() {
		return new SelectionSort<String>();
	}

}
