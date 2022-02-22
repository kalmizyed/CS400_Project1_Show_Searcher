import java.util.List;
import java.util.Scanner;

public class ShowSearcherFrontend implements IShowSearcherFrontend {
    ShowSearcherBackendPlaceholder showSearcher = new ShowSearcherBackendPlaceholder();

    // Used for displaying streaming providers
    String[] providers = {"Netflix", "Hulu", "Prime Video", "Disney+"};

    /**
     * Starts the ShowSearcher app frontend.
     */
    @Override
    public void runCommandLoop() {
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
        
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        scanner.close();

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
                break;
            case '4':
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a word that you would like to search for: ");
        try {
            String word = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Enter a valid string.");
            scanner.close();
            titleSearch();
        }
        scanner.close();

        List<IShow> showList = showSearcher.searchByTitleWord(word);
        System.out.print("Found " + showList.size() + "/" + showSearcher.getNumberOfShows() + " matches.");
        displayShows(showList);
        displayCommandMenu();
    }

    /**
     * Allows the user to search for a show by its year.  Displays the resulting list of shows.
     */
    @Override
    public void yearSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a year that you would like to search: ");
        try {
            int year = Integer.parseInt(scanner.nextLine());
        }
        catch (Exception e) {
            System.out.println("Enter an integer.");
            scanner.close();
            yearSearch();
        }
        scanner.close();

        List<IShow> showList = showSearcher.searchByYear(year);
        System.out.print("Found " + showList.size() + "/" + showSearcher.getNumberOfShows() + " matches.");
        displayShows(showList);
        displayCommandMenu();
    }

    /**
     * Allows the user to toggle which providers are filtered for.
     */
    public void filterByProvider() {
        // TODO
    }
    
}
