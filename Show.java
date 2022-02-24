
public class Show implements IShow{
  
  public String title;
  public int year;
  public int rating;
  public String providers;
  public int ID;
  
  public Show (String title, int year, int rating, String providers, int ID) {
    this.title = title;
    this.year = year;
    this.rating = rating;
    this.providers = providers;
    this.ID = ID;
  }
  
  @Override
  public int compareTo(IShow o) {
    // TODO Auto-generated method stub
    return 0;
  }

  public int getID() {
    // TODO Auto-generated method stub
    return this.ID;
  }

  @Override
  public String getTitle() {
    // TODO Auto-generated method stub
    return this.title;
  }

  @Override
  public int getYear() {
    // TODO Auto-generated method stub
    return this.year;
  }

  @Override
  public int getRating() {
    // TODO Auto-generated method stub
    return this.rating;
  }

  @Override
  public boolean isAvailableOn(String provider) {
    if ((this.providers).contains(provider)) return true;
    return false;
  }

}

