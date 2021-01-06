package collection.list.library;

import collection.AbstractCollection;

public abstract class List<E> extends AbstractCollection<E> implements Iterable<E> {

	public abstract void add(int index, E element);

	public abstract void addLast(E element);

	public abstract void addFirst(E element);

	public abstract int indexOf(E element);

	public abstract int lastIndexOf(E element);

	public abstract E get(int index);

	public abstract E removeIndex(int index);

	public abstract E removeLast();

	public abstract E removeFirst();

	public abstract boolean removeElement(E element);

	public abstract E set(int index, E element);

	public abstract String toString();

}
