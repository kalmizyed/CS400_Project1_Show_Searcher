import java.util.ArrayList;
import java.util.List;

/**
 * PLACEHOLDER CLASS
 * Returns placeholder values for methods in the IShowSearcherBackend interface.
 */
public class ShowSearcherBackendPlaceholder implements IShowSearcherBackend {

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
        System.out.println("Provider filter set.");
    }

    @Override
    public boolean getProviderFilter(String provider) {
        return true;
    }

    @Override
    public void toggleProviderFilter(String provider) {
        System.out.println("Provider filter toggled.");
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
