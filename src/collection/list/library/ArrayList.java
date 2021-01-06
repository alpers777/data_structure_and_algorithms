package collection.list.library;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> extends List<E> {

	private static final int INITIAL_CAPACITY = 16;

	private E[] array;

	// O(1)
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}

	// O(1)
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (E[]) new Object[capacity];
	}

	// O(1)
	@SuppressWarnings("unchecked")
	public void clear() {
		super.clear();
		array = (E[]) new Object[INITIAL_CAPACITY];
	}

	// O(n)
	private void enlargeIfNecessery() {
		if (size == array.length - 1) {
			// O(n)
			@SuppressWarnings("unchecked")
			E[] newArray = (E[]) new Object[array.length * 2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}

	}

	// O(n)
	private void shrinkIfNecessery() {
		if (size < array.length / 3) {
			// O(n)
			@SuppressWarnings("unchecked")
			E[] newArray = (E[]) new Object[array.length / 2];
			System.arraycopy(array, 0, newArray, 0, newArray.length);
			array = newArray;
		}
	}

	// O(n)
	public void add(int index, E element) {
		if (index > size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		enlargeIfNecessery();

		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}

		array[index] = element;
		size++;
	}

	// Add to last -> O(1 + 1) -> O(1)
	@Override
	public void addLast(E element) {
		add(size, element);
	}

	// O(n)
	public void addFirst(E element) {
		add(0, element);
	}

	// O(n)
	public int indexOf(E element) {
		for (int i = 0; i < size; i++) {
			if (element.equals(array[i])) {
				return i;
			}
		}
		return -1;
	}

	// O(n)
	public int lastIndexOf(E element) {
		for (int i = size - 1; i >= 0; i--) {
			if (element.equals(array[i])) {
				return i;
			}
		}
		return -1;
	}

	// O(n)
	public boolean contains(E element) {
		return indexOf(element) != -1;
	}

	// O(1)
	public E get(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		return array[index];
	}

	// O(n)
	public E removeIndex(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		E data = array[index];

		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}

		size--;

		shrinkIfNecessery();

		return data;
	}

	// O(1)
	public E removeLast() {
		return removeIndex(size - 1);
	}

	// O(n)
	public E removeFirst() {
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

	// O(1)
	public E set(int index, E element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		E data = array[index];
		array[index] = element;

		return data;
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

	@Override
	public Iterator<E> iterator() {

		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator<E> {

		private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			return currentIndex < size;
		}

		@Override
		public E next() {
			if (hasNext()) {
				;
				return array[currentIndex++];
			} else {
				throw new NoSuchElementException();
			}
		}

	}
}
