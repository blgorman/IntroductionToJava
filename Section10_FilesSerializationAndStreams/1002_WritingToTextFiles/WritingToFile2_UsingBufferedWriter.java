import java.io.*;
/**
 *
 * @author Brian
 */
public class WritingToFile2_UsingBufferedWriter {
public static void main(String[] args)
    {
        //this will create and store the file locally in
        //the project directory
        String filePath = "SomeTextFile2.txt";
        FileWriter fw = null;
        BufferedWriter bw = null;
        try
        {
            fw = new FileWriter(filePath);
            bw = new BufferedWriter(fw);
            int lineNumber = 1;
            //note: you can write directly here with the writer
            String lineBase = "This is line ";
            String line2 = String.format("%s %d in my file\n"
                                            , lineBase
                                            , lineNumber);
            bw.write(line2);
            lineNumber++;
            line2 = String.format("%s %d in my file\n"
                                            , lineBase
                                            , lineNumber);
            bw.write(line2);
            lineNumber++;
            line2 = String.format("%s %d in my file\n"
                                            , lineBase
                                            , lineNumber);
            bw.write(line2);
        }
        catch (IOException ioex)
        {
            ioex.printStackTrace();
        }
        finally
        {
            try
            {
                if (bw != null)
                {
                    bw.close();
                }
                if (fw != null)
                {
                    fw.close();
                }
            }
            catch (IOException ioex2)
            {
                System.out.println("File was lost before "
                        + "it could be closed");
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
