/**
 *
 * @author Brian
 */
public abstract class GameShell implements Game
{
    private int numPlayers;
    private Player[] players;
    private String instructions;
    
    public GameShell()
    {
        numPlayers = 0;
    }
    
    /**
     * Get the number of players.
     * @return number of players
     */
    public int getNumberOfPlayers()
    {
        return this.numPlayers;
    }
    
    /**
     * Set the number of players.
     */
    public void setNumberOfPlayers(int value)
    {
        this.numPlayers = value;
    }
    
    /**
     * Get the player details.
     * @return array of players.
     */
    public Player[] getPlayerDetails()
    {
        return this.players;
    }
    
    /**
     * Set all player details.
     * @param value the array of players.
     */
    public void setPlayerDetails(Player[] value)
    {
        this.players = value;
    }
    
    /**
     * Get the instructions for the game.
     * @return Instruction details as a String.
     */
    public String getInstructions()
    {
        return this.instructions;
    }
    
    /**
     * Set the instructions for the game.
     */
    public void setInstructions(String value)
    {
        this.instructions = value;
    }

    /**
     * The play algorithm will be different for each game
     * so we need to defer that code to the implementing class.
     */
    public abstract void Play();
    
    /**
     * Add a player
     * @param p the player to add
     * @return true if success.
     */
    protected boolean AddPlayer(Player p)
    {
        Player[] newPlayers = new Player[this.numPlayers + 1];
        for (int i = 0; i < this.numPlayers; i++)
        {
            newPlayers[i] = players[i];
        }
        newPlayers[this.numPlayers] = p;
        //testing revealed the following line was missing:
        players = newPlayers;
        this.numPlayers++;
        return true;
    }
    
    //method to remove players
    //methods to get/adjust scores
    //etc.
    
    /**
     * List each player by details in a String.
     * @return String with all player details.
     */
    public String listPlayers()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.numPlayers; i++)
        {
            sb.append(String.format("%s\n", players[i])); 
        }
        return sb.toString();
    }
}
