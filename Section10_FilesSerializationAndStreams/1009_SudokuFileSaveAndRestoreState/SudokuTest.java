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
public class SudokuTest extends GameShellTest{
    
    public SudokuTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Override
    public GameShell getGameShell() {
        return new Sudoku();
    }
    
    //For now, there isn't really a way to test gameplay
    //because it's all done in a void method and it just prints
    //everything out.  Testing will have to be done by playing 
    //the game.
}