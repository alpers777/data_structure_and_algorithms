package sortLibrary;

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
