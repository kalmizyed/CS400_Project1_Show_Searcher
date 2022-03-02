// --== CS400 Project One File Header ==--
// Name: Kaden Almizyed
// CSL Username: kaden
// Email: kalmizyed@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader: None

import java.util.Arrays;
import java.util.List;

/**
 * PLACEHOLDER CLASS
 * Returns placeholder values for methods in the IShow interface.
 */
public class ShowPlaceholder implements IShow {

    private static final String[] providersArray = {"Netflix", "Hulu", "Prime Video", "Disney+"};
    private static final List<String> providers = Arrays.asList(providersArray);

    private String title;
    private int year;
    private int rating;
    private boolean[] isAvailableOn;

    public ShowPlaceholder(String title, int year, int rating, boolean netflix, boolean hulu, boolean prime, boolean disney) {
        this.title = title;
        this.year = year; // Between 2010-2014
        this.rating = rating; // Between 70-79
        isAvailableOn = new boolean[]{netflix, hulu, prime, disney};
    }

    public ShowPlaceholder() {
        this("NO TITLE", 2010, 50, true, true, true, true);
    }

    @Override
    public int compareTo(IShow o) {
        return this.rating - o.getRating();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public boolean isAvailableOn(String provider) {
        int index = providers.indexOf(provider);
        return isAvailableOn[index];
    }
    
}
