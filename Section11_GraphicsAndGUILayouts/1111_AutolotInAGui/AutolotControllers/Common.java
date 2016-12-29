package AutolotControllers;

import java.io.Serializable;

/**
 *
 * @author Brian
 */
public class Common implements Serializable
{
    public static String MAKE = "FORD";
    public static String MODEL = "MUSTANG GT";
    public static int YEAR = 2013;
    public static String VIN = "1234567ABCDEFGHIJK";
    public static double MILES = 72.1;
    public static double FUEL = 14.0;
    public static double DELTA = 0.00001;
    public static double TOPSPEED = 237.94;
    public static String CARTYPE = "CAR";
    public static String TRUCKTYPE = "TRUCK";
    public static String MOTORCYCLETYPE = "MOTORCYCLE";
    
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
    public static boolean ValidateDouble(String val)
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
     * Print out a string of 's' repeated num times
     * @param num the number of times to repeat the string
     * @param s the String to repeat
     * @return A version of the string with the 's' string repeated n times.
     */
    public static String CharacterGeneration(int num, String s)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++)
        {
            sb.append(s);
        }
        return sb.toString();
    }
    
    /**
     * Use this to make sure null won't cause a problem
     * @param o1 first object
     * @param o2 second object
     * @return true if equal (including both null)
     */
    public static boolean nullSafeEquals(Object o1, Object o2)
    {
        return (o1 == null ? o2 ==null : o1.equals(o2));
    }
}
