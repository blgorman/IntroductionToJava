import java.io.*;
import java.util.*;
/**
 * Use files and Simple Encryption to send encoded messages.
 * @author Brian
 */
public class SecretAgentDecoderEncoderProgram {
    private static Scanner input;
    
    public static void main(String[] args)
    {
        input = new Scanner(System.in);
        boolean continueProgram = true;
        while (continueProgram)
        {
            int option = PrintMenu();
            switch (option)
            {
                case 1:
                    EncodeDecodeTextFile();
                    break;
                case 2:
                    EncodeDecodeTextFile();
                    break;
                case 3:
                    Quit();
                    break;
                default:
                    Quit();
                    break;
            }
        }
    }
   
    /**
     * Print the option menu.
     * @return integer option user input
     */
    public static int PrintMenu()
    {
        boolean isValid = false;
        int userSelectedOption = -1;
        while (!isValid)
        {
            System.out.println(Common.CharacterGeneration(50,"*"));
            System.out.println("What would you like to do today?");
            System.out.println("Enter 1 to encode a file");
            System.out.println("Enter 2 to decode a file");
            System.out.println("Enter 3 to quit the program");
            System.out.println(Common.CharacterGeneration(50, "*"));
            String userOpt = input.nextLine();
            isValid = Common.ValidateNumber(userOpt);
            if (isValid) userSelectedOption = Integer.parseInt(userOpt);
            if (userSelectedOption < 1 || userSelectedOption > 3)
            {
                isValid = false;
                userSelectedOption = -1;
            }
        }
        return userSelectedOption;
    }
    
    /**
     * Quit the program.
     */
    public static void Quit()
    {
        System.exit(0);
    }
    
    /**
     * Encode or decode the file:
     */
    public static void EncodeDecodeTextFile()
    {
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try
        {
            int shift = GetShift();
            String filePath = GetFilePath(1);
            String savePath = GetFilePath(2);
            
            //open the file, reading in each line
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String line = br.readLine();
            StringBuilder resultString = new StringBuilder();
            while (line != null)
            {
                //for each line, parse out and change
                //each character by the appropriate shift
                for (int i = 0; i < line.length(); i++)
                {
                    char ch = line.charAt(i);
                    char newChar = ShiftChar(ch, shift);
                    resultString.append(newChar);
                }
                resultString.append("\n");
                line = br.readLine();
            }
            
            //write the result string
            fw = new FileWriter(savePath);
            bw = new BufferedWriter(fw);
            bw.write(resultString.toString());
        }
        catch (Exception ex)
        {
            System.out.println("You are not authorized.");
            System.exit(0);
        }
        finally
        {
            try
            {
                if (br != null) br.close();
                if (fr != null) fr.close();
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            }
            catch (Exception innerEx)
            {
                System.out.println("Some error message");
            }
            
            br = null;
            fr = null;
            bw = null;
            fw = null;
        }
    }
    
    /**
     * Get the shift from the agent.
     * @return the value entered by the agent for shifting
     */
    public static int GetShift()
    {
        System.out.println("Please enter the encryption key:");
        String keyCode = input.nextLine();
        int kValue = 0;
        try  
        {
            kValue = Integer.parseInt(keyCode);
        }
        catch (Exception ex)
        {
            System.out.println("You are not authorized to use the system");
            Quit();
        }
        return kValue;
    }
    
    /**
     * Get the path for encryption/decryption
     * @return 
     */
    public static String GetFilePath(int option)
    {
        switch (option)
        {
            case 1:
                System.out.println("Please enter the path to the file:");
                break;
            case 2:
                System.out.println("Please enter the save path for the file:");
                break;
            default:
                System.out.println("Please enter the path to the file:");
                break;
        }
        
        String path = input.nextLine();
        return path;
    }
    
    /**
     * Use ansii coding to shift the char
     * @param ch the char to shift
     * @param key the shift key
     * @return shifted char
     */
    public static char ShiftChar(char ch, int key)
    {
        int charValue = (int)ch;
        int newCharValue = charValue;
        
        //easy way (not true ceasar):
        //add the key (works both ways if use negative to decode):
        newCharValue = charValue + key;
        return (char)newCharValue;
        
        //if you wanted, you could determine key between 1 and 26
        //and use that to shift values so that only the alphabet is used.
        //more like a true ceasar encryption.
    }
}
