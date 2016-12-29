/**
 * Interchangeable Game Object.
 * @author Brian
 */
public interface Game
{
    /**
     * Get the number of players.
     * @return number of players
     */
    int getNumberOfPlayers();
    /**
     * Set the number of players.
     */
    void setNumberOfPlayers(int value);
    /**
     * Get the player details.
     * @return array of players.
     */
    Player[] getPlayerDetails();
    /**
     * Set all player details.
     * @param value the array of players.
     */
    void setPlayerDetails(Player[] value);
    /**
     * Get the instructions for the game.
     * @return Instruction details as a String.
     */
    String getInstructions();
    /**
     * Set the instructions for the game.
     */
    void setInstructions(String value);
    /**
     * Run the algorithm to play the game.
     */
    void Play();
    
    /**
     * List each player by details in a String.
     * @return String with all player details.
     */
    String listPlayers();
}
