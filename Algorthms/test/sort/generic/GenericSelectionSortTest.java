package sort.generic;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

public class GenericSelectionSortTest {

	public void genSelectionSortTest() {
		Integer[] expectedArray = { 3, 3, 9, 11, 5, 36, 5, 8 };
		Integer[] actualArray = expectedArray.clone();

		Arrays.sort(expectedArray);

		GenSelectionSort.selectionSort(actualArray);

		assertArrayEquals(expectedArray, actualArray);
		
		String[] expectedArrayString = { "Ankara", "İstanbul", "Antalya", "Çanakkale", "Diyatbakır" };
		String[] actualArrayString = expectedArrayString.clone();

		Arrays.sort(expectedArrayString);

		GenSelectionSort.selectionSort(actualArrayString);

		assertArrayEquals(expectedArrayString, actualArrayString);
	}
}
