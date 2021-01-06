package sort.heap;

import collection.list.library.ArrayList;

public class MinHeap<E extends Comparable<E>> {

	private ArrayList<E> list = new ArrayList<>();

	public void add(E element) {
		list.addLast(element);
		int currentIndex = list.size() - 1;

		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) < 0) {
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
		if (list.size() == 0) {
			return null;
		}

		E removedElement = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.removeLast();

		int currentIndex = 0;

		while (true) {
			int leftIndex = currentIndex * 2 + 1;
			int rightIndex = currentIndex * 2 + 2;

			if (leftIndex >= list.size()) {
				break;
			}

			int maxIndex = leftIndex;
			if (rightIndex < list.size()) {
				if (list.get(rightIndex).compareTo(list.get(maxIndex)) < 0) {
					maxIndex = rightIndex;
				}
			}
			if (list.get(maxIndex).compareTo(list.get(currentIndex)) < 0) {
				E e = list.get(currentIndex);
				list.set(currentIndex, list.get(maxIndex));
				list.set(maxIndex, e);
			} else {
				break;
			}
			currentIndex = maxIndex;
		}
		return removedElement;
	}
}
