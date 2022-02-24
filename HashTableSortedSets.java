import java.util.LinkedList;
import java.util.NoSuchElementException;

  class Node<Key, Value>{
    public Key key;
    public Value value;
    
    public Node(Key key, Value value) {
      this.key = key;
      this.value = value;
    }
  }

  public class HashTableSortedSets /*<KeyType, ValueType>*/ implements IHashTableSortedSets{

    private int capacity;
    private int size;
    
    @SuppressWarnings("rawtypes")
    protected LinkedList<IShow/*Node<KeyType, ValueType>*/>[] table;
    
    /**
     * Default Constructor
     */
    public HashTableSortedSets() {
      this.capacity = 20;
      this.size = 0;
      table = (LinkedList<IShow/*Node<KeyType, ValueType>*/>[]) new LinkedList[20];
    }
    
    /**
     * Constructor
     * @param capacity the capacity of the table
     */
    public HashTableSortedSets(int capacity) {
      this.capacity = capacity;
      this.size = 0;
      table = (LinkedList<IShow/*Node<KeyType, ValueType>*/>[]) new LinkedList[capacity];
    }
    
    public boolean put(Object a, Object b) {
      return false;
    }
    
    /**
     * Stores a key, val pair into the hash table
     */
    public boolean put(int key, IShow show) {
      
      //if not placed, return false
      //situations where not put: if key is null or if key is same
      /*
      if (containsKey(key) || key == null)
        return false;
        */
      //check load factor
      if (loadFactor() >= 0.65) {
        //createNewTable();
      }
      //make the hash key:
      int index = hash(key);
      //after determining the index that the value belongs to, add it to the linked list
      //size increases if it's added to an empty linked list

      if (keyIsEmpty(index)) {
        table[index] = new LinkedList();
        table[index].add(show);
        size++;
      }
      else 
        table[index].add(show);
      return true;
    }
    public boolean put(String key, IShow show) {
      
      //if not placed, return false
      //situations where not put: if key is null or if key is same
      /*
      if (containsKey(key) || key == null)
        return false;
        */
      //check load factor
      if (loadFactor() >= 0.65) {
        //createNewTable();
      }
      //make the hash key:
      int index = hash(key);
      //after determining the index that the value belongs to, add it to the linked list
      //size increases if it's added to an empty linked list

      if (keyIsEmpty(index)) {
        table[index] = new LinkedList();
        table[index].add(show);
        size++;
      }
      else 
        table[index].add(show);
      return true;
    }


    public Object get(Object key) throws NoSuchElementException {
      /*
      //scenarios: is empty, and is not
      //if it's empty, throw exception
      int index = hash(key);
      if (keyIsEmpty(index))
        throw new NoSuchElementException();
      
      LinkedList<Node<KeyType, ValueType>> list = table[index];
      for (Node<KeyType, ValueType>  node : list) {
        if (node.key.equals(key))
          return node.value;
      }
      
      throw new NoSuchElementException();
      */
      return null;
    }

    /**
     * Returns the number of key-value mappings in this map
     */
    public int size() {
      return size;
    }
    

    public boolean containsKey(Object key) {
      /*
      int index = hash(key);
      
      if (table[index] == null)
        return false;
      
      LinkedList<Node<KeyType, ValueType>> list = table[index];
      for (Node<KeyType, ValueType>  node : list) {
        if (node.key.equals(key))
          return true;
      }
      return false;
      */
      return false;
    }


    public Object remove(Object key) {
      /*
      int index = hash(key);

      LinkedList<Node<KeyType, ValueType>> list = table[index];
      
      for (Node<KeyType, ValueType>  node : list) {
        if (node.key.equals(key)) {
          list.remove(node);
          
          //only update size if it's the only node in the list
          if (list.isEmpty()) size--;
          return node;
        }
      }
      return null;
      */
      return null;
    }

    
    /**
     * Clears the hash table
     */
    public void clear() {
      for (int i = 0; i < table.length; i++)
        table[i] = null;
      size = 0;
    }
    
    /**
     * make the key into an index in the table
     * @param key the key to convert
     * @return the index
     */
    public int hash(Object key) {
      return Math.abs(key.hashCode()) % capacity;
    }
    
    /**
     * Tests if the linked list in the table is empty
     * @param index the index to check
     * @return true if it's empty, false if not
     */
    public boolean keyIsEmpty(int index) {
      if (table[index] == null)
        return true;
      else return false;
    }
    
    /**
     * calculates the load factor of the table
     * @return the load factor
     */
    public double loadFactor() {
      return (double)size/capacity;
    }
    
    /**
     * creates a new table double the size
     */
    /*
    public void createNewTable() {
      
      //create temp table and make new table 2x size
      //deep copy of table
      //LinkedList[] temp = table.clone();
      LinkedList[] temp = (LinkedList<Node<KeyType, ValueType>>[]) new LinkedList[capacity]; 
      for (int i = 0; i < table.length; i++) {
        temp[i] = table[i];
      }
      table = new LinkedList[capacity * 2];
      size = 0;
      
      for (int i = 0; i < capacity; i++) {
        
        //check for null pointer
        if (temp[i] != null && i < capacity) {
          
          LinkedList<Node<KeyType, ValueType>> list = temp[i];
          //for every node in current linked list, copy over contents
          if (!list.isEmpty()) {
            for (Node<KeyType, ValueType>  node : list) {
              put(node.key, node.value);
            }
          } 
        }
      }
      
      capacity *= 2;
    }
    */
    
    public int getCapacity() {
      return capacity;
    }
    
    public boolean getIndex(int index) {
      return table[index] == null;
    }
    public IShow returnObject(int i) {
      return table[i].getFirst();
    }

    public void add(Object key, Object value) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void add(Object key, Comparable value) {
      // TODO Auto-generated method stub
      
    }
    
}

