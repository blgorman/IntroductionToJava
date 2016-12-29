/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joptionpanemessageandinputdialogs;

import javax.swing.JOptionPane;

/**
 *
 * @author Riker
 */
public class JOptionPaneMessageAndInputDialogs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n1 =
            Integer.parseInt(JOptionPane.showInputDialog
                                ("Please enter the first number"));
        int n2 =
            Integer.parseInt(JOptionPane.showInputDialog
                                ("Please enter the second number"));
        String output = String.format("N1 * N2 = %d", n1 * n2);
        JOptionPane.showMessageDialog(null, output
                , "Result", JOptionPane.INFORMATION_MESSAGE);
        
        GameBoard board = new GameBoard();
    }
}
