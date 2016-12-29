/*
 * See the notes in Common Test about not changing the testing layout...
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
public class PlayerTest {
    private final String playerName = "John Jacob Jingleheimer Schmit";
    private final int playerScore = 3263637;
    private final int playerID = 232662910;
    
    private Player p;
    private Player p2;
    
    @Before
    public void setUp() {
        p = new Player();
        p2 = new Player(playerName, playerID);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testConstructors()
    {
        assertNotNull("The default Player could not be constructed"
                        , p);
        assertNull("The default Player name was not as expected"
                        , p.getPlayerName());
        assertEquals("The default Player ID was not as expected"
                        , 0
                        , p.getPlayerID());
        assertEquals("The default Player score was not as expected"
                        , 0
                        , p.getPlayerScore());
        assertNotNull("The explicit Player could not be constructed"
                        , p2);
        assertEquals("The explicit Player name was not as expected"
                        , playerName
                        , p2.getPlayerName());
        assertEquals("The explicit Player ID was not as expected"
                        , playerID
                        , p2.getPlayerID());
        assertEquals("The explicit Player score was not as expected"
                        , 0
                        , p2.getPlayerScore());
    }
    
    @Test
    public void testMutatorsAndAccessors()
    {
        p.setPlayerName(playerName);
        assertEquals("The Player name was not as expected"
                        , playerName
                        , p.getPlayerName());
        p.setPlayerID(playerID);
        assertEquals("The Player ID was not as expected"
                        , playerID
                        , p.getPlayerID());
        p.setPlayerScore(playerScore);
        assertEquals("The Player score was not as expected"
                        , playerScore
                        , p.getPlayerScore());
    }
    
    @Test
    public void testToString()
    {
        String playerString = p2.toString();
        assertTrue("Player string does not contain name as expected"
                    , playerString.contains(playerName));
        assertTrue("Player string does not contain score as expected"
                    , playerString.contains("0"));
        assertTrue("Player string does not contain id as expected"
                    , playerString.contains(String.format("%d", playerID)));
    }
}