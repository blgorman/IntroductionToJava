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
public class Checkers extends JInternalFrame {

    public Checkers(){
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
        JLabel title = new JLabel("Checkers");
        game.add(title);
        JPanel board = new JPanel(new GridLayout(8,8));
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                JButton b = new JButton();
                b.setName(String.format("%d_%d", i, j));
                if (i % 2 == 0)
                {
                    if (j % 2 == 0)
                    {
                        b.setBackground(Color.RED);
                    }
                    else
                    {
                        b.setBackground(Color.WHITE);
                    }
                }
                else
                {
                    if (j % 2 == 0)
                    {
                        b.setBackground(Color.WHITE);
                    }
                    else
                    {
                        b.setBackground(Color.RED);
                    }
                }
                b.addActionListener(new buttonPressEvent());
                board.add(b);
            }
        }
        
        game.add(board);
        add(game);
        //pack and show:
        pack();
        setVisible(true);
    }
    
    class buttonPressEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            if (src instanceof JButton)
            {
                JButton b = (JButton)src;
                JOptionPane.showMessageDialog(null, b.getName());
            }
        }
    
    }
}
