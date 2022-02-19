// --== CS400 Project One File Header ==--
// Name: Jack Blake
// CSL Username: jblake
// Email: jhblake2@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader: 

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
     * or an empty list if there aren't columns for every relevant show attribute
     */
    @Override
    public List<IShow> loadShows(String filepath) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(filepath), "UTF-8");
        ArrayList<IShow> list = new ArrayList<IShow>();
        //if no columns are defined, return an empty list
        if(!scn.hasNextLine()) return list;

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
                quotesSinceLastComma = 0; //not stricly necessary
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


        //loop through each line until there are none left
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

            
            //loop through the characters of this line
            for(int i = 0; i < line.length(); i++){
                String currChar = line.substring(i, i+1);
                if(currChar.equals("\"")) {
                    quotesSinceLastComma++;
                    continue;
                }
                if(quotesAtStart == 0) quotesAtStart = quotesSinceLastComma;
                if((currChar.equals(",")) && quotesSinceLastComma % 2 == 0){
                    String val = line.substring(indexOfLastComma + 1, i);
                    if(quotesAtStart % 2 != 0){
                        val = val.substring(1, val.length()-1);
                    }
                    val = val.replace("\"\"", "\"");

                    //amybe keep track of another index to see if there are any false commas
                    //after the first comma, if there is a comma before any other quotes, remove the outer quotes.
                    //then remove 
                    if(currColIndex == titleIndex) title = val;
                    if(currColIndex == yearIndex) year = Integer.parseInt(val);
                    if(currColIndex == ratingIndex) rating = Integer.parseInt(val.substring(0, val.indexOf("/")));
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
                if(currColIndex == ratingIndex) rating = Integer.parseInt(val.substring(0, val.indexOf("/")));
                if(currColIndex == netflixIndex && val.equals("1")) providers += "Netflix";
                if(currColIndex == huluIndex && val.equals("1")) providers += "Hulu";
                if(currColIndex == primeIndex && val.equals("1")) providers += "Prime Video";
                if(currColIndex == disneyIndex && val.equals("1")) providers += "Disney+";
            }
            
            if(title == null || year == -1 || rating == -1) continue;
            list.add(new Show(title, year, rating, providers));
        }
        return list;
    }

}

