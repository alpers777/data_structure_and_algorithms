package collection.list.library;

public abstract class List<T> implements Iterable<T> {

	protected int size;

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
		size = 0;
	}

	public abstract void add(int index, T element);

	public abstract void addLast(T element);

	public abstract void addFirst(T element);

	public abstract int indexOf(T element);

	public abstract int lastIndexOf(T element);

	public abstract boolean contains(T element);

	public abstract T get(int index);

	public abstract T removeIndex(int index);

	public abstract T removeLast();

	public abstract T removeFirst();

	public abstract boolean removeElement(T element);

	public abstract T set(int index, T element);

	public abstract String toString();

}
