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
public abstract class GameShellTest {
    GameShell gs;
    private int numPlayers;
    private Player p1;
    private Player p2;
    private String p1Name = "John";
    private String p2Name = "Mary";
    private int p1ID = 1;
    private int p2ID = 2;
    private Player[] players;
    private String instructions;
    
    public GameShellTest() {
        gs = getGameShell();
    }
    
    @Before
    public void setUp() {
        numPlayers = 2;
        p1 = new Player(p1Name, p1ID);
        p2 = new Player(p2Name, p2ID);
        players[0] = p1;
        players[1] = p2;
        instructions = "The game instructions go here.";
    }
    
    @After
    public void tearDown() {
    }
    
    public abstract GameShell getGameShell();

    @Test
    public void testConstructor()
    {
        assertNotNull("Could not construct default gameshell"
                        , gs);
        assertEquals("Gameshell was not constructed with default"
                + " number of players"
                    , 0
                    , gs.getNumberOfPlayers());
    }
    
    @Test
    public void testMutatorsAndAccessors()
    {
        gs.setNumberOfPlayers(numPlayers);
        assertEquals("Number of players was not set as expected"
                    , numPlayers
                    , gs.getNumberOfPlayers());
        
        gs.setInstructions(instructions);
        assertEquals("Instructions where not set as expected"
                    , instructions
                    , gs.getInstructions());
        
        gs.setPlayerDetails(players);
        Player[] retPlayers = gs.getPlayerDetails();
        for (int i = 0; i < gs.getNumberOfPlayers(); i++)
        {
            assertEquals("The player was not as expected"
                        , players[i]
                        , retPlayers[i]);
        }
    }
    
    @Test
    public void testAddPlayer()
    {
        
        Player p3 = new Player("Steve", 3);
        gs.AddPlayer(p1);
        assertEquals("Count was not correct after adding player"
                    , 1
                    , gs.getNumberOfPlayers());
        
        gs.AddPlayer(p2);
        assertEquals("Count was not correct after adding player"
                    , 2
                    , gs.getNumberOfPlayers());
        
        gs.AddPlayer(p3);
        assertEquals("Count was not correct after adding player"
                    , 3
                    , gs.getNumberOfPlayers());
        
        //make sure the players are correct
        Player[] gamePlayers = gs.getPlayerDetails();
        assertEquals("Player 1 was not as expected"
                    , gamePlayers[0]
                    , p1);
        assertEquals("Player 2 was not as expected"
                    , gamePlayers[1]
                    , p2);
        assertEquals("Player 3 was not as expected"
                    , gamePlayers[2]
                    , p3);
    }
    
    @Test
    public void testListPlayers()
    {
        p1 = new Player(p1Name, p1ID);
        p2 = new Player(p2Name, p2ID);
        Player p3 = new Player("Steve", 3);
        gs.AddPlayer(p1);
        gs.AddPlayer(p2);
        String playerList = gs.listPlayers();
        
        assertTrue("Player 1 is not in the player list"
                    , playerList.contains(p1.toString()));
        assertTrue("Player 2 is not in the player list"
                    , playerList.contains(p2.toString()));
        assertFalse("Invalid player should not be in the list"
                    , playerList.contains(p3.toString()));
    }
}