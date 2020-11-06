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
	public void addLast(int e) {
		enlargeIfNecessery();
		array[size++] = e;
	}

	// O(n)
	public void addFirst(int e) {
		enlargeIfNecessery();

		for (int i = size; i > 0; i--) {
			array[i] = array[i - 1];
		}

		array[0] = e;
		size++;
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
		for (int i = 0; i < size; i++) {
			if (e == array[i]) {
				return true;
			}
		}
		return false;
	}

	public int removeLast() {

		return 0;
	}

	public int removeIndex(int index) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
		int data = array[index];

		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}

		size--;

		return data;
	}

	public int removeElement(int e) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int set(int index, int element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		// TODO Auto-generated method stub
		return 0;
	}

	public void add(int index, int element) {
		if (index >= size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);

		// TODO Auto-generated method stub

	}

	public int indexOf(int e) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(int e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
