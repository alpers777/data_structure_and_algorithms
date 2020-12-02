package list.library;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListWithoutTail<E> extends List<E> {
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
	public void addLast(E element) {
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
	public void addFirst(E element) {
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
	public E get(int index) {
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
	public boolean contains(E element) {
		return indexOf(element) != -1;
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

	@Override
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

		public Node(E data) {
			this.data = data;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListWithoutTailIterator();
	}

	private class LinkedListWithoutTailIterator implements Iterator<E> {

		Node current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			E data = current.data;
			current = current.next;
			return data;
		}

	}

}
