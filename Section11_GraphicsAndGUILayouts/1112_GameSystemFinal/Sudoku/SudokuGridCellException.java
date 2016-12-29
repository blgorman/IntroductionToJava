package Sudoku;


import java.io.Serializable;

/**
 *
 * @author MajorGuidance
 */
public class SudokuGridCellException extends RuntimeException 
    implements Serializable
{
    public SudokuGridCellException()
    {
        super("Grid cells must contain numbers 1-9 only.");
    }
    
    public SudokuGridCellException(String message)
    {
        super(String.format("%s\n%s"
                ,"Grid cells must contain numbers 1-9 only."
                , message));
    }
}
