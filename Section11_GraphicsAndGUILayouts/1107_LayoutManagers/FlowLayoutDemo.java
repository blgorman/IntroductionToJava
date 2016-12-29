/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package layoutmanagers;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Brian
 */
public class FlowLayoutDemo extends JFrame{
    //panels are created with flow layout by default
    //, so nothing has to be done to get the layout set
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    public FlowLayoutDemo()
    {
        JPanel display = new JPanel(new GridLayout(2,1));
        
        //create the buttons
        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");
        b4 = new JButton("Button 4");
        
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(b1);
        p1.add(b2);
        
        JPanel p2 = new JPanel();
        p2.add(b3);
        p2.add(b4);
        
        display.add(p1);
        display.add(p2);
        add(display);
        
        //set everything visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setSize(400,400);
        this.setTitle("Best Game Ever");
        this.setBounds(250,250,400,400);
        this.setVisible(true);
    }
}
