import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackendDeveloperTests {
  
  public static void main (String[] args) {
    System.out.println(test1() && test2() && test3() && test4() && test5());
  }
  
  public static boolean test1() { /* test code here */ 
    Show show1 = new Show("Breaking Bad", 2008, 100, "Netflix", 1);
    Show show2 = new Show("Stranger Things", 2016, 96, "Netflix", 2);
    Show show3 = new Show("Attack on Titan", 2013, 95, "Netflix, Hulu", 3);
       
    ShowSearcherBackend hi = new ShowSearcherBackend();
    hi.addShow(show1);
    hi.addShow(show2);
    hi.addShow(show3);
    if (hi.getNumberOfShows() != 3) return false;
    if (!hi.titleList.returnObject(2).equals(show2)) return false;
    if (!hi.yearList.returnObject(8).equals(show1)) return false;

    return true;
  }
  public static boolean test2() { /* test code here */ 
    //test constructor
    
    ShowSearcherBackend hi = new ShowSearcherBackend();
    if (hi.titleList == null) return false;
    if (hi.yearList == null) return false;
    if (hi.provider != null) return false;
    if (hi.filter == true) return false;
    if (hi.size != 0) return false;
    
    return true;
  }
  
  public static boolean test3() { /* test code here */
    
    //test filters
    
    Show show1 = new Show("Breaking Bad", 2008, 100, "Netflix", 1);
    Show show2 = new Show("Stranger Things", 2016, 96, "Netflix", 2);
    Show show3 = new Show("Attack on Titan", 2013, 95, "Netflix, Hulu", 3);
        
    ShowSearcherBackend hi = new ShowSearcherBackend();
    hi.addShow(show1);
    hi.addShow(show2);
    hi.addShow(show3);
    
    hi.setProviderFilter("Netflix", true);
    if (hi.getProviderFilter("Netflix") == false) return false;
    if (!hi.getProvider().equals("Netflix")) return false;
    
    return true;
  }
  
  public static boolean test4() { /* test code here */ 
    //test searchByYear
    Show show1 = new Show("Breaking Bad", 2008, 100, "Netflix", 1);
    Show show2 = new Show("Stranger Things", 2016, 96, "Netflix", 2);
    Show show3 = new Show("Attack on Titan", 2013, 95, "Netflix, Hulu", 3);
        
    ShowSearcherBackend hi = new ShowSearcherBackend();
    hi.addShow(show1);
    hi.addShow(show2);
    hi.addShow(show3);

    LinkedList<IShow> yearList = (LinkedList<IShow>) hi.searchByYear(2013);
    if (!yearList.getFirst().equals(show3)) return false;
    
    return true;
  }
  
  public static boolean test5() { /* test code here */ 
    //test searchByTitle
    Show show1 = new Show("Breaking Bad", 2008, 100, "Netflix", 1);
    Show show2 = new Show("Stranger Things", 2016, 96, "Netflix", 2);
    Show show3 = new Show("Attack on Titan", 2013, 95, "Netflix, Hulu", 3);
        
    ShowSearcherBackend hi = new ShowSearcherBackend();
    hi.addShow(show1);
    hi.addShow(show2);
    hi.addShow(show3);

    LinkedList<IShow> titleList = (LinkedList<IShow>) hi.searchByTitleWord("on");
    if (!titleList.getFirst().equals(show3)) return false;
    
    LinkedList<IShow> titleList2 = (LinkedList<IShow>) hi.searchByTitleWord("Breaking");
    if (!titleList2.getFirst().equals(show1)) return false;
    
    return true;
  }
}

