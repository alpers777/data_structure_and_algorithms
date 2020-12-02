package list.simple;

public class StackUsingLinkedList {
	
	private LinkedList list = new LinkedList();

	public void push(int element) {
		list.addLast(element);
	}

	public int pop() {
		return list.removeLast();
	}

	public int peek() {
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
