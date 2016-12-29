/**
 *
 * @author Brian
 */
public class DoctorTest extends PersonTest {
    private String specialty = "Surgeon";
    Doctor d; 
    Doctor d1;
    Doctor d2;
    Doctor d3;
    
    public void setUp() {
        d = new Doctor();
        d1 = new Doctor(firstNameActual, lastNameActual
                                , ageActual, "Anesthesiologist");
        d2 = new Doctor(firstNameActual, lastNameActual
                            , ageActual, specialty);
        d3 = new Doctor(firstNameActual, lastNameActual
                            , ageActual, specialty);
    }
    
    public void tearDown() {
    }

    /**
     * Factory to get default Person
     * @return Person with nothing set.
     */
    public Person getDefaultPerson() {
        return new Doctor();
    }

    /**
     * Explicit person factory.
     * @return a person with properties set.
     */
    public Person getExplicitPerson() {
        return new Doctor(firstNameActual, lastNameActual
                , ageActual, "DoctorType 1");
    }
    
    /*
     * And if we had a bast testing the common stuff
     * all we'd have to do here is testing equality and
     * comparability on the specific properties.
     * But this won't work, because, as we stated in the base class
     * we can't have a Person that is Equal to a doctor.
    public void testToString()
    {
        String doctorString = d3.toString();
        assertTrue("Doctor toString does not contain specialty"
                    , doctorString.contains(specialty));
    }
    
    public void testDoctorEquality()
    {
        assertFalse("Doctors with different specialties should "
                + " not be equal", d1.equals(d2));
        assertTrue("Doctors with the same specialties should "
                + " be equal", d2.equals(d3));
    }
    
    public void testDoctorComparability()
    {
        assertEquals("A doctor that is less than another doctor"
                + " should return -1 when compared"
                , expectedm1
                , d1.compareTo(d2));
    }
    */
    
    /**
     * Test the toString() method.
     */
    public void testToString()
    {
        String doctorString = d3.toString();
        assertTrue("Person toString does not contain firstName"
                    , doctorString.contains(firstNameActual));
        assertTrue("Person toString does not contain lastName"
                    , doctorString.contains(lastNameActual));
        assertTrue("Person toString does not contain age"
                    , doctorString.contains(String.format("%d", ageActual)));
        assertTrue("Doctor toString does not contain specialty"
                    , doctorString.contains(specialty));
    }
    
    /** 
     * Test Comparability
     */
    public void testComparability()
    {
        Object o = null;
        Object o2 = "This is really a String";
        
        //x = new Person(firstNameActual, lastNameActual, ageActual);
        //x = getExplicitPerson();
        //use D3 as x
        //use d as p and d2 as p2
        
        //cannot compare against null, so we are coding this to
        //return 1.  We have to remember here -- this is how we
        //coded it for this system.  It could have been different elsewhere!
        assertEquals("Null value should be less than our person!"
                        , expected1, d3.compareTo(o));
        //cannot compare against non person, we stated that person
        //would be greater if the value is null or not a person
        //so again this is arbitrary based on our system
        assertEquals("Non-person should be less than our person!"
                        , expected1, d3.compareTo(o));
        
        
        //now we need to test our comparable algorithm --
        assertEquals("Doctor with nothing set should be less than"
                        + " our Doctor"
                        , expected1
                        , d3.compareTo(d));
        //set the last name to match:
        d.setLastName(lastNameActual);
        
        //now we need to test when person last name is not null (and matches)
        //and matches but first name is null
        //testing again reveals we must take null values into account!
        assertEquals("Doctor with no first name and matching last name"
                        + " should be less than our Doctor"
                        , expected1
                        , d3.compareTo(d));
        
        //set the first name to match:
        d.setFirstName(firstNameActual);
        //note: Integers are never null --> they are set to 0
        assertEquals("Doctor with matching first and last name but no age"
                        + " should be less than our Doctor"
                        , expected1
                        , d3.compareTo(d));
        
        //set the age to match
        d.setAge(ageActual);
        assertEquals("Doctor with matching first and last name and same age"
                        + " but no specialty should be less than our doctor"
                        , expected1
                        , d3.compareTo(d));
        
        //set the specialty to match
        d.setSpecialty(specialty);
        assertEquals("Doctor with matching first and last name, same age"
                        + " and specialty should be equal to our Doctor"
                    , expected0
                    , d3.compareTo(d));
        
        
        //test expected results for 0/1/-1 on last name
        d.setLastName("Zimmer");
        assertEquals("Doctor with greater last name should be greater "
                        + " than our Doctor"
                        , expectedm1
                        , d3.compareTo(d));
        
        d.setLastName("Andrews");
        assertEquals("Doctor with lesser last name should be less "
                        + " than our Doctor"
                        , expected1
                        , d3.compareTo(d));
        
        
        d.setLastName(lastNameActual);
        assertEquals("Doctor with matching first and last name, same age"
                        + " and specialty should be equal to our Doctor"
                        , expected0
                        , d3.compareTo(d));
        
        //test expected results for 0/1/-1 on first name
        d.setFirstName("Zane");
        assertEquals("Doctor with greater first name should be greater "
                        + " than our Doctor"
                        , expectedm1
                        , d3.compareTo(d));
        
        d.setFirstName("Andrews");
        assertEquals("Doctor with lesser first name should be less "
                        + " than our Doctor"
                        , expected1
                        , d3.compareTo(d));
        
        d.setFirstName(firstNameActual);
        assertEquals("Doctor with matching first and last name, same age"
                        + " and specialty should be equal to our Doctor"
                        , expected0
                        , d3.compareTo(d));
        
        //test expected results for 0/1/-1 on age
        d.setAge(1000);
        assertEquals("Doctor with greater age should be greater "
                        + " than our Doctor"
                        , expectedm1
                        , d3.compareTo(d));
        
        d.setAge(0);
        assertEquals("Doctor with lesser age should be less "
                        + " than our Doctor"
                        , expected1
                        , d3.compareTo(d));
        
        d.setAge(ageActual);
        assertEquals("Doctor with matching first and last name, same age"
                        + " and specialty should be equal to our Doctor"
                        , expected0
                        , d3.compareTo(d));
        
        //test expected results for 0/1/-1 on specialty
        d.setSpecialty("ZZZ");
        assertEquals("Doctor with greater specialty should be greater "
                        + " than our Doctor"
                        , expectedm1
                        , d3.compareTo(d));
        
        d.setSpecialty("AAAAA");
        assertEquals("Doctor with lesser specialty should be less "
                        + " than our Doctor"
                        , expected1
                        , d3.compareTo(d));
        
        d.setSpecialty(specialty);
        assertEquals("Doctor with matching first and last name, same age"
                        + " and specialty should be equal to our Doctor"
                        , expected0
                        , d3.compareTo(d));
        
        //verify that an instant match is a match:
        assertEquals("Doctor with matching first and last name, same age"
                        + " and specialty should be equal to our Doctor"
                        , expected0
                        , d3.compareTo(d2));
    }
    
    /**
     * Test Equality
     */
    public void testEquality()
    {
        Object o = null;
        Object o2 = "This is really a String";
        //Person p = getDefaultPerson(); //new Person();
        //Person p2 = getExplicitPerson(); //new Person(firstNameActual, lastNameActual, ageActual);
        //use d = p; d2 = p2, x = d3
        
        //x = new Person(firstNameActual, lastNameActual, ageActual);
        
        //first, make sure it's false if the value is null
        assertFalse("Object cannot be equal to a null object"
                        , d3.equals(o));
        //next, make sure it's false if the value is not a Person
        assertFalse("Object cannot be equal to an object of "
                    + "a different type"
                        , d3.equals(o2));
        
        //make sure the equality is false if any of the parameters don't match
        //even if the type is the same
        assertFalse("Object cannot be equal if lastNames are not"
                + " the same"
                    , d3.equals(d));
        //set to match to test
        d.setLastName(lastNameActual);
        //guarantee it is working
        assertTrue("Last names don't match when they should"
                    , d3.getLastName().equals(d.getLastName()));
         
        //make sure equality is still false
        assertFalse("Object cannot be equal if first names are not"
               + " the same"
                   , d3.equals(d));
        
        //set to match to test
        d.setFirstName(firstNameActual);
        assertTrue("First names don't match when they should"
                    , d3.getFirstName().equals(d.getFirstName()));
        
        //make sure equality is still false
        assertFalse("Object cannot be equal if ages are not"
                    + " the same"
                    , d3.equals(d));
        d.setAge(ageActual);
        //make sure they are the same
        assertEquals("Ages don't match when they should"
                    , d3.getAge(),d.getAge());
        
        //make sure the objects are still not equal
        assertFalse("Object cannot be equal if specialities are not"
                    + " the same"
                    , d3.equals(d));
        
        //check the equality on specialty
        d.setSpecialty(specialty);
        assertEquals("Specialties don't match when they should"
                    , d3.getSpecialty(),d.getSpecialty());
        
        //now they should be equal
        assertTrue("Object should be equal when first and last name "
                    + " are the same, and age and specialty"
                    + " are the same"
                    , d3.equals(d));
        
        //finally, make sure objects are equal from explicit constructor
        assertTrue("Object should be equal when first and last name "
                    + " are the same, and age and specialty"
                    + " are the same"
                    , d3.equals(d2));
        
        //and make sure unequal objects are unequal
        assertFalse("Objects that do not have the same specialty should"
                    + " be unequal"
                    , d3.equals(d1));
    }
}