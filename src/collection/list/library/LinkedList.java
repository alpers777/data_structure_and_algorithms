package collection.list.library;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> extends List<E> {

	private Node head;

	private Node tail;

	// O(1)
	public void clear() {
		super.clear();
		head = tail = null;
	}

	// Add to last O(1)
	public void addLast(E element) {
		if (isEmpty()) {
			head = tail = new Node(element);
		} else {
			Node newElement = new Node(element);
			tail.next = newElement;
			tail = newElement;
		}
		size++;
	}

	// O(1)
	public void addFirst(E element) {
		if (isEmpty()) {
			head = tail = new Node(element);
		} else {
			Node newElement = new Node(element);
			newElement.next = head;
			head = newElement;
		}
		size++;
	}

	// O(n)
	public E get(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		if (size - 1 == index)
			return tail.data;

		Node current = head;

		while (index > 0) {
			index--;
			current = current.next;
		}

		return current.data;
	}

	// O(n)
	public boolean contains(E element) {
		Node current = head;
		while (current != null) {
			if (current.data == element) {
				return true;
			}
			current = current.next;
		}

		return false;
	}

	// O(n)
	public E removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();

		return removeIndex(size - 1);
	}

	// O(1)
	public E removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		return removeIndex(0);
	}

	// O(n + n) -> O(n)
	public boolean removeElement(E element) {
		int index = indexOf(element);

		if (index != -1) {
			removeIndex(index);
			return true;
		}

		return false;
	}

	// O(n)
	public E removeIndex(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		if (index == 0) {
			E first = head.data;
			head = head.next;

			if (head == null) {
				tail = null;
			}

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

		if (index == size - 1) // (curentNext == null)
			tail = previous;

		size--;

		return current.data;
	}

	// O(1)
	public E set(int index, E element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		E data = current.data;

		current.data = element;

		return data;
	}

	// O(n)
	public void add(int index, E element) {
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
	public int indexOf(E element) {
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
	public int lastIndexOf(E element) {
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

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("[");
		if (size == 0) {
			sb.append("]");
		} else {
			for (E e : this) {
				sb.append(e);
				sb.append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());

			sb.append("]");
		}

		return sb.toString();
	}

	private class Node {
		E data;
		Node next;

		public Node(E element) {
			this.data = element;
		}

	}

	@Override
	public Iterator<E> iterator() {

		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<E> {

		Node current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if (hasNext() == false)
				throw new NoSuchElementException();

			E data = current.data;
			current = current.next;
			return data;
		}

	}

}
