/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class AutoLotTest extends junit.framework.TestCase {
    private AutoLot al;
    private Vehicle v;
    private final int MAX_VEHICLES = 10;
    
    public AutoLotTest() {
    }

    public void setUp() {
        al = new AutoLot();
        v = new Car(Common.MAKE, Common.MODEL, Common.YEAR, 
                    Common.MILES, Common.VIN);
    }

    public void tearDown() {
    }

    /**
     * Test the constructor.
     */
    public void testConstructor(){
        assertNotNull("the auto lot could not be created"
                        , al);
    }
    
    /**
     * Test adding a vehicle
     */
    public void testAddVehicle()
    {
        //make sure null vehicle is not able to be added
        assertFalse("Should not be able to add a null object"
                    , al.AddVehicle(null));
        
        assertTrue("Could not add vehicle as expected"
                    , al.AddVehicle(v));
        assertEquals("Count was not correct after the "
                    + "vehicle was added" 
                    , 1
                    , al.getVehicleCount());
        //make sure can't add existing
        assertFalse("Vehicle that already existed should not "
                    + "be added to the autolot"
                    , al.AddVehicle(v));
        assertEquals("Count should not increment when vehicles "
                        + "are not successfully added"
                        , 1
                        , al.getVehicleCount());
        
        //make sure can't add more than max
        for (int i = 1; i < MAX_VEHICLES; i++)
        {
            Vehicle v2 = new Car();
            v2.setVIN(String.format("%d", i));
            assertTrue("Could not add a vehicle as expected"
                        , al.AddVehicle(v2));
        }
        Vehicle v2 = new Car();
        v2.setVIN(String.format("%d", MAX_VEHICLES));
        assertFalse("Should not be able to add a vehicle when"
                + " the lot is full"
                , al.AddVehicle(v2));
    }
    
    /**
     * Test removing vehicles
     */
    public void testRemoveVehicle()
    {
        //make sure cannot remove a null
        assertFalse("Should not be able to remove a null vehicle"
                    , al.RemoveVehicle(null));
        
        //add a Vehicle to try to remove later
        al.AddVehicle(v);
        assertEquals("Vehicle count was not as expected in remove testing"
                    , 1
                    , al.getVehicleCount());
        
        //make sure can't remove a non-existing vehicle
        assertFalse("Should not be able to remove a vehicle not in the system"
                    , al.RemoveVehicle("1231241"));
        //make sure that the count was not altered
        assertEquals("Vehicle count should not change when a vehicle"
                + " is not removed from the system."
                    , 1
                    , al.getVehicleCount());
        
        //add another vehicle so when removing not just removing the only 
        //vehicle
        Vehicle v2 = new Car();
        v2.setVIN("1234");
        al.AddVehicle(v2);
        assertEquals("Vehicle count should have increased"
                + " after adding a valid vehicle."
                    , 2
                    , al.getVehicleCount());
        
        //make sure can remove a vehicle that exists
        assertTrue("Should be able to remove a vehicle that exists"
                    , al.RemoveVehicle(v.getVIN()));
        //make sure count is correct
        assertEquals("Vehicle count should only decrease by one"
                + " when a vehicle is removed from the system."
                    , 1
                    , al.getVehicleCount());
        
        //make sure can't remove a vehicle already removed
        assertFalse("Should not be able to remove a vehicle that doesn't exist"
                    , al.RemoveVehicle(v.getVIN()));
        assertEquals("Vehicle count should not decrease"
                + " when a vehicle is not removed from the system."
                    , 1
                    , al.getVehicleCount());
        
        //make sure can remove the last vehicle from the system
        assertTrue("Could not remove a valid vehicle from the system"
                    , al.RemoveVehicle(v2.getVIN()));
        assertEquals("Vehicle count should be zero"
                + " when all vehicles are removed from the system."
                    , 0
                    , al.getVehicleCount());
        
    }
    
    /**
     * Test toString()
     */
    public void testToString()
    {
        //following the same pattern as before,
        //just going to test that vehicles are listed.
        //add a Vehicle to try to remove later
        al.AddVehicle(v);
        assertEquals("Vehicle count was not as expected in toString testing"
                    , 1
                    , al.getVehicleCount());
        
        Vehicle v2 = new Car("aMake", "aModel", 2010
                                , 235.4, "aVIN");
        al.AddVehicle(v2);
        assertEquals("Vehicle count was not as expected in toString testing"
                    , 2
                    , al.getVehicleCount());
        
        //make sure both vehicles are contained
        String alString = al.toString();
        assertTrue("The autolot toString does not contain the vehicle details"
                + " as expected"
                , alString.contains(v.toString()));
        
        assertTrue("The autolot toString does not contain the vehicle details"
                + " as expected"
                , alString.contains(v2.toString()));
        
    }
    
}