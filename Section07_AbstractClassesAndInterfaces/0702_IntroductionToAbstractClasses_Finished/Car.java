/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package introductiontoabstractclasses;

/**
 * A Car.
 * @author Brian
 */
public class Car extends VehicleBase
{
    public String toString()
    {
        return String.format("Type = Car\t%s"
                                , super.toString());
    }
}