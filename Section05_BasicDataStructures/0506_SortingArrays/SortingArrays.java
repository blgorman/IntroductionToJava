
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class SortingArrays 
{
    public static void main(String[] args)
    {
        //there are many ways to sort an array, but one of the easiest
        //is to use an algorithm called 'insertion sort'
        //insertion sort works very similar to how you would sort
        //your cards in your hand if you were playing a card game.
        //by comparing the item to the left, the item to the right can 
        //"slide" as far left as it needs to in order to be sorted.
        
        //for example, let's sort an array of random numbers
        Random r = new Random();
        int[] numbers = new int[15];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = r.nextInt(10000);
        }
        
        System.out.println("Unsorted..");
        for (int i : numbers)
        {
            System.out.printf("Next Number: %d\n", i);
        }
        
        SortArrayUsingInsertionSort(numbers); //remember, this is by reference!
        System.out.println("Sorted..");
        for (int i : numbers)
        {
            System.out.printf("Next Number: %d\n", i);
        }
        System.out.println(Stars(30));
        
        //of course, we don't have to re-invent the wheel:
        String[] lastNames = new String[10];
        lastNames[0] = "Jones";
        lastNames[1] = "Andrews";
        lastNames[2] = "Zielinski";
        lastNames[3] = "Cooper";
        lastNames[4] = "Thomas";
        lastNames[5] = "Stone";
        lastNames[6] = "Balboa";
        lastNames[7] = "Anderson";
        lastNames[8] = "Polinski";
        lastNames[9] = "Lochte";
        
        Arrays.sort(lastNames);
        for (String s : lastNames)
        {
            System.out.printf("Next Name: %s\n", s);
        }
        System.out.println(Stars(30));
        
        //and of course if you wanted to sort just a few, you could
        numbers = new int[10];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = r.nextInt(10000);
        }
        
        Arrays.sort(numbers, 3, 7);
        for (int i = 0; i < numbers.length; i++)
        {
            if (i > 1 && i < 9)
            {
                System.out.printf("Next Number: %d\n", numbers[i]);
            }
        }
    }
    
    
    private static void SortArrayUsingInsertionSort(int[] data)
    {
        //there is nothing to the left of [0] so we can't sort it
        //therefore, start at 1:
        for (int i = 1; i < data.length; i++)
        {
            //work in reverse from current position, sliing left
            //if the number to the right is larger
            for (int j = i; j > 0 && data[j] < data[j-1]; j--)
            {
                /*
                System.out.printf("%d < %d, sliding left...\n"
                                    , data[j], data[j-1]);
                */
                int temp = data[j-1];
                data[j-1] = data[j];
                data[j] = temp;
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
