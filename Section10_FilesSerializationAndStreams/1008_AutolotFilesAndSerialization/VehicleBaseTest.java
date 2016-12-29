/**
 * Vehicle Base Test class tests all VehicleBaseMethods.
 * We'll use a factory so we don't have to retest these
 * methods in each subclass
 * NOTE: Vehicle Base is abstract
 *       The test is also abstract
 *       This means the test will only run from a subclass
 *       through inheritance
 *       This is correct, since we can't instantiate a VehicleBase
 * @author Brian
 */
public abstract class VehicleBaseTest extends junit.framework.TestCase {
    public abstract VehicleBase getVehicleBase();
    public abstract VehicleBase getVehicleBaseExplicit();
    private VehicleBase v;
    private VehicleBase v2;
    
    public VehicleBaseTest(){
        v = getVehicleBase();
        v2 = getVehicleBaseExplicit();
    }
    
    //get the VehicleBase objects before the test runs
    //using the factory method:
    public void setUp() {
        
    }
    
    public void tearDown() {
    }
    
    //now, since we have a factory in place, both
    //of our default methods that will exist in all inherited classes
    //can get us the correct object as a VehilceBase and allow
    //for us to work against all VehicleBase Methods
    public void testConstructors()
    {
        
        assertNotNull("Default constructor factory is not creating a "
                + "VehicleBase as expected", v);
        assertNotNull("Explicit constructor factory is not creating a "
                + "VehicleBase as expected", v2);
        
        //make sure explicit properties are set
        assertEquals("Explicit VehicleBase Make is not as expected"
                        , Common.MAKE
                        , v2.getMake());
        assertEquals("Explicit VehicleBase Model is not as expected"
                        , Common.MODEL
                        , v2.getModel());
        assertEquals("Explicit VehicleBase Year is not as expected"
                        , Common.YEAR
                        , v2.getYear());
        assertEquals("Explicit VehicleBase Mileage is not as expected"
                        , Common.MILES
                        , v2.getMileage()
                        , Common.DELTA);
        assertEquals("Explicit VehicleBase VIN is not as expected"
                        , Common.VIN
                        , v2.getVIN());
    }
    
    /**
     * Test the mutator/accessor methods that are common for all VehicleBase
     * objects
     */
    public void testVehicleBaseMutatorsAndAccessors()
    {
        v.setMake(Common.MAKE);
        assertEquals("Make was not set as expected"
                        , Common.MAKE, v.getMake());
        
        //now we need to add the testing to make sure illegal arguments
        //are thrown when bad input is encountered
        boolean caught = false;
        try
        {
            v.setMake(null);
        }
        catch (IllegalArgumentException iaex)
        {
            caught = true;
        }
        assertTrue("Make did not throw illegal argument as "
                + "expected on null input"
                , caught);
        caught = false;
        try
        {
            v.setMake("");
        }
        catch (IllegalArgumentException iaex)
        {
            caught = true;
        }
        assertTrue("Make did not throw illegal argument as "
                + "expected on empty String input"
                , caught);
        
        /************** MODEL ********************************/
        v.setModel(Common.MODEL);
        assertEquals("Model was not set as expected"
                        , Common.MODEL, v.getModel());
        caught = false;
        try
        {
            v.setModel(null);
        }
        catch (IllegalArgumentException iaex)
        {
            caught = true;
        }
        assertTrue("Model did not throw illegal argument as "
                + "expected on null input"
                , caught);
        caught = false;
        try
        {
            v.setModel("");
        }
        catch (IllegalArgumentException iaex)
        {
            caught = true;
        }
        assertTrue("Model did not throw illegal argument as "
                + "expected on null input"
                , caught);
        
        /************** YEAR  ********************************/
        v.setYear(Common.YEAR);
        assertEquals("Year was not set as expected"
                        , Common.YEAR, v.getYear());
        
        caught = false;
        try
        {
            v.setYear(-1);
        }
        catch (IllegalArgumentException iaex)
        {
            caught = true;
        }
        assertTrue("Year did not throw illegal argument as "
                + "expected on minimal input"
                , caught);
        
        caught = false;
        try
        {
            v.setYear(2101);
        }
        catch (IllegalArgumentException iaex)
        {
            caught = true;
        }
        assertTrue("Year did not throw illegal argument as "
                + "expected on maximal input"
                , caught);
        
        /************** MILES *******************************/
        v.setMileage(Common.MILES);
        assertEquals("Mileage was not set as expected"
                        , Common.MILES
                        , v.getMileage()
                        , Common.DELTA);
        
        caught = false;
        try
        {
            v.setMileage(-1.0);
        }
        catch (IllegalArgumentException iaex)
        {
            caught = true;
        }
        assertTrue("Mileage did not throw illegal argument as "
                + "expected on minimal input"
                , caught);
        
        caught = false;
        try
        {
            v.setMileage(5000001.0);
        }
        catch (IllegalArgumentException iaex)
        {
            caught = true;
        }
        assertTrue("Mileage did not throw illegal argument as "
                + "expected on maximal input"
                , caught);
        
        /************* VIN   ********************************/
        v.setVIN(Common.VIN);
        assertEquals("VIN was not set as expected"
                        , Common.VIN
                        , v.getVIN());
        caught = false;
        try
        {
            v.setVIN(null);
        }
        catch (IllegalArgumentException iaex)
        {
            caught = true;
        }
        assertTrue("setVIN did not throw illegal argument as "
                + "expected on null String input"
                , caught);
        caught = false;
        
        try
        {
            v.setVIN("");
        }
        catch (IllegalArgumentException iaex)
        {
            caught = true;
        }
        assertTrue("setVIN did not throw illegal argument as "
                + "expected on empty String input"
                , caught);
        
        /************* FUEL   **************************************/
        v.setFuel(15.0);
        assertEquals("Could not set fuel as expected on vehicle"
                    , 15.0
                    , v.getFuel());
        
        caught = false;
        try
        {
            v.setFuel(-1.0);
        }
        catch (IllegalArgumentException iaex)
        {
            caught = true;
        }
        assertTrue("setFuel did not throw illegal argument as "
                + "expected on negative input"
                , caught);
        caught = false;
        
        try
        {
            v.setFuel(25.0);
        }
        catch (IllegalArgumentException iaex)
        {
            caught = true;
        }
        assertTrue("setFuel did not throw illegal argument as "
                + "expected on maximal input"
                , caught);
    }
    
    /**
     * Test the toString()
     */
    public void testToString()
    {
        //make sure all the common stuff appears in the toString()
        String vString = v2.toString();
        
        //make sure all the values are in toString()
        assertTrue("VehicleBase toString does not contain Make"
                    , vString.contains(Common.MAKE));
        assertTrue("VehicleBase toString does not contain Model"
                    , vString.contains(Common.MODEL));
        assertTrue("VehicleBase toString does not contain Year"
                    , vString.contains(String.format("%d", Common.YEAR)));
        assertTrue("VehicleBase toString does not contain Miles"
                    , vString.contains(String.format("%.1f", Common.MILES)));
        assertTrue("VehicleBase toString doesnot contain VIN"
                    , vString.contains(Common.VIN));
        assertTrue("VehicleBase toString does not contain FUEL"
                    , vString.contains(String.format("%.1f", Common.FUEL)));
    }
}