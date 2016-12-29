package Sudoku;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

/**
 * A Sudoku Grid Cell For use in the GUI
 * This is an extended JTextField.
 * @author Brian
 */
public class SudokuGridCell extends JTextField {
    private boolean isLocked;
    /**
     * Constructor.
     */
    public SudokuGridCell()
    {
        super();
        setupCell();
    }
    
    /**
     * Constructor.
     * @param cols num cols.
     */
    public  SudokuGridCell(int cols)
    {
        super(cols);
        setupCell();
    }
    
    public boolean getIsLocked()
    {
        return isLocked;
    }
    public void setIsLocked(boolean value)
    {
        isLocked = value;
    }
    
    /**
     * Set the default properties.
     */
    private void setupCell(){
        this.setText("");
        this.setFont(new Font("Verdana", java.awt.Font.PLAIN, 22));
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
    }
}
