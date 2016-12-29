/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brian
 */
public class MustRefuelExceptionTest extends junit.framework.TestCase{
    
    public void setUp() {
    }
    
    public void tearDown() {
    }
   
    public void testExceptions()
    {
        MustRefuelException mre = new MustRefuelException();
        assertNotNull("Could not create default exception", mre);
        assertEquals("Message for default mre was not as expected"
                        , "Vehicle is out of fuel.  Add fuel to continue..."
                        , mre.getMessage());
        
        MustRefuelException mre2 = new MustRefuelException("Fill car with gas.");
        assertNotNull("Could not create explicit exception", mre2);
        assertEquals("Message for explicit mre was not as expected"
                        , "Fill car with gas."
                        , mre2.getMessage());
        
    }
}