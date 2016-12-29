import java.io.*;
/**
 *
 * @author Brian
 */
public class WritingToFile4_AppendToExistingFile_UsingBufferedWriter {
    public static void main(String[] args)
    {
        //this will create and store the file locally in
        //the project directory
        String filePath = "SomeTextFile4.txt";
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        int lineCount = 0;
        
        //find the file -- if it's there, open it, read it, count lines
        try
        {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null)
            {
                lineCount++;
                line = br.readLine();
            }
        }
        catch (IOException ioex)
        {
            //squelch this
            System.out.println("Some Text File 4 does not exist");
        }
        finally
        {
            try
            {
                if (br != null) br.close();
                if (fr != null) fr.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                br = null;
                fr = null;
            }
        }
        
        int lineNumber = lineCount + 1;
        
        //open the file and APPEND TO IT
        try
        {
            //toggle true to append:
            fw = new FileWriter(filePath, true);
            bw = new BufferedWriter(fw);
 
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
            //printwriter doesn't throw ioexception!
            try
            {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                bw = null;
                fw = null;
            }
        }
        
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
