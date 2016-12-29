import java.io.*;
import java.util.*;

/**
 *
 * @author MajorGuidance
 */
public class WritingToFile3_UsingPrintWriter {
    public static void main(String[] args)
    {
        //this will create and store the file locally in
        //the project directory
        String filePath = "SomeTextFile3.txt";
        PrintWriter pw = null;
        try
        {
            File f = new File(filePath);
            pw = new PrintWriter(f);
            int lineNumber = 1;
 
            String lineBase = "This is line ";
            String line2 = String.format("%s %d in my file\n"
                                            , lineBase
                                            , lineNumber);
            pw.write(String.format("%s", line2));
            lineNumber++;
            line2 = String.format("%s %d in my file\n"
                                            , lineBase
                                            , lineNumber);
            pw.write(line2);
            lineNumber++;
            line2 = String.format("%s %d in my file\n"
                                            , lineBase
                                            , lineNumber);
            pw.write(line2);
        }
        catch (IOException ioex)
        {
            ioex.printStackTrace();
        }
        finally
        {
            //printwriter doesn't throw ioexception!
            if (pw != null)
            {
                pw.close();
            }
        }
        
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null)
            {
                System.out.println(line);
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
                if (br != null) br.close();
                if (fr != null) fr.close();
            }
            catch (IOException ex)
            {
                System.out.println("Error");
            }
        }
    }
}
