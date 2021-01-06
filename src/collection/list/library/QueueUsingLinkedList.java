package collection.list.library;


public class QueueUsingLinkedList<E> {

	private LinkedList<E> list = new LinkedList<E>();

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
