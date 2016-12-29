import java.io.*;
import java.util.*;

/**
 *
 * @author Brian
 */
public class StringTokenizing 
{
/**
     * Read in a comma separated file and split on the , and then
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
            f = new File("SAMPLE_DATA2.csv");
            input = new Scanner(f);
            String line = "";
            
            while (input.hasNextLine())
            {
                Employee e = new Employee();
                //read in the next line
                line = input.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                int iteration = 0;
                while (tokenizer.hasMoreTokens())
                {
                    String token = tokenizer.nextToken();
                    switch(iteration)
                    {
                        case 0:
                            e.setID(Integer.parseInt(token));
                            break;
                        case 1:
                            e.setName(token);
                            break;
                        case 2:
                            e.setAge(Integer.parseInt(token));
                            break;
                        case 3:
                            e.setPWD(token);
                            break;
                        default:
                            break;
                    }
                    iteration++;
                }
                System.out.println(String.format("Next Employee: \t%s\n"
                                , e));
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
