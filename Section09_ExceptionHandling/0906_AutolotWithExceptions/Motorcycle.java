/**
 *
 * @author Brian
 */
public class Motorcycle extends VehicleBase
{
    /**
     * Default Constructor.
     */
    public Motorcycle()
    {
    
    }
    
    /**
     * Explicit Constructor.
     * @param make The make of the motorcycle
     * @param model The model of the motorcycle
     * @param year The year of the motorcycle
     * @param miles The miles on the motorcycle
     * @param VIN The VIN of the motorcycle
     */
    public Motorcycle(String make, String model, int year
                        , double miles, String VIN)
    {
        super(make, model, year, miles, VIN);
    }
    
    /**
     * The toString() method.
     * @return string representing Motorcycle.
     */
    public String toString()
    {
        return String.format("Type = %s\t%s"
                                , Common.MOTORCYCLETYPE
                                , super.toString());
    }
}
