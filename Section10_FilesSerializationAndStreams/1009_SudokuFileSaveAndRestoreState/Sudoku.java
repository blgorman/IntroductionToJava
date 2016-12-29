import java.util.*;
import java.io.*;

/**
 *
 * @author Brian
 */
public class Sudoku extends GameShell implements Serializable
{
    Scanner input;
    final int eEGGNumber = -999999999;
    final int gridResetNumber = -999999998;
    private SudokuGrid _gameBoard;
    private final int minCoordinateVal = 0;
    private final int maxCoordinateVal = 8;
    private final int minCellValue = 1;
    private final int maxCellValue = 9;
    private final String savePath = "SudokuGridSavedState.bin";
    
    public void Play() {
        input = new Scanner(System.in);
        //create the player details:
        System.out.println("Welcome to Sudoku!");
        String name = ValidateUserInputString("What is your name?");
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
        
        //first prompt:
        System.out.println("Enter 'RESTORE' to restore last saved game");
        System.out.println("Enter 'SAVE' to save current game");
        System.out.println("Enter 'QUIT' to exit");
        System.out.println("Simply Press Enter to continue.");
        String userEntry = input.nextLine();
        if (userEntry.equalsIgnoreCase("RESTORE"))
        {
            SudokuGrid sg = RestoreGame();
            if (sg != null) _gameBoard = sg;
            //print the grid 
            System.out.println(_gameBoard.toString());
        }
        else if (userEntry.equalsIgnoreCase("SAVE"))
        {
            SaveGame(_gameBoard);
        }
        else if (userEntry.equalsIgnoreCase("QUIT"))
        {
            Quit();
        }
            
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
            
            System.out.println("Enter 'RESTORE' to restore last saved game");
            System.out.println("Enter 'SAVE' to save current game");
            System.out.println("Enter 'QUIT' to exit");
            System.out.println("Simply Press Enter to continue.");
            userEntry = input.nextLine();
            if (userEntry.equalsIgnoreCase("RESTORE"))
            {
                SudokuGrid sg = RestoreGame();
                if (sg != null) _gameBoard = sg;
                //print the grid 
                System.out.println(_gameBoard.toString());
            }
            else if (userEntry.equalsIgnoreCase("SAVE"))
            {
                SaveGame(_gameBoard);
            }
            else if (userEntry.equalsIgnoreCase("QUIT"))
            {
                Quit();
            }
        }
        //end the program.
        System.out.println("Great job!");
    }

    /**
     * Restore a grid from saved state.
     * @return the grid from saved state.
     */
    private SudokuGrid RestoreGame()
    {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        SudokuGrid sg = null;
        try
        {
            fis = new FileInputStream(savePath);
            ois = new ObjectInputStream(fis);
            sg = (SudokuGrid)ois.readObject();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if (fis != null) fis.close();
                if (ois != null) ois.close();
            }
            catch (Exception innerEx)
            {
                System.out.println(innerEx.getMessage());
            }
            fis = null;
            ois = null;
        }
        return sg;
    }
    
    /**
     * Save the grid
     * @param sg the grid to save
     */
    private void SaveGame(SudokuGrid sg)
    {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try
        {
            fos = new FileOutputStream(savePath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sg);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if (fos != null) fos.close();
                if (oos != null) oos.close();
            }
            catch (Exception innerEx)
            {
                System.out.println(innerEx.getMessage());
            }
            fos = null;
            oos = null;
        }
    }
    
    /**
     * Quit the game without saving.
     */
    private void Quit()
    {
        //exit
        System.exit(0);
    }
    
    /**
     * Get input from the user for a position to solve
     */
    private boolean GatherInput()
    {
        
        int row = GetIntWithPrompt("Enter coordinate row of "
                + "new value 0 - 8:", minCoordinateVal, maxCoordinateVal);
        int col = GetIntWithPrompt("Enter coordinate column of "
                + "new value 0 - 8:", minCoordinateVal, maxCoordinateVal);
        int userVal = GetIntWithPrompt("Enter the value for this position:"
                                        , minCellValue, maxCellValue);
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
    
    
    
    /**
     * Make sure the user gives a valid String for a response
     * @param prompt The prompt to ask the user.
     * @return the valid input from the user.
     */
    private String ValidateUserInputString(String prompt)
    {
        String response = "";
        while (response == null || response.equals(""))
        {
            System.out.println(prompt);
            try
            {
                response = input.nextLine();
            }
            catch (Exception ex)
            {
                System.out.println("Please enter a valid response");
            }
        }
        return response;
    }
    
    /**
     * Make sure the user puts in an integer of the correct value
     * @param prompt What to print to ask the user for input
     * @param validMin the minimum acceptable integer
     * @param validMax the maximum acceptable integer
     * @return a valid integer response from the user.
     */
    private int ValidateUserInputInteger(String prompt, int validMin, 
                                                    int validMax)
    {
        int response = -999999999;
        while (response < validMin || response > validMax)
        {
            try
            {
                System.out.println(prompt);
                String r = input.nextLine();
                response = Integer.parseInt(r);
            }
            catch(Exception ex)
            {
                System.out.printf("Please enter a valid input between %d and %d\n"
                                    , validMin, validMax);
                response = -999999999;
            }
        }
        return response;
    }
    
    /**
     * Make sure the user inputs a valid double.
     * @param prompt The prompt to issue to the user
     * @param validMin the minimum acceptable value
     * @param validMax the maximum acceptable value
     * @return 
     */
    private double ValidateUserInputDouble(String prompt
                                    , double validMin, double validMax)
    {
        double response = -9999999999999999.9;
        while (response < validMin || response > validMax)
        {
            try
            {
                System.out.println(prompt);
                String r = input.nextLine();
                response = Double.parseDouble(r);
            }
            catch(Exception ex)
            {
                System.out.printf("Please enter a valid input between %d and %d\n"
                                    , validMin, validMax);
                response = -9999999999999999.9;
            }
        }
        return response;
    }
}
