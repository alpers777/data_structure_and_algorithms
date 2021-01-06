package collection.list.library;


public class QueueUsingArrayList<E> {

	private ArrayList<E> list = new ArrayList<E>();

	public void enqueue(E element) {
		list.addLast(element);
	}

	public E dequeue() {
		return list.removeFirst();
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void clear() {
		list.clear();
	}
}
