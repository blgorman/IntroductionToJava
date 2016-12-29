/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sudoku;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author MajorGuidance
 */
public class SudokuGrid implements Serializable
{
    private SudokuGridValueCell[][] _grid;
    private SudokuGridValueCell[][] _gridStartCondition;
    private SudokuGridValueCell[][] _solution;
    private final int _xSize = 9;
    private final int _ySize = 9;
    private int _difficultyLevel;
    Random r;
    /**
     * Create a new grd objectfor gameplay.
     * difficulty = easiet, default seed.
     */
    public SudokuGrid()
    {
        _difficultyLevel = 0;
        r = new Random();
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
        r = new Random();
        ResetGame();
    }
    
    /**
     * Reset the game.
     */
    private void ResetGame()
    {
        _grid = new SudokuGridValueCell[_xSize][_ySize];
        _gridStartCondition = new SudokuGridValueCell[_xSize][_ySize];
        for (int i = 0; i < _xSize; i++)
        {
            for (int j = 0; j < _ySize; j++)
            {
                _grid[i][j] = new SudokuGridValueCell(0, false);
                _gridStartCondition[i][j] = new SudokuGridValueCell(0,false);
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
        _solution = new SudokuGridValueCell[_xSize][_ySize];
        SudokuGenerator sg = new SudokuGenerator();
        int[][] tempSol = sg.generateSolution(new int[_xSize][_ySize], 0);
        for (int i = 0; i < _xSize; i++)
        {
            for (int j = 0; j < _ySize; j++)
            {
                SudokuGridValueCell sgc = new SudokuGridValueCell();
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
                SudokuGridValueCell sgc = new SudokuGridValueCell();
                sgc.setValue(tempGame[i][j]);
                sgc.setIsLocked(sgc.getValue() != 0);
                _grid[i][j] = sgc;
                SudokuGridValueCell sgc2 = new SudokuGridValueCell();
                sgc2.setValue(tempGame[i][j]);
                sgc2.setIsLocked(sgc.getValue() != 0);
                _gridStartCondition[i][j] = sgc2;
            }
        }
        
        int x;
        int y;
        boolean altered = false;
        
        if (_difficultyLevel == 0)
        {
            //easiest -- add in one more number per sector
            x = GetNextRandom(0, 2);
            y = GetNextRandom(0, 2);
            PartialSolveBlock(x, y, 0, 2, 0, 2);
            x = GetNextRandom(3,5);
            y = GetNextRandom(0,2);
            PartialSolveBlock(x, y, 3, 5, 0, 2);
            x = GetNextRandom(6,8);
            y = GetNextRandom(0,2);
            PartialSolveBlock(x, y, 6, 8, 0, 2);
            x = GetNextRandom(0,2);
            y = GetNextRandom(3,5);
            PartialSolveBlock(x, y, 0, 2, 3, 5);
            x = GetNextRandom(3,5);
            y = GetNextRandom(3,5);
            PartialSolveBlock(x, y, 3, 5, 3, 5);
            x = GetNextRandom(6,8);
            y = GetNextRandom(3,5);
            PartialSolveBlock(x, y, 6, 8, 3, 5);
            x = GetNextRandom(0,2);
            y = GetNextRandom(6,8);
            PartialSolveBlock(x, y, 0, 2, 6, 8);
            x = GetNextRandom(3,5);
            y = GetNextRandom(6,8);
            PartialSolveBlock(x, y, 3, 5, 6, 8);
            x = GetNextRandom(6,8);
            y = GetNextRandom(6,8);
            PartialSolveBlock(x, y, 6, 8, 6, 8);
        }
        else if (_difficultyLevel == 1)
        {
            int alteredCount = 0;
            //easy -- add in 6 extra numbers at random cells
            while (alteredCount < 5)
            {
                x = GetNextRandom(0,8);
                y = GetNextRandom(0,8);
                if (!_grid[x][y].IsLocked())
                {
                    SudokuGridValueCell sgc = new SudokuGridValueCell();
                    sgc.setValue(_solution[x][y].getValue());
                    sgc.setIsLocked(sgc.getValue() != 0);
                    _grid[x][y] = sgc;
                    SudokuGridValueCell sgc2 = new SudokuGridValueCell();
                    sgc2.setValue(_solution[x][y].getValue());
                    sgc2.setIsLocked(sgc.getValue() != 0);
                    _gridStartCondition[x][y] = sgc2;
                    alteredCount++;
                }
            }
        }
        else if (_difficultyLevel == 2)
        {
            //medium -- add in 3 extra numbers at random cells
            int alteredCount = 0;
            while (alteredCount < 3)
            {
                x = GetNextRandom(0,8);
                y = GetNextRandom(0,8);
                if (!_grid[x][y].IsLocked())
                {
                    SudokuGridValueCell sgc = new SudokuGridValueCell();
                    sgc.setValue(_solution[x][y].getValue());
                    sgc.setIsLocked(sgc.getValue() != 0);
                    _grid[x][y] = sgc;
                    SudokuGridValueCell sgc2 = new SudokuGridValueCell();
                    sgc2.setValue(_solution[x][y].getValue());
                    sgc2.setIsLocked(sgc.getValue() != 0);
                    _gridStartCondition[x][y] = sgc2;
                    alteredCount++;
                }
            }
        }
        //otherwise leave as is
    }
    
    /**
     * Solve part of the puzzle to lower the difficulty
     * @param x row coord
     * @param y col coord
     * @param minx min value for row
     * @param maxx max value for row
     * @param miny min value for col
     * @param maxy max value for col
     */
    private void PartialSolveBlock(int x, int y, int minx, int maxx
                                    , int miny, int maxy)
    {
        boolean altered = false;
        
        while((_grid[x][y]).IsLocked() && altered == false)
        {
            x++;
            if (x > maxx) x=minx;

            if ((_grid[x][y]).IsLocked() && altered == false)
            {
                y++;
                if (y > maxy) y=miny;
                if ((_grid[x][y]).IsLocked() && altered == false)
                {
                    y--;
                    if (y < miny) y = maxy;
                }
                else
                {
                    SudokuGridValueCell sgc = new SudokuGridValueCell();
                    sgc.setValue(_solution[x][y].getValue());
                    sgc.setIsLocked(sgc.getValue() != 0);
                    _grid[x][y] = sgc;
                    SudokuGridValueCell sgc2 = new SudokuGridValueCell();
                    sgc2.setValue(_solution[x][y].getValue());
                    sgc2.setIsLocked(sgc.getValue() != 0);
                    _gridStartCondition[x][y] = sgc2;
                    altered = true;
                }
            }
            else
            {
                SudokuGridValueCell sgc = new SudokuGridValueCell();
                sgc.setValue(_solution[x][y].getValue());
                sgc.setIsLocked(sgc.getValue() != 0);
                _grid[x][y] = sgc;
                SudokuGridValueCell sgc2 = new SudokuGridValueCell();
                sgc2.setValue(_solution[x][y].getValue());
                sgc2.setIsLocked(sgc.getValue() != 0);
                _gridStartCondition[x][y] = sgc2;
                altered = true;
            }
        }
        if (!altered)
        {
            SudokuGridValueCell sgc = new SudokuGridValueCell();
            sgc.setValue(_solution[x][y].getValue());
            sgc.setIsLocked(sgc.getValue() != 0);
            _grid[x][y] = sgc;
            SudokuGridValueCell sgc2 = new SudokuGridValueCell();
            sgc2.setValue(_solution[x][y].getValue());
            sgc2.setIsLocked(sgc.getValue() != 0);
            _gridStartCondition[x][y] = sgc2;
            altered = true;
        }
    }
    
    /**
     * Get a true random for a range
     * @param min the minimum value in the range
     * @param max the maximum value in the range
     * @return a random in range min to max
     */
    private int GetNextRandom(int min, int max)
    {
        return min + (int)(java.lang.Math.random() * ((max - min) + 1));
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
                SudokuGridValueCell sgc = _grid[i][j];
                SudokuGridValueCell sgcSol = _solution[i][j];
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
        /*
        for (int i = 0; i < _xSize; i++)
        {
            for (int j = 0; j < _ySize; j++)
            {
                SudokuGridValueCell sgc = new SudokuGridValueCell();
                sgc.setIsLocked(_gridStartCondition[i][j].getIsLocked());
                sgc.setValue(_gridStartCondition[i][j].getValue());
                _grid[i][j] = sgc;
            }
        }
        */
        _grid = _gridStartCondition.clone();
    }
    
    
    /**
     * Have to allow the user to enter a bad number but not set the grid.
     * @param row row to check
     * @param col col to check
     * @param val val to check
     * @return true if it's a good value, else false
     */
    public boolean CheckCellValue(int row, int col, int val)
    {
        if (val < 1 || val > 9) 
        {
            return false;
        }
        return ValidateInput(row, col,val);
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
            SudokuGridValueCell sgc = _grid[row][col];
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
        SudokuGridValueCell sgc = _grid[row][col];
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
            SudokuGridValueCell sgc = _grid[row][i];
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
            SudokuGridValueCell sgc = _grid[i][col];
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
                SudokuGridValueCell sgc = _grid[i][j];
                if (sgc.getValue() == val)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    /** get the grids as value that can be used to generate the results**/
    /**
     * Return the Game Grid
     * @return game Grid current state
     */
    public SudokuGridValueCell[][] getGameGrid()
    {
        return _grid;
    }
    
    /**
     * Return the solution
     * @return the solved grid
     */
    public SudokuGridValueCell[][] getSolution()
    {
        return _solution;
    }
    
    /**
     * Return the start condition/reset grid
     * @return start condition grid.
     */
    public SudokuGridValueCell[][] getStartCondition()
    {
        return _gridStartCondition;
    }
}
