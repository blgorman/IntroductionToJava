/**
 * Our Custom Exception or DoctorSpecialty.
 * Extends RuntimeException.
 * @author Brian
 */
public class DoctorSpecialtyException extends RuntimeException 
{
    /**
     * A default specialty exception.
     */
    public DoctorSpecialtyException()
    {
        super("A Doctor Specialty Exception was encountered.");
    }
    
    /**
     * A custom specialty exception
     * @param message the message to display when the exception happens.
     */
    public DoctorSpecialtyException(String message)
    {
        super(message);
    }
}
