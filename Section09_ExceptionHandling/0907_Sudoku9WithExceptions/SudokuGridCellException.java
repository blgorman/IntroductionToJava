/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MajorGuidance
 */
public class SudokuGridCellException extends RuntimeException
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
