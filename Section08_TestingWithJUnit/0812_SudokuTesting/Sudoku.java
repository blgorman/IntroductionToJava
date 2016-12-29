import java.util.*;

/**
 *
 * @author Brian
 */
public class Sudoku extends GameShell
{
    Scanner input;
    final int eEGGNumber = -999999999;
    final int gridResetNumber = -999999998;
    private SudokuGrid _gameBoard;
    
    public void Play() {
        input = new Scanner(System.in);
        //create the player details:
        
        System.out.println("Welcome to Sudoku!");
        System.out.println("What is your name?");
        String name = input.nextLine();
        Player p = new Player();
        p.setPlayerID(1);
        p.setPlayerName(name);
        //in an advanced system, we could create scoring behaviors
        //and interchange them on the player object so the player
        //could have different scores based on the game they are playing
        //for example, sudoku might score based on time, number incorrect, etc.
        //while a card game might score on number of tricks or just overall points.
        p.setPlayerScore(0);
        
        //leverage shell method to add the player
        this.AddPlayer(p);
        
        _gameBoard = new SudokuGrid();
        System.out.println(_gameBoard.toString());
        
        while(!_gameBoard.IsSolved())
        {
            //get user input
            boolean success = GatherInput();
            //print the grid after each entry so the user sees the updates
            System.out.println(_gameBoard.toString());
            if (!success)
            {
                System.out.println("Your last input was invalid.  Please try again!");
            }
        }
        //end the program.
        System.out.println("Great job!");
    }

    /**
     * Get input from the user for a position to solve
     */
    private boolean GatherInput()
    {
        int row = GetIntWithPrompt("Enter coordinate row of "
                + "new value 0 - 8:", 0, 8);
        int col = GetIntWithPrompt("Enter coordinate column of "
                + "new value 0 - 8:", 0, 8);
        int userVal = GetIntWithPrompt("Enter the value for this position:"
                                        , 1, 9);
        if (userVal == eEGGNumber)
        {
            //EASTER EGG
            _gameBoard.InstantSolveGrid();
            return true;
        }
        else if (userVal == gridResetNumber)
        {
            _gameBoard.InstantResetGrid();
            return true;
        }
        else if (userVal == -1)
        {
            return false;
        }
        else
        {
            return _gameBoard.SetCellValue(row, col, userVal);
        }
    }
    
    /**
     * Get an integer with a prompt.
     * @param prompt prompt to the user
     * @param minInt range limiter minimum value
     * @param maxInt range limiter max value
     * @return 
     */
    private int GetIntWithPrompt(String prompt, int minInt, int maxInt)
    {
        int result = -1;
        boolean isValid = false;
        while (!isValid)
        {
            System.out.println(prompt);
            String val = input.nextLine();
            if (val.trim().toUpperCase().equals("SOLVE_FOR_ME"))
            {
                //EASTER EGG
                return eEGGNumber;
            }
            else if (val.trim().toUpperCase().equals("-1"))
            {
                //let the user get out
                return -1;
            }
            else if (val.trim().toUpperCase().equals("RESET"))
            {
                //reset the board to start condition
                return gridResetNumber;
            }
            isValid = Common.ValidateNumber(val);
            if (!isValid)
            {
                continue;
            }
            
            //can parse, but validate by range
            result = Integer.parseInt(val);
            if (result < minInt || result > maxInt)
            {
                isValid = false;
                result = -1;
            }
        }
        return result;
    }
    
    /**
     * Validate a statement with y/n input expected
     * @param prompt Output to user
     * @return true if user response is y, else false
     */
    private boolean ValidateYN(String prompt)
    {
        boolean isValid = false;
        boolean validated = false;
        while (!isValid)
        {
            System.out.println(prompt);
            String response = input.nextLine();
            String rCharStr = Common.GetFirstCharAsString(response);
            if (rCharStr.toUpperCase().equals("Y"))
            {
                isValid = true; 
                validated = true;
            }
            else if(rCharStr.toUpperCase().equals("N"))
            {
                isValid = true;
                validated = false;
            }
            else
            {
                System.out.println("Invalid response. "
                                        + "Please enter 'Y' or 'N'");
            }
        }
        return validated;
    }
}
