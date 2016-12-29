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
    public static String MAKE = "FORD";
    public static String MODEL = "MUSTANG GT";
    public static int YEAR = 2013;
    public static String VIN = "1234567ABCDEFGHIJK";
    public static double MILES = 72.1;
    public static double DELTA = 0.00001;
    public static double TOPSPEED = 237.94;
    public static String CARTYPE = "CAR";
    public static String TRUCKTYPE = "TRUCK";
    public static String MOTORCYCLETYPE = "MOTORCYCLE";
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
