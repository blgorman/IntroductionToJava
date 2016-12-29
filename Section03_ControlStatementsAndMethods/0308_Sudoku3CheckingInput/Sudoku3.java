
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brian
 */
public class Sudoku3 {
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
    static String GridLine = "%s | %s | %s\n";
    static String GridData = "%s:%s:%s";
    static Scanner input;
    
    public static void main(String[] args)
    {
        System.out.println("Welcome to Sudoku!");
        System.out.println(HORIZONTAL_LINE);
        input = new Scanner(System.in);
        PrintUnsolvedPuzzle(1);
        
        //gather input a few times, but we aren't solving yet
        //too hard to track at this point
        GatherInput();
        GatherInput();
        GatherInput();
        GatherInput();
        GatherInput();
        //etc...
        //doesn't it seem like there should be a better way?
        //how would we possibly know how many gathers
        //if the user gets many wrong???
    }
    
    /**
     * Print the unsolved puzzle to the screen
     * @param difficulty  - level of difficulty for the puzzle
     */
    public static void PrintUnsolvedPuzzle(int difficulty)
    {
        PrintGridLine(1, difficulty);
        PrintGridLine(2, difficulty);
        PrintGridLine(3, difficulty);
        System.out.println(HORIZONTAL_LINE);
        PrintGridLine(4, difficulty);
        PrintGridLine(5, difficulty);
        PrintGridLine(6, difficulty);
        System.out.println(HORIZONTAL_LINE);
        PrintGridLine(7, difficulty);
        PrintGridLine(8, difficulty);
        PrintGridLine(9, difficulty);
    }
    
    /**
     * Print a specific grid line by difficulty
     * @param lineNumber
     * @param difficulty 
     */
    public static void PrintGridLine(int lineNumber, int difficulty)
    {
        String firstThree;
        String secondThree;
        String thirdThree;
        
        if (difficulty == 1)
        {
            switch(lineNumber)
            {
                case 1:
                    firstThree = BuildSetOfThree(BLANK, BLANK
                                            , GetSolutionItem(0,2)); 
                    secondThree = BuildSetOfThree(BLANK, BLANK
                                            , GetSolutionItem(0,5));
                    thirdThree = BuildSetOfThree(GetSolutionItem(0,6)
                                            , GetSolutionItem(0,7)
                                            , BLANK);
                    
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 2:
                    firstThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(1,1)
                                    , BLANK);
                    secondThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(1,4)
                                    , BLANK);
                    thirdThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , GetSolutionItem(1,8));
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    
                    break;
                case 3:
                    firstThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , GetSolutionItem(2,2));
                    secondThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , GetSolutionItem(2,5));
                    thirdThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , BLANK);
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 4:
                    firstThree = BuildSetOfThree(GetSolutionItem(3,0)
                                    , BLANK
                                    , BLANK);
                    secondThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(3,4)
                                    , BLANK);
                    thirdThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(3,7)
                                    , BLANK);
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 5:
                    firstThree = BuildSetOfThree(GetSolutionItem(4,0)
                                    , GetSolutionItem(4,1)
                                    , BLANK);
                    secondThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , BLANK);
                    thirdThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(4,7)
                                    , GetSolutionItem(4,8));
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 6:
                    firstThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(5,1)
                                    , BLANK);
                    secondThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(5,4)
                                    , BLANK);
                    thirdThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , GetSolutionItem(5,8));
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 7:
                    firstThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , BLANK);
                    secondThree = BuildSetOfThree(GetSolutionItem(6,3)
                                    , BLANK
                                    , BLANK);
                    thirdThree = BuildSetOfThree(GetSolutionItem(6,6)
                                    , BLANK
                                    , BLANK);
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 8:
                    firstThree = BuildSetOfThree(GetSolutionItem(7,0)
                                    , BLANK
                                    , BLANK);
                    secondThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(7,4)
                                    , BLANK);
                    thirdThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(7,7)
                                    , BLANK);
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 9:
                    firstThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(8,1)
                                    , GetSolutionItem(8,2));
                    secondThree = BuildSetOfThree(GetSolutionItem(8,3)
                                    , BLANK
                                    , BLANK);
                    thirdThree = BuildSetOfThree(GetSolutionItem(8,6)
                                    , BLANK
                                    , BLANK);
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
            }
        }
    }
    
    /**
     * Build a set of three numbers
     * @param x the first number
     * @param y the second number
     * @param z the third number
     * @return 
     */
    public static String BuildSetOfThree(String x, String y, String z)
    {
        return String.format(GridData, x, y, z);
    }
    
    /**
     * Return a solution item from the solved grid
     * @param row -- the row coordinate
     * @param column -- the column coordinate
     * @return the value for the specific spot on the grid
     */
    public static String GetSolutionItem(int row, int column)
    {  
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
        
        if (row == 0)
        {
            switch (column)
            {
                case 0:
                    return SIX;
                case 1:
                    return NINE;
                case 2:
                    return FIVE;
                case 3:
                    return SEVEN;
                case 4:
                    return EIGHT;
                case 5:
                    return THREE;
                case 6:
                    return ONE;
                case 7:
                    return FOUR;
                case 8:
                    return TWO;
            }
        }
        else if (row == 1)
        {
            switch (column)
            {
                case 0:
                    return ONE;
                case 1:
                    return SEVEN;
                case 2:
                    return EIGHT;
                case 3:
                    return SIX;
                case 4:
                    return TWO;
                case 5:
                    return FOUR;
                case 6:
                    return THREE;
                case 7:
                    return NINE;
                case 8:
                    return FIVE;
            }
        }
        else if (row == 2)
        {
            switch (column)
            {
                case 0:
                    return THREE;
                case 1:
                    return FOUR;
                case 2:
                    return TWO;
                case 3:
                    return FIVE;
                case 4:
                    return NINE;
                case 5:
                    return ONE;
                case 6:
                    return EIGHT;
                case 7:
                    return SIX;
                case 8:
                    return SEVEN;
            }
        }
        else if (row == 3)
        {
            switch (column)
            {
                case 0:
                    return TWO;
                case 1:
                    return ONE;
                case 2:
                    return SEVEN;
                case 3:
                    return EIGHT;
                case 4:
                    return THREE;
                case 5:
                    return NINE;
                case 6:
                    return FOUR;
                case 7:
                    return FIVE;
                case 8:
                    return SIX;
            }
        }
        else if (row == 4)
        {
            switch (column)
            {
                case 0:
                    return NINE;
                case 1:
                    return SIX;
                case 2:
                    return THREE;
                case 3:
                    return ONE;
                case 4:
                    return FOUR;
                case 5:
                    return FIVE;
                case 6:
                    return SEVEN;
                case 7:
                    return TWO;
                case 8:
                    return EIGHT;
            }
        }
        else if (row == 5)
        {
            switch (column)
            {
                case 0:
                    return EIGHT;
                case 1:
                    return FIVE;
                case 2:
                    return FOUR;
                case 3:
                    return TWO;
                case 4:
                    return SEVEN;
                case 5:
                    return SIX;
                case 6:
                    return NINE;
                case 7:
                    return ONE;
                case 8:
                    return THREE;
            }
        }
        else if (row == 6)
        {
            switch (column)
            {
                case 0:
                    return FIVE;
                case 1:
                    return TWO;
                case 2:
                    return NINE;
                case 3:
                    return THREE;
                case 4:
                    return ONE;
                case 5:
                    return EIGHT;
                case 6:
                    return SIX;
                case 7:
                    return SEVEN;
                case 8:
                    return FOUR;
            }
        }
        else if (row == 7)
        {
            switch (column)
            {
                case 0:
                    return FOUR;
                case 1:
                    return THREE;
                case 2:
                    return SIX;
                case 3:
                    return NINE;
                case 4:
                    return FIVE;
                case 5:
                    return SEVEN;
                case 6:
                    return TWO;
                case 7:
                    return EIGHT;
                case 8:
                    return ONE;
            }
        }
        else if (row == 8)
        {
            switch (column)
            {
                case 0:
                    return SEVEN;
                case 1:
                    return EIGHT;
                case 2:
                    return ONE;
                case 3:
                    return FOUR;
                case 4:
                    return SIX;
                case 5:
                    return TWO;
                case 6:
                    return FIVE;
                case 7:
                    return THREE;
                case 8:
                    return NINE;
            }
        }
        return null; 
    }
    
    /**
     * Get input from the user for a position to solve
     */
    public static void GatherInput()
    {
        System.out.println("Enter coordinate row of new value 0 - 8:");
        int row = input.nextInt();
        System.out.println("Enter coordinate column of new value 0 - 8:");
        int col = input.nextInt();
        input.nextLine();
        System.out.println("Enter the value for this position: ");
        String val = input.nextLine();
        
        //critical note: For String equality, we CANNOT use == in java
        //instead, we call to the 'equals(object obj) method
        //this will evaluate one String against another object
        //to see if they are equal Strings
        String solVal = GetSolutionItem(row,col);
        if (solVal.equals(val))
        {
            String result = String.format("%s is the correct value "
                            + "for coordinate [%d, %d]! Good job!"
                            , val, row, col);
            System.out.println(result);
        }
        else
        {
            System.out.println("Incorrect value for "
                                    + "that coordinate!");
        }
    }
    
}
