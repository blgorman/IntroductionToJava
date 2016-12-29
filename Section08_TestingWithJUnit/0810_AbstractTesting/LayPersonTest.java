

/**
 *
 * @author Brian
 */
public class LayPersonTest extends PersonTest {
    LayPerson x;
    
    public void setUp() {
        x = new LayPerson(firstNameActual, lastNameActual, ageActual);
    }
    
    public void tearDown() {
    }

    /**
     * Factory to get default Person
     * @return Person with nothing set.
     */
    public Person getDefaultPerson() {
        return new LayPerson();
    }

    /**
     * Explicit person factory.
     * @return a person with properties set.
     */
    public Person getExplicitPerson() {
        return new LayPerson(firstNameActual, lastNameActual, ageActual);
    }
    
    /* have to test toString, equality and comparability because
     * they can't be equal or comparable if they aren't of the exact same type 
     */
    public void testToString()
    {
        String personString = x.toString();
        assertTrue("Person toString does not contain firstName"
                    , personString.contains(firstNameActual));
        assertTrue("Person toString does not contain lastName"
                    , personString.contains(lastNameActual));
        assertTrue("Person toString does not contain age"
                    , personString.contains(String.format("%d", ageActual)));
    }
    
    /**
     * Test Comparability.
     */
    public void testComparability()
    {
        Object o = null;
        Object o2 = "This is really a String";
        Person p = getDefaultPerson();
        Person p2 = getExplicitPerson();
        
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
    
    /**
     * Test Equality.
     */
    public void testEquality()
    {
        Object o = null;
        Object o2 = "This is really a String";
        Person p = getDefaultPerson(); //new Person();
        Person p2 = getExplicitPerson(); //new Person(firstNameActual, lastNameActual, ageActual);
        
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
}