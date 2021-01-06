package collection.list.library;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;

import collection.AbstractCollection;

public class CircularArrayList<E> extends AbstractCollection<E> {

	private static final int INITIAL_CAPACITY = 16;

	private E[] array;

	private int head;
	private int tail;

	// O(1)
	public CircularArrayList() {
		this(INITIAL_CAPACITY);
	}

	// O(1)
	@SuppressWarnings("unchecked")
	public CircularArrayList(int capacity) {
		array = (E[]) new Object[capacity];
	}

	// O(1)
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		size = 0;
		array = (E[]) new Object[INITIAL_CAPACITY];
		head = tail = 0;
	}

	public void addLast(E element) {
		if (isFull()) {
			throw new RuntimeException("Array is full");
		}
			
		array[tail] = element;
		tail = (tail + 1) % array.length;
		size++;
		
	}
	
	public void addFirst(E element) {
		if (isFull()) {
			throw new RuntimeException("Array is full");
		}
		
		head = (head - 1 + array.length) % array.length;	
		array[head] = element;
		
		size++;
	}
	

	public boolean isFull() {
		return size == array.length;
	}

	public E removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		
		E e = array[head];

		head = (head + 1) % array.length;
		size--;
		return e;
	}

	public E removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();
		
		tail = (tail - 1 + array.length) % array.length;
		
		E e = array[tail];
		
		size--;
		return e;
		
	}

	public boolean contains(E element) {
		int index = head;
		for (int i = 0; i < size; i++) {
			if (array[index].equals(element))
				return true;

			index = (index + 1) % array.length;
		}
		return false;
	}

	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
