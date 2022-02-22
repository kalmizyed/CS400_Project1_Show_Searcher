import java.util.List;
import java.util.Scanner;

/**
 * The frontend of the Show Searcher App.  Runs commands in a loop until the user quits.
 * @author Kaden Almizyed
 */
public class ShowSearcherFrontend implements IShowSearcherFrontend {
    IShowSearcherBackend showSearcher;
    Scanner scanner;

    // Used for displaying streaming providers
    private static final String[] providers = {"Netflix", "Hulu", "Prime Video", "Disney+"};

    /**
     * ShowSearcherFrontend constructor.  Creates a new ShowSearcherFrontend utilizing the given IShowSearcherBackend.
     * @param showSearcher
     */
    public ShowSearcherFrontend(IShowSearcherBackend showSearcher) {
        this.showSearcher = showSearcher;
    }

    /**
     * Starts the ShowSearcher app frontend.
     */
    @Override
    public void runCommandLoop() {
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the Show Searcher App!");
        System.out.println("=================================");
        displayCommandMenu();
    }

    /**
     * Displays a list of commands and takes user input to select a command.
     */
    @Override
    public void displayCommandMenu() {

        System.out.println("Command Menu:");
        System.out.println("    1) Search by [T]itle Word");
        System.out.println("    2) Search by [Y]ear First Produced");
        System.out.println("    3) [F]ilter by Streaming Provider");
        System.out.println("    4) [Q]uit");
        System.out.print("Choose a command from the menu above: ");
        
        String command = scanner.nextLine();

        // Make sure command is only one character
        if(command.length() > 1) {
            System.out.println("Invalid command.");
            displayCommandMenu();
            return;
        }

        char commandChar = command.toLowerCase().charAt(0);

        switch(commandChar) {
            case 't':
                titleSearch();
                break;
            case '1':
                titleSearch();
                break;
            case 'y':
                yearSearch();
                break;
            case '2':
                yearSearch();
                break;
            case 'f':
                filterByProvider();
                break;
            case '3':
                filterByProvider();
                break;
            case 'q':
                quit();
                break;
            case '4':
                quit();
                break;
            default:
                System.out.println("Invalid command.");
                displayCommandMenu();
                break;
        }
    }

    /**
     * Displays a given list of shows.
     */
    @Override
    public void displayShows(List<IShow> shows) {
        for(int i = 0; i < shows.size(); i++) {
            IShow show = shows.get(i);

            // Print item number
            System.out.print((i+1) + ". ");

            // Print show name
            System.out.println(show.getTitle());

            // Print rating, year
            System.out.print("    ");
            System.out.print(show.getRating() + "/100 ");
            System.out.print("(" + show.getYear() + ") on:");

            // Print streaming services 
            boolean firstPrinted = false;
            for(String provider : providers) {
                if(show.isAvailableOn(provider)) {
                    if(firstPrinted) System.out.print(","); // Add comma between providers
                    else firstPrinted = true;
                    
                    System.out.print(" " + provider);
                }
            }

            System.out.println();
        }
    }

    /**
     * Allows the user to search for a show by its title.  Displays the resulting list of shows.
     */
    @Override
    public void titleSearch() {
        System.out.print("Choose a word that you would like to search for: ");
        String word = scanner.nextLine();

        List<IShow> showList = showSearcher.searchByTitleWord(word);
        System.out.println("Found " + showList.size() + "/" + showSearcher.getNumberOfShows() + " matches.");
        displayShows(showList);
        displayCommandMenu();
    }

    /**
     * Allows the user to search for a show by its year.  Displays the resulting list of shows.
     */
    @Override
    public void yearSearch() {
        System.out.print("Choose a year that you would like to search: ");
        int year = Integer.parseInt(scanner.nextLine());

        List<IShow> showList = showSearcher.searchByYear(year);
        System.out.print("Found " + showList.size() + "/" + showSearcher.getNumberOfShows() + " matches.");
        displayShows(showList);
        displayCommandMenu();
    }

    /**
     * Allows the user to toggle which providers are filtered for.
     */
    public void filterByProvider() {
        System.out.println("Providers that shows are being searched for:");

        for(int i = 0; i < providers.length; i++) {
            String provider = providers[i];
            if(showSearcher.getProviderFilter(provider)) {
                System.out.println("    " + (i+1) + ") _X_ [" + provider.charAt(0) + "]" + provider.substring(1));
            } else {
                System.out.println("    " + (i+1) + ") ___ [" + provider.charAt(0) + "]" + provider.substring(1));
            }
        }

        System.out.println("    5) [Q]uit toggling provider filters");

        char command;
        System.out.print("Enter your command: ");
        String commandString = scanner.nextLine();

        // Make sure command is only one character
        if(commandString.length() > 1) {
            System.out.println("Invalid command.");
            filterByProvider();
            return;
        }

        command = commandString.toLowerCase().charAt(0);

        switch(command) {
            case 'n':
                showSearcher.toggleProviderFilter("Netflix");
                filterByProvider();
                break;
            case '1':
                showSearcher.toggleProviderFilter("Netflix");
                filterByProvider();
                break;
            case 'h':
                showSearcher.toggleProviderFilter("Hulu");
                filterByProvider();
                break;
            case '2':
                showSearcher.toggleProviderFilter("Hulu");
                filterByProvider();
                break;
            case 'p':
                showSearcher.toggleProviderFilter("Prime Video");
                filterByProvider();
                break;
            case '3':
                showSearcher.toggleProviderFilter("Prime Video");
                filterByProvider();
                break;
            case 'd':
                showSearcher.toggleProviderFilter("Disney+");
                filterByProvider();
                break;
            case '4':
                showSearcher.toggleProviderFilter("Disney+");
                filterByProvider();
                break;
            case 'q':
                displayCommandMenu();
                break;
            case '5':
                displayCommandMenu();
                break;
            default:
                System.out.println("Invalid command.");
                filterByProvider();
                break;
        }
    }

    /**
     * Ends the command loop and closes the scanner object.
     */
    public void quit() {
        System.out.println("Quitting...");
        scanner.close();
    }
}
