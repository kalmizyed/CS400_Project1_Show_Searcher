import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShowSearcherBackend implements IShowSearcherBackend{

  //do we need an array for the providers ?
  
  public HashTableSortedSets titleList;
  public HashTableSortedSets yearList;
  public int size;
  
  public String provider;
  public boolean filter;
  
  public ShowSearcherBackend() {
    titleList = new HashTableSortedSets();
    yearList = new HashTableSortedSets();
    provider = null;
    filter = false;
    size = 0;
  }
  
  //get title and get year as key
  /**
   * adds show to backend database
   */
  @Override
  public void addShow(IShow show) { //
    
    String[] split = show.getTitle().split(" ");
    for (int i = 0; i < split.length; i++) {
      titleList.put(split[i], show);
      //System.out.println(split[i] + " placed at index: " + titleList.hash(split[i]));
    }

    yearList.put(show.getYear(), show);
    //System.out.println(show.getTitle() + " placed at index: " + yearList.hash(show.getYear()));
    size++;
  }

  /**
   * retrieve number of shows in database
   */
  @Override
  public int getNumberOfShows() {
    return size;
  }

  /**
   * 
   */
  @Override
  public void setProviderFilter(String provider, boolean filter) {
    this.provider = provider;
    this.filter = filter;
  }

  @Override
  public boolean getProviderFilter(String provider) {
    return filter;
  }

  //do we need this
  @Override
  public void toggleProviderFilter(String provider) {
    // TODO Auto-generated method stub
  }

  public String getProvider() {
    return this.provider;
  }
  
  @Override
  public List<IShow> searchByTitleWord(String word) {
    //List<IShow> titleList = new ArrayList<IShow>();
    
    /*
    for (int i = 0; i < showList.getCapacity(); i++) {
      LinkedList<Show> list = showList.table[i];
      for (Show show : list) {
        if (show.getTitle().contains(word) && show.isAvailableOn(provider))
          titleList.add(show);
      }
    }
    
    sortList(titleList);
    */
    //int index = hash()
    List<IShow> retList = new LinkedList<IShow>();
    int index = titleList.hash(word);
    
    for (IShow show : titleList.table[index]) {
      if (show.getTitle().contains(word))
        retList.add(show);
    }
    
    return retList;
  }

  @Override
  public List<IShow> searchByYear(int year) {
    
    /*
    List<IShow> yearList = new ArrayList<IShow>();
    
    for (int i = 0; i < showList.getCapacity(); i++) {
      LinkedList<Show> list = showList.table[i];
      for (Show show : list) {
        if (show.getYear() == year && show.isAvailableOn(provider))
          yearList.add(show);
      }
    }
    
    sortList(yearList);
    return yearList;
    */
    int index = yearList.hash(year);
    return yearList.table[index];
    
  }
  
  /*
  private void sortList(List<IShow> list) {
    //insertion sort the items in the list by their rating 
    for (int j = 1; j < list.size(); j++) {
      IShow current = list.get(j);
      int i = j-1;
      while ((i > -1) && ((list.get(i).getRating() > current.getRating()))) {
          list.set(i+1, list.get(i));
          i--;
      }
      list.set(i+1, current);
    
    }
  }
  */
}

