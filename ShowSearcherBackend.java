import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShowSearcherBackend implements IShowSearcherBackend{

  //do we need an array for the providers ?
  
  public HashTableSortedSets<String, IShow> titleList;
  public HashTableSortedSets<Integer, IShow> yearList;
  public int size;
  
  public String provider;
  private boolean NetflixFilter;
  private boolean PrimeFilter;
  private boolean HuluFilter;
  private boolean DisneyFilter;
  
  public ShowSearcherBackend() {
    titleList = new HashTableSortedSets();
    yearList = new HashTableSortedSets();
    provider = null;
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
      titleList.add(split[i], show);
      //System.out.println(split[i] + " placed at index: " + titleList.hash(split[i]));
    }

    yearList.add(show.getYear(), show);
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
    if (provider.equals("Netflix")) NetflixFilter = filter;
    if (provider.equals("Hulu")) HuluFilter = filter;
    if (provider.equals("Disney+")) DisneyFilter = filter;
    if (provider.equals("Prime Video")) PrimeFilter = filter;
  }

  @Override
  public boolean getProviderFilter(String provider) {
    if (provider.equals("Netflix")) return NetflixFilter;
    if (provider.equals("Hulu")) return HuluFilter;
    if (provider.equals("Disney+")) return DisneyFilter;
    if (provider.equals("Prime Video")) return PrimeFilter;
    return false;
  }

  //do we need this
  @Override
  public void toggleProviderFilter(String provider) {
    if (provider.equals("Netflix")) NetflixFilter ^= true;
    if (provider.equals("Hulu")) HuluFilter ^= true;
    if (provider.equals("Disney+")) DisneyFilter ^= true;
    if (provider.equals("Prime Video")) PrimeFilter ^= true;
  }

  public String getProvider() {
    return this.provider;
  }
  
  @Override
  public List<IShow> searchByTitleWord(String word) {
    List<IShow> titles = new ArrayList<IShow>();
    titles = titleList.get(word);
    
    
    ArrayList<IShow> retList = new ArrayList<IShow>();
    try {
      for (IShow show : titles) {
        if ((DisneyFilter == true && show.isAvailableOn("Disney+")) || (NetflixFilter == true && show.isAvailableOn("Netflix"))
            || (HuluFilter == true && show.isAvailableOn("Hulu")) || (PrimeFilter == true && show.isAvailableOn("Prime Video")))
          retList.add(show);
      }
    }
    catch (Exception e) {
    }
    return retList;
  }

  @Override
  public List<IShow> searchByYear(int year) {
    List<IShow> years = new ArrayList<IShow>();
    years = yearList.get(year);
    
    ArrayList<IShow> retList = new ArrayList<IShow>();
    
    for (IShow show : years) {
      if ((DisneyFilter == true && show.isAvailableOn("Disney+")) || (NetflixFilter == true && show.isAvailableOn("Netflix"))
          || (HuluFilter == true && show.isAvailableOn("Hulu")) || (PrimeFilter == true && show.isAvailableOn("Prime Video")))
        retList.add(show);
    }
    
    return retList;
    
  }
}


