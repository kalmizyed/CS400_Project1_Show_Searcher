import java.util.ArrayList;

/**
 * Tests the ShowSearcherFrontend class.
 * @author Kaden Almizyed
 */
public class FrontendDeveloperTests {
    // Tester and frontend objects to be used in tests
    private static ShowSearcherFrontend frontend = new ShowSearcherFrontend(new ShowSearcherBackendPlaceholder());

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
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Choose a word that you would like to search for")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 1A");
                return false;
            }

            // 1B: uppercase character
            tester = new TextUITester("T\n\nQ\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Choose a word that you would like to search for")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 1B");
                return false;
            }

            // 1C: number
            tester = new TextUITester("1\n\n4\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Choose a word that you would like to search for")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 1C");
                return false;
            }


            // SCENARIO 2: Test invalid input
            /////////////////////////////////

            // 2A: invalid lowercase character
            tester = new TextUITester("u\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 2A");
                return false;
            }

            // 2B: invalid uppercase character
            tester = new TextUITester("U\nQ\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 2B");
                return false;
            }

            // 2C: invalid number
            tester = new TextUITester("7\n4\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 2C");
                return false;
            }

            // 2D: string longer than 1 character
            tester = new TextUITester("Title\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testDisplayCommandMenu(); Scenario 2D");
                return false;
            }

            // 2E: invalid character
            tester = new TextUITester("=\nq\n");
            frontend.runCommandLoop();
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
     * Tests the displayShows() method.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testDisplayShows() {
        try {
            TextUITester tester;
            String output;

            // SCENARIO 1: Test displaying empty list
            /////////////////////////////////////////

            tester = new TextUITester("");
            frontend.displayShows(new ArrayList<>());
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
            frontend.displayShows(showList);

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
     * Tests the titleSearch() method.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testTitleSearch() {
        try {
            TextUITester tester;
            String output;

            // SCENARIO 1: Test no match
            ////////////////////////////

            tester = new TextUITester("t\nqwerty\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Found 0/")) {
                System.out.println("FAILED: testTitleSearch(); Scenario 1");
                return false;
            }


            // SCENARIO 2: Test match
            /////////////////////////

            tester = new TextUITester("t\ntitan\nq\n");
            frontend.runCommandLoop();
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
     * Tests the yearSearch() method.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testYearSearch() {
        try {
            TextUITester tester;
            String output;

            // SCENARIO 1: Test no match
            ////////////////////////////

            tester = new TextUITester("y\n1900\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Found 0/")) {
                System.out.println("FAILED: testYearSearch(); Scenario 1");
                return false;
            }


            // SCENARIO 2: Test match
            /////////////////////////

            tester = new TextUITester("y\n2011\nq\n");
            frontend.runCommandLoop();
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
     * Tests the filterByProvider() method.
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
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("___ [N]etflix")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 1A");
                return false;
            }

            // 1B: uppercase character
            tester = new TextUITester("F\nN\nQ\nQ\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("___ [N]etflix")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 1B");
                return false;
            }
            
            // 1C: number
            tester = new TextUITester("3\n1\n5\n4\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("___ [N]etflix")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 1C");
                return false;
            }
            

            // SCENARIO 2: Test invalid input
            /////////////////////////////////

            // 2A: invalid lowercase character
            tester = new TextUITester("f\nu\nq\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 2A");
                return false;
            }

            // 2B: invalid uppercase character
            tester = new TextUITester("F\nU\nQ\nQ\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 2B");
                return false;
            }

            // 2C: invalid number
            tester = new TextUITester("3\n7\n5\n4\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 2C");
                return false;
            }

            // 2D: string longer than 1 character
            tester = new TextUITester("f\nnetflix\nq\nq\n");
            frontend.runCommandLoop();
            output = tester.checkOutput();

            if(!output.contains("Invalid command")) {
                System.out.println("FAILED: testFilterByProvider(); Scenario 2D");
                return false;
            }

            // 2E: invalid character
            tester = new TextUITester("f\n=\nq\nq\n");
            frontend.runCommandLoop();
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

    public static void main(String[] args) {
        System.out.println("testDisplayCommandMenu(): " + testDisplayCommandMenu());
        System.out.println("testDisplayShows(): " + testDisplayShows());
        System.out.println("testTitleSearch(): " + testTitleSearch());
        System.out.println("testYearSearch(): " + testYearSearch());
        System.out.println("testFilterByProvider(): " + testFilterByProvider());
    }
}
