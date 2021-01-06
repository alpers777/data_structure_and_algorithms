package collection.list.library;

import collection.AbstractCollection;

public abstract class List<T> extends AbstractCollection<T> implements Iterable<T> {

	public abstract void add(int index, T element);

	public abstract void addLast(T element);

	public abstract void addFirst(T element);

	public abstract int indexOf(T element);

	public abstract int lastIndexOf(T element);

	public abstract T get(int index);

	public abstract T removeIndex(int index);

	public abstract T removeLast();

	public abstract T removeFirst();

	public abstract boolean removeElement(T element);

	public abstract T set(int index, T element);

	public abstract String toString();

}
