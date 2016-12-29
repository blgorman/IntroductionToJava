/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Brian
 */
public class CommanderTest extends PersonTest {
    Commander c; 
    Commander c1;
    Commander c2;
    Commander c3;
    Commander c4;
    private String rank = "Captain";
    private String serialNumber = "1234567890";
    
    public void setUp() {
        c = new Commander();
        c1 = new Commander(firstNameActual, lastNameActual
                                , ageActual, "Admiral", serialNumber);
        c4 = new Commander (firstNameActual, lastNameActual
                                , ageActual, rank, "2345678901");
        c2 = new Commander(firstNameActual, lastNameActual
                            , ageActual, rank, serialNumber);
        c3 = new Commander(firstNameActual, lastNameActual
                            , ageActual, rank, serialNumber);
    }
    
    public void tearDown() {
    }

    /**
     * Factory to get default Person
     * @return Person with nothing set.
     */
    public Person getDefaultPerson() {
        return new Commander();
    }

    /**
     * Explicit person factory.
     * @return a person with properties set.
     */
    public Person getExplicitPerson() {
        return new Commander(firstNameActual, lastNameActual
                , ageActual, rank, serialNumber);
    }

    /**
     * Test the toString() method.
     */
    public void testToString()
    {
        String commanderString = c3.toString();
        assertTrue("Person toString does not contain firstName"
                    , commanderString.contains(firstNameActual));
        assertTrue("Person toString does not contain lastName"
                    , commanderString.contains(lastNameActual));
        assertTrue("Person toString does not contain age"
                    , commanderString.contains(String.format("%d", ageActual)));
        assertTrue("Commander toString does not contain rank"
                    , commanderString.contains(rank));
        assertTrue("Commander toString does not contain serial number"
                    , commanderString.contains(serialNumber));
    }
    
    /** 
     * Test Comparability
     */
    public void testComparability()
    {
        Object o = null;
        Object o2 = "This is really a String";

        //cannot compare to a null object
        assertEquals("Null value should be less than our person!"
                        , expected1, c3.compareTo(o));
        //cannot compare against non commander
        assertEquals("Non-person should be less than our person!"
                        , expected1, c3.compareTo(o));
        
        
        //now we need to test our comparable algorithm --
        assertEquals("Commander with nothing set should be less than"
                        + " our Commander"
                        , expected1
                        , c3.compareTo(c));
        //set the last name to match:
        c.setLastName(lastNameActual);
        
        //now we need to test when person last name is not null (and matches)
        //and matches but first name is null
        //testing again reveals we must take null values into account!
        assertEquals("Commander with no first name and matching last name"
                        + " should be less than our Commander"
                        , expected1
                        , c3.compareTo(c));
        
        //set the first name to match:
        c.setFirstName(firstNameActual);
        //note: Integers are never null --> they are set to 0
        assertEquals("Commander with matching first and last name but no age"
                        + " should be less than our Commander"
                        , expected1
                        , c3.compareTo(c));
        
        //set the age to match
        c.setAge(ageActual);
        assertEquals("Commander with matching first and last name and same age"
                        + " but no rank should be less than our Commander"
                        , expected1
                        , c3.compareTo(c));
        
        //set the rank
        c.setRank(rank);
        assertEquals("Commander with matching first and last name, same age"
                        + " and rank but no serial number "
                        + "should not be equal to our Doctor"
                    , expected1
                    , c3.compareTo(c));
        
        //set the serial number
        c.setSerialNumber(serialNumber);
        assertEquals("Commander with matching first and last name, same age"
                        + " and rank, and serial number "
                        + "should be equal to our Doctor"
                    , expected0
                    , c3.compareTo(c));
        
        
        //test expected results for 0/1/-1 on last name
        c.setLastName("Zimmer");
        assertEquals("Commander with greater last name should be greater "
                        + " than our Commander"
                        , expectedm1
                        , c3.compareTo(c));
        
        c.setLastName("Andrews");
        assertEquals("Commander with lesser last name should be less "
                        + " than our Commander"
                        , expected1
                        , c3.compareTo(c));
        
        
        c.setLastName(lastNameActual);
        assertEquals("Commander with matching first and last name, same age"
                        + " and rank, and serial number "
                        + "should be equal to our Commander"
                    , expected0
                    , c3.compareTo(c));
        
        //test expected results for 0/1/-1 on first name
        c.setFirstName("Zane");
        assertEquals("Commander with greater first name should be greater "
                        + " than our Commander"
                        , expectedm1
                        , c3.compareTo(c));
        
        c.setFirstName("Andrews");
        assertEquals("Commander with lesser first name should be less "
                        + " than our Commander"
                        , expected1
                        , c3.compareTo(c));
        
        c.setFirstName(firstNameActual);
        assertEquals("Commander with matching first and last name, same age"
                        + " and rank, and serial number "
                        + "should be equal to our Commander"
                    , expected0
                    , c3.compareTo(c));
        
        //test expected results for 0/1/-1 on age
        c.setAge(1000);
        assertEquals("Commander with greater age should be greater "
                        + " than our Commander"
                        , expectedm1
                        , c3.compareTo(c));
        
        c.setAge(0);
        assertEquals("Commander with lesser age should be less "
                        + " than our Commander"
                        , expected1
                        , c3.compareTo(c));
        
        c.setAge(ageActual);
        assertEquals("Commander with matching first and last name, same age"
                        + " and rank, and serial number "
                        + "should be equal to our Commander"
                    , expected0
                    , c3.compareTo(c));
        
        //test expected results for 0/1/-1 on Rank
        c.setRank("ZZZ");
        assertEquals("Commander with greater rank should be greater "
                        + " than our Commander"
                        , expectedm1
                        , c3.compareTo(c));
        
        c.setRank("AAAAA");
        assertEquals("Commander with lesser rank should be less "
                        + " than our Commander"
                        , expected1
                        , c3.compareTo(c));
        
        c.setRank(rank);
        assertEquals("Commander with matching first and last name, same age"
                        + " and rank, and serial number "
                        + "should be equal to our Commander"
                    , expected0
                    , c3.compareTo(c));
        
        //test expected results for 0/1/-1 on serial number
        c.setSerialNumber("99999");
        assertEquals("Commander with greater serialnumber should be greater "
                        + " than our Commander"
                        , expectedm1
                        , c3.compareTo(c));
        
        c.setSerialNumber("0000");
        assertEquals("Commander with lesser serialnumber should be less "
                        + " than our Commander"
                        , expected1
                        , c3.compareTo(c));
        
        c.setSerialNumber(serialNumber);
        assertEquals("Commander with matching first and last name, same age"
                        + " and rank, and serial number "
                        + "should be equal to our Commander"
                    , expected0
                    , c3.compareTo(c));
        
        //verify that an instant match is a match:
        assertEquals("Commander with matching first and last name, same age"
                        + " rank, and serial number "
                        + "should be equal to our Doctor"
                        , expected0
                        , c3.compareTo(c2));
    }
    
    /**
     * Test Equality
     */
    public void testEquality()
    {
        Object o = null;
        Object o2 = "This is really a String";
        
        //first, make sure it's false if the value is null
        assertFalse("Object cannot be equal to a null object"
                        , c3.equals(o));
        //next, make sure it's false if the value is not a Person
        assertFalse("Object cannot be equal to an object of "
                    + "a different type"
                        , c3.equals(o2));
        
        //make sure the equality is false if any of the parameters don't match
        //even if the type is the same
        assertFalse("Object cannot be equal if lastNames are not"
                + " the same"
                    , c3.equals(c));
        //set to match to test
        c.setLastName(lastNameActual);
        //guarantee it is working
        assertTrue("Last names don't match when they should"
                    , c3.getLastName().equals(c.getLastName()));
         
        //make sure equality is still false
        assertFalse("Object cannot be equal if first names are not"
               + " the same"
                   , c3.equals(c));
        
        //set to match to test
        c.setFirstName(firstNameActual);
        assertTrue("First names don't match when they should"
                    , c3.getFirstName().equals(c.getFirstName()));
        
        //make sure equality is still false
        assertFalse("Object cannot be equal if ages are not"
                    + " the same"
                    , c3.equals(c));
        c.setAge(ageActual);
        //make sure they are the same
        assertEquals("Ages don't match when they should"
                    , c3.getAge(),c.getAge());
        
        //make sure the objects are still not equal
        assertFalse("Object cannot be equal if specialities are not"
                    + " the same"
                    , c3.equals(c));
        
        //check the equality on rank
        c.setRank(rank);
        assertEquals("Ranks don't match when they should"
                    , c3.getRank(),c.getRank());
        
        //still not equal
        assertFalse("Objects should not be equal when first and last"
                + " name are the same, age and rank are the same"
                + " but serial numbers do not match"
                    , c3.equals(c));
        
        //check the equality on serial
        c.setSerialNumber(serialNumber);
        assertEquals("Serial Numbers don't match when they should"
                    , c3.getSerialNumber(),c.getSerialNumber());
        
        
        //now they should be equal
        assertTrue("Objects should be equal when first and last name "
                    + " are the same, and age, rank, and serial"
                    + " are the same"
                    , c3.equals(c));
        
        //finally, make sure objects are equal from explicit constructor
        assertTrue("Objects should be equal when first and last name "
                    + " are the same, and age, rank, and serial"
                    + " are the same"
                    , c3.equals(c2));
        
        //and make sure unequal objects are unequal
        assertFalse("Objects that do not have the same rank should"
                    + " be unequal"
                    , c3.equals(c1));
        assertFalse("Objects that do not have the same serial number"
                    + " should not be equal"
                    , c3.equals(c4));
    }
}