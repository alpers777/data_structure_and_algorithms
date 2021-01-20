package hash;

import collection.list.library.LinkedList;

public class Hash<K, V> {

	private LinkedList<Entry<K, V>>[] list;
	private int DEFAULT_CAPACITY = 16;
	private int size = 0;
	private double loadFactor = 0.75;

	@SuppressWarnings("unchecked")
	public Hash() {
		list = new LinkedList[DEFAULT_CAPACITY];
	}

	public void put(K key, V value) {
		int hash = getHash(key);
		LinkedList<Entry<K, V>> entry = new LinkedList<Entry<K, V>>();
		if (list[hash] == null) {
			list[hash] = entry;
			entry.addFirst(new Entry<K, V>(key, value));
			size++;
		} else {
			list[hash].addLast(new Entry<K, V>(key, value));
		}
		enlargeIfNecessary();

	}

	public V remove(K key, V value) {
		int hash = getHash(key);
		if (list[hash] == null) {
			return null;
		} else {
			int index = 0;
			Entry<K, V> entry = list[hash].get(index);
			while (entry.key != key) {
				index++;
				entry = list[hash].get(index);
			}
			value = list[hash].get(index).value;
			list[hash].removeIndex(index);
			if (list[hash].size() == 0) {
				size--;
			}
			return value;
		}
	}

	public boolean containsValue(V value) {
		boolean isContains = false;
		for (int i = 0; i < DEFAULT_CAPACITY; i++) {
			if (list[i] != null) {
				for (int j = 0; j < list[i].size(); j++) {
					if (list[i].get(j).value == value) {
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
		for (int i = 0; i < list[hash].size(); i++) {
			if (list[hash].get(i).key == key) {
				isContains = true;
			}
		}
		return isContains;
	}

	@SuppressWarnings("unchecked")
	public void clear() {
		size = 0;
		list = (LinkedList<Entry<K, V>>[]) new Object[DEFAULT_CAPACITY];
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

	private void enlargeIfNecessary() {
		if (size / DEFAULT_CAPACITY > loadFactor) {
			@SuppressWarnings("unchecked")
			LinkedList<Entry<K, V>>[] newList = (LinkedList<Entry<K, V>>[]) new Object[list.length * 2];
			System.arraycopy(list, 0, newList, 0, list.length);
			list = newList;
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
