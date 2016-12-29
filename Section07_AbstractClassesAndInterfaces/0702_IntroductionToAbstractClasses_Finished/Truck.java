/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package introductiontoabstractclasses;

/**
 * A Truck.
 * @author Brian
 */
public class Truck extends VehicleBase implements FourWheelDrive
{
    boolean isFWD = false;
    
    public String toString()
    {
        return String.format("Type = Truck\tIs FWD: %b\t%s"
                                , this.isFourWheelDrive()
                                , super.toString());
    }

    public void toggleFourWheelDrive(boolean value)
    {
        isFWD = value;
    }
    
    public boolean isFourWheelDrive()
    {
        return this.isFWD;
    }
}

