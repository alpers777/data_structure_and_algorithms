package collection.map;

import collection.list.library.ArrayList;
import collection.list.library.LinkedList;
import collection.list.library.List;
import collection.set.HashSet;
import collection.set.Set;

public class HashMap<K, V, E> extends Map<K, V> {

	private LinkedList<Entry<K, V>>[] hashTable;
	private int DEFAULT_CAPACITY = 16;
	private int size = 0;
	private double loadFactor = 0.75;

	@SuppressWarnings("unchecked")
	public HashMap() {
		hashTable = new LinkedList[DEFAULT_CAPACITY];
	}

	public void put(K key, V value) {
		rehashIfNecessary();

		int hash = getHash(key);
		if (hashTable[hash] == null) {
			hashTable[hash] = new LinkedList<Entry<K, V>>();
		}
		hashTable[hash].addLast(new Entry<K, V>(key, value));
		size++;
	}

	@Override
	public V remove(K key) {
		int hash = getHash(key);
		if (hashTable[hash] == null) {
			return null;
		} else {
			int index = 0;
			Entry<K, V> entry = hashTable[hash].get(index);
			while (entry.key != key) {
				index++;
				entry = hashTable[hash].get(index);
			}
			if (hashTable[hash].get(index) == null) {
				return null;
			}
			V value = hashTable[hash].get(index).value;
			hashTable[hash].removeIndex(index);
			size--;
			return value;
		}
	}

	@Override
	public V get(K key) {
		int hash = getHash(key);
		if (hashTable[hash] == null) {
			return null;
		} else {
			int index = 0;
			Entry<K, V> entry = hashTable[hash].get(index);
			while (entry.key != key) {
				index++;
				entry = hashTable[hash].get(index);
			}
			if (hashTable[hash].get(index) == null) {
				return null;
			}
			return hashTable[hash].get(index).value;
		}
	}

	public boolean containsValue(V value) {
		boolean isContains = false;
		for (int i = 0; i < DEFAULT_CAPACITY; i++) {
			if (hashTable[i] != null) {
				for (int j = 0; j < hashTable[i].size(); j++) {
					if (hashTable[i].get(j).value == value) {
						isContains = true;
					}
				}
			}
		}
		return isContains;
	}

	public boolean containsKey(K key) {
		boolean isContains = false;
		int hash = getHash(key);
		for (int i = 0; i < hashTable[hash].size(); i++) {
			if (hashTable[hash].get(i).key == key) {
				isContains = true;
			}
		}
		return isContains;
	}

	@Override
	public Set<K> keySet() {
		HashSet<K> keys = new HashSet<K>();
		for (int i = 0; i < hashTable.length; i++) {
			for (int j = 0; j < hashTable[i].size(); j++) {
				if (hashTable[i].get(j) != null) {
					keys.add(hashTable[i].get(j).key);
				}
			}
		}
		return keys;
	}

	@Override
	public List<V> values() {
		ArrayList<V> values = new ArrayList<V>();
		for (int i = 0; i < hashTable.length; i++) {
			for (int j = 0; j < hashTable[i].size(); j++) {
				if (hashTable[i].get(j) != null) {
					values.addLast(hashTable[i].get(j).value);
				}
			}
		}
		return values;
	}

	@SuppressWarnings("unchecked")
	public void clear() {
		size = 0;
		hashTable = (LinkedList<Entry<K, V>>[]) new Object[DEFAULT_CAPACITY];
	}

	public int getCapacity() {
		return this.DEFAULT_CAPACITY;
	}

	public int getSize() {
		return this.size;
	}

	private int getHash(K key) {
		return key.hashCode() % DEFAULT_CAPACITY;
	}

	@SuppressWarnings("unchecked")
	private void rehashIfNecessary() {
		if ((double) size / hashTable.length >= loadFactor) {
			LinkedList<Entry<K, V>>[] oldTable = hashTable;
			hashTable = new LinkedList[hashTable.length * 2];
			size = 0;

			for (LinkedList<Entry<K, V>> list : oldTable) {
				if (list != null) {
					for (Entry<K, V> e : list) {
						put(e.key, e.value);
					}
				}
			}
		}
	}

	private static class Entry<K, V> {
		private K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

}