package list.simple;

public class ArrayList {

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

	// Add to last -> O(1 + 1) -> O(1)
	public void addLast(int element) {
		enlargeIfNecessery();
		array[size++] = element;
	}

	// O(n)
	public void addFirst(int element) {
		add(0, element);
	}

	private void enlargeIfNecessery() {
		if (size == array.length) {
			// O(n)
			int[] newArray = new int[array.length * 2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}

	}

	// O(1)
	public int get(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		return array[index];
	}

	// O(n)
	public boolean contains(int e) {
		return indexOf(e) != -1;
	}

	// O(1)
	public int removeLast() {
		return removeIndex(size - 1);
	}

	// O(n)
	public int removeFirst() {
		return removeIndex(0);
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

	// O(n + n) -> O(n)
	public boolean removeElement(int e) {
		int index = indexOf(e);

		if (index != -1) {
			removeIndex(index);
		}

		return false;
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

	// O(1)
	public int set(int index, int element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
		
		int data = array[index];
		array[index] = element;

		return data;
	}

	// O(n)
	public void add(int index, int element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		enlargeIfNecessery();

		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}

		array[index] = element;
		size++;
	}

	// O(n)
	public int indexOf(int e) {
		for (int i = 0; i < size; i++) {
			if (e == array[i]) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(int e) {
		for (int i = size - 1; i >= 0; i--) {
			if (e == array[i]) {
				return i;
			}
		}
		return -1;
	}

}
