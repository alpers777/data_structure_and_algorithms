package sortGeneric;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class GenericSortTest {

	@Test
	public void bubbleSortTest() {
		Integer[] expectedArray = { 3, 3, 9, 11, 5, 36, 5, 8 };
		Integer[] actualArray = expectedArray.clone();

		Arrays.sort(expectedArray);

		GenBubbleSort.bubbleSort(actualArray);

		assertArrayEquals(expectedArray, actualArray);

		String[] expectedArrayString = { "Ankara", "İstanbul", "Antalya", "Çanakkale", "Diyatbakır" };
		String[] actualArrayString = expectedArrayString.clone();

		Arrays.sort(expectedArrayString);

		GenBubbleSort.bubbleSort(actualArrayString);

		assertArrayEquals(expectedArrayString, actualArrayString);
	}

	public void insertionSortTest() {
		Integer[] expectedArray = { 3, 3, 9, 11, 5, 36, 5, 8 };
		Integer[] actualArray = expectedArray.clone();

		Arrays.sort(expectedArray);

		GenInsertionSort.insertionSort(actualArray);

		assertArrayEquals(expectedArray, actualArray);
	}

	public void selectionSortTest() {
		Integer[] expectedArray = { 3, 3, 9, 11, 5, 36, 5, 8 };
		Integer[] actualArray = expectedArray.clone();

		Arrays.sort(expectedArray);

		GenSelectionSort.selectionSort(actualArray);

		assertArrayEquals(expectedArray, actualArray);
	}

}
