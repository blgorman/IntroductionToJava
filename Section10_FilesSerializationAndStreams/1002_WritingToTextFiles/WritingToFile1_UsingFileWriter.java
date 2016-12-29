import java.io.*;
/**
 *
 * @author Brian
 */
public class WritingToFile1_UsingFileWriter {
    public static void main(String[] args)
    {
        //this will create and store the file locally in
        //the project directory
        String filePath = "SomeTextFile1.txt";
        FileWriter fw = null;
        try
        {
            fw = new FileWriter(filePath);
            int lineNumber = 1;
            //note: you can write directly here with the writer
            String lineBase = "This is line ";
            String line2 = String.format("%s %d in my file\n"
                                            , lineBase
                                            , lineNumber);
            fw.write(String.format("%s", line2));
            lineNumber++;
            line2 = String.format("%s %d in my file\n"
                                            , lineBase
                                            , lineNumber);
            fw.write(line2);
            lineNumber++;
            line2 = String.format("%s %d in my file\n"
                                            , lineBase
                                            , lineNumber);
            fw.write(line2);
        }
        catch (IOException ioex)
        {
            ioex.printStackTrace();
        }
        finally
        {
            //NOTE: It is IMPERATIVE that you close a file
            //      you are writing to.
            //      if you don't, the file will lock
            //      and the information you are writing to the
            //      file will be lost forever.
            if (fw != null)
            {
                try
                {
                    fw.close();
                }
                catch (IOException ioex2)
                {
                    System.out.println("File was lost before "
                            + "it could be closed");
                }
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
