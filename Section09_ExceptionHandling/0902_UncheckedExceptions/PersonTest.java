/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public abstract class PersonTest extends junit.framework.TestCase {
    private Person x;
    private Person y;
    protected String firstNameActual = "John";
    protected String lastNameActual = "Doe";
    protected int ageActual = 50;
    protected int expected1 = 1;
    protected int expected0 = 0;
    protected int expectedm1 = -1;
    //Have to get the Person from a subclass factory
    //now that person is abstract.
    //all will still be able to easily cast to abstract Person
    //and therefore any subclass can be used to test the
    //abstract class code.
    public abstract Person getDefaultPerson();
    public abstract Person getExplicitPerson();
    
    public PersonTest(){
        x = getDefaultPerson();
        y = getExplicitPerson();
    }
    
    public void setUp() {
    }
    
    public void tearDown() {
        
    }
    /**
     * Test the constructors.
     */
    public void testConstructor(){
        //can't make new abstract Person.  Have to rely on factory.
        //x = new Person();
        assertNotNull("Person was null", x);
        
        //can't make new Abstract Person. Have to rely on factory.
        //x = new Person(firstNameActual, lastNameActual, ageActual);
        x = getExplicitPerson();
        assertNotNull("Person was null", x);
        assertEquals("First name not set correctly"
                        , firstNameActual
                        , x.getFirstName());
        assertEquals("Last name not set correctly"
                        , lastNameActual
                        , x.getLastName());
        assertEquals("Age not set correctly"
                        , ageActual
                        , x.getAge());
    }
    
    /**
     * This is our mutator/accessor testing.
     */
    public void testGetSetValues(){
        //x = new Person();
        
        x.setFirstName(firstNameActual);
        assertEquals("First name not set correctly"
                        , firstNameActual
                        , x.getFirstName());
    
        x.setLastName(lastNameActual);
        assertEquals("Last name not set correctly"
                        , lastNameActual
                        , x.getLastName());
        
        x.setAge(ageActual);
        assertEquals("Age not set correctly"
                        , ageActual
                        , x.getAge());
    }
   
    public abstract void testToString();
    public abstract void testEquality();
    public abstract void testComparability();
}