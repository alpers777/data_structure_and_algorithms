package list.generic;

import java.util.NoSuchElementException;

public class GenLinkedList<E> {

	private Node<E> head;

	private Node<E> tail;

	private int size;

	private class Node<E> {
		
		public Node(E element) {
			this.data = element;
		}

		E data;
		Node<E> next;
	}

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
	public void addLast(E element) {
		if (isEmpty()) {
			head = tail = new Node<E>(element);
		} else {
			Node<E> newElement = new Node<E>(element);
			tail.next = newElement;
			tail = newElement;
		}
		size++;
	}

	// O(1)
	public void addFirst(E element) {
		if (isEmpty()) {
			head = tail = new Node<E>(element);
		} else {
			Node<E> newElement = new Node<E>(element);
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
			return (E) tail.data;

		Node<E> current = head;

		while (index > 0) {
			index--;
			current = current.next;
		}

		return (E) current.data;
	}

	// O(n)
	public boolean contains(E element) {
		Node<E> current = head;
		while (current != null) {
			if (current.data == element) {
				return true;
			}
			current = current.next;
		}

		return false;
	}

	// O(n)
	@SuppressWarnings("unchecked")
	public E removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E data = (E) tail.data;
		if (head.next == null) {
			head = tail = null;
		} else {
			Node<E> previous = head;
			while (previous.next != tail) {
				previous = previous.next;
			}
			tail = previous;
			tail.next = null;
		}
		return data;
	}

	// O(1)
	public E removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		E first = head.data;
		head = head.next;

		if (head == null) {
			tail = null;
		}

		size--;

		return first;
	}

}
