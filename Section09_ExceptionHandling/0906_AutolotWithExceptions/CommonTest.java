
/**
 *
 * @author Brian
 */
public class CommonTest extends junit.framework.TestCase  {
    private final String number1 = "1";
    private final String numberMinus1 = "-1";
    private final String notANumber = "NotANumber";
    private final String number1Point0 = "1.0";
    private final String numberMinus1Point0 = "-1.0";
    private final String stringA = "Alpha";
    private final String stringAB = "AlphaBeta";
    private final String stringZ = "Zulu";
    
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
     * Test Character generation string method.
     */
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

    public void testNullSafeEquals()
    {
        //make sure null is able to be tested
        String s1 = null;
        String s2 = "AAA";
        String s3 = "ZZZ";
        String s4 = "AAA";
        String s5 = null;
        
        assertFalse("Null safe equals not working when arg 1 is null"
                        , Common.nullSafeEquals(s1, s2));
        assertFalse("Null safe equals not working when arg 2 is null"
                        , Common.nullSafeEquals(s2, s1));
        assertFalse("Null safe equals not working when both args not null"
                + " and not equal"
                    , Common.nullSafeEquals(s2, s3));
        assertFalse("Null safe equals not working when both args not null"
                + " and not equal"
                    , Common.nullSafeEquals(s3, s2));
        
        assertTrue("null safe equals not working when args are equal"
                    , Common.nullSafeEquals(s2, s4));
        assertTrue("null safe equals not working when args are equal"
                    , Common.nullSafeEquals(s4, s2));
        assertTrue("null safe equals not working when args are equal"
                    , Common.nullSafeEquals(s1, s5));
        assertTrue("null safe equals not working when args are equal"
                    , Common.nullSafeEquals(s5, s1));
        
        
    }
}