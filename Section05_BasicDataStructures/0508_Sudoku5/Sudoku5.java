
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class Sudoku5 {
    final static String ONE = "1";
    final static String TWO = "2";
    final static String THREE = "3";
    final static String FOUR = "4";
    final static String FIVE = "5";
    final static String SIX = "6";
    final static String SEVEN = "7";
    final static String EIGHT = "8";
    final static String NINE = "9";
    final static String BLANK = " ";
    final static String HORIZONTAL_LINE = "XXXXXXXXXXXXXXXXXXXXX";

    static Scanner input;
    static boolean solved;
    final static int eEGGNumber = -999999999;
    
    //THE GAMEBOARD IS A 2-Dimensional Array.
    //Again, the ONLY time an MD Array is a good idea is when you have a grid
    //of identical items.  Here, a 9x9 grid of numbers does the trick for us
    static String[][] gameBoard;
    static String[][] solutionBoard;
    
    public static void main(String[] args)
    {
        System.out.println("Welcome to Sudoku!");
        System.out.println(HORIZONTAL_LINE);
        
        //create the grids on startup
        SetupGridsFirstRun(1);
        //print the current grid
        PrintCurrentGrid();
        
        input = new Scanner(System.in);
        solved = false;
        while(!solved)
        {
            //get user input
            GatherInput();
            //determine if grid is solved:
            solved = CheckIfSolved();
        }
        //end the program.
        System.out.println("Great job!");
    }
    
    
    
    /**
     * Print the current grid with whatever values exist.
     */
    public static void PrintCurrentGrid()
    {
        System.out.println(Stars(50));
        for (int i = 1; i < 10; i++)
        {
            for (int j = 1; j < 10; j++)
            {
                System.out.print(gameBoard[i-1][j-1]);
                if (j % 3 == 0)
                {
                    System.out.print("|");
                }
                else
                {
                    System.out.print(":");
                }
            }
            System.out.println("");
            if (i % 3 == 0)
            {
                System.out.println(HORIZONTAL_LINE);
            }
        }
        System.out.println(Stars(50));
    }
    
    /**
     * Check if the grid is solved.
     * @return 
     */
    public static boolean CheckIfSolved()
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (gameBoard[i][j].equals(BLANK)
                        || !gameBoard[i][j].equals(solutionBoard[i][j]))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Get input from the user for a position to solve
     */
    public static void GatherInput()
    {
        int row = GetIntWithPrompt("Enter coordinate row of "
                + "new value 0 - 8:", 0, 8);
        //int row = input.nextInt();
        int col = GetIntWithPrompt("Enter coordinate column of "
                + "new value 0 - 8:", 0, 8);
        //int col = input.nextInt();
        //input.nextLine();
        
        int userVal = GetIntWithPrompt("Enter the value for this position:"
                                        , 1, 9);
        if (userVal == eEGGNumber)
        {
            //EASTER EGG
            SolveIt();
        }
        else
        {
            String val = String.format("%d", userVal);
            
            //we are not going to validate.  We'll let the user do whatever
            //they want here.  This is more accurate to the game play.
            //Later we'll figure out ways to quickly solve
            //in fact, at this point nothing is locked down so the user can actually
            //overwrite one of the solution items.
            SetItemInGrid(row, col, val);
        }
        //print the grid after each entry so the user sees the updates
        PrintCurrentGrid();
    }
    
    /**
     * Solve the entire grid.
     */
    public static void SolveIt()
    {
        gameBoard = solutionBoard.clone();
    }
    
    /**
     * Keep track of the current state of the puzzle based on user input.
     * @param row The row coordinate;
     * @param column The col coordinate;
     * @return the String representation of the value in the current position
     */
    public static String GetCurrentStateItem(int row, int column)
    {
        return gameBoard[row][column];
    }
    
    /**
     * Set up the grid items based on the initial difficulty.
     * @param difficulty 
     */
    public static void SetupGridsFirstRun(int difficulty)
    {
        //create the blank gameBoard:
        gameBoard = new String[9][9];
        //create the blank solutionBoard
        solutionBoard = new String[9][9];
        //set the solution for the game 
        SetSolution();
        
        //make sure every slot in the gameboard has a blank so it
        //won't show as null
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                gameBoard[i][j] = BLANK;
            }
        }
        
        //populate all the 'givens' with the known values
        if (difficulty == 1)
        {
            //note, here we can replace 
            gameBoard[0][2] = GetSolutionItem(0,2);
            gameBoard[0][5] = GetSolutionItem(0,5);
            gameBoard[0][6] = GetSolutionItem(0,6);
            gameBoard[0][7] = GetSolutionItem(0,7);
            
            gameBoard[1][1] = GetSolutionItem(1,1);
            gameBoard[1][4] = GetSolutionItem(1,4);
            gameBoard[1][8] = GetSolutionItem(1,8);
            
            gameBoard[2][2] = GetSolutionItem(2,2);
            gameBoard[2][5] = GetSolutionItem(2,5);
            
            gameBoard[3][0] = GetSolutionItem(3,0);
            gameBoard[3][4] = GetSolutionItem(3,4);
            gameBoard[3][7] = GetSolutionItem(3,7);
            
            gameBoard[4][0] = GetSolutionItem(4,0);
            gameBoard[4][1] = GetSolutionItem(4,1);
            gameBoard[4][7] = GetSolutionItem(4,7);
            gameBoard[4][8] = GetSolutionItem(4,8);
            
            gameBoard[5][1] = GetSolutionItem(5,1);
            gameBoard[5][4] = GetSolutionItem(5,4);
            gameBoard[5][8] = GetSolutionItem(5,8);
            
            gameBoard[6][3] = GetSolutionItem(6,3);
            gameBoard[6][6] = GetSolutionItem(6,6);
            
            gameBoard[7][1] = GetSolutionItem(7,1);
            gameBoard[7][4] = GetSolutionItem(7,4);
            gameBoard[7][7] = GetSolutionItem(7,7);
            
            gameBoard[8][1] = GetSolutionItem(8,1);
            gameBoard[8][2] = GetSolutionItem(8,2);
            gameBoard[8][3] = GetSolutionItem(8,4);
            gameBoard[8][6] = GetSolutionItem(8,6);
        }
        //...now we can see medium, hard, expert
        //...can be easily generated by adding a case for each difficulty
        //...and eliminating some of what is show to the extent of difficulty.
    }
    
    /**
     * Set the solution on game startup/reset
     */
    public static void SetSolution()
    {
        //We still only have one solution at this time...
        //  0  1  2   3  4  5   6  7  8
        //0 6  9  5   7  8  3   1  4  2
        //1 1  7  8   6  2  4   3  9  5
        //2 3  4  2   5  9  1   8  6  7
        
        //3 2  1  7   8  3  9   4  5  6
        //4 9  6  3   1  4  5   7  2  8
        //5 8  5  4   2  7  6   9  1  3
        
        //6 5  2  9   3  1  8   6  7  4
        //7 4  3  6   9  5  7   2  8  1
        //8 7  8  1   4  6  2   5  3  9
        solutionBoard[0][0] = SIX;
        solutionBoard[0][1] = NINE;
        solutionBoard[0][2] = FIVE;
        solutionBoard[0][3] = SEVEN;
        solutionBoard[0][4] = EIGHT;
        solutionBoard[0][5] = THREE;
        solutionBoard[0][6] = ONE;
        solutionBoard[0][7] = FOUR;
        solutionBoard[0][8] = TWO;
        
        solutionBoard[1][0] = ONE;
        solutionBoard[1][1] = SEVEN;
        solutionBoard[1][2] = EIGHT;
        solutionBoard[1][3] = SIX;
        solutionBoard[1][4] = TWO;
        solutionBoard[1][5] = FOUR;
        solutionBoard[1][6] = THREE;
        solutionBoard[1][7] = NINE;
        solutionBoard[1][8] = FIVE;
        
        solutionBoard[2][0] = THREE;
        solutionBoard[2][1] = FOUR;
        solutionBoard[2][2] = TWO;
        solutionBoard[2][3] = FIVE;
        solutionBoard[2][4] = NINE;
        solutionBoard[2][5] = ONE;
        solutionBoard[2][6] = EIGHT;
        solutionBoard[2][7] = SIX;
        solutionBoard[2][8] = SEVEN;
        
        solutionBoard[3][0] = TWO;
        solutionBoard[3][1] = ONE;
        solutionBoard[3][2] = SEVEN;
        solutionBoard[3][3] = EIGHT;
        solutionBoard[3][4] = THREE;
        solutionBoard[3][5] = NINE;
        solutionBoard[3][6] = FOUR;
        solutionBoard[3][7] = FIVE;
        solutionBoard[3][8] = SIX;
        
        solutionBoard[4][0] = NINE;
        solutionBoard[4][1] = SIX;
        solutionBoard[4][2] = THREE;
        solutionBoard[4][3] = ONE;
        solutionBoard[4][4] = FOUR;
        solutionBoard[4][5] = FIVE;
        solutionBoard[4][6] = SEVEN;
        solutionBoard[4][7] = TWO;
        solutionBoard[4][8] = EIGHT;
        
        solutionBoard[5][0] = EIGHT;
        solutionBoard[5][1] = FIVE;
        solutionBoard[5][2] = FOUR;
        solutionBoard[5][3] = TWO;
        solutionBoard[5][4] = SEVEN;
        solutionBoard[5][5] = SIX;
        solutionBoard[5][6] = NINE;
        solutionBoard[5][7] = ONE;
        solutionBoard[5][8] = THREE;
        
        solutionBoard[6][0] = FIVE;
        solutionBoard[6][1] = TWO;
        solutionBoard[6][2] = NINE;
        solutionBoard[6][3] = THREE;
        solutionBoard[6][4] = ONE;
        solutionBoard[6][5] = EIGHT;
        solutionBoard[6][6] = SIX;
        solutionBoard[6][7] = SEVEN;
        solutionBoard[6][8] = FOUR;
        
        solutionBoard[7][0] = FOUR;
        solutionBoard[7][1] = THREE;
        solutionBoard[7][2] = SIX;
        solutionBoard[7][3] = NINE;
        solutionBoard[7][4] = FIVE;
        solutionBoard[7][5] = SEVEN;
        solutionBoard[7][6] = TWO;
        solutionBoard[7][7] = EIGHT;
        solutionBoard[7][8] = ONE;
        
        solutionBoard[8][0] = SEVEN;
        solutionBoard[8][1] = EIGHT;
        solutionBoard[8][2] = ONE;
        solutionBoard[8][3] = FOUR;
        solutionBoard[8][4] = SIX;
        solutionBoard[8][5] = TWO;
        solutionBoard[8][6] = FIVE;
        solutionBoard[8][7] = THREE;
        solutionBoard[8][8] = NINE;
    }
    
    /**
     * Return a solution item from the solved grid
     * @param row -- the row coordinate
     * @param column -- the column coordinate
     * @return the value for the specific spot on the grid
     */
    public static String GetSolutionItem(int row, int column)
    {  
        return solutionBoard[row][column];
    }

    /**
     * Set an item in the grid by entry of user
     * @param row the row coordinate
     * @param column the col coordinate
     * @param val the value to set
     */
    public static void SetItemInGrid(int row, int column, String val)
    {
        String entry = TranslateVal(val);
        gameBoard[row][column] = entry;
    }
    
    /**
     * Translate a value from number to constant variable
     * @param inVal
     * @return 
     */
    public static String TranslateVal(String inVal)
    {
        if (inVal.equals("1"))
        {
            return ONE;
        }
        else if (inVal.equals("2"))
        {
            return TWO;
        }
        else if (inVal.equals("3"))
        {
            return THREE;
        }
        else if (inVal.equals("4"))
        {
            return FOUR;
        }
        else if (inVal.equals("5"))
        {
            return FIVE;
        }
        else if (inVal.equals("6"))
        {
            return SIX;
        }
        else if (inVal.equals("7"))
        {
            return SEVEN;
        }
        else if (inVal.equals("8"))
        {
            return EIGHT;
        }
        else if (inVal.equals("9"))
        {
            return NINE;
        }
        return BLANK;
    }
    /******************   END ONLY WAY WE KNOW RIGHT NOW *******************/
    
    
    
    /********** HELPER FUNCTIONS *************************************/
    /**
     * Make sure user entered only a valid number:
     * @param checkString
     * @return 
     */
    public static boolean ValidateNumber(String checkString)
    {
        return ValidateNumber(checkString, false);
    }
    
    /**
     * Make sure user entered only a valid number:
     * @param checkString
     * @return 
     */
    public static boolean ValidateNumber(String checkString
                                        , boolean ignoreDecimalAndHyphen)
    {
        boolean isValid = true;
        //loop on all characters
        for (int i = 0; i < checkString.length(); i++)
        {
            char checkChar = checkString.charAt(i);
            if (ignoreDecimalAndHyphen && (checkChar == 45 || checkChar == 46))
            {
                continue;
            }
            if (checkChar < 48 || checkChar > 57)
            {
                isValid = false;
                System.out.printf("Invalid character in response: %s\n"
                        , checkChar);
                System.out.println("Please enter only numbers");
                break;
            }
        }
        
        //if get to here, all chars are valid
        return isValid;
    }
    
    /**
     * This method will validate a String to see
     *  if it can be parsed as a double
     * @param val the value to parse
     * @return true if can be made into a double, else false;
     */
    private static boolean ValidateDouble(String val)
    {
        return ValidateNumber(val, true);
    }
    
    /**
     * Get an integer with a prompt.
     * @param prompt prompt to the user
     * @param minInt range limiter minimum value
     * @param maxInt range limiter max value
     * @return 
     */
    public static int GetIntWithPrompt(String prompt, int minInt, int maxInt)
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
            
            isValid = ValidateNumber(val);
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
    public static boolean ValidateYN(String prompt)
    {
        boolean isValid = false;
        boolean validated = false;
        while (!isValid)
        {
            System.out.println(prompt);
            String response = input.nextLine();
            String rCharStr = GetFirstCharAsString(response);
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
     * Get the first char of a string as a new string
     * @param val The string to get first char as string
     * @return The first char of a String as a String
     */
    public static String GetFirstCharAsString(String val)
    {
        return ((Character)val.charAt(0)).toString();
    }
    
    /**
     * Print out a string of stars based on passed in length
     * @param num
     * @return
     */
    public static String Stars(int num)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++)
        {
            sb.append("*");
        }
        return sb.toString();
    }

    /**
     * Print out a string of dashes based on passed in length
     * @param num
     * @return
     */
    public static String Dashes(int num)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++)
        {
            sb.append("-");
        }
        return sb.toString();
    }
    /********** END HELPER FUNCTIONS *********************************/
}
