package sortLibrary;

import java.util.List;

public abstract class AbstractSort<T extends Comparable<T>> {
	
	public abstract void sort(T[] array);
	
	public void sort(List<T> list) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) list.toArray();
		
		sort(array);
		
		for (int i = 0; i < array.length; i++) {
			list.set(i, array[i]);
		}
	}

}
