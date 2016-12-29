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
public class SudokuGridCellExceptionTest extends junit.framework.TestCase {
    
    public SudokuGridCellExceptionTest() {
    }
    
    public void setUp() {
    }
    
    public void tearDown() {
    }
   
    public void testExceptions()
    {
        SudokuGridCellException sgce = new SudokuGridCellException();
        assertNotNull("Could not create default sgce", sgce);
        assertEquals("The message was not as expected for sgce"
                        , "Grid cells must contain numbers 1-9 only."
                        , sgce.getMessage());
        SudokuGridCellException sgce2 
                = new SudokuGridCellException("ERROR Encountered Here");
        assertNotNull("Could not create explicit sgce", sgce2);
        assertEquals("The message was not as expected for sgce"
                        , "Grid cells must contain numbers 1-9 only.\n"
                            + "ERROR Encountered Here"
                        , sgce2.getMessage());
        
    }
}