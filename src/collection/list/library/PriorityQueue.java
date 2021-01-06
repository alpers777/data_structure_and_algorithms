package collection.list.library;

import sort.heap.Heap;

public class PriorityQueue<E extends Comparable<E>> {
	
	Heap<E> heap = new Heap<E>();
	
	public void enqueue(E element) {
		heap.add(element);
	}

	public E dequeue() {
		return heap.remove();
	}

	public int size() {
		return heap.getSize();
	}
	
	public boolean isEmpty() {
		return heap.getSize() == 0;
	}

	public void clear() {
		heap.clear();;
	}


}
