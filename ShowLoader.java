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
     * @returns a list of Show objects
     */
    @Override
    public List<IShow> loadShows(String filepath) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(filepath), "UTF-8");
        ArrayList<IShow> list = new ArrayList<IShow>();
        if(!scn.hasNextLine()) return list;
        ArrayList<String> columns = getArrayListFromCSVRow(scn.nextLine());
        int titleIndex = columns.indexOf("Title");
        int yearIndex = columns.indexOf("Year");
        int ratingIndex = columns.indexOf("Rotten Tomatoes");
        int netflixIndex = columns.indexOf("Netflix");
        int huluIndex = columns.indexOf("Hulu");
        int primeIndex = columns.indexOf("Prime Video");
        int disneyIndex = columns.indexOf("Disney+");

        while(scn.hasNext()){
            ArrayList<String> row = getArrayListFromCSVRow(scn.nextLine());
            String providers = "";
            if(row.get(netflixIndex).equals("1")) providers += "Netflix";
            if(row.get(huluIndex).equals("1")) providers += "Hulu";
            if(row.get(primeIndex).equals("1")) providers += "Prime Video";
            if(row.get(disneyIndex).equals("1")) providers += "Disney+";
            list.add(new Show(row.get(titleIndex), 
                Integer.parseInt(row.get(yearIndex)), 
                Integer.parseInt(row.get(ratingIndex).substring(0, row.get(ratingIndex).indexOf("/"))),
                providers));
        }
        return list;
    }
    /**
     * Helper method to get an arraylist from a csv row
     * @param line line to turn into an ArrayList
     * @return ArrayList representation of line, split at each comma that isnt inside of quotes
     */
    private ArrayList<String> getArrayListFromCSVRow(String line){
        ArrayList<String> list = new ArrayList<String>();
        int quotesSinceLastComma = 0;
        int indexOfLastComma = -1;
        for(int i = 0; i < line.length(); i++){
            String currChar = line.substring(i, i+1);
            if(currChar.equals("\"")) quotesSinceLastComma++;
            if(currChar.equals(",") && quotesSinceLastComma % 2 == 0){
                list.add(line.substring(indexOfLastComma + 1, i).replace("\"\"", "\""));
                indexOfLastComma = i;
            }
        }
        return list;
    }

}

