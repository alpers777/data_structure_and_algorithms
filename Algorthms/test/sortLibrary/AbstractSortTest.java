package sortLibrary;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public abstract class AbstractSortTest {

	@Test
	public void sortTest() {
		Integer[] expectedArray = { 3, 3, 9, 11, 5, 36, 5, 8 };
		Integer[] actualArray = expectedArray.clone();

		Arrays.sort(expectedArray);

		AbstractSort<Integer> bsi = createIntegerSortClass();
		bsi.sort(actualArray);

		assertArrayEquals(expectedArray, actualArray);
		
		
		String[] expectedArrayString = { "Ankara", "İstanbul", "Antalya", "Çanakkale", "Diyatbakır" };
		String[] actualArrayString = expectedArrayString.clone();

		Arrays.sort(expectedArrayString);

		AbstractSort<String> bss = createStringSortClass();
		bss.sort(actualArrayString);

		assertArrayEquals(expectedArrayString, actualArrayString);
	}
	
	public abstract AbstractSort<Integer> createIntegerSortClass();
	
	public abstract AbstractSort<String> createStringSortClass();
}
