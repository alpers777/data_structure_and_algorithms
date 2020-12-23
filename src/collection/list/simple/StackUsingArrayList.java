package collection.list.simple;

public class StackUsingArrayList {
	
	private ArrayList list = new ArrayList();

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
