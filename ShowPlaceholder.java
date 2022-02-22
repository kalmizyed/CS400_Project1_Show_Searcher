import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * PLACEHOLDER CLASS
 * Returns placeholder values for methods in the IShow interface.
 */
public class ShowPlaceholder implements IShow { // TODO replace placeholder

    Random rand = new Random();
    private static final String[] providersArray = {"Netflix", "Hulu", "Prime Video", "Disney+"};
    private static final List<String> providers = Arrays.asList(providersArray);

    private String title;
    private int year;
    private int rating;
    private boolean[] isAvailableOn;

    public ShowPlaceholder(String title) {
        this.title = title;
        year = rand.nextInt(5) + 2010; // Between 2010-2014
        rating = rand.nextInt(10) + 70; // Between 70-79
        isAvailableOn = new boolean[]{rand.nextBoolean(), rand.nextBoolean(), rand.nextBoolean(), rand.nextBoolean()};
    }

    public ShowPlaceholder() {
        this("NO TITLE");
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
