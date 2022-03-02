// --== CS400 Project One File Header ==--
// Name: Kaden Almizyed
// CSL Username: kaden
// Email: kalmizyed@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader: Code review partner: Jack Blake (Data Wrangler)

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Tests the ShowSearcherFrontend class.
 * @author Kaden Almizyed
 */
public class FrontendDeveloperTests {
    /**
     * Runs and prints the results of each test.
     */
    public static void main(String[] args) {
        System.out.println("testDisplayCommandMenu(): " + testDisplayCommandMenu());
        System.out.println("testDisplayShows(): " + testDisplayShows());
        System.out.println("testTitleSearch(): " + testTitleSearch());
        System.out.println("testYearSearch(): " + testYearSearch());
        System.out.println("testFilterByProvider(): " + testFilterByProvider());
        System.out.println("testTitleSearchIntegrated(): " + testTitleSearchIntegrated());
        System.out.println("testFilterByProviderIntegrated(): " + testFilterByProviderIntegrated());
        System.out.println("testIsAvailableOn(): " + testIsAvailableOn());
        System.out.println("testShowLoader(): " + testShowLoader());
    }


    /////////////////////////////////////////////////////////////
    // The following tests are designed to check functionality
    // when the ShowSearcherFrontend class is used in conjunction
    // with placeholder classes.
    /////////////////////////////////////////////////////////////

    // Tester and frontend objects to be used in tests
    private static ShowSearcherFrontend frontendWithPlaceholder = new ShowSearcherFrontend(new ShowSearcherBackendPlaceholder());
    private static ShowSearcherFrontend frontend = new ShowSearcherFrontend(new ShowSearcherBackend());

    /**
     * Tests the displayCommandMenu() method.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testDisplayCommandMenu() {
        try {
            TextUITester tester;
            String output;

            // SCENARIO 1: Test valid input
            ///////////////////////////////

            // 1A: lowercase character
            tester = new TextUITester("t\n\nq\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Choose a word that you would like to search for")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 1A");
                return false;
            }

            // 1B: uppercase character
            tester = new TextUITester("T\n\nQ\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Choose a word that you would like to search for")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 1B");
                return false;
            }

            // 1C: number
            tester = new TextUITester("1\n\n4\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Choose a word that you would like to search for")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 1C");
                return false;
            }


            // SCENARIO 2: Test invalid input
            /////////////////////////////////

            // 2A: invalid lowercase character
            tester = new TextUITester("u\nq\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 2A");
                return false;
            }

            // 2B: invalid uppercase character
            tester = new TextUITester("U\nQ\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 2B");
                return false;
            }

            // 2C: invalid number
            tester = new TextUITester("7\n4\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 2C");
                return false;
            }

            // 2D: string longer than 1 character
            tester = new TextUITester("Title\nq\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 2D");
                return false;
            }

            // 2E: invalid character
            tester = new TextUITester("=\nq\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 2E");
                return false;
            }
        } catch (Exception e) {
            System.out.println("FAILED: testDisplayCommandMenu(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Tests the displayShows() method.  Makes use of placeholder classes.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testDisplayShows() {
        try {
            TextUITester tester;
            String output;

            // SCENARIO 1: Test displaying empty list
            /////////////////////////////////////////

            tester = new TextUITester("");
            frontendWithPlaceholder.displayShows(new ArrayList<>());
            output = tester.checkOutput();

            if(output.length() != 0) {
                System.out.println("FAILED: testDisplayShows(); Scenario 1");
                return false;
            }


            // SCENARIO 2: Test displaying filled list
            //////////////////////////////////////////

            tester = new TextUITester("");
            
            ArrayList<IShow> showList = new ArrayList<>();
            showList.add(new ShowPlaceholder());
            frontendWithPlaceholder.displayShows(showList);

            output = tester.checkOutput();

            if(output.length() == 0 || !output.contains("NO TITLE")) {
                System.out.println("FAILED: testDisplayShows(); Scenario 2");
                return false;
            }

        } catch (Exception e) {
            System.out.println("FAILED: testDisplayShows(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Tests the titleSearch() method.  Makes use of placeholder classes.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testTitleSearch() {
        try {
            TextUITester tester;
            String output;

            // SCENARIO 1: Test no match
            ////////////////////////////

            tester = new TextUITester("t\nqwerty\nq\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Found 0/")) {
                System.out.println("FAILED: testTitleSearch(); Scenario 1");
                return false;
            }


            // SCENARIO 2: Test match
            /////////////////////////

            tester = new TextUITester("t\ntitan\nq\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Attack on Titan")) {
                System.out.println("FAILED: testTitleSearch(); Scenario 2");
                return false;
            }

        } catch (Exception e) {
            System.out.println("FAILED: testTitleSearch(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Tests the yearSearch() method.  Makes use of placeholder classes.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testYearSearch() {
        try {
            TextUITester tester;
            String output;

            // SCENARIO 1: Test no match
            ////////////////////////////

            tester = new TextUITester("y\n1900\nq\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Found 0/")) {
                System.out.println("FAILED: testYearSearch(); Scenario 1");
                return false;
            }


            // SCENARIO 2: Test match
            /////////////////////////

            tester = new TextUITester("y\n2011\nq\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Breaking Bad")) {
                System.out.println("FAILED: testYearSearch(); Scenario 2");
                return false;
            }

        } catch (Exception e) {
            System.out.println("FAILED: testYearSearch(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Tests the filterByProvider() method.  Makes use of placeholder classes.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testFilterByProvider() {
        try {
            TextUITester tester;
            String output;

            // SCENARIO 1: Test valid input
            ///////////////////////////////

            // 1A: lowercase character
            tester = new TextUITester("f\nn\nq\nq\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("___ [N]etflix")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 1A");
                return false;
            }

            // 1B: uppercase character
            tester = new TextUITester("F\nN\nQ\nQ\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("___ [N]etflix")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 1B");
                return false;
            }
            
            // 1C: number
            tester = new TextUITester("3\n1\n5\n4\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("___ [N]etflix")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 1C");
                return false;
            }
            

            // SCENARIO 2: Test invalid input
            /////////////////////////////////

            // 2A: invalid lowercase character
            tester = new TextUITester("f\nu\nq\nq\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 2A");
                return false;
            }

            // 2B: invalid uppercase character
            tester = new TextUITester("F\nU\nQ\nQ\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 2B");
                return false;
            }

            // 2C: invalid number
            tester = new TextUITester("3\n7\n5\n4\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 2C");
                return false;
            }

            // 2D: string longer than 1 character
            tester = new TextUITester("f\nnetflix\nq\nq\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 2D");
                return false;
            }

            // 2E: invalid character
            tester = new TextUITester("f\n=\nq\nq\n");
            frontendWithPlaceholder.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 2E");
                return false;
            }

        } catch (Exception e) {
            System.out.println("FAILED: testFilterByProvider(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return true;
    }


    /////////////////////////////////////////////////////////////
    // The following tests are designed to check functionality
    // when the ShowSearcherFrontend class is used in conjunction
    // with other developers' classes.
    /////////////////////////////////////////////////////////////

    /**
     * Tests the titleSearch() method.  Makes use of integrated classes.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testTitleSearchIntegrated() {
        try {
            TextUITester tester;
            String output;

            // SCENARIO 1: Test no match
            ////////////////////////////

            tester = new TextUITester("t\nqwerty\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Found 0/")) {
                System.out.println("FAILED: testTitleSearchIntegrated(); Scenario 1");
                return false;
            }


            // SCENARIO 2: Test match
            /////////////////////////

            // 2A: case-sensitive
            tester = new TextUITester("t\nTitan\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Attack on Titan")) {
                System.out.println("FAILED: testTitleSearchIntegrated(); Scenario 2A");
                return false;
            }

            // 2B: not case-sensitive
            tester = new TextUITester("t\ntitan\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Attack on Titan")) {
                System.out.println("FAILED: testTitleSearchIntegrated(); Scenario 2B");
                return false;
            }

        } catch (Exception e) {
            System.out.println("FAILED: testTitleSearchIntegrated(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Tests the filterByProvider() method.  Makes use of integrated classes.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testFilterByProviderIntegrated() {
        try {
            TextUITester tester;
            String output;

            // SCENARIO 1: Test toggling 
            ////////////////////////////

            // 1A: Netflix
            tester = new TextUITester("f\nn\nq\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("___ [N]etflix")) {
                System.out.println("FAILED: testFilterByProviderIntegrated(); Scenario 1A");
                return false;
            }

            // 1B: Hulu
            tester = new TextUITester("f\nh\nq\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("___ [H]ulu")) {
                System.out.println("FAILED: testFilterByProviderIntegrated(); Scenario 1B");
                return false;
            }

            // 1C: Prime Video
            tester = new TextUITester("f\np\nq\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("___ [P]rime Video")) {
                System.out.println("FAILED: testFilterByProviderIntegrated(); Scenario 1C");
                return false;
            }

            // 1D: Disney+
            tester = new TextUITester("f\nd\nq\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("___ [D]isney+")) {
                System.out.println("FAILED: testFilterByProviderIntegrated(); Scenario 1D");
                return false;
            }

        } catch (Exception e) {
            System.out.println("FAILED: testFilterByProviderIntegrated(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return true;
    }


    ////////////////////////////////////////////////////
    // The following tests are designed to check the
    // functionality of the Show and ShowLoader classes.
    // Used for the code review.
    ////////////////////////////////////////////////////
    
    /**
     * Tests the isAvailableOn() method from the Show class.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testIsAvailableOn() {
        try {

            // SCENARIO 1: Test separators in provider String
            /////////////////////////////////////////////////

            Show spaceSeparator = new Show("The space between us", 50, 50, "Netflix Hulu");
            boolean spaceSeparatorAccepted = spaceSeparator.isAvailableOn("Netflix") && spaceSeparator.isAvailableOn("Hulu");

            Show slashSeparator = new Show("The hash-slinging slasher", 50, 50, "Netflix/Hulu");
            boolean slashSeparatorAccepted = slashSeparator.isAvailableOn("Netflix") && spaceSeparator.isAvailableOn("Hulu");

            Show commaSeparator = new Show("Comma over here", 50, 50, "Netflix,Hulu");
            boolean commaSeparatorAccepted = commaSeparator.isAvailableOn("Netflix") && spaceSeparator.isAvailableOn("Hulu");

            Show mixedSeparator = new Show("Mixing it up", 50, 50, "Netflix, Hulu/Disney+");
            boolean mixedSeparatorAccepted = mixedSeparator.isAvailableOn("Netflix") && spaceSeparator.isAvailableOn("Hulu") && mixedSeparator.isAvailableOn("Disney+");

            if(!(spaceSeparatorAccepted && slashSeparatorAccepted && commaSeparatorAccepted && mixedSeparatorAccepted)) {
                System.out.println("FAILED: testShow(); Scenario 1");
                
                System.out.println("Failed separators:");
                if(!spaceSeparatorAccepted) System.out.println("Space");
                if(!slashSeparatorAccepted) System.out.println("Slash");
                if(!commaSeparatorAccepted) System.out.println("Comma");
                if(!mixedSeparatorAccepted) System.out.println("Mixed separators");

                return false;
            }

        } catch (Exception e) {
            System.out.println("FAILED: testShow(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Tests the ShowLoader class.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testShowLoader() {
        try {

            // SCENARIO 1: Invalid filepath
            ///////////////////////////////

            try {
                new ShowLoader().loadShows("tv_shows_2.csv");
                
                // If no exception is thrown, test fails
                System.out.println("FAILED: testShowLoader(); Scenario 1");
                return false;
            } catch (FileNotFoundException e) {
                // Runs as expected
            }

        } catch (Exception e) {
            System.out.println("FAILED: testShowLoader(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
