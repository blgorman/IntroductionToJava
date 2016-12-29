/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplegraphicsandthejcomponent;

import javax.swing.*;

/**
 *
 * @author Brian
 */
public class ComponentFrame extends JFrame {
    public ComponentFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setSize(400,400);
        this.setTitle("GameBoard");
        this.setBounds(250,250,400,400);
        
        JavaGraphics1 jg1 = new JavaGraphics1();
        
        this.getContentPane().add(jg1);
        this.setVisible(true);
    }
}
