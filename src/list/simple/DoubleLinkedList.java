package list.simple;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList implements Iterable<Integer> {

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
		if (isEmpty()) {
			head = tail = new Node(element);
		} else {
			Node newElement = new Node(element);
			tail.next = newElement;
			newElement.prev = tail;
			tail = newElement;
		}
		size++;
	}

	// O(1)
	public void addFirst(int element) {
		if (isEmpty()) {
			head = tail = new Node(element);
		} else {
			Node newElement = new Node(element);
			newElement.next = head;
			head.prev = newElement;
			head = newElement;
		}
		size++;
	}

	// O(n)
	public int get(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
		
		return getNode(index).data;
	}
	
	// O(n)
	private Node getNode(int index) {
		if (size - 1 == index)
			return tail;
		
		Node current;
		if (index <= size / 2) {
			current = head;
	
			while (index > 0) {
				index--;
				current = current.next;
			}
		} else {
			current = tail;
			index = size - index - 1;
			
			while (index > 0) {
				index--;
				current = current.prev;
			}
			
		}
		
		return current;
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
			

			if (head == null) {
				tail = null;
			} else {
				head.prev = null;
			}

			size--;

			return first;
		}
		
		Node current = getNode(index);
		Node previous = current.prev;
		Node next = current.next;
		
		previous.next = next;
				
		if (index == size - 1) { // (curentNext == null)
			tail = previous;
		} else {
			next.prev = previous;
		}

		size--;

		return current.data;
	}

	// O(n)
	public int set(int index, int element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
		
		Node current = getNode(index);

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

		Node current = getNode(index);
		Node previous = current.prev;
		
		Node newNode = new Node(element);

		previous.next = newNode;
		newNode.next = current;
		
		current.prev = newNode;
		newNode.prev = previous;

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
		Node prev;

		public Node(int data) {
			this.data = data;
		}
	}

	@Override
	public Iterator<Integer> iterator() {

		return new DoubleLinkedListIterator();
	}

	private class DoubleLinkedListIterator implements Iterator<Integer> {

		Node current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Integer next() {
			if (hasNext() == false)
				throw new NoSuchElementException();
			
			int data = current.data;

			current = current.next;

			return data;
		}

	}

}
