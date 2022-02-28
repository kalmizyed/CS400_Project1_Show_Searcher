// --== CS400 Project One File Header ==--
// Name: Jack Blake
// CSL Username: jblake
// Email: jhblake2@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader: Brute force approach used to optimize time and space complexity

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author jblake
 * @version 1.0
 * Class representing list of shows from a specified csv source file.
 * The following csv columns are used to load these show attributes:
 *   - Title: the complete title for a show
 *   - Year: the year that the show was first produced
 *   - Rotten Tomatoes: the review score (out of 100) for this show
 *   - Netflix: 1 = available on this service, other wise 0
 *   - Hulu: 1 = available on this service, other wise 0
 *   - Prime Video: 1 = available on this service, other wise 0
 *   - Disney+: 1 = available on this service, other wise 0
 */
public class ShowLoader implements IShowLoader{

    /**
     * method to retrieve a list of shows from the a given realtive path
     * @param filepath relative filepath of the csv file
     * @returns a list of Show objects parsed from the csv file, 
     * or an empty list if there aren't columns for every relevant show attribute.
     * Skips over any shows that have invalid data in relevant attribute columns.
     */
    @Override
    public List<IShow> loadShows(String filepath) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(filepath), "UTF-8");
        ArrayList<IShow> list = new ArrayList<IShow>();
        //if no columns are defined, return an empty list
        if(!scn.hasNextLine()) return list;

        //variables that will be used to store the indices in the top row that contain
        // the corresponding show attribute. Initial values are -1, so if they are not reset,
        // I can check for that later
        int titleIndex = -1;
        int yearIndex = -1;
        int ratingIndex = -1;
        int netflixIndex = -1;
        int huluIndex = -1;
        int primeIndex = -1;
        int disneyIndex = -1;

        String columns = scn.nextLine();

        int quotesSinceLastComma = 0;
        int indexOfLastComma = -1;
        int currColIndex = 0;

        //loop through columns and find indices of show attributes
        for(int i = 0; i < columns.length(); i++){
            String currChar = columns.substring(i, i+1);
            if(currChar.equals("\"")) quotesSinceLastComma++;
            if((currChar.equals(",")) && quotesSinceLastComma % 2 == 0){
                String curr = columns.substring(indexOfLastComma + 1, i);

                if(curr.equals("Title")) titleIndex = currColIndex;
                if(curr.equals("Year")) yearIndex = currColIndex;
                if(curr.equals("Rotten Tomatoes")) ratingIndex = currColIndex;
                if(curr.equals("Netflix")) netflixIndex = currColIndex;
                if(curr.equals("Hulu")) huluIndex = currColIndex;
                if(curr.equals("Prime Video")) primeIndex = currColIndex;
                if(curr.equals("Disney+")) disneyIndex = currColIndex;

                currColIndex++;
                indexOfLastComma = i;
                quotesSinceLastComma = 0; //not strictly necessary, since its gaurunteed to be
                //even at this point
            }
        }
        //since items are checked once you hit a trailing comma, must do an extra check on the last elements
        //done same way as in loop
        if(indexOfLastComma != columns.length() - 1){
            String curr = columns.substring(indexOfLastComma + 1);
            if(curr.equals("Title")) titleIndex = currColIndex;
            if(curr.equals("Year")) yearIndex = currColIndex;
            if(curr.equals("Rotten Tomatoes")) ratingIndex = currColIndex;
            if(curr.equals("Netflix")) netflixIndex = currColIndex;
            if(curr.equals("Hulu")) huluIndex = currColIndex;
            if(curr.equals("Prime Video")) primeIndex = currColIndex;
            if(curr.equals("Disney+")) disneyIndex = currColIndex;
        }


        //if any of the attribute indices are still -1, return an empty list
        if(titleIndex == -1 || yearIndex == -1 || ratingIndex == -1 
            || netflixIndex == -1 || huluIndex == -1 || primeIndex == -1
            || disneyIndex == -1
            ) return list;


        //loop through each line until there are none left, adding each as a show object
        while(scn.hasNext()){
            String line = scn.nextLine();

            String title = null;
            int year = -1;
            int rating = -1;
            String providers = "";

            quotesSinceLastComma = 0;
            indexOfLastComma = -1;
            currColIndex = 0;
            int quotesAtStart = 0;

            
            try {
                //loop through the characters of this line
                for(int i = 0; i < line.length(); i++){
                    String currChar = line.substring(i, i+1);
                    if(currChar.equals("\"")) {
                        quotesSinceLastComma++;
                        continue;
                    }
                    //at the first non-quote char, set quotesAtStart to the amount of quotes there have been
                    if(quotesAtStart == 0) quotesAtStart = quotesSinceLastComma;
                    if((currChar.equals(",")) && quotesSinceLastComma % 2 == 0){
                        String val = line.substring(indexOfLastComma + 1, i);
                        //remove surrounding single quotes if quotesAtStart is odd
                        if(quotesAtStart % 2 != 0){
                            val = val.substring(1, val.length()-1);
                        }
                        //turn double quotes back into single quotes
                        val = val.replace("\"\"", "\"");

                        if(currColIndex == titleIndex) title = val;
                        if(currColIndex == yearIndex) year = Integer.parseInt(val);
                        if(currColIndex == ratingIndex) rating = Integer.parseInt(val.substring(0, val.indexOf("/100")));
                        if(currColIndex == netflixIndex && val.equals("1")) providers += "Netflix";
                        if(currColIndex == huluIndex && val.equals("1")) providers += "Hulu";
                        if(currColIndex == primeIndex && val.equals("1")) providers += "Prime Video";
                        if(currColIndex == disneyIndex && val.equals("1")) providers += "Disney+";
                        indexOfLastComma = i;
                        currColIndex++;
                        quotesSinceLastComma = 0;
                        quotesAtStart = 0;
                    } 
                }
                //since items are checked once you hit a trailing comma, must do an extra check on the last elements
                //done same way as in loop
                if(indexOfLastComma < line.length() - 1){
                    String val = line.substring(indexOfLastComma + 1).replace("\"\"", "\"");
                    if(currColIndex == titleIndex) title = val;
                    if(currColIndex == yearIndex) year = Integer.parseInt(val);
                    if(currColIndex == ratingIndex) rating = Integer.parseInt(val.substring(0, val.indexOf("/100")));
                    if(currColIndex == netflixIndex && val.equals("1")) providers += "Netflix";
                    if(currColIndex == huluIndex && val.equals("1")) providers += "Hulu";
                    if(currColIndex == primeIndex && val.equals("1")) providers += "Prime Video";
                    if(currColIndex == disneyIndex && val.equals("1")) providers += "Disney+";
                }
                //if any of the show attributes are still their initial values, skip to the next show
                if(title == null || year == -1 || rating == -1) continue;
                //add the show to the list to be returned if everything check out
                list.add(new Show(title, year, rating, providers));
            } catch(StringIndexOutOfBoundsException e){
                //Will get thrown if rating is not of the form "#/100", 
                //skip to the next show in this case
                continue;
            } catch(NumberFormatException e){
                //will get thrown if year or rating aren't numbers, so skip to next show
                continue;
            }
        }
        return list;
    }
}

