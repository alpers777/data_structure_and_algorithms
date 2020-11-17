package list.generic;

public class GenArrayList<E> {

	private static final int INITIAL_CAPACITY = 16;

	private Object[] array;

	private int size;

	// O(1)
	public GenArrayList() {
		this(INITIAL_CAPACITY);
	}

	// O(1)
	public GenArrayList(int size) {
		array = new Object[size];
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
		array = new Object[INITIAL_CAPACITY];
		size = 0;
	}

	// O(n)
	private void enlargeIfNecessery() {
		if (size == array.length - 1) {
			// O(n)
			Object[] newArray = new Object[array.length * 2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}

	}

	// O(n)
	private void shrinkIfNecessery() {
		if (size < array.length / 3) {
			// O(n)
			Object[] newArray = new Object[array.length / 2];
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
			if (element == array[i]) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(E element) {
		for (int i = size - 1; i >= 0; i--) {
			if (element == array[i]) {
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
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		return (E) array[index];
	}

	// O(n)
	@SuppressWarnings("unchecked")
	public E removeIndex(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		E data = (E) array[index];

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
	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		E data = (E) array[index];
		array[index] = element;

		return data;
	}

}
