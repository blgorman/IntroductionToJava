/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package actionlisteners;

import javax.swing.JFrame;

/**
 *
 * @author Brian
 */
public class Game extends JFrame {
    public Game(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setSize(400,400);
        this.setTitle("Best Game Ever");
        this.setBounds(250,250, 400,400);
        
        GameBoard gb = new GameBoard();
        this.add(gb);
        this.setVisible(true);
    }
}
