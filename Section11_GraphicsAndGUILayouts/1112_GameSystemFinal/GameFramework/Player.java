package GameFramework;

import java.io.Serializable;


/**
 * A Player Object.
 * @author Brian
 */
public class Player implements Serializable 
{
    private String playerName;
    private int playerScore;
    private int playerID;
    private final int minPlayers = 1;
    private final int maxPlayers = 25;
    private final int minScore = 0;
    private final int maxScore = 25000000;
    
    /**
     * Default Constructor.
     */
    public Player()
    {
        //do nothing..
    }
    
    /**
     * Construct with name and score = 0
     * @param name The name of the player.
     * @param ID The id/position.
     */
    public Player(String name, int ID)
    {
        playerName = name;
        playerID = ID;
        playerScore = 0;
    }
    
    /**
     * Construct with name, id, and score.
     * @param name the name of the player.
     * @param ID the playerID.
     * @param score the current score.
     */
    public Player(String name, int ID, int score)
    {
        this.setPlayerName(name);
        this.setPlayerID(ID);
        this.setPlayerScore(score);
    }
    
    /**
     * Get the player name.
     * @return the name of the player.
     */
    public String getPlayerName()
    {
        return this.playerName;
    }
    /**
     * Set the player name.
     * @param value the name for the player.
     */
    public void setPlayerName(String value)
    {
        if (value == null || value.equals(""))
        {
            throw new IllegalArgumentException("Please enter a valid"
                    + " player name.");
        }
        this.playerName = value;
    }
    /**
     * Get the player ID.
     * @return Player ID
     */
    public int getPlayerID()
    {
        return this.playerID;
    }
    /**
     * Set the player ID.
     * @param value the ID for the player.
     */
    public void setPlayerID(int value)
    {
        if (value < minPlayers || value > maxPlayers)
        {
            throw new IllegalArgumentException("ID should match player number");
        }
        this.playerID = value;
    }
    
    /**
     * Get the player score.
     * @return Score for the player.
     */
    public int getPlayerScore()
    {
        return this.playerScore;
    }
    /**
     * Set the player score.
     * @param value the score.
     */
    public void setPlayerScore(int value)
    {
        if (value < minScore || value > maxScore)
        {
            throw new IllegalArgumentException("Score needs to be valid.");
        }
        this.playerScore = value;
    }
    
    /**
     * The player details.
     * @return player details as string
     */
    public String toString()
    {
        return String.format("%d]%s | %d\n"
                , this.getPlayerID()
                , this.getPlayerName()
                , this.getPlayerScore());
    }
}
