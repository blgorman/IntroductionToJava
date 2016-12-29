/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package layoutmanagers;
import javax.swing.*;

public class BoxLayoutDemo extends JFrame{
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
       
    public BoxLayoutDemo(){
        //create a JPanel, setting the layout to "BorderLayout"
        JPanel display = new JPanel();
        display.setLayout(new BoxLayout(display, BoxLayout.Y_AXIS));
        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");
        b4 = new JButton("Button 4");
        b5 = new JButton("Button 5");
        display.add(b1);
        display.add(b2);
        display.add(b3);
        display.add(b4);
        display.add(b5);
        
        //add the display to the frame:
        add(display);
        //set everything visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setSize(400,400);
        this.setTitle("Best Game Ever");
        this.setBounds(250,250,400,400);
        this.setVisible(true);
    }
}

