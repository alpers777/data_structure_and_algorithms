package collection.map;

import collection.AbstractCollection;
import collection.set.Set;

public abstract class Map<K, V> extends AbstractCollection<K> implements Entry<K, V> {

	public abstract boolean containsKey(Object key);

	public abstract boolean containsValue(Object value);

	public abstract Set<Entry<K,V>> entrySet();

	public abstract V get(Object key);

	public abstract Set<K> keySet();

	public abstract void put(K key, V value);

	public abstract V remove(Object Key);

//	public abstract ? values();
//	public abstract void putAll(Map<? extends K,? extends V> m);
}
