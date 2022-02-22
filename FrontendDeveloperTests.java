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
            // SCENARIO 1: Test displaying empty list
            /////////////////////////////////////////


            // SCENARIO 2: Test displaying filled list
            //////////////////////////////////////////

        } catch (Exception e) {
            System.out.println("FAILED: testDisplayShows(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return false; // TODO
    }

    /**
     * Tests the titleSearch() method.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testTitleSearch() {
        try {
            // SCENARIO 1: Test no match
            ////////////////////////////


            // SCENARIO 2: Test match
            /////////////////////////

        } catch (Exception e) {
            System.out.println("FAILED: testTitleSearch(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return false; // TODO
    }

    /**
     * Tests the yearSearch() method.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testYearSearch() {
        try {
            // SCENARIO 1: Test no match
            ////////////////////////////


            // SCENARIO 2: Test match
            /////////////////////////

        } catch (Exception e) {
            System.out.println("FAILED: testYearSearch(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return false; // TODO
    }

    /**
     * Tests the filterByProvider() method.
     * @return true if all tests pass, false otherwise
     */
    public static boolean testFilterByProvider() {
        try {
            // SCENARIO 1: Test valid input
            ///////////////////////////////

            // 1A: lowercase character

            // 1B: uppercase character

            // 1C: number

            // 1D: quit


            // SCENARIO 2: Test invalid input
            /////////////////////////////////

            // 2A: invalid lowercase character

            // 2B: invalid uppercase character

            // 2C: invalid number

            // 2D: string longer than 1 character

            // 2E: invalid character

        } catch (Exception e) {
            System.out.println("FAILED: testFilterByProvider(); unexpected exception");
            e.printStackTrace();
            return false;
        }

        return false; // TODO
    }
}
