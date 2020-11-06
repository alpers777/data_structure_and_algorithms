package sort.simple;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import sort.simple.BubbleSort;
import sort.simple.InsertionSort;
import sort.simple.SelectionSort;

public class IntegerSortTest {
	

	@Test
	public void bubbleSortTest() {
		int[] expectedArray = { 3, 3, 9, 11, 5, 36, 5, 8 };
		int[] actualArray = expectedArray.clone();

		Arrays.sort(expectedArray);
		
		BubbleSort.bubbleSort((actualArray));

		assertArrayEquals(expectedArray, actualArray);
	}

	public void insertionSortTest() {
		int[] expectedArray = { 3, 3, 9, 11, 5, 36, 5, 8 };
		int[] actualArray = expectedArray.clone();

		Arrays.sort(expectedArray);

		InsertionSort.insertionSort(actualArray);

		assertArrayEquals(expectedArray, actualArray);
	}

	public void selectionSortTest() {
		int[] expectedArray = { 3, 3, 9, 11, 5, 36, 5, 8 };
		int[] actualArray = expectedArray.clone();

		Arrays.sort(expectedArray);

		SelectionSort.selectionSort(actualArray);

		assertArrayEquals(expectedArray, actualArray);
	}

}
