/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class GameSystem 
{
    private static final int MAX_GAMES = 10;
    private static Game[] theGames = new Game[MAX_GAMES];
    private static int numGames;
    
    public static void main(String[] args)
    {
        theGames[0] = new Sudoku();
        numGames++;
        
        System.out.println("Here would be a menu...");
        System.out.println("The user would choose the game..Sudoku");
        System.out.println("We then call to execute the play on that game...");
        
        //obviously, this is not a solution, this is just a stub
        //to show how we can now have multiple games if we want.
        theGames[0].Play();
    }
    
    //Add methods to add games/remove games/list games
    //Print menu, etc.
}
