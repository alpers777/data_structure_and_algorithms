package sort.heap;

public class Main {
	
	public static void main(String[] args) {
		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		
		maxHeapSort(list);
		
		minHeapSort(list);
		
		heapSortMax(list);
		
		heapSortMin(list);

	}

	private static void heapSortMin(Integer[] list) {
		Heap<Integer> maxHeap = new Heap<Integer>(false);
		for(Integer number : list) {
			maxHeap.add(number);
		}
		for(int i = 0; i < list.length; i++) {
			System.out.print(maxHeap.remove() + " ");
		}
		System.out.println();
	}

	private static void heapSortMax(Integer[] list) {
		Heap<Integer> minHeap = new Heap<Integer>();
		for(Integer number : list) {
			minHeap.add(number);
		}
		for(int i = 0; i < list.length; i++) {
			System.out.print(minHeap.remove() + " ");
		}
		System.out.println();
	}

	private static void minHeapSort(Integer[] list) {
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
		for(Integer number : list) {
			minHeap.add(number);
		}
		for(int i = 0; i < list.length; i++) {
			System.out.print(minHeap.remove() + " ");
		}
		System.out.println();
	}

	private static void maxHeapSort(Integer[] list) {
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		for(Integer number : list) {
			maxHeap.add(number);
		}
		for(int i = 0; i < list.length; i++) {
			System.out.print(maxHeap.remove() + " ");
		}
		System.out.println();
	}

}
