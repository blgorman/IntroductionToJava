/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class CarTest extends VehicleBaseTest {
    
    public CarTest() {
    }
    
   
    public void setUp() {
    }
    
    public void tearDown() {
    }

    /**
     * Factory to get a default VehicleBase
     * @return A car with no properties set as a default VehicleBase
     */
    public VehicleBase getVehicleBase() {
        //create a default Car as VehicleBase
        Car c = new Car();
        VehicleBase v = c;
        return v;
    }

    /**
     * Factory to get an explicit VehicleBase
     * @return a Car with properties set as an explicit VehicleBase
     */
    public VehicleBase getVehicleBaseExplicit() {
        Car c = new Car(Common.MAKE, Common.MODEL
                        , Common.YEAR, Common.MILES
                        , Common.VIN);
        //set this, even though it won't be accessible
        c.setTopSpeed(Common.TOPSPEED);
        VehicleBase v = c;
        return v;
    }
    
    /**
     * Test the car constructors
     */
    public void testConstructors()
    {
        Car c = new Car();
        assertNotNull(c);
        c = new Car(Common.MAKE, Common.MODEL, Common.YEAR
                    , Common.MILES, Common.VIN);
        assertNotNull(c);
        //make sure the properties are equal after default construction
        assertEquals("Explicit Car Make is not as expected"
                        , Common.MAKE
                        , c.getMake());
        assertEquals("Explicit Car Model is not as expected"
                        , Common.MODEL
                        , c.getModel());
        assertEquals("Explicit Car Year is not as expected"
                        , Common.YEAR
                        , c.getYear());
        assertEquals("Explicit Car Mileage is not as expected"
                        , Common.MILES
                        , c.getMileage()
                        , Common.DELTA);
        assertEquals("Explicit Car VIN is not as expected"
                        , Common.VIN
                        , c.getVIN());
    }
    
    /**
     * Test Mutator/Accessor methods
     * Since the base does common, only have to test unique here
     */
    public void testMutatorAndAccessorMethods()
    {
        Car c = new Car();
        c.setTopSpeed(Common.TOPSPEED);
        assertEquals("Top speed was not set as expected"
                    , Common.TOPSPEED
                    , c.getTopSpeed()
                    , Common.DELTA);
        
        assertEquals("Internal Type was not returned as expected"
                        , Common.CARTYPE
                        , c.getInternalType());
    }
    
    /**
     * Test toString.
     * Base class tests everything except unique.
     */
    public void testToString()
    {
        Car c = new Car(Common.MAKE, Common.MODEL, Common.YEAR
                    , Common.MILES, Common.VIN);
        String carString = c.toString();
        assertTrue("Car toString does not contain Internal Type"
                    , carString.contains(c.getInternalType()));
        assertTrue("Car toString does not contain top Speed"
                    , carString.contains(String.format("%.2f"
                                            , c.getTopSpeed())));
    }
}