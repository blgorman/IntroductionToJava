/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author Brian
 */
public class SudokuGrid 
{
    private SudokuGridCell[][] _grid;
    private SudokuGridCell[][] _gridStartCondition;
    private SudokuGridCell[][] _solution;
    private final int _xSize = 9;
    private final int _ySize = 9;
    private final static String HORIZONTAL_LINE = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    //private final static String UNDER_LINE = "---------------------";
    private final static String COLUMN_LINE = "   0   1   2   3   4   5   6   7   8";
    private int _difficultyLevel;
    
    /**
     * Create a new grid object for gameplay.
     *  difficulty = easiest, default seed.
     */
    public SudokuGrid()
    {
        _difficultyLevel = 0;  //0 = undefined or easiest;
        ResetGame();
    }
    
    /**
     * Create a new grid object for gameplay.
     * @param difficultyLevel the difficulty level of the puzzle
     * uses default seed
     */
    public SudokuGrid(int difficultyLevel)
    {
        _difficultyLevel = difficultyLevel;
        ResetGame();
    }
    
    /**
     * Reset the game.
     */
    private void ResetGame()
    {
        _grid = new SudokuGridCell[_xSize][_ySize];
        _gridStartCondition = new SudokuGridCell[_xSize][_ySize];
        for (int i = 0; i < _xSize; i++)
        {
            for (int j = 0; j < _ySize; j++)
            {
                _grid[i][j] = new SudokuGridCell(0, false);
                _gridStartCondition[i][j] = new SudokuGridCell(0,false);
            }
        }
        //build the solution:
        generateNewSolution();
    }
    
    /**
     * Generate a new solution, then put it in the solution grid.
     */
    private void generateNewSolution()
    {
        _solution = new SudokuGridCell[_xSize][_ySize];
        SudokuGenerator sg = new SudokuGenerator();
        int[][] tempSol = sg.generateSolution(new int[_xSize][_ySize], 0);
        for (int i = 0; i < _xSize; i++)
        {
            for (int j = 0; j < _ySize; j++)
            {
                SudokuGridCell sgc = new SudokuGridCell();
                sgc.setValue(tempSol[i][j]);
                sgc.setIsLocked(true);
                _solution[i][j] = sgc;
            }
        }
        
        int[][] tempGame = sg.generateGame(tempSol);
        for (int i = 0; i < _xSize; i++)
        {
            for (int j = 0;j < _ySize; j++)
            {
                SudokuGridCell sgc = new SudokuGridCell();
                sgc.setValue(tempGame[i][j]);
                sgc.setIsLocked(sgc.getValue() != 0);
                _grid[i][j] = sgc;
                SudokuGridCell sgc2 = new SudokuGridCell();
                sgc2.setValue(tempGame[i][j]);
                sgc2.setIsLocked(sgc.getValue() != 0);
                _gridStartCondition[i][j] = sgc2;
            }
        }

    }
    
    /**
     * Determine if the grid is solved.
     * @return 
     */
    public boolean IsSolved()
    {
        //iterate entire gameboard grid and determine if there are
        //any missing numbers.
        for (int i = 0; i < _xSize; i++)
        {
            for (int j = 0; j < _ySize; j++)
            {
                SudokuGridCell sgc = _grid[i][j];
                SudokuGridCell sgcSol = _solution[i][j];
                int gridVal = sgc.getValue();
                int solVal = sgcSol.getValue();
                if (gridVal == 0 || (gridVal != solVal))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Instantly set the grid to solved.
     */
    public void InstantSolveGrid()
    {
        //set the game grid to the solution grid so it's solved
        _grid = _solution.clone();
    }
    
    /**
     * Instantly reset the grid back to the start condition.
     */
    public void InstantResetGrid()
    {
        for (int i = 0; i < _xSize; i++)
        {
            for (int j = 0; j < _ySize; j++)
            {
                SudokuGridCell sgc = new SudokuGridCell();
                sgc.setIsLocked(_gridStartCondition[i][j].getIsLocked());
                sgc.setValue(_gridStartCondition[i][j].getValue());
                _grid[i][j] = sgc;
            }
        }
    }
    
    /**
     * Attempt to set the grid cell to a given value.
     *  If the input is invalid (i.e. contained in row, column, or sector
     *  nothing will happen.  If the input is valid, the grid will be updated
     *  either way, the grid gets reprinted at the end.
     * @param row the row position
     * @param col the grid position
     * @param val the value to update
     */
    public boolean SetCellValue(int row, int col, int val)
    {
        //validate that the cell can be updated
        if (val < 1 || val > 9) 
        {
            return false;
        }
        
        boolean isOK = ValidateInput(row, col,val);
        if (isOK)
        {
            SudokuGridCell sgc = _grid[row][col];
            sgc.setValue(val);
            return true;
        }
        return false;
    }
    
    /**
     * Validate input
     * @param row the row
     * @param col the column
     * @param val the value
     * @return true if can be inserted, else false.
     * obviously, this works only against the game grid, not the solution grid.
     */
    private boolean ValidateInput(int row, int col, int val)
    {
        SudokuGridCell sgc = _grid[row][col];
        if (sgc.IsLocked())
        {
            return false;
        }
        
        if (!isValidRow(row, val))
        {
            return false;
        }
        if (!isValidCol(col, val))
        {
            return false;
        }
        if (!isValidSector(row, col, val))
        {
            return false;
        }
        return true;
    }
    
    /**
     * Check for number already in row
     * @param row the row to parse
     * @param val the val to check
     * @return true if can insert, else false
     */
    private boolean isValidRow(int row, int val)
    {
        for (int i = 0; i < _ySize; i++)
        {
            SudokuGridCell sgc = _grid[row][i];
            if (sgc.getValue() == val)
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Check if number already in column
     * @param col
     * @param val
     * @return true if can insert in column, else false
     */
    private boolean isValidCol(int col, int val)
    {
        for (int i = 0; i < _xSize; i++)
        {
            SudokuGridCell sgc = _grid[i][col];
            if (sgc.getValue() == val)
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Check if valid in sector
     * @param row the row to insert to
     * @param col the col to insert to
     * @param val the val to insert
     * @return true if the sector is ok with this value, else false
     *  a sector is the 3x3 subgrid that this val exists in
     */
    private boolean isValidSector(int row, int col, int val)
    {
        int maxRow = 0;
        int minRow = 0;
        int maxCol = 0;
        int minCol = 0;
        
        if (row < 3)
        {
            maxRow = 3;
            minRow = 0;
        }
        else if (row < 6)
        {
            maxRow = 6;
            minRow = 3;
        }
        else 
        {
            maxRow = 9;
            minRow = 6;
        }
        
        if (col < 3)
        {
            maxCol = 3;
            minCol = 0;
        }
        else if (col < 6)
        {
            maxCol = 6;
            minCol = 3;
        }
        else
        {
            maxCol = 9;
            minCol = 6;
        }
        
        for (int i = minRow; i < maxRow; i++)
        {
            for (int j = minCol; j < maxCol; j++)
            {
                SudokuGridCell sgc = _grid[i][j];
                if (sgc.getValue() == val)
                {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Print the Game Grid formatted as a String.
     * @return grid formatted as a String.
     */
    public String toString()
    {
        return printGridAsString(_grid);
    }
    
    /**
     * Print the solution Grid
     * @return the solution grid formatted as a String
     */
    public String solutionToString()
    {
        return printGridAsString(_solution);
    }
    
    /**
     * Format print the grid in a readable way.
     * @param grid The grid to print out
     * @return String representing the grid data.
     */
    private String printGridAsString(SudokuGridCell[][] grid)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(COLUMN_LINE);
        sb.append("\n");
        sb.append(HORIZONTAL_LINE);
        sb.append("\n");
        for (int i = 0; i < _xSize; i++)
        {
            for (int j = 0; j < _ySize; j++)
            {
                if (j == 0)
                {
                    sb.append(String.format("%d] ", i));
                }
                SudokuGridCell gridCell = grid[i][j];
                int cellVal = gridCell.getValue();
                if (cellVal != 0)
                {
                    sb.append(gridCell.toString());
                }
                else
                {
                    //print a " "
                    sb.append(" ");
                }
                if ((j+1) % 3 == 0)
                {
                    sb.append(" | ");
                }
                else
                {
                    sb.append(" : ");
                }
            }
            sb.append("\n");
            if ((i+1) % 3 == 0)
            {
                sb.append(HORIZONTAL_LINE);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
