/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class NuclearPropulsion implements PropulsionBehavior
{
    private final int MOVEMENT_DISTANCE = 20;
    
    public String flightOperation() {
        return "This ship is flying with Nuclear propulsion.";
    }

    
    public int movementDistance() {
        return MOVEMENT_DISTANCE;
    }
}
