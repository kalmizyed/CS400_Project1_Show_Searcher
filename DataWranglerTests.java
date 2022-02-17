// --== CS400 Project One File Header ==--
// Name: Jack Blake
// CSL Username: jblake
// Email: jhblake2@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader: 

import java.io.FileNotFoundException;

/**
 * @author jblake
 * @version 1.0
 * Class of static tests methods meant to check for proper functionality of the Show and ShowLoader classes
 */
public class DataWranglerTests {
    public static void main(String[] args){
        ShowLoader s = new ShowLoader();
        try {
            for(IShow show : s.loadShows("tv_shows.csv")){
                System.out.println("Title: " + show.getTitle() + " Year: + " + show.getYear() + " Rating: " + show.getRating());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * description of high level functionality
     * @return true if all cases work as intended, false otherwise
     */
    public static boolean test1(){
        try {

        } catch(Exception e){
            return false;
        }
        return true;
    }
    /**
     * description of high level functionality
     * @return true if all cases work as intended, false otherwise
     */
    public static boolean test2(){
        try {

        } catch(Exception e){
            return false;
        }
        return true;
    }
    /**
     * description of high level functionality
     * @return true if all cases work as intended, false otherwise
     */
    public static boolean test3(){
        try {

        } catch(Exception e){
            return false;
        }
        return true;
    }
    /**
     * description of high level functionality
     * @return true if all cases work as intended, false otherwise
     */
    public static boolean test4(){
        try {

        } catch(Exception e){
            return false;
        }
        return true;
    }
    /**
     * description of high level functionality
     * @return true if all cases work as intended, false otherwise
     */
    public static boolean test5(){
        try {

        } catch(Exception e){
            return false;
        }
        return true;
    }
}
