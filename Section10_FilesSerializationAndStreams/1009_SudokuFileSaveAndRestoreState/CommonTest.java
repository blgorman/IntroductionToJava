/**
 * Because all the videos used a custom testing scheme, where we name
 * all methods with testXYZ and then we just run that that way
 * I also want to leave this last in "default" mode.  The testXYZ allows
 * for students using BlueJ to easily port their code.
 * However, in more advanced editors such as Netbeans and Eclipse it is 
 * not necessary.  Furthermore, more advanced editors may use @Test as
 * a point of entry for each test.  For that reason, I'm going to leave
 * the Sudoku code in Native testing mode for Netbeans.  
 * 
 * Therefore, if you are trying to port this to BlueJ, you'll need
 * to extend the junit framework on the test class and also you'll need
 * to remove all the @Test directives and rename the test methods to start 
 * with the lowercase 'test...'
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing the Common Class
 * @author Brian
 */
public class CommonTest {
    private final String number1 = "1";
    private final String numberMinus1 = "-1";
    private final String notANumber = "NotANumber";
    private final String number1Point0 = "1.0";
    private final String numberMinus1Point0 = "-1.0";
    private final String stringA = "Alpha";
    private final String stringAB = "AlphaBeta";
    private final String stringZ = "Zulu";

    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test the Validate number method.
     * ***Please read the notes at the top of the class
     *    if you are confused as to why these tests look different
     */
    @Test
    public void ValidateNumberTest()
    {
        //validate number has two signatures to test.
        //one takes only the number and does not ignore - and .
        //the other takes the number and a boolean override to ignore the - and
        //.
        assertTrue("A valid number string should be correctly validated"
                        , Common.ValidateNumber(number1));
        assertFalse("A valid number with no override should be "
                + " invalid"
                        , Common.ValidateNumber(numberMinus1));
        assertFalse("A valid number with no override should be "
                + " invalid"
                        , Common.ValidateNumber(number1Point0));
        assertFalse("An invalid number should be invalid"
                        , Common.ValidateNumber(notANumber));
        
        assertTrue("A valid number with override should be correctly "
                + "validated"
                        , Common.ValidateNumber(number1, true));
        assertTrue("A valid number without override and no bad chars "
                + "should be validated"
                        , Common.ValidateNumber(number1, false));
        assertTrue("A valid number with override should be correctly "
                + "validated"
                        , Common.ValidateNumber(numberMinus1, true));
        assertTrue("A valid number with override should be correctly "
                + "validated"
                        , Common.ValidateNumber(number1Point0, true));
        assertTrue("A valid number with override should be correctly "
                + "validated"
                        , Common.ValidateNumber(numberMinus1Point0, true));
        assertFalse("An invalid number with override should not be valid"
                        , Common.ValidateNumber(notANumber, true));
    }
    
    /**
     * Validate that a double in a String object is a number.
     * (Is it really that hard/bad to just preface tests with 'test...')
     * I'm going to do that for the rest of the tests.  Your convention
     * will be up to you, of course.
     * Also note: 
     * I made ValidateDouble method access 
     * public as it was private before. It is not being used, 
     * but still needs to be tested in case it is used in the future.
     */
    @Test
    public void testValidateDouble()
    {
        assertTrue("A valid number with override should be correctly "
                + "validated"
                        , Common.ValidateDouble(numberMinus1));
        assertTrue("A valid number with override should be correctly "
                + "validated"
                        , Common.ValidateDouble(number1Point0));
        assertTrue("A valid number with override should be correctly "
                + "validated"
                        , Common.ValidateDouble(numberMinus1Point0));
        assertFalse("An invalid number with override should not be valid"
                        , Common.ValidateDouble(notANumber));
    }
    
    /**
     * Test the ability to get the first char of a String as a String
     */
    @Test
    public void testGetFirstCharAsString()
    {
        //make sure the strings returned are only one char long
        
        assertEquals("A call to the GetFirstCharAsString() method "
                    + "should return a String with only one character."
                    , 1
                    , Common.GetFirstCharAsString(stringA).length());
        assertEquals("A call to the GetFirstCharAsString() method "
                    + "should return a String with only one character."
                    , 1
                    , Common.GetFirstCharAsString(stringAB).length());
        
        //and have the correct starting character.
        assertEquals("A call to the GetFirstCharAsString() method "
                    + "did not return the expected character "
                    + "as a String"
                    , "A"
                    , Common.GetFirstCharAsString(stringA));
        assertEquals("A call to the GetFirstCharAsString() method "
                    + "did not return the expected character "
                    + "as a String"
                    , "A"
                    , Common.GetFirstCharAsString(stringAB));
        assertEquals("A call to the GetFirstCharAsString() method "
                    + "did not return the expected character "
                    + "as a String"
                    , "Z"
                    , Common.GetFirstCharAsString(stringZ));
    }
    
    /**
     * Test the stars/dashes method.
     * //there really should be an override to just 
     * //have this method pass in the single char that
     * //we want to repeat.  Therefore, I'm going to
     * //nix this method and fix the code to use the new
     * //one.  This is evident when testing that we have
     * //some easily refactored code to prevent duplication
     * 
     * //Final note: 
     * //This method (along with Stars and Dashes) are not even used
     * //in Sudoku anymore.  However, we'll keep them in our utility class
     * //because we may package it separately in the future to use
     * //in other systems which might need this type of method.
     */
    @Test
    public void testCharacterGenerationString()
    {
        //since we're allowing any string, need to make sure to account
        //for non 1-character strings
        int testLen = 2;
        int lenABTimesLen = stringAB.length() * testLen;
        String expected = "AlphaBetaAlphaBeta";
        String result = Common.CharacterGeneration(testLen, stringAB);
        assertEquals("The String passed to character generation "
                   + "was not as long as the string * num repetitions"
                    , lenABTimesLen
                    , result.length());
        assertEquals("The generated string was not as expected "
                    + " when passed to character genertion method."
                    , expected
                    , result);
        
        //also test that stars and dashes work as expected
        expected = "*****";
        testLen = 5;
        result = Common.CharacterGeneration(testLen, "*");
        assertEquals("The String passed to character generation "
                   + "was not as long as the string * num repetitions"
                    , testLen
                    , result.length());
        assertEquals("The generated string was not as expected "
                    + " when passed to character genertion method."
                    , expected
                    , result);
        
        expected = "-----";
        testLen = 5;
        result = Common.CharacterGeneration(testLen, "-");
        assertEquals("The String passed to character generation "
                   + "was not as long as the string * num repetitions"
                    , testLen
                    , result.length());
        assertEquals("The generated string was not as expected "
                    + " when passed to character genertion method."
                    , expected
                    , result);
    }
}