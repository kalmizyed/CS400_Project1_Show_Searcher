// --== CS400 Project One File Header ==--
// Name: Jack Blake
// CSL Username: jblake
// Email: jhblake2@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader: 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;

/**
 * @author jblake
 * @version 1.0
 * Class of static tests methods meant to check for proper functionality of the Show and ShowLoader classes
 */
public class DataWranglerTests {
    public static void main(String[] args){
        System.out.println(test1());
        System.out.println(test2());
        System.out.println(test3());
        System.out.println(test4());
        System.out.println(test5());
    }

    /**
     * Tests the functionality of the Show class in multiple cases
     * @return true if all cases work as intended, false otherwise
     */
    public static boolean test1(){
        try {
            //make sure constructor throws no Exceptions
            Show s = new Show("Stranger Things", 2021, 99, "Netflix Hulu");
            //test getters
            if(s.getRating() != 99) return false;
            if(!s.getTitle().equals("Stranger Things")) return false;
            if(s.getYear() != 2021) return false;
            //test isAvailableOn on providers the show is on
            if(!s.isAvailableOn("Netflix")) return false;
            if(!s.isAvailableOn("Hulu")) return false;
            //test isAvailableOn on providers the show is NOT on
            if(s.isAvailableOn("Prime Video")) return false;
            if(s.isAvailableOn("Disney+")) return false;
            //test show's compareTo
            Show a = new Show("Dune", 2021, 99, "Netflix Hulu");
            Show b= new Show("The Dark Knight", 2021, 97, "Netflix Hulu");
            Show c = new Show("The Grinch", 2021, 92, "Netflix Hulu");
            Show d = new Show("WestWorld", 2021, 92, "Netflix Hulu");
            //make sure higherRating.compareTo(lowerRating) returns a negative int
            if(a.compareTo(b) >= 0) return false;
            if(b.compareTo(c) >= 0) return false;
            //make sure lowerRating.compareTo(higherRating) returns a positive int
            if(b.compareTo(a) <= 0) return false;
            if(c.compareTo(b) <= 0) return false;
            //make sure equalRating.comparTo(equalRating) returns 0
            if(c.compareTo(d) != 0) return false;

        } catch(Exception e){
            //unexpected Exceptions
            return false;
        }
        return true;
    }
    /**
     * tests the ShowLoader's loadShows method on a csv with ONLY the relevant columns
     * and no tricky quotes/commas
     * @return true if all cases work as intended, false otherwise
     */
    public static boolean test2(){
        try {
            File f = new File("test2.csv");
            FileWriter writer = new FileWriter(f, false);
            writer.write("Title,Year,Rotten Tomatoes,Netflix,Hulu,Prime Video,Disney+\n"
            + "Joe Dirt,2012,22/100,1,0,1,0\n"
            + "Hell's Kitchen,2015,99/100,0,1,1,0");
            writer.close();

            ShowLoader s = new ShowLoader();
            //Loop through the list of show returned by loadShows, for each show, if it's title isn't one
            // of the 2 from above, return false, otherwise, check to make sure all of show's other
            //data matches up with the title
            List<IShow> shows = s.loadShows("test2.csv");
            if(shows.size() != 2) return false;
            for(IShow show : shows) {                
                if(show.getTitle().equals("Joe Dirt")){
                    if(show.getYear() != 2012) return false;
                    if(show.getRating() != 22) return false;
                    if(!show.isAvailableOn("Netflix")) return false;
                    if(show.isAvailableOn("Hulu")) return false;
                    if(!show.isAvailableOn("Prime Video")) return false;
                    if(show.isAvailableOn("Disney+")) return false;
                } else if(show.getTitle().equals("Hell's Kitchen")){
                    if(show.getYear() != 2015) return false;
                    if(show.getRating() != 99) return false;
                    if(show.isAvailableOn("Netflix")) return false;
                    if(!show.isAvailableOn("Hulu")) return false;
                    if(!show.isAvailableOn("Prime Video")) return false;
                    if(show.isAvailableOn("Disney+")) return false;
                } else return false;
            }
        } catch(Exception e){
            e.printStackTrace();
            //unexpected Exceptions
            return false;
        }
        return true;
    }
    /**
     * tests the ShowLoader's loadShows method on a csv with more columns than
     * just the relevant ones but no tricky quotes/commas
     * @return true if all cases work as intended, false otherwise
     */
    public static boolean test3(){
        try {
            File f = new File("test3.csv");
            FileWriter writer = new FileWriter(f, false);
            writer.write("Title,IMDB,Year,Rotten Tomatoes,Sugma,Netflix,Hulu,Prime Video,Disney+\n"
            + "Joe Dirt,23848923,2012,22/100,Chi,1,0,1,0\n"
            + "Hell's Kitchen,hello world,2015,99/100,Madison WI,0,1,1,0");
            writer.close();

            ShowLoader s = new ShowLoader();
            //Loop through the list of show returned by loadShows, for each show, if it's title isn't one
            // of the 2 from above, return false, otherwise, check to make sure all of show's other
            //data matches up with the title
            List<IShow> shows = s.loadShows("test3.csv");
            if(shows.size() != 2) return false;
            for(IShow show : shows) {                
                if(show.getTitle().equals("Joe Dirt")){
                    if(show.getYear() != 2012) return false;
                    if(show.getRating() != 22) return false;
                    if(!show.isAvailableOn("Netflix")) return false;
                    if(show.isAvailableOn("Hulu")) return false;
                    if(!show.isAvailableOn("Prime Video")) return false;
                    if(show.isAvailableOn("Disney+")) return false;
                } else if(show.getTitle().equals("Hell's Kitchen")){
                    if(show.getYear() != 2015) return false;
                    if(show.getRating() != 99) return false;
                    if(show.isAvailableOn("Netflix")) return false;
                    if(!show.isAvailableOn("Hulu")) return false;
                    if(!show.isAvailableOn("Prime Video")) return false;
                    if(show.isAvailableOn("Disney+")) return false;
                } else return false;
            }
        } catch(Exception e){
            //unexpected Exceptions
            return false;
        }
        return true;
    }
    /**
     * tests the ShowLoader's loadShows method on a csv with tricky quotes/commas 
     * (In columns for relevant attribute so they don't get skipped)
     * @return true if all cases work as intended, false otherwise
     */
    public static boolean test4(){
        try {
            File f = new File("test4.csv");
            FileWriter writer = new FileWriter(f, false);
            //made this in google sheets and downloaded it, absolutly nasty quotes/commas in here
            writer.write("Title,Year,Rotten Tomatoes,Netflix,Hulu,Prime Video,Disney+\n\"\"\"Ramsey, Gordon\"\", to Hell, and Back again\",2012,22/100,1,0,1,0\n\",,\"\"The Good Life\"\",\",2015,99/100,0,1,1,0");
            //titles look like this in actual sheet:
            //  "Ramsey, Gordon", to Hell, and Back again
            //  ,,"The Good Life",
            writer.close();

            ShowLoader s = new ShowLoader();
            //Loop through the list of show returned by loadShows, for each show, if it's title isn't one
            // of the 2 from above, return false, otherwise, check to make sure all of show's other
            //data matches up with the title
            List<IShow> shows = s.loadShows("test4.csv");
            if(shows.size() != 2) return false;
            for(IShow show : shows) {         
                if(!(
                    show.getTitle().equals("\"Ramsey, Gordon\", to Hell, and Back again")
                    || show.getTitle().equals(",,\"The Good Life\",")
                    )
                    ) return false;
            }
        } catch(Exception e){
            e.printStackTrace();
            //unexpected Exceptions
            return false;
        }
        return true;
    }
    /**
     * tests the ShowLoader's loadShows method with invalid and non-existent files
     * @return true if all cases work as intended, false otherwise
     */
    public static boolean test5(){
        try {
            ShowLoader s = new ShowLoader();
            try{
                s.loadShows("Invalid file path");
                //should've thrown FileNotFoundException
                return false;
            }
            catch(FileNotFoundException e){
                //expected
            }
            //empty file should yeild an empty list
            File f = new File("empty.csv");
            FileWriter writer = new FileWriter(f);
            writer.write("");
            writer.close();
            if(!s.loadShows("empty.csv").isEmpty()) return false;

        } catch(Exception e){
            //unexpected Exceptions
            return false;
        }
        return true;
    }
}
