/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

/**
 *
 * @author Brian
 */
public class CodingWithArrays 
{
    public static void main(String[] args)
    {
        //to declare an array, use the type, variable name and size
        //declare a string array to hold 10 Strings
        String[] someStrings = new String[10];
        
        //populate the arrays
        someStrings[0] = "The first string in the array has index 0.";
        someStrings[1] = "The second string in the array is at index 1.";
        someStrings[2] = "Learning Java programming is fun.";
        someStrings[3] = "But things are becoming more complicated by the day.";
        someStrings[7] = "You don't have to work with these in order";
        someStrings[4] = "But it might be easier to keep track if you do";
        someStrings[5] = "";
        someStrings[6] = "";
        someStrings[8] = "";
        someStrings[9] = "";
        //and you can't do this:
        //someStrings[10] = "";
        //for the same reason you can't do this:
        //someStrings[17] = "";
        //we also can't use a negative index:
        //someStrings[-10] = ""; //all indexes must be positive.
        
        //and you want to print the Strings:
        System.out.println(someStrings[0]);
        System.out.printf("String 0: %s\nString 1: %s\n"
                            , someStrings[0]
                            , someStrings[1]);
        
        //when working with arrays, there is always a length, which makes it
        //easy to loop
        for (int i = 0; i < someStrings.length; i++)
        {
            System.out.printf("STRING %d)\t%s\n", i, someStrings[i]);
        }
        System.out.println(Stars(30));
        
        //any type can be used
        int[] testScores = new int[20];
        
        //but you can't mix and match types
        //testScores[10] = String.format("The score for 10) %d", 85);
        //someString[2] = 85;
        
        //if you make it new, you can resize, and everything is lost
        //all indexes are reset to the default
        someStrings = new String[20];
        
        Random rnd = new Random();
        
        //setup for printing
        for (int i = 0; i < 20; i++)
        {
            testScores[i] = rnd.nextInt(100);
            someStrings[i] = String.format("Student %d", rnd.nextInt(50000));
        }
        
        //arrays can be passed to a method
        PrintScores(testScores, someStrings);
        System.out.println(Stars(30));
        
        
        //with arrays, you are limited to the size that you specify on creation:
        int[] numbers = new int[10]; //indexes 0-9, count/length/size = 10
        for (int i = 0; i < 10; i++)
        {
            numbers[i] = rnd.nextInt(100);
        }
        
        //so if we needed to add another index after we maxed out
        //one way to do it is to 
        //create a new array with the correct size and copy all the indexes
        //don't worry, we'll learn something better in the array copy video in
        //a couple of lessons.
        int[] numbers2 = new int[20];
        for (int i = 0; i < 20; i++)
        {
            if (i < 10)
            {
                numbers2[i] = numbers[i];
            }
            else
            {
                numbers2[i] = rnd.nextInt(100);
            }
        }
        
        for (int i = 0; i < 20; i++)
        {
            System.out.println(numbers2[i]);
        }
        System.out.println(Stars(30));
    }
    
    public static void PrintScores(int[] testScores, String[] studentNames)
    {
        //NOTE: there would be a HUGE problem if scores weren't lined up
        //and/or if the arrays weren't the same size....
        for (int i = 0; i < testScores.length; i++)
        {
            //safety check to make sure the other array is not null and has
            //enough slots
            if (studentNames.length >= i && studentNames[i] != null)
            {
                System.out.printf("%s scored %d\n"
                                    , studentNames[i]
                                    , testScores[i]);
            }
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
