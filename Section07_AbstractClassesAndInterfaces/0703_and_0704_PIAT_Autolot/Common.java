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
