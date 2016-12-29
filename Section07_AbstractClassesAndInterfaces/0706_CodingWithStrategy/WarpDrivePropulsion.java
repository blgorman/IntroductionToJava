/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Warp Drive Propulsion Behavior.
 * @author Brian
 */
public class WarpDrivePropulsion implements PropulsionBehavior
{
    public String flightOperation() {
        return "This ship is using warp engines to fly.";
    }

    public int movementDistance() {
        return 100;
    }
}
