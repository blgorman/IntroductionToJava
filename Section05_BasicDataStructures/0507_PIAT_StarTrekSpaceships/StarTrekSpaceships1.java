/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Brian
 */
public class StarTrekSpaceships1 
{
    public static void main(String[] args)
    {
        //I want to be very clear.  There are much better ways to work with data.
        //We are not there yet.  For now, let's use arrays to "store" our "data"
        
        //as of right now, we don't have any way to store advanced objects.
        //we've already seen that Arrays can only hold One type.
        //this is fine if we only need to track one thing, (like strings)
        //for example, we could store names of ships:
        //Enterprise
        //Reliant
        //Pegasus
        //Defiant
        //But these ships also have designations:
        //NCC-1701
        //NCC-1864
        //NCC-53847
        //NX-74205
        //And class designations
        //Constitution-class
        //Miranda-class
        //Oberth-class
        //Defiant-class
        //And captains
        //Kirk
        //Terrell
        //Pressman
        //Sisko
        //and aren't commanders really humans that have names, ages, salaries?
        
        //one mistake I see many students make, is creating multiple arrays
        //and trying to keep items lined up:
        String[] ships = new String[4];
        ships[0] = "USS Enterprise";
        ships[1] = "USS Reliant";
        ships[2] = "USS Pegasus";
        ships[3] = "USS Defiant";
        
        //by the way, you can declare and set an array with {}'s and the correct
        //type, but most of the time you won't use this (but you need to be
        //aware that this is valid syntax
        //each item in the array is separated by a comma and since they are 
        //strings, surrounded by quotes
        String[] designations = {"NCC-1701", "NCC-1864"
                                    , "NCC-53847", "NX-74205"};
        String[] classes = {"Constitution-class"
                                , "Miranda-class"
                                , "Oberth-class"
                                , "Defiant-class"};
        String[] commanders = {"Kirk", "Terrell", "Pressman", "Sisko"};
        
        //who can see why this is a REALLY bad idea?  Think about our last
        //lesson...
        
        //let's print them out...{assuming they are all the same size}...
        for (int i = 0; i < ships.length; i++)
        {
            System.out.printf("Ship: %s\t| Designation: %s\t| "
                                + "Class: %s\t| Commander: %s\n"
                                , ships[i], designations[i]
                                , classes[i], commanders[i]);
        }
        
        //what about the captain though, is it just really one name?
        //what about the class? are there more details?  
        //how complex can we make this before we lose track and can't manage it?
        System.out.println(Stars(30));
        //and, as we thought about above, what happens one ONE of them is sorted?
        Arrays.sort(classes);
        for (int i = 0; i < ships.length; i++)
        {
            System.out.printf("Ship: %s\t| Designation: %s\t| "
                                + "Class: %s\t| Commander: %s\n"
                                , ships[i], designations[i]
                                , classes[i], commanders[i]);
        }
        //this is a big mess!
        
        //along comes the second mistake that most beginning programmers make
        //multi-dimensional arrays.
        
        //Yes, it is possible, and sometimes even best
        //to use multi-dimensional arrays to track information
        //i.e., the grid for Sudoku. [9]x[9].  We'll get to that...
        //for now, you should think to yourself.  Unless this is a gameboard 
        //grid or a space simulation, I SHOULD NOT USE A MULTI-DIMENSIONAL ARRAY!
        
        //What is an MD Array?  It's an array with multiple indexes
        int[][] numbers = new int[10][10];
        //this creates a 10x10 array.  This is not what you think, however.
        //there are not 10 x 2 indexes, or 20 indexes.  There are 10x10
        //==> 100 indexes.
        //let's prove it:
        int currentSlot = 1;
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                numbers[i][j] = currentSlot;
                currentSlot++;
            }
        }
        
        //now let's print them out:
        System.out.println(Stars(30));
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                System.out.printf("The next number is: %d\n", numbers[i][j]);
            }
        }
        
        //and granted, we could do this to store our ship data:
        String[][] shipData = new String[4][4];
        shipData[0][0] = "USS Enterprise";
        shipData[0][1] = "NCC-1701";
        shipData[0][2] = "Constitution-class";
        shipData[0][3] = "Kirk";
        shipData[1][0] = "USS Reliant";
        shipData[1][1] = "NCC-1864";
        shipData[1][2] = "Miranda-class";
        shipData[1][3] = "Terrell";
        shipData[2][0] = "USS Pegasus";
        shipData[2][1] = "NCC-53847";
        shipData[2][2] = "Oberth-class";
        shipData[2][3] = "Pressman";
        shipData[3][0] = "USS Defiant";
        shipData[3][1] = "NX-74205";
        shipData[3][2] = "Defiant-class";
        shipData[3][3] = "Sisko";
        System.out.println(Stars(30));
        for (int i = 0; i < shipData.length; i++)
        {
            for (int j = 0; j < shipData.length; j++)
            {
                System.out.printf("The next ship data info is: %s\n", shipData[i][j]);
            }
        }
        //but again, this is a programming nightmare if the system gets too big.
        //and with thousands of ships and changing commanders and needing
        //to be able to sort and pull data, well, you get the point (I hope).
        
        //and you could even make a 3-d array, if you are working for NASA,
        //creating a space simulator, or a flight simulator, or need 3-d 
        //coordinates.  Again, this would be even worse to manage...
        int athousandPoints[][][] = new int[10][10][10];  //that's right, 1000
        //just don't do it. and don't even think about 4d, unless you are a
        //time-traveller.
        
        //so what do we do then?
        //Next week we'll learn about classes.  We'll use classes.
        //in the absence of classes, we'll create a SINGLE STRING ENTRY
        //and parse it out when the data is returned to us:
        //~please note: you may not need to know about string functions yet
        //~but you will when you get to writing files, so watch this now
        //~and learn it later.  Like I said, we'll learn a better method next 
        //~week anyway for storing our data.
        String[] shipInfo = new String[4];
        shipInfo[0] = "USS Enterprise|NCC-1701|Constitution-class|Kirk";
        shipInfo[1] = "USS Reliant|NCC-1864|Miranda-class|Terrell";
        shipInfo[2] = "USS Pegasus|NCC-53847|Oberth-class|Pressman";
        shipInfo[3] = "USS Defiant|NX-74205|Defiant-class|Sisko";
        System.out.println(Stars(30));
        for (int i = 0; i < shipInfo.length; i++)
        {
            System.out.printf("The next ship data info is: %s\n", shipInfo[i]);
        }
        //this is manageable, sortable, etc. (although still not super sortable
        //as you couldn't sort by captain or class or ship, just the name at
        //this point.  But at least all of your data stays together.
        //You could also write these lines to a file to save it for later...
        
        //the other nice thing is we can use String functions to get the
        //specific data.
        //there are TWO common ways to get the data.  Since we're working
        //with arrays this week, I'm going to show you the first one (we'll cover
        //the other one in our week when we do file operations
        
        //the "Split" method, allows us to "split" a string on a delimiter.
        //The delimiter used above is the Pipe character: '|'.  Never delimit
        //on a comma unless you have to.  Why? put a monetary value in your 
        //String and you'll see why. $1,242.61 for example.
        
        //and let's sort the ships
        Arrays.sort(shipInfo, 0, shipInfo.length);
        
        //split pulls the string and puts the tokens into an array using a 
        //regular expression (don't be scared!):
        for (int i = 0; i < shipInfo.length; i++)
        {
            String[] tempData = shipInfo[i].split("\\|"); //uses REGEX
            for (int j = 0; j < tempData.length; j++)
            {
                System.out.printf("Next value: %s\t", tempData[j]);
            }
            System.out.println("");
        }
    }
 
    /**
     * Print out a string of stars based on passed in length
     * @param num
     * @return
     */
    public static String Stars(int num)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++)
        {
            sb.append("*");
        }
        return sb.toString();
    }
    
}
