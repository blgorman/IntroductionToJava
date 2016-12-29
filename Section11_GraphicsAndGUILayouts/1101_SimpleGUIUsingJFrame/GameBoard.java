/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleguiusingjframe;

import javax.swing.*;

/**
 *
 * @author Brian
 */
public class GameBoard extends JFrame {
    public GameBoard(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setSize(400,400);
        this.setTitle("Sudoku");
        this.setBounds(250,250, 400,400);
        this.setVisible(true);
    }
}
