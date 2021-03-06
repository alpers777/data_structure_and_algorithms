package collection.list.simple;

import java.util.NoSuchElementException;

public class LinkedListWithoutTail {

	private Node head;

	private int size;

	// O(1)
	public int size() {
		return size;
	}

	// O(1)
	public boolean isEmpty() {
		return size == 0;
	}

	// O(1)
	public void clear() {
		head = null;
		size = 0;
	}

	// Add to last O(n)
	public void addLast(int element) {
		if (isEmpty()) {
			head = new Node(element);
		} else {
			Node newNode = new Node(element);
			
			Node current = head;
			for (int i = 0; i < size - 1; i++) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
	}

	// O(1)
	public void addFirst(int element) {
		if (isEmpty()) {
			head = new Node(element);
		} else {
			Node newElement = new Node(element);
			newElement.next = head;
			head = newElement;
		}
		size++;
	}

	// O(n)
	public int get(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		Node current = head;

		while (index > 0) {
			index--;
			current = current.next;
		}

		return current.data;
	}

	// O(n)
	public boolean contains(int element) {
		return indexOf(element) != -1;
	}
	

	// O(n)
	public int removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();
		
		return removeIndex(size - 1);
	}

	// O(1)
	public int removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		return removeIndex(0);
	}

	// O(n + n) -> O(n)
	public boolean removeElement(int element) {
		int index = indexOf(element);

		if (index != -1) {
			removeIndex(index);
			return true;
		}

		return false;
	}

	// O(n)
	public int removeIndex(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
		
		if (index == 0) {
			int first = head.data;
			head = head.next;

			size--;

			return first;
		} 
		
		Node previous = head;
		for (int i = 0; i < index - 1; i++) {
			previous = previous.next;
		}
		
		Node current = previous.next;
		Node curentNext = current.next;
		
		previous.next = curentNext;
		
		size--;
		
		return current.data;
	}
	
	// O(1)
	public int set(int index, int element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
		
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		
		int data = current.data;
		
		current.data = element;

		return data;
	}

	// O(n)
	public void add(int index, int element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
		
		if (index == 0) {
			addFirst(element);
			return;
		}
		
		Node previous = head;
		for (int i = 0; i < index - 1; i++) {
			previous = previous.next;
		}
		
		Node current = previous.next;
		
		Node newNode = new Node(element);
		
		previous.next = newNode;
		newNode.next = current;
		
		size++;	
	}

	// O(n)
	public int indexOf(int element) {
		int index = 0;
		Node current = head;
		while (current != null) {
			index++;
			if (current.data == element) {
				return index;
			}
			current = current.next;
		}

		return -1;
	}

	// O(n)
	public int lastIndexOf(int element) {
		int index = 0;
		int lastIndex = -1;
		Node current = head;
		while (current != null) {
			index++;
			if (current.data == element) {
				lastIndex = index;
			}
			current = current.next;
		}

		return lastIndex;
	}

	private class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}

}
