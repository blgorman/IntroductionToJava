import java.util.*;
import java.io.*;

/**
 * Use the string 'split' operation to get items into an array.
 * @author Brian
 */
public class StringSplitting {

    /**
     * Read in a pipe-delimited file and split on the | and then
     * create an Employee object off of the data
     * @param args 
     */
    public static void main(String[] args)
    {
        File f = null;
        Scanner input = null;
        
        //open the file
        try
        {
            f = new File("SAMPLE_DATA.txt");
            input = new Scanner(f);
            String line = "";
            while (input.hasNextLine())
            {
                //read in the next line
                line = input.nextLine();
                //use a regular expression in the string "Split"
                //operation to get the values into an array
                String[] params = line.split("\\|");
                //now, use the params to get the data for the employee
                if (params.length == 4)
                {
                    Employee e = new Employee();
                    e.setID(Integer.parseInt(params[0]));
                    e.setName(params[1]);
                    e.setAge(Integer.parseInt(params[2]));
                    e.setPWD(params[3]);
                    
                    System.out.println("Employee:  " + e);
                    
                    //of course you can do more with the data here...
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("Problems...");
        }
        finally
        {
            if (input != null) input.close();
        }
    }
}
