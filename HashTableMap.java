// --== CS400 Project One File Header ==--
// Name: Joseph Cai
// CSL Username: josephc
// Email: jbcai@wisc.edu
// Lecture #: 004
// Notes to Grader:

import java.util.LinkedList;
import java.util.NoSuchElementException;
/**
 * HashMap implementation
 * @author joe
 *
 * @param <KeyType> type of key
 * @param <ValueType> type of value
 */
public class HashTableMap <KeyType, ValueType> implements MapADT<KeyType,ValueType>{
  
  /**
   * Represents key,value pair
   * @author joe
   *
   * @param <K> key type
   * @param <V> value type
   */
  private class Pair<K, V>{
    private K key;
    private V value;
    public Pair(K key, V value){
      this.key = key;
      this.value = value;
    }
    public K key() {
      return key;
    }
    public V value() {
      return value;
    }
  }
  
  protected LinkedList<Pair<KeyType,ValueType>>[] array;
  private int capacity;
  private int size;
  
  /**
   * Creates HashtableMap with custom capacity
   * @param capacity of map
   */
  public HashTableMap(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    array = (LinkedList<Pair<KeyType, ValueType>>[]) new LinkedList[capacity];
  }
  
  /**
   * Creates HashtableMap with default 20 capacity
   */
  public HashTableMap() {
    this.capacity = 20;
    this.size = 0;
    array = (LinkedList<Pair<KeyType, ValueType>>[]) new LinkedList[capacity];
  }

  
  
  /**
   * Puts key into map. Doubles capacity and rehashes if 75% full.
   * @param key
   * @param value
   * @return true if successful, false if failed
   */
  @Override
  public boolean put(KeyType key, ValueType value) {
    if(key==null||this.containsKey(key)) return false;
    if(array[Math.abs(key.hashCode())%capacity]==null) {
      array[Math.abs(key.hashCode())%capacity] = new LinkedList<Pair<KeyType,ValueType>>();
    }
    array[Math.abs(key.hashCode())%capacity].add(new Pair<KeyType,ValueType>(key,value));
    size++;
    
    //Rehashing
    if(size>=3.0/4.0*capacity) {
      rehash();
    }
    
    return true;
  }
  
  /**
   * Doubles capacity and stores keys in new array
   */
  private void rehash() {
    capacity*=2;
    
    //Creating new array
    LinkedList[] newArr = new LinkedList[capacity];
    for(int i = 0; i<array.length; i++) {
      if(array[i]!=null) {
        LinkedList<Pair<KeyType,ValueType>> list = array[i];
        
        //Putting all pairs into new array
        for(Pair<KeyType,ValueType> p : list) {
          if(newArr[p.key().hashCode()%capacity] == null) {
            newArr[p.key().hashCode()%capacity] = new LinkedList<Pair<KeyType,ValueType>>();
          }
          newArr[p.key().hashCode()%capacity].add(p);
        }
      }
    }
    array = newArr;
  }
  
  /**
   * Gets value associated with key
   * @throws NoSuchElementException if key not found
   * @param key
   * @return value
   */
  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    //Checks if position in array is empty
    if(key==null||array[Math.abs(key.hashCode())%capacity]==null) throw new NoSuchElementException();
    //Finds key
    for(Pair<KeyType,ValueType> p : array[Math.abs(key.hashCode())%capacity]) {
      if(p.key().equals(key)) return p.value();
    }
    throw new NoSuchElementException();
  }
  
  /**
   * Gets current size
   * @return size
   */
  @Override
  public int size() {
    return size;
  }
  
  /**
   * Checks whether key is in map
   * @param key
   * @returns true if found
   */
  @Override
  public boolean containsKey(KeyType key) {
    //Checks whether position in array is empty
    if(array[Math.abs(key.hashCode())%capacity]==null) return false;
    //Finds key
    for(Pair<KeyType,ValueType> p : array[Math.abs(key.hashCode())%capacity]) {
      if(p.key().equals(key)) return true;
    }
    return false;
  }
  
  /**
   * Removes key from map
   * @param key
   * @return value of removed key, null if unsuccessful
   */
  @Override
  public ValueType remove(KeyType key) {
    //Finds key
    if(array[Math.abs(Math.abs(key.hashCode()))%capacity]==null) return null;
    for(Pair<KeyType,ValueType> p : array[Math.abs(key.hashCode())%capacity]) {
      //Removes key
      if(p.key().equals(key)) {
        array[Math.abs(key.hashCode())%capacity].remove(p);
        size--;
        return p.value();
      }
    }
    return null;
  }
  
  /**
   * Clears the map
   */
  @Override
  public void clear() {
    size = 0;
    array = (LinkedList<Pair<KeyType, ValueType>>[]) new LinkedList[capacity];
  }
  
}
