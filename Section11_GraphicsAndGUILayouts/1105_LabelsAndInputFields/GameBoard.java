/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package labelsandinputfields;
import javax.swing.*;
/**
 *
 * @author Brian
 */
public class GameBoard extends JPanel{

    public GameBoard(){
        //
        JLabel labelP1 = new JLabel("Please Enter the name of Player 1:");
        JLabel labelP2 = new JLabel("Please Enter the name of Player 2:");
        
        //
        JTextField jtfP1 = new JTextField(10);
        JTextField jtfP2 = new JTextField(10);
        
        JButton b1 = new JButton("Save Input");
        
        this.add(labelP1);
        this.add(jtfP1);
        this.add(labelP2);
        this.add(jtfP2);
        this.add(b1);
        this.setVisible(true);
    }
}
