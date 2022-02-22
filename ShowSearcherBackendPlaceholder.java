import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PLACEHOLDER CLASS
 * Returns placeholder values for methods in the IShowSearcherBackend interface.
 */
public class ShowSearcherBackendPlaceholder implements IShowSearcherBackend { // TODO replace placeholder

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
        System.out.println("Show added.");
    }

    @Override
    public int getNumberOfShows() {
        return shows.size();
    }

    @Override
    public void setProviderFilter(String provider, boolean filter) {
        int index = providers.indexOf(provider);
        providerFilters[index] = filter;
        System.out.println("Provider filter set to " + filter);
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
        System.out.println("Provider filter toggled to " + providerFilters[index]);
    }

    @Override
    public List<IShow> searchByTitleWord(String word) {
        List<IShow> matchingShows = new ArrayList<IShow>();

        for(IShow show : shows) {
            if(show.getTitle().toLowerCase().contains(word.toLowerCase())) {
                boolean showMatchesFilters = false;
                for(int i = 0; i < providerFilters.length; i++) { // Show must be on at least one filtered provider
                    if(show.isAvailableOn(providersArray[i]) && providerFilters[i]) showMatchesFilters = true;
                }
                if(showMatchesFilters) matchingShows.add(show);
            }
        }

        return matchingShows;
    }

    @Override
    public List<IShow> searchByYear(int year) {
        List<IShow> matchingShows = new ArrayList<IShow>();

        for(IShow show : shows) {
            if(show.getYear() == year) {
                boolean showMatchesFilters = false;
                for(int i = 0; i < providerFilters.length; i++) { // Show must be on at least one filtered provider
                    if(show.isAvailableOn(providersArray[i]) && providerFilters[i]) showMatchesFilters = true;
                }
                if(showMatchesFilters) matchingShows.add(show);
            }
        }

        return matchingShows;
    }
    
}
