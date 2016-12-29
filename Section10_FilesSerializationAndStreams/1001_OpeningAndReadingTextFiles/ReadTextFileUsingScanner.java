import java.util.*;
import java.io.*;
/**
 *
 * @author MajorGuidance
 */
public class ReadTextFileUsingScanner {
    public static void main(String[] args)
    {
        String filePath = "E:\\Data"
                     + "\\UdemyWeek10FilesForReadWrite" 
                     + "\\ASampleTextFile.txt";
        
        //scanner can be opened with a file as the parameter
        //or with an InputStream as the parameter...
        File f = null;
        Scanner in = null;
        try
        {
            f = new File(filePath);
            in = new Scanner(f);
            String line = null;
            //scanner has a peek method so we don't have
            //to read in the line first, we can check if there
            //is a next line
            while (in.hasNextLine())
            {
                //here we'll read the line
                line = in.nextLine(); //look familiar? it should..
                //here we'll make everything lowercase
                System.out.println(line.toLowerCase());
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            //scanner doesn't throw io exception!
            if (in != null)
            {
                in.close();
            }
        }
    }
}
