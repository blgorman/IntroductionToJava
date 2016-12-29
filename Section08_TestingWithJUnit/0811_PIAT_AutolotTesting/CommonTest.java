
/**
 *
 * @author Brian
 */
public class CommonTest extends junit.framework.TestCase  {
    
    public CommonTest() {
    }
    
    public void setUp() {
    }
    
    public void tearDown() {
    }
    
    public void testConstructors()
    {
        Common c = new Common();
        assertNotNull("Could not create a new Common class from default "
                + "constructor.", c);
    }
    
    /**
     * Test the stars method.
     */
    public void testStars()
    {
        //since stars is static, we don't need a new common
        String s = "**********";
        String s2 = Common.Stars(10);
        assertTrue("Returned string is not long enough"
                        , s2.length() == 10);
        assertTrue("Returned string does not match expected."
                        , s2.equals(s));
    }
    
    /**
     * Test the dashes method
     */
    public void testDashes()
    {
        //since stars is static, we don't need a new common
        String s = "----------";
        String s2 = Common.Dashes(10);
        assertTrue("Returned string is not long enough"
                        , s2.length() == 10);
        assertTrue("Returned string does not match expected."
                        , s2.equals(s));
    }
}