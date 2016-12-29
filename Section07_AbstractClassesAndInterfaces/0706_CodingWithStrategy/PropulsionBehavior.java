/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The propulsion behavior will allow for flight operations
 * @author Brian
 */
public interface PropulsionBehavior 
{
    //
    /**
     * The flight operation
     * @return Description of flight
     */
    String flightOperation();
    
    /**
     * The Distance Flown by this operation
     * @return Distance as integer.
     */
    int movementDistance();
}
