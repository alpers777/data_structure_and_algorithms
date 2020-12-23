package collection.list.simple;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList implements Iterable<Integer>{

	private static final int INITIAL_CAPACITY = 16;

	private int[] array;

	private int size;

	// O(1)
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}

	// O(1)
	public ArrayList(int capacity) {
		array = new int[capacity];
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
		array = new int[INITIAL_CAPACITY];
		size = 0;
	}

	// O(n)
	private void enlargeIfNecessery() {
		if (size == array.length - 1) {
			int[] newArray = new int[array.length * 2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}

	}

	// O(n)
	private void shrinkIfNecessery() {
		if (size < array.length / 3) {
			// O(n)
			int[] newArray = new int[array.length / 2];
			System.arraycopy(array, 0, newArray, 0, newArray.length);
			array = newArray;
		}
	}

	// O(n)
	public void add(int index, int element) {
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
	public void addLast(int element) {
		add(size, element);
	}

	// O(n)
	public void addFirst(int element) {
		add(0, element);
	}

	// O(n)
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (element == array[i]) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(int element) {
		for (int i = size - 1; i >= 0; i--) {
			if (element == array[i]) {
				return i;
			}
		}
		return -1;
	}

	// O(n)
	public boolean contains(int element) {
		return indexOf(element) != -1;
	}

	// O(1)
	public int get(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		return array[index];
	}

	// O(n)
	public int removeIndex(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		int data = array[index];

		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}

		size--;

		shrinkIfNecessery();

		return data;
	}

	// O(1)
	public int removeLast() {
		return removeIndex(size - 1);
	}

	// O(n)
	public int removeFirst() {
		return removeIndex(0);
	}

	// O(n + n) -> O(n)
	public boolean removeElement(int element) {
		int index = indexOf(element);

		if (index != -1) {
			removeIndex(index);
		}

		return false;
	}

	// O(1)
	public int set(int index, int element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		int data = array[index];
		array[index] = element;

		return data;
	}

	@Override
	public Iterator<Integer> iterator() {
		
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<Integer> {
		
		private int currentIndex = 0;
		
		@Override
		public boolean hasNext() {
			return currentIndex < size;
		}

		@Override
		public Integer next() {

			if (hasNext() == false)
				throw new NoSuchElementException();
			
			return array[currentIndex++];
		}
		
	}

}