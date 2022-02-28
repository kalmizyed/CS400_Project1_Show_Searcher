// --== CS400 Project One File Header ==--
// Name: Jack Blake
// CSL Username: jblake
// Email: jhblake2@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader: 
/**
 * @author jblake
 * @version 1.0
 * class representing show objects that can be stored, sorted, and searched for
 */
public class Show implements IShow{

    private final String title;
    private final int year;
    private final int rating;
    private final String providers;

    /**
     * creates a show instance
     * @param title title of the show
     * @param year year the show was released
     * @param rating rating of the show
     * @param providers platforms the show can be found on
     */
    public Show(String title, int year, int rating, String providers) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.providers = providers;
    }

    /**
     * compares this show to another (for a descending sort)
     * @param o other show to compare this show to
     * @return an int > 0 if o's rating is higher than this show's, 
     * -1 if o's rating is less than this show's, and 0 if they are equal
     */
    @Override
    public int compareTo(IShow o) {
        return o.getRating() - this.rating;
    }
    /**
     * getter for this show's title
     * @return the title of this show
     */
    @Override
    public String getTitle() {
        return this.title;
    }
    /**
     * getter for the year of this show
     * @return the year this show was released
     */
    @Override
    public int getYear() {
        return this.year;
    }
    /**
     * getter for the rating of this show
     * @return the rating of this show
     */
    @Override
    public int getRating() {
        return this.rating;
    }
    /**
     * Checks if this show is available on the giver provider
     * @param provider provider to check whether they have the show
     * @return true if the given provider does have the show, false otherwise
     */
    @Override
    public boolean isAvailableOn(String provider) {
        if(this.providers.contains(provider)) return true;
        return false;
    }
}
