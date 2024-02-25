import java.util.ArrayList;

public interface MapInterface<K,V>
{
	public void clear();
	public boolean containsKey(K key);
	public boolean containsValue(V value);
	public SetInterface<MapEnt<K,V>> entrySet();
	public V get(K o);
	public boolean isEmpty();
	public SetInterface<K> keySet();
	public V put(K key, V value);
	public int size();
	public V remove(K key);
	public ArrayList<V> values();
}