import java.io.*;
/**
 *
 * @author Brian
 */
public class ReadTextFileUsingBufferedReader2 
{
    public static void main(String[] args)
    {
        //The easiest way to open and read a text file is with the
        //java file reader object
        //Remember that last week we discussed exceptions
        //  since we'll be using a file path, we can expect a checked
        //  exception on the filereader and either have to throw it
        //  or handle it.  Since our driver is responsible for providing
        //  the correct file path, we will handle the checked exception
        //  using a try...catch...finally block.
        try
        {
            //to access a file not in the same directory, you must
            //qualify the path fully with two slashes instead of one:
            /*
            String filePath = "E:\\Data"
                            + "\\UdemyWeek10FilesForReadWrite"
                            + "\\ASampleTextFile.txt";
            */
            String filePath = "ASampleTextFile.txt";
            //a local file can easily be accessed with no
            //qualifying path:
            FileReader fr = new FileReader(filePath);
            //use a buffered reader
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
            //it's proper to close files after using them:
            br.close();
            fr.close();
            //but what happens if there is an error?
        }
        catch (IOException ioex)
        {
            ioex.printStackTrace();
        }
    }
}
