/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thejpanel;

import javax.swing.*;

/**
 *
 * @author Riker
 */
public class TheJPanel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame mainBoard = new JFrame();
        mainBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainBoard.getContentPane().setSize(400,400);
        mainBoard.setTitle("Sudoku");
        mainBoard.setBounds(250,250, 400,400);
        mainBoard.setVisible(true);
        
        JPanel panelWithNothing = new JPanel();
        mainBoard.add(panelWithNothing);
        
        CustomPanel cp = new CustomPanel();
        mainBoard.add(cp);
    }
}
