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
public class BorderLayoutDemo extends JFrame{
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
        
    public BorderLayoutDemo() {
        //create a JPanel, setting the layout to "BorderLayout"
        JPanel display = new JPanel(new BorderLayout());
        b1 = new JButton("NORTH");
        b2 = new JButton("EAST");
        b3 = new JButton("WEST");
        b4 = new JButton("SOUTH");
        b5 = new JButton("MIDDLE");
        //add whatever controls to each section of the panel
        display.add(b1,  BorderLayout.NORTH);
        display.add(b2, BorderLayout.EAST);
        display.add(b3, BorderLayout.WEST);
        display.add(b4, BorderLayout.SOUTH);
        display.add(b5, BorderLayout.CENTER);
        //obviously, you could modify any of these sections
        //add action listeners, etc.
        
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
