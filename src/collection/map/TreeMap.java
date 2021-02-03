package collection.map;

import java.util.Iterator;

import collection.list.library.List;
import collection.set.Set;
import collection.set.TreeSet;

public class TreeMap<K extends Comparable<K>, V> extends Map<K, V> implements Iterable<K> {

	private Set<Entry<K, V>> set;

	public TreeMap() {
		set = new TreeSet();
	}

	@Override
	public void put(K key, V value) {
		set.add(new ComparableEntry<K, V>(key, value));
	}

	@Override
	public boolean containsKey(K key) {
		return set.contains(new ComparableEntry<K, V>(key, null));
	}

	@Override
	public V get(K key) {

		return null;
	}

	@Override
	public boolean containsValue(V value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K Key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	static class ComparableEntry<K extends Comparable<K>, V> extends Entry<K, V>
			implements Comparable<ComparableEntry<K, V>> {

		public ComparableEntry(K key, V value) {
			super(key, value);
		}

		@Override
		public int compareTo(ComparableEntry<K, V> o) {
			return this.key.compareTo(o.key);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;

			if (obj == null)
				return false;

			if (getClass() != obj.getClass())
				return false;

			ComparableEntry other = (ComparableEntry) obj;
			if (key == null)
				if (other.key != null)
					return false;

			if (!key.equals(other.key))
				return false;

			return true;
		}

	}

}
