package collection.list.simple;

public class QueueUsingLinkedList {
	
	private ArrayList list = new ArrayList();

	public void enqueue(int element) {
		list.addLast(element);
	}

	public int dequeue() {
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
