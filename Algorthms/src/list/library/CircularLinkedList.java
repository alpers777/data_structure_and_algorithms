package list.library;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class CircularLinkedList<E> extends List<E> {

	private Node head;

	private Node tail;

	// O(1)
	public void clear() {
		super.clear();
		head = tail = null;
	}


	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLast(E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFirst(E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeElement(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
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

		return new CircularLinkedListIterator();
	}

	private class CircularLinkedListIterator implements Iterator<E> {

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
