/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author Brian
 */
public class Common 
{
    public static int CurrentSpeedLimit = 65;
    public static final int AbsoluteSpeedLimit = 100;
    
    public static boolean IsSpeeding(double speed)
    {
        return Math.ceil(speed) > AbsoluteSpeedLimit;
    }
    
    public static boolean IsCurrentlySpeeding(double speed)
    {
        return Math.ceil(speed) > CurrentSpeedLimit;
    }
    
    
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
