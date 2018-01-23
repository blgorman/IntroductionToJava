import java.io.*;
/**
 *
 * @author Brian
 */
public class Common 
{
    public static int CurrentSpeedLimit = 65;
    public static final int AbsoluteSpeedLimit = 100;
    
    /**
     * Determine if the vehicle is speeding
     * @param speed the current speed of the vehicle
     * @return true if the vehicle is speeding.
     */
    public static boolean IsSpeeding(double speed)
    {
        return Math.ceil(speed) > AbsoluteSpeedLimit;
    }
    
    /**
     * Check if currently speeding.
     * @param speed the speed of the vehicle
     * @return true if speeding.
     */
    public static boolean IsCurrentlySpeeding(double speed)
    {
        return Math.ceil(speed) > CurrentSpeedLimit;
    }
    
    /**
     * Get a String of Stars
     * @param num the number of stars to put in the string
     * @return a String of Stars of specified length.
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
}