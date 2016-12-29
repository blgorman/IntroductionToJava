/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The Sudoku Grid Cell.
 * @author Brian
 */
public class SudokuGridCell 
{
    private int _value;
    private boolean _isLocked;
    
    /**
     * Construct an unlocked GridCell with no value.
     */
    public SudokuGridCell()
    {
        //do nothing.
    }
    
    /**
     * Construct an unlocked gridcell with value.
     * @param value the value for the cell.
     */
    public SudokuGridCell(int value)
    {
        ValidateValue(value);
        _value = value;
        _isLocked = false;
    }
    
    /**
     * Construct a grid cell with value and lock
     * @param value     the value of the cell
     * @param isLocked  locked is true when user can't alter
     */
    public SudokuGridCell(int value, boolean isLocked)
    {
        _value = value;
        _isLocked = isLocked;
    }
    
    /**
     * Get the value of the cell.
     * @return the value as integer
     */
    public int getValue()
    {
        return _value;
    }
    /**
     * Set the value of the cell.
     * @param value the value to set as integer
     */
    public void setValue(int value)
    {
        ValidateValue(value);
        _value = value;
    }
    
    /**
     * Get the lock on the cell.
     * @return true if locked, else false
     */
    public boolean getIsLocked()
    {
        return _isLocked;
    }
    
    /**
     * Public friendly method for use in code
     * @return true if the cell is locked, else false.
     */
    public boolean IsLocked()
    {
        return getIsLocked();
    }
    /**
     * Set the lock on the cell.
     * @param value use true to lock the cell, else false
     */
    public void setIsLocked(boolean value)
    {
        _isLocked = value;
    }
    
    /**
     * Return ONLY THE VALUE of the cell in toString
     * @return the value of the gridcell.
     */
    public String toString()
    {
        return String.format("%d", _value);
    }
    
    /**
     * Validate that the value is valid for a Sudoku Cell
     * @param value The value to evaluate.
     */
    private void ValidateValue(int value)
    {
        if ((value < 0 || value > 9))
        {
            throw new SudokuGridCellException();
        }
    }
}
