package collection.list.library;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArrayList<E> extends List<E> {

	private static final int INITIAL_CAPACITY = 16;

	private E[] array;

	// O(1)
	public CircularArrayList() {
		this(INITIAL_CAPACITY);
	}

	// O(1)
	@SuppressWarnings("unchecked")
	public CircularArrayList(int size) {
		array = (E[]) new Object[size];
	}

	private int length = array.length;

	@Override
	public void add(int index, E element) {
		if (index > size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
		if (size > length) {
			for (int i = index + length; i > index + 1; i--) {
				array[(i - 1) % length] = array[(i - 2) % length];
			}
		} else {
			for (int i = size; i > index; i--) {
				array[i] = array[i - 1];
			}
		}
		array[index] = element;
		size++;
	}

	@Override
	public void addLast(E element) {
		add(size, element);
	}

	@Override
	public void addFirst(E element) {
		add(0, element);
	}

	@Override
	public int indexOf(E element) {
		if (size > length) {
			for (int i = 0; i < length; i++) {
				if (element.equals(array[i])) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(array[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E element) {
		if (size > length) {
			for (int i = length - 1; i > -1; i--) {
				if (element.equals(array[i])) {
					return i;
				}
			}
		} else {
			for (int i = size - 1; i > -1; i--) {
				if (element.equals(array[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public E get(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		return array[index];
	}

	@Override
	public E removeIndex(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		E data = array[index];
		
		if(size > length) {
			for(int i = index; i < size % length)
		}

		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}

		size--;

		shrinkIfNecessery();

		return data;
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

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
