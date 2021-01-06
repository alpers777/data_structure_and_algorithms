package collection.map;

public interface Entry<K, V> {

	public K getKey();

	public V getValue();

	public void setValue(V value);

}
