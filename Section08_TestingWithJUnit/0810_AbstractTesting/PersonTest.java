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
    
    /******
     * We might be tempted to write comparable and Equality testing here
     * After all, why not leverage all the common things about
     * equality and comparability, and then just override the small details
     * in the more-specific test, right?
     * Problem: We're testing abstractly, so the object coming in is a 
     * Person, but it's really a more-specific person.  While it IS possible
     * to test the common properties at the base level, a Doctor or a Commander
     * will NEVER be equal to just a person.  You can go from more specific to 
     * less specific, but you CANNOT go from less specific to more specific 
     * without a cast.  Leaving the property null will also be a problem because
     * it can still come up as a null pointer.  Therefore, instead of writing the
     * code here, we need to declare it abstract, and force that it is written
     * in each individual subclass.  This ensures that proper equality and
     * comparability on proper objects.
     * The 'default object': LayPerson will simply implement this base code
     * The other objects will implement the same code and will also modify it
     * to test for the specific items for that class.
     */
    
    /**
     * Testing our toString() method.
     */
    /*
    public void testToString()
    {
        x = getExplicitPerson();
        String personString = x.toString();
        assertTrue("Person toString does not contain firstName"
                    , personString.contains(firstNameActual));
        assertTrue("Person toString does not contain lastName"
                    , personString.contains(lastNameActual));
        assertTrue("Person toString does not contain age"
                    , personString.contains(String.format("%d", ageActual)));
    }
    */
    
    /**
     * Test comparable properties.
     */
    /*
    public void testComparability()
    {
        Object o = null;
        Object o2 = "This is really a String";
        Person p = getDefaultPerson();
        Person p2 = getExplicitPerson();
        
        //x = new Person(firstNameActual, lastNameActual, ageActual);
        x = getExplicitPerson();
        //cannot compare against null, so we are coding this to
        //return 1.  We have to remember here -- this is how we
        //coded it for this system.  It could have been different elsewhere!
        assertEquals("Null value should be less than our person!"
                        , expected1, x.compareTo(o));
        //cannot compare against non person, we stated that person
        //would be greater if the value is null or not a person
        //so again this is arbitrary based on our system
        assertEquals("Non-person should be less than our person!"
                        , expected1, x.compareTo(o));
        
        
        //now we need to test our comparable algorithm --
        assertEquals("Person with nothing set should be less than"
                        + " our person"
                        , expected1
                        , x.compareTo(p));
        //set the last name to match:
        p.setLastName(lastNameActual);
        
        //now we need to test when person last name is not null (and matches)
        //and matches but first name is null
        //testing again reveals we must take null values into account!
        assertEquals("Person with no first name and matching last name"
                        + " should be less than our person"
                        , expected1
                        , x.compareTo(p));
        
        //set the first name to match:
        p.setFirstName(firstNameActual);
        //note: Integers are never null --> they are set to 0
        assertEquals("Person with matching first and last name but no age"
                        + " should be less than our person"
                        , expected1
                        , x.compareTo(p));
        
        //set the age to mach
        p.setAge(ageActual);
        assertEquals("Person with matching first and last name and same age"
                        + " should be equal to our person"
                        , expected0
                        , x.compareTo(p));
        
        
        //test expected results for 0/1/-1 on last name
        p.setLastName("Zimmer");
        assertEquals("Person with greater last name should be greater "
                        + " than our person"
                        , expectedm1
                        , x.compareTo(p));
        
        p.setLastName("Andrews");
        assertEquals("Person with lesser last name should be less "
                        + " than our person"
                        , expected1
                        , x.compareTo(p));
        
        
        p.setLastName(lastNameActual);
        assertEquals("Person with matching first and last name and same age"
                        + " should be equal to our person"
                        , expected0
                        , x.compareTo(p));
        
        //test expected results for 0/1/-1 on first name
        p.setFirstName("Zane");
        assertEquals("Person with greater first name should be greater "
                        + " than our person"
                        , expectedm1
                        , x.compareTo(p));
        
        p.setFirstName("Andrews");
        assertEquals("Person with lesser first name should be less "
                        + " than our person"
                        , expected1
                        , x.compareTo(p));
        
        p.setFirstName(firstNameActual);
        assertEquals("Person with matching first and last name and same age"
                        + " should be equal to our person"
                        , expected0
                        , x.compareTo(p));
        
        //test expected results for 0/1/-1 on age
        p.setAge(1000);
        assertEquals("Person with greater age should be greater "
                        + " than our person"
                        , expectedm1
                        , x.compareTo(p));
        
        p.setAge(0);
        assertEquals("Person with lesser age should be less "
                        + " than our person"
                        , expected1
                        , x.compareTo(p));
        
        p.setAge(ageActual);
        assertEquals("Person with matching first and last name and same age"
                        + " should be equal to our person"
                        , expected0
                        , x.compareTo(p));
        
        //verify that an instant match is a match:
        assertEquals("Person with same first and last names and age"
                        + " should be equal to our person"
                        , expected0
                        , x.compareTo(p2));
    }
    */
    
    /**
     * Test equality.
     */
    /*
    public void testEquality()
    {
        Object o = null;
        Object o2 = "This is really a String";
        Person p = getDefaultPerson(); //new Person();
        Person p2 = getExplicitPerson(); //new Person(firstNameActual, lastNameActual, ageActual);
        
        //x = new Person(firstNameActual, lastNameActual, ageActual);
        x = getExplicitPerson();
        //first, make sure it's false if the value is null
        assertFalse("Object cannot be equal to a null object"
                        , x.equals(o));
        //next, make sure it's false if the value is not a Person
        assertFalse("Object cannot be equal to an object of "
                    + "a different type"
                        , x.equals(o2));
        
        //make sure the equality is false if any of the parameters don't match
        //even if the type is the same
        assertFalse("Object cannot be equal if lastNames are not"
                + " the same"
                    , x.equals(p));
        //set to match to test
        p.setLastName(lastNameActual);
        //guarantee it is working
        assertTrue("Last names don't match when they should"
                    , x.getLastName().equals(p.getLastName()));
         
        //make sure equality is still false
        assertFalse("Object cannot be equal if first names are not"
               + " the same"
                   , x.equals(p));
        
        //set to match to test
        p.setFirstName(firstNameActual);
        assertTrue("First names don't match when they should"
                    , x.getFirstName().equals(p.getFirstName()));
        
        //make sure equality is still false
        assertFalse("Object cannot be equal if ages are not"
                    + " the same"
                    , x.equals(p));
        p.setAge(ageActual);
        //make sure they are the same
        assertEquals("Ages don't match when they should"
                    , x.getAge(),p.getAge());
         
        //now they should be equal
        assertTrue("1 Object should be equal when first and last name "
                    + " are the same, and age is the same"
                    , x.equals(p));
        
        //finally, make sure objects are equal from explicit constructor
        assertTrue("2 Object should be equal when first and last name "
                    + " are the same, and age is the same"
                    , x.equals(p2));
    }   
    */
    
    public abstract void testToString();
    public abstract void testEquality();
    public abstract void testComparability();
}