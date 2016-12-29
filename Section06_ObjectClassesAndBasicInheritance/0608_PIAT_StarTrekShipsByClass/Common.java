/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

/**
 *
 * @author Brian
 */
public class Common {
    public static final String CONSTITUTION_CLASS= "Constitution-class";
    public static final String MIRANDA_CLASS = "Miranda-class";
    public static final String OBERTH_CLASS = "Oberth-class";
    public static final String DEFIANT_CLASS = "Defiant-class";
    
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
