package list.simple;

import java.util.NoSuchElementException;

public class LinkedList {
	
	private Node head;
	
	private Node tail;
	
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
		head = tail = null;
		size = 0;
	}

	// Add to last O(1)
	public void addLast(int element) {
		if(isEmpty()) {
			head = tail = new Node(element);
		} else {
			Node newElement = new Node(element);
			tail.next = newElement;
			tail = newElement;
		}
		size++;
	}

	// O(1)
	public void addFirst(int element) {
		if(isEmpty()) {
			head = tail = new Node(element);
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
		
		if (size - 1 == index)
			return tail.data;

		Node current = head;
		
		while(index > 0) {
			index--;
			current = current.next;
		}
		
		return current.data;
	}

	// O(n)
	public boolean contains(int element) {
		Node current = head;
		while(current != null) {
			if (current.data == element) {
				return true;
			}
			current = current.next;
		}
		
		return false;
	}

	// O(n)
	public int removeLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		int data = tail.data;
		if(head.data == 1) {
			head = tail = null;
		}else {
			Node previous = head;
			while(previous.next != tail) {
				previous = previous.next;
			}
			tail = previous;
			tail.next = null;
		}
		return data;
	}

	// O(1)
	public int removeFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		int first = head.data;
		head = head.next;
		
		if(head == null) {
			tail = null;
		}
		
		size--;
		
		return first;
	}
	
	/* BURADA KALDIK */ 

	// O(n)
	public int removeIndex(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
		
		return 0;
	}

	// O(n + n) -> O(n)
	public boolean removeElement(int e) {
		return false;
	}

	// O(1)
	public int set(int index, int element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		return 0;
	}

	// O(n)
	public void add(int index, int element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
	}

	// O(n)
	public int indexOf(int e) {
		return -1;
	}

	public int lastIndexOf(int e) {
		return -1;
	}


	private class Node {
		public Node(int element) {
			// TODO Auto-generated constructor stub
		}
		int data;
		Node next;
	}

}
