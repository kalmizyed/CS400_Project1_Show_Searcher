import java.util.List;
import java.util.NoSuchElementException;

// --== CS400 Project One File Header ==--
// Name: Joseph Cai
// CSL Username: josephc
// Email: jbcai@wisc.edu
// Lecture #: 004
// Notes to Grader:

/**
 * Tests for HashTableSortedSets
 * @author joseph
 *
 */
public class AlgorithmEngineerTests {

  /*
   * Tests normal use
   * @return true if everything works as expected, false otherwise
   */
  public static boolean test1() {
    try {
      HashTableSortedSets<Integer, Integer> table = new HashTableSortedSets<Integer, Integer>();
      table.add(1, 2);
      table.add(1, 3);
      table.add(1, 1);
      table.add(2, 2);
      if(table.get(1).get(0)!=1) return false;
      if(table.get(1).get(1)!=2) return false;
      if(table.get(1).get(2)!=3) return false;
      if(table.get(2).get(0)!=2) return false;
    }
    catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
  /**
   * Tests size of arrays
   * @return true if everything works as expected, false otherwise
   */
  public static boolean test2() {
    try {
      HashTableSortedSets<Integer, Integer> table = new HashTableSortedSets<Integer, Integer>();
      table.add(1, 2);
      table.add(1, 3);
      table.add(1, 1);
      table.add(2, 2);
      if(table.get(1).size()!=3) return false;
      table.add(1, 4);
      if(table.get(1).size()!=4) return false;
      if(table.get(2).size()!=1) return false;
    }
    catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Tests exceptions
   * @return true if everything works as expected, false otherwise
   */
  public static boolean test3() {
    try {
      HashTableSortedSets<Integer, Integer> table = new HashTableSortedSets<Integer, Integer>();
      table.add(1, 1);
      
      //Nonexistent Key
      try {
        List<Integer> list = table.get(2);
      } catch(NoSuchElementException e) {
        //Expected behavior
      }
      
      //Null key
      try {
        List<Integer> list = table.get(null);
      } catch(NoSuchElementException e) {
        //Expected behavior
      }
      
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Tests hash collisions
   * @return true if everything works as expected, false otherwise
   */
  public static boolean test4() {
    try {
      HashTableSortedSets<Integer, Integer> table = new HashTableSortedSets<Integer, Integer>();
      table.add(1, 2);
      table.add(1, 3);
      table.add(1, 1);
      table.add(21, 1);
      table.add(21, 2);
      if(table.get(1).get(0)!=1) return false;
      if(table.get(1).get(1)!=2) return false;
      if(table.get(1).get(2)!=3) return false;
      if(table.get(21).get(0)!=1) return false;
      if(table.get(21).get(1)!=2) return false;
    }
    catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Tests size
   * @return true if everything works as expected, false otherwise
   */
  public static boolean test5() {
    try {
      HashTableSortedSets<Integer, Integer> table = new HashTableSortedSets<Integer, Integer>();
      table.add(1, 2);
      if(table.size()!=1) return false;
      table.add(1, 3);
      table.add(1, 1);
      if(table.size()!=3) return false;
      table.add(2, 2);
      table.add(1, 4);
      if(table.size()!=5) return false;
    }
    catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Main method
   * @param args command line args
   */
  public static void main(String[] args) {
    System.out.println(test1());
    System.out.println(test2());
    System.out.println(test3());
    System.out.println(test4());
    System.out.println(test5());
  }
}
