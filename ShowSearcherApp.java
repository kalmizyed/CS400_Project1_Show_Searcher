import java.util.List;

public class ShowSearcherApp {
    public static void main(String[] args) throws Exception {
        IShowLoader loader = new ShowLoaderPlaceholder(); // TODO replace placeholder
        List<IShow> shows = loader.loadShows("data/tv_shows.csv");
        IShowSearcherBackend backend = new ShowSearcherBackendPlaceholder(); // TODO replace placeholder
        for(IShow show : shows) backend.addShow(show);
        IShowSearcherFrontend frontend = new ShowSearcherFrontend(backend);
        frontend.runCommandLoop();
    }
}
