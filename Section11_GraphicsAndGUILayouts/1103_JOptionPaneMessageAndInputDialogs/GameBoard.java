/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package joptionpanemessageandinputdialogs;
import javax.swing.*;
/**
 *
 * @author Brian
 */
public class GameBoard extends JFrame{

    public GameBoard(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setSize(400,400);
        this.setTitle("Sudoku");
        this.setBounds(250,250, 400,400);
        this.setVisible(true);
        
        String p1 = JOptionPane.showInputDialog(
                        "What is the name of player 1?");
        String p2 = JOptionPane.showInputDialog(
                        "What is the name of player 2?");
        String output = String.format("Player 1: %s\nPlayer 2: %s\n"
                                        , p1
                                        , p2);
        JOptionPane.showMessageDialog(null, output
                , "Player List", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
