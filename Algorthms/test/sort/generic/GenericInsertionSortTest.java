package sort.generic;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class GenericInsertionSortTest {
	
	@Test
	public void genericInsertionSortTest() {
		Integer[] expectedArray = { 3, 3, 9, 11, 5, 36, 5, 8 };
		Integer[] actualArray = expectedArray.clone();

		Arrays.sort(expectedArray);

		GenInsertionSort.insertionSort(actualArray);

		assertArrayEquals(expectedArray, actualArray);
		
		String[] expectedArrayString = { "Ankara", "İstanbul", "Antalya", "Çanakkale", "Diyatbakır" };
		String[] actualArrayString = expectedArrayString.clone();

		Arrays.sort(expectedArrayString);

		GenInsertionSort.insertionSort(actualArrayString);

		assertArrayEquals(expectedArrayString, actualArrayString);
	}

}
