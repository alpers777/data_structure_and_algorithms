package sort.library;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import sort.library.AbstractSort;

public abstract class AbstractSortTest {

	@SuppressWarnings("unchecked")
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

		Integer[] expectedArrayInteger = new Integer[1_000_000];
		Integer[] actualArrayInteger;

		for (int i = 0; i < 1_000_000; i++) {
			expectedArrayInteger[i] = (int) (Math.random() * 100_000);
		}

		actualArrayInteger = expectedArrayInteger.clone();

		Arrays.sort(expectedArrayInteger);
		AbstractSort<Integer> intArray = createIntegerSortClass();
		intArray.sort(actualArrayInteger);
		assertArrayEquals(expectedArrayInteger, actualArrayInteger);
		
		ArrayList<Integer> expectedListInteger = new ArrayList<>();
		ArrayList<Integer> actualListInteger;
		Integer[] array = new Integer[1_000_000];

		for (int i = 0; i < 1_000_000; i++) {
			expectedListInteger.add((int) (Math.random() * 100_000));
		}

		actualListInteger = (ArrayList<Integer>) expectedListInteger.clone();
		
		array = (Integer[]) expectedListInteger.toArray();
		Arrays.sort(array);
		
		for (int i = 0; i < array.length; i++) {
			expectedListInteger.set(i, array[i]);
		}
		
		AbstractSort<Integer> intList = createIntegerSortClass();
		intList.sort(actualListInteger);
		actualListInteger.equals(expectedListInteger);
		

	}

	public abstract AbstractSort<Integer> createIntegerSortClass();

	public abstract AbstractSort<String> createStringSortClass();
}
