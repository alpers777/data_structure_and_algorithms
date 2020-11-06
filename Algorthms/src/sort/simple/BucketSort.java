package sort.simple;

import java.util.ArrayList;

public class BucketSort {
	
	volkan yazacak

	public void bucketSort(int[] list) {
		ArrayList<Integer>[] bucket = new ArrayList[list.length + 1];
		
		// Distribute the elements from list to buckets
		for (int i = 0; i < list.length; i++) {
			int key = list[i]; // Assume element has the getKey() method
			if (bucket[key] == null)
				bucket[key] = new ArrayList<>();
			bucket[key].add(list[i]);
		}
		// Now move the elements from the buckets back to list int k = 0; // k is an
		// index for list
		int k = 0;
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] != null) {
				for (int j = 0; j < bucket[i].size(); j++)
					list[k++] = bucket[i].get(j);
			}
		}
	}
}
