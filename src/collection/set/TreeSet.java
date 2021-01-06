package collection.set;

import java.util.Iterator;

import trees.AVL;

public class TreeSet<E extends Comparable<E>> extends Set<E> implements Iterable<E> {
	
	private AVL<E> avl;
	
	public TreeSet() {
		avl = new AVL<E>();
	}

	// O(log n)
	@Override
	public boolean add(E element) {
		return avl.insert(element);

	}

	// O(log n)
	@Override
	public boolean remove(E element) {
		return avl.delete(element);
	}

	// O(log n)
	@Override
	public boolean contains(E element) {
		return avl.search(element);
	}

	@Override
	public Iterator<E> iterator() {
		return avl.iterator();
	}
	

}
