/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package introductiontoabstractclasses;

/**
 *
 * @author Brian
 */
public class Motorcycle extends VehicleBase
{
    public String toString()
    {
        return String.format("Type = Motorcycle\t%s"
                                , super.toString());
    }
}
