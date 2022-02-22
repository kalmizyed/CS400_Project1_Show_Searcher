/**
 * PLACEHOLDER CLASS
 * Returns placeholder values for methods in the IShow interface.
 */
public class ShowBlank implements IShow {

    @Override
    public int compareTo(IShow o) {
        return 0;
    }

    @Override
    public String getTitle() {
        return "TITLE";
    }

    @Override
    public int getYear() {
        return 2022;
    }

    @Override
    public int getRating() {
        return 10;
    }

    @Override
    public boolean isAvailableOn(String provider) {
        return true;
    }
    
}
