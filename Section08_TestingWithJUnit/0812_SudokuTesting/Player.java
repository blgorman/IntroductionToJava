/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class Player 
{
    private String playerName;
    private int playerScore;
    private int playerID;
    
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
        playerName = name;
        playerID = ID;
        playerScore = score;
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
