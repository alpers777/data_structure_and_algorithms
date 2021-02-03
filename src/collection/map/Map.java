package collection.map;

import collection.list.library.List;
import collection.set.Set;

public abstract class Map<K, V>  {

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
	

	public abstract void put(K key, V value);

	public abstract V remove(K key);

	public abstract boolean containsKey(K key);

	public abstract boolean containsValue(V value);

	public abstract V get(K key);

	public abstract Set<K> keySet();
	
	public abstract List<V> values();
	
	
}
