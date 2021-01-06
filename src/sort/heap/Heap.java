package sort.heap;

import collection.list.library.ArrayList;

public class Heap<E extends Comparable<E>> {
	
	private boolean isMax = true;
	
	private ArrayList<E> list = new ArrayList<E>();

	public Heap() {
		this.isMax = true;
	}

	public Heap(boolean isMax) {
		this.isMax = isMax;
	}
	
	public void add(E element) {
		list.addLast(element);
		int currentIndex = list.size() - 1;

		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			if ((isMax && list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) ||
				(!isMax && list.get(currentIndex).compareTo(list.get(parentIndex)) < 0)) {
				
				E e = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, e);
			} else {
				break;
			}
			currentIndex = parentIndex;
		}
	}

	public E remove() {
		if (list.size() == 0)
			return null;

		E removedElement = list.get(0);

		list.set(0, list.get(list.size() - 1));

		list.removeLast();

		int currentIndex = 0;

		while (true) {
			int leftIndex = 2 * currentIndex + 1;
			int rigthIndex = 2 * currentIndex + 2;
			
			if (leftIndex >= list.size())
				break;

			int nextIndex = leftIndex;
			if (rigthIndex < list.size()) {
				if ((isMax && list.get(rigthIndex).compareTo(list.get(nextIndex)) > 0) ||
					(!isMax && list.get(rigthIndex).compareTo(list.get(nextIndex)) < 0)) {
					
					nextIndex = rigthIndex;
				}
			}

			if ((isMax && list.get(nextIndex).compareTo(list.get(currentIndex)) > 0) ||
				(!isMax && list.get(nextIndex).compareTo(list.get(currentIndex)) < 0)) {
				
				E e = list.get(currentIndex);
				list.set(currentIndex, list.get(nextIndex));
				list.set(nextIndex, e);
			} else {
				break;
			}

			currentIndex = nextIndex;
		}

		return removedElement;
	}

}
