// --== CS400 Project One File Header ==--
// Name: Joseph Cai
// CSL Username: josephc
// Email: jbcai@wisc.edu
// Lecture #: 004
// Notes to Grader:

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Hashtable that stores a list of values 
 * associated with each unique key.  These lists of values are sorted
 * according to the compareTo() defined within the ValueType.
 */
public class HashTableSortedSets <KeyType,ValueType extends Comparable<ValueType>> extends HashTableMap<KeyType,List<ValueType>> implements IHashTableSortedSets <KeyType,ValueType>{

  
  public int numShows;
  
  /**
   * This add method is different from the put() method in that it appends a
   * single value to the end of the list associated with a given key.  If a
   * key does not yet have a list of values associated with it, then a new 
   * one will be created when this method is called.
   * @param key used to later lookup the list containing this value
   * @param value associated with the previous key
   */
  @Override
  public void add(KeyType key, ValueType value) {
    if(!this.containsKey(key)) {
      this.put(key, new ArrayList<ValueType>());
    }
    this.get(key).add(value);
    Collections.sort(this.get(key));
    numShows++;
  }
  
  /**
   * Returns the number of elements of lists stored in hashtable
   * @return number of (shows)
   */
  @Override
  public int size() {
    return this.numShows;
  }  
}
