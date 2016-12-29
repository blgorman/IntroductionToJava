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
public class GridLayoutDemo extends JFrame{
    //grid layout is the easiest to manage.  #rows, #cols.  
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton b8;
    
    
    public GridLayoutDemo(){
        JPanel display = new JPanel(new GridLayout(2,4));
        //create the buttons
        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");
        b4 = new JButton("Button 4");
        b5 = new JButton("Button 5");
        b6 = new JButton("Button 6");
        b7 = new JButton("Button 7");
        b8 = new JButton("Button 8");
        
        display.add(b1);
        display.add(b2);
        display.add(b3);
        display.add(b4);
        display.add(b5);
        display.add(b6);
        display.add(b7);
        display.add(b8);
        
        add(display);
        
        //set everything visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setSize(400,400);
        this.setTitle("Best Game Ever");
        this.setBounds(250,250,400,400);
        this.setVisible(true);
    }
}
