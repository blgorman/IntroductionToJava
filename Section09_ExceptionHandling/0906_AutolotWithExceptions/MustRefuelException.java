/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MajorGuidance
 */
public class MustRefuelException extends RuntimeException 
{
    public MustRefuelException()
    {
        super("Vehicle is out of fuel.  Add fuel to continue...");
    }
    
    public MustRefuelException(String message)
    {
        super(message);
    }
}
