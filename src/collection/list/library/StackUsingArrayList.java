package collection.list.library;


public class StackUsingArrayList<E> {

	private ArrayList<E> list = new ArrayList<E>();

	public void push(E element) {
		list.addLast(element);
	}

	public E pop() {
		return list.removeLast();
	}

	public E peek() {
		return list.get(list.size() - 1);
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
