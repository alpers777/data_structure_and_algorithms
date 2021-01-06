package collection;

public abstract class AbstractCollection<E> {

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
	
	public abstract boolean contains(E element);

}
