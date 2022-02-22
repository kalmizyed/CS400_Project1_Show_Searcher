import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ShowLoaderPlaceholder implements IShowLoader { // TODO replace placeholder

    @Override
    public List<IShow> loadShows(String filepath) throws FileNotFoundException {
        ArrayList<IShow> showList = new ArrayList<>();

        showList.add(new ShowPlaceholder());
        showList.add(new ShowPlaceholder());
        showList.add(new ShowPlaceholder());

        return showList;
    }

}
