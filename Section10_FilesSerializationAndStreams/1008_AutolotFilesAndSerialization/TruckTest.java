

/**
 *
 * @author Brian
 */
public class TruckTest extends VehicleBaseTest {
    
    public VehicleBase getVehicleBase() {
        Truck t = new Truck();
        return t;
    }

    public VehicleBase getVehicleBaseExplicit() 
    {
        Truck t = new Truck(Common.MAKE, Common.MODEL
                        , Common.YEAR, Common.MILES, Common.VIN
                        , true);
        return t;
    }
    
    public TruckTest() {
    }
    
    public void setUp() {
    }
    
    public void tearDown() {
    }
    
    /*
     * Test the constructors
     */
    public void testConstructors()
    {
        Truck t = new Truck();
        assertNotNull("Default Constructor not working for truck"
                        , t);
        t = new Truck(Common.MAKE, Common.MODEL
                            , Common.YEAR, Common.MILES, Common.VIN
                            , true);
        assertNotNull("Explicit Constructor not working for truck"
                        , t);
        assertEquals("Truck constructor did not set four wheel drive"
                        , true
                        , t.isFourWheelDrive());
    }
    
    /**
     * Test mutators and accessors
     */
    public void testMutatorAndAccessors()
    {
        Truck t = new Truck();
        t.toggleFourWheelDrive(true);
        assertEquals("Truck FWD Toggle is not working as expected"
                        , true
                        , t.isFourWheelDrive());
    }
    
    /**
     * Test ToString.
     */
    public void testToString()
    {
        Truck t = new Truck();
        t.toggleFourWheelDrive(true);
        String tString = t.toString();
        assertTrue("Truck ToString does not contain type as expected"
                    , tString.contains(Common.TRUCKTYPE));
        assertTrue("Truck toString does not contain fwd value as expected"
                    , tString.contains(String.format("%b", true)));
    }
}