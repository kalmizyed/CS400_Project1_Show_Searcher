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

    @Override
    public void addShow(IShow show) {
        System.out.println("Show added.");
    }

    @Override
    public int getNumberOfShows() {
        return 15;
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
        return new ArrayList<IShow>();
    }

    @Override
    public List<IShow> searchByYear(int year) {
        return new ArrayList<IShow>();
    }
    
}
