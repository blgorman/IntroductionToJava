
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MajorGuidance
 */
public class ReadTextFileUsingBufferedReader1 {
public static void main(String[] args)
    {
        //we could do a nested try...catch, but it's really only 
        //necessary to have one.  We'll uncomment these lines
        //and fix the declaration code to show scope with
        //a try..catch block:
        //FileReader fr = null;
        //BufferedReader br = null;
        try
        {
            //a local file can easily be accessed with no
            //qualifying path:
            FileReader fr = new FileReader("E:\\Data\\"
                    + "UdemyWeek10FilesForReadWrite\\ASampleTextFile.txt");
            //there are two ways to use a file reader to read files
            //one way is with the "BufferedReader" class, which decorates
            //an existing file reader.  To do the decoration, create a 
            //new buffered reader with the filereader as a parameter:
            BufferedReader br = new BufferedReader(fr);
            //now that we have the br open with the correct file
            //we can easily read to the end of the file with a while loop
            //read the first line
            String line = br.readLine();
            while (line != null)
            {
                //do whatever you need to do with the line.
                //Here we'll just make it uppercase and print it out:
                System.out.println(line.toUpperCase());
                //read the next line
                line = br.readLine();
            }
        }
        catch (IOException ioex)
        {
            ioex.printStackTrace();
        }
        finally
        {
            try
            {
                //close the files [note the scope!]:
                if (br != null) {
                    br.close();
                }
                if (fr != null){
                    fr.close();
                }
            }
            catch (Exception ex)
            {
                System.out.println("File lost...");
            }
        }
    }
}
