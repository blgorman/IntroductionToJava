/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class Common 
{
    /**
     * Make sure user entered only a valid number:
     * @param checkString
     * @return 
     */
    public static boolean ValidateNumber(String checkString)
    {
        return ValidateNumber(checkString, false);
    }
    
    /**
     * Make sure user entered only a valid number:
     * @param checkString
     * @return 
     */
    public static boolean ValidateNumber(String checkString
                                        , boolean ignoreDecimalAndHyphen)
    {
        boolean isValid = true;
        //loop on all characters
        for (int i = 0; i < checkString.length(); i++)
        {
            char checkChar = checkString.charAt(i);
            if (ignoreDecimalAndHyphen && (checkChar == 45 || checkChar == 46))
            {
                continue;
            }
            if (checkChar < 48 || checkChar > 57)
            {
                isValid = false;
                break;
            }
        }
        
        //if get to here, all chars are valid
        return isValid;
    }
    
    /**
     * This method will validate a String to see
     *  if it can be parsed as a double
     * @param val the value to parse
     * @return true if can be made into a double, else false;
     */
    private static boolean ValidateDouble(String val)
    {
        return ValidateNumber(val, true);
    }
    
    /**
     * Get the first char of a string as a new string
     * @param val The string to get first char as string
     * @return The first char of a String as a String
     */
    public static String GetFirstCharAsString(String val)
    {
        return ((Character)val.charAt(0)).toString();
    }
    
    /**
     * Print out a string of stars based on passed in length
     * @param num
     * @return
     */
    public static String Stars(int num)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++)
        {
            sb.append("*");
        }
        return sb.toString();
    }

    /**
     * Print out a string of dashes based on passed in length
     * @param num
     * @return
     */
    public static String Dashes(int num)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++)
        {
            sb.append("-");
        }
        return sb.toString();
    }
}
