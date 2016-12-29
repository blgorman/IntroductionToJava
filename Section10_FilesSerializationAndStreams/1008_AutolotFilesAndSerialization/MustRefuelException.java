import java.io.Serializable;
/**
 *
 * @author Brian
 */
public class MustRefuelException extends RuntimeException 
        implements Serializable
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
