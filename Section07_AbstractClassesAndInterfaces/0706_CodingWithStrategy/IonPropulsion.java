/**
 * Ion Propulsion Behavior.
 * @author Brian
 */
public class IonPropulsion implements PropulsionBehavior
{
    private static final int MOVEMENT_DISTANCE = 10;
    public String flightOperation() {
        return "This ship is using Ion Propulsion to fly";
    }

    public int movementDistance() {
        return MOVEMENT_DISTANCE;
    }

}
