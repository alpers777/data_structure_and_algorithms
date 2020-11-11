package sort.library;

import java.util.Arrays;

import org.junit.Test;

public class PerformanceTest {
	
	@Test
	public void testPerformance() {
		
		for (int i = 100; i < 10_000_000; i *= 10) {
			System.out.println("Sort performance test for size: " + i);
			Integer[] randomArray = generateRandomArray(i);
			
			System.out.printf("%-20s%-10d\n", "Java Sort", javaSortTime(randomArray.clone()));
			
			if (i < 100_000) {
				System.out.printf("%-20s%-10d\n", "BubbleSort", sortTime(new BubbleSort<Integer>(), randomArray.clone()));
				
				System.out.printf("%-20s%-10d\n", "InsertionSort", sortTime(new InsertionSort<Integer>(), randomArray.clone()));
				
				System.out.printf("%-20s%-10d\n", "SelectionSort", sortTime(new SelectionSort<Integer>(), randomArray.clone()));
			}
			System.out.printf("%-20s%-10d\n", "MergeSort", sortTime(new MergeSort<Integer>(), randomArray.clone()));
			
			System.out.printf("%-20s%-10d\n", "QuickSort", sortTime(new QuickSort<Integer>(), randomArray.clone()));
			
			System.out.println("---------------------------\n");
		}
		
		
	}
	
	private long sortTime(AbstractSort<Integer> sorter, Integer[] array) {
		long start = System.currentTimeMillis();
		
		sorter.sort(array);
		
		long end = System.currentTimeMillis();
		
		return end - start;
	}
	
	private long javaSortTime(Integer[] array) {
		long start = System.currentTimeMillis();
		
		Arrays.sort(array);
		
		long end = System.currentTimeMillis();
		
		return end - start;
	}
	
	private Integer[] generateRandomArray(int size) {
		
		Integer[] randomArray = new Integer[size];
		
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}
		
		return randomArray;
	}
	

}
