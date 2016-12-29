/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brian
 */
public class SudokuGridCellTest {
    private final boolean isLockedFalse = false;
    private final boolean isLockedTrue = true;
    private final int value = 7;
    private SudokuGridCell GridCellUnlockedNoValue;
    private SudokuGridCell GridCellLockedNoValue;
    private SudokuGridCell GridCellUnlockedValue;
    private SudokuGridCell GridCellLockedValue;
    private SudokuGridCell GridCellDefault;
    
    @Before
    public void setUp() {
        GridCellDefault = new SudokuGridCell();
        GridCellUnlockedValue = new SudokuGridCell(value);
        GridCellLockedValue = new SudokuGridCell(value, isLockedTrue);
        GridCellUnlockedNoValue = new SudokuGridCell(0, isLockedFalse);
        GridCellLockedNoValue = new SudokuGridCell(0, isLockedTrue);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testConstructors()
    {
        assertNotNull("Cell was not constructed as expected"
                        , GridCellDefault);
        assertEquals("Cell was not constructed with proper value"
                        , 0
                        , GridCellDefault.getValue());
        assertEquals("Cell was not constructed with proper lock"
                        , isLockedFalse
                        , GridCellDefault.getIsLocked());
        
        assertNotNull("Cell was not constructed as expected"
                        , GridCellUnlockedValue);
        assertEquals("Cell was not constructed with proper value"
                        , value
                        , GridCellUnlockedValue.getValue());
        assertEquals("Cell was not constructed with proper lock"
                        , isLockedFalse
                        , GridCellUnlockedValue.getIsLocked());
        
        assertNotNull("Cell was not constructed as expected"
                        , GridCellLockedValue);
        assertEquals("Cell was not constructed with proper value"
                        , value
                        , GridCellLockedValue.getValue());
        assertEquals("Cell was not constructed with proper lock"
                        , isLockedTrue
                        , GridCellLockedValue.getIsLocked());
        
        assertNotNull("Cell was not constructed as expected"
                        , GridCellUnlockedNoValue);
        assertEquals("Cell was not constructed with proper value"
                        , 0
                        , GridCellUnlockedNoValue.getValue());
        assertEquals("Cell was not constructed with proper lock"
                        , isLockedFalse
                        , GridCellUnlockedNoValue.getIsLocked());
        
        assertNotNull("Cell was not constructed as expected"
                        , GridCellLockedNoValue);
        assertEquals("Cell was not constructed with proper value"
                        , 0
                        , GridCellLockedNoValue.getValue());
        assertEquals("Cell was not constructed with proper lock"
                        , isLockedTrue
                        , GridCellLockedNoValue.getIsLocked());
        
    }
    
    @Test
    public void testAccessorsAndMutators()
    {
        //get/set value
        GridCellDefault.setValue(value);
        assertEquals("The grid cell value was not set as expected"
                        , value
                        , GridCellDefault.getValue());
        
        boolean caught = false;
        try
        {
            GridCellDefault.setValue(-1);
        }
        catch (SudokuGridCellException sgce)
        {
            caught = true;
        }
        assertTrue("Grid cell did not prevent bad value as expected"
                    , caught);
        caught = false;
        
        try
        {
            GridCellDefault.setValue(10);
        }
        catch (SudokuGridCellException sgce)
        {
            caught = true;
        }
        assertTrue("Grid cell did not prevent bad value as expected"
                    , caught);
        
        //get/set isLocked
        GridCellDefault.setIsLocked(isLockedTrue);
        assertEquals("The grid cell lock was not set as expected"
                        , isLockedTrue
                        , GridCellDefault.getIsLocked());
        GridCellDefault.setIsLocked(isLockedFalse);
        assertEquals("The grid cell lock was not set as expected"
                        , isLockedFalse
                        , GridCellDefault.getIsLocked());
    }
    
    @Test
    public void testToString()
    {
        //since the toString is only returning the value
        //we need to make sure it is as expected
        GridCellLockedValue = new SudokuGridCell(value, isLockedTrue);
        String gridCellValue = GridCellLockedValue.toString();
        assertEquals("Cell Value was not returned as expected in toString()"
                        , String.format("%d", value)
                        , gridCellValue);
        
        GridCellDefault = new SudokuGridCell();
        gridCellValue = GridCellDefault.toString();
        assertEquals("Cell Value was not returned as expected in toString()"
                        , "0"
                        , gridCellValue);
    }
}