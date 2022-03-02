// --== CS400 Project One File Header ==--
// Name: Kaden Almizyed
// CSL Username: kaden
// Email: kalmizyed@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader: None

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PLACEHOLDER CLASS
 * Returns placeholder values for methods in the IShowSearcherBackend interface.
 */
public class ShowSearcherBackendPlaceholder implements IShowSearcherBackend {

    // Used for toggling streaming provider filters
    private static final String[] providersArray = {"Netflix", "Hulu", "Prime Video", "Disney+"};
    private static final List<String> providers = Arrays.asList(providersArray);
    private boolean[] providerFilters = {true, true, true, true};
    private List<IShow> shows;

    public ShowSearcherBackendPlaceholder() {
        shows = new ArrayList<>();
    }

    @Override
    public void addShow(IShow show) {
        shows.add(show);
    }

    @Override
    public int getNumberOfShows() {
        return 122;
    }

    @Override
    public void setProviderFilter(String provider, boolean filter) {
        int index = providers.indexOf(provider);
        providerFilters[index] = filter;
    }

    @Override
    public boolean getProviderFilter(String provider) {
        int index = providers.indexOf(provider);
        return providerFilters[index];
    }

    @Override
    public void toggleProviderFilter(String provider) {
        int index = providers.indexOf(provider);
        if(providerFilters[index]) providerFilters[index] = false;
        else providerFilters[index] = true;
    }

    @Override
    public List<IShow> searchByTitleWord(String word) {
        List<IShow> matchingShows = new ArrayList<IShow>();

        switch(word.toLowerCase()) {
            case "title":
                matchingShows.add(new Show("NO TITLE", 50, 50, "Netflix"));
                matchingShows.add(new Show("NO TITLE", 50, 50, "Netflix"));
                matchingShows.add(new Show("NO TITLE", 50, 50, "Netflix"));
                matchingShows.add(new Show("NO TITLE", 50, 50, "Netflix"));
                break;
            case "titan":
                matchingShows.add(new Show("Attack on Titan", 2013, 80, "Netflix Hulu"));
                matchingShows.add(new Show("Titanic", 2010, 70, "Netflix Disney+"));
            default:
                break;
        }

        return matchingShows;
    }

    @Override
    public List<IShow> searchByYear(int year) {
        List<IShow> matchingShows = new ArrayList<IShow>();

        switch(year) {
            case 2010:
                matchingShows.add(new Show("NO TITLE", 50, 50, "Netflix"));
                matchingShows.add(new Show("NO TITLE", 50, 50, "Netflix"));
                matchingShows.add(new Show("NO TITLE", 50, 50, "Netflix"));
                matchingShows.add(new Show("NO TITLE", 50, 50, "Netflix"));
                break;
            case 2011:
                matchingShows.add(new Show("Breaking Bad", 2011, 80, "Netflix Hulu"));
                matchingShows.add(new Show("Titanic II", 2011, 70, "Netflix Disney+"));
            default:
                break;
        }

        return matchingShows;
    }
    
}
