/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mdi_jdesktoppane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Brian
 */
public class Sudoku extends JInternalFrame {

    public Sudoku(){
        SetupForm();
    }
    
    private void SetupForm(){
        //add content here...
        setBackground(Color.WHITE);
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        
        getContentPane().setFont(new Font("Verdana", Font.PLAIN, 12));
        getContentPane().setBackground(Color.WHITE);
        //getContentPane().setLayout(null);
        JPanel game = new JPanel(new GridLayout(2,1));
        JLabel title = new JLabel("Sudoku");
        //add borders, colors, etc.
        game.add(title);
        JPanel board = new JPanel(new GridLayout(9,9));
        
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                final JTextField jtf = new JTextField(1);
                jtf.setName(String.format("%d_%d", i, j));
                jtf.addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent e){
                        char c = e.getKeyChar();
                        if ( ((c < '1') || (c > '9')))
                        {
                            e.consume(); //ignore
                        }
                        else
                        {
                            //reset the text to just this value
                            String t = String.format("%s", c);
                            jtf.setText(t);

                            e.consume();
                        }

                    }
                });
                board.add(jtf);
            }
        }
        game.add(board);
        add(game);
        //pack and show:
        pack();
        setVisible(true);
    }
    
}

