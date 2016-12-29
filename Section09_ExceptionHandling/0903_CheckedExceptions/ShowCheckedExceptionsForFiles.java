import java.io.*;
/**
 * Showing an example of a checked exception.
 * @author Brian
 */
public class ShowCheckedExceptionsForFiles {
    //note: We will show how to work with files in the next section
    //for now, let's go with the code just to show IOExceptions
    //which are the most common types -- i.e. FileNotFound, EOFException, etc
    
    //the main thing to note: Any time the program error might be out of the 
    //control of the programmer, a Checked exception type is used
    //this ensures error handling is in place for things like (but not limited to):
    //1) Files not found (server was moved, file was deleted, etc)
    //2) Connections to sdatabases weren't correctly set up or DB is not available
    
    public static void main(String[] args) //throws IOException
    {
        //File reader can be used to open and read a text file
        //pretend to open a file...
        
        //untrapped:
        FileReader f = new FileReader("test.txt");
        
        //trap it:
        try
        {
            FileReader f2 = new FileReader("test.txt");
        }
        catch (FileNotFoundException fnfex)
        {
            System.out.println("File was not found. try again...");
        }
        
        //note:
        //if YOU, the person writing the code are responsible for this file
        //then you should NOT throw it.
        //if the file is dependent on the USER giving you a valid file
        //you should Throw it.  It's not your fault if their info is bad:
        ReadFileToConsole("nosuchfileexists.txt");
        //note, the caller MUST handle by throwing or trapping when
        //the method declares checked exception...
    }
    
    /**
     * A mock method to show that could take a path and throw ex.
     * @param filePath the path to the mystical file.
     * @throws FileNotFoundException when the file path is incorrect.
     */
    public static void ReadFileToConsole(String filePath) throws FileNotFoundException
    {
        FileReader f = new FileReader(filePath);
        //...do something with it...
    }
}
