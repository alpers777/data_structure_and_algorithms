package sort.simple;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class SelectionSortTest {
	
	@Test
	public void selectionSortTest() {
		int[] expectedArray = { 3, 3, 9, 11, 5, 36, 5, 8 };
		int[] actualArray = expectedArray.clone();

		Arrays.sort(expectedArray);

		SelectionSort.selectionSort(actualArray);

		assertArrayEquals(expectedArray, actualArray);
	}

}
