package arraydatastrucrute;

import java.util.Iterator;
import java.util.LinkedList;

public class HashTableSeperateChaining <K,V> implements Iterable <K> {

	
	private int capacity;
	 
	private LinkedList <Entry<K,V>> [] table;
	
	public static void main(String[] args) {
          
		HashTableSeperateChaining <String, Integer> map = new HashTableSeperateChaining<String, Integer>(5);

		map.put("chandra", 100);
		map.put("chandra1", 102);
		map.put("chandra2", 103);
		map.put("chandra3", 104);
		map.put("chandra4", 105);
		
		System.out.println( " " + map.get("chandra2"));
		
	}
	
	// Insert, put and add all place a value in the hash-table
	  public V put(K key, V value) { return insert(key, value); }
	  public V add(K key, V value) { return insert(key, value); }
	  
	public HashTableSeperateChaining (int capacity) {
		if (capacity < 0)
		      throw new IllegalArgumentException("Illegal capacity");
	   this.capacity = capacity;
	   
	   table = new LinkedList[this.capacity];

	}
	
	public V insert(K key, V value) {
		if (key == null) throw new IllegalArgumentException("NUll key");
		Entry <K,V> newEntry = new Entry<>(key, value);
		
		int bucketIndex = normalizeIndex(newEntry.hash);
		return bucketInsertEntry(bucketIndex, newEntry);
	}
	
	public V get(K key){
		
		if (key == null) return null;
		int bucketIndex = normalizeIndex(key.hashCode());
		Entry<K,V> entry = bucketSeekEntry(bucketIndex, key);
		if(entry != null) return entry.value;
		return null;
	}
	
	private V bucketInsertEntry(int bucketIndex, Entry<K, V> entry) {
		
		LinkedList <Entry<K,V>> bucket = table[bucketIndex];
		if(bucket == null) table[bucketIndex] = bucket = new LinkedList<>();
		
		Entry<K, V> existentEntry = bucketSeekEntry(bucketIndex, entry.key);
		
		if(existentEntry == null) {
			bucket.add(entry);
		} else {
			V oldVal = existentEntry.value;
			existentEntry.value = entry.value;
			return oldVal;
		}
		
		return null;
	}

	// Finds and returns a particular entry in a given bucket if it exists, returns null otherwise
	private Entry<K, V> bucketSeekEntry(int bucketIndex, K key) {

		if(key == null) return null;
		LinkedList <Entry<K,V>> bucket = table[bucketIndex];
		if (bucket == null) return null;
		for (Entry <K,V> entry : bucket)
			if (entry.key.equals(key))
				return entry;
		return null;
	}

	private int normalizeIndex(int keyHash) {
		// TODO Auto-generated method stub
		return (keyHash % capacity);
	}


	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

class Entry <K, V> {

	  int hash;
	  K key; V value;

	  public Entry(K key, V value) {
	    this.key = key;
	    this.value = value;
	    this.hash = key.hashCode();
	  }
}
