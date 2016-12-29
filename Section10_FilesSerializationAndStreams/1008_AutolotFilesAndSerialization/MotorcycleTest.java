/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MajorGuidance
 */
public class MotorcycleTest extends VehicleBaseTest
{
    /** 
     * Factory get default
     * @return default vehiclebase
     */
    public VehicleBase getVehicleBase() {
        Motorcycle m = new Motorcycle();
        return m;
    }

    /**
     * Factory get explicit
     * @return explicit vehicleBase
     */
    public VehicleBase getVehicleBaseExplicit() {
        Motorcycle m = new Motorcycle(Common.MAKE, Common.MODEL
                                    , Common.YEAR, Common.MILES
                                    , Common.VIN);
        return m;
    }
    
    /**
     * Test the toString() method
     */
    public void testToString()
    {
       Motorcycle m = new Motorcycle(Common.MAKE, Common.MODEL
                                    , Common.YEAR, Common.MILES
                                    , Common.VIN);
       String sMotorcycle = m.toString();
       assertTrue("Motorcycle toString does not contain type as expected"
                    , sMotorcycle.contains(Common.MOTORCYCLETYPE));
    }

}
