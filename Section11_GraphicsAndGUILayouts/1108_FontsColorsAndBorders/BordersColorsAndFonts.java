/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fontscolorsandborders;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.BorderFactory.*;
import java.awt.event.*;

/**
 *
 * @author Brian
 */
public class BordersColorsAndFonts extends JFrame {

    public BordersColorsAndFonts(){
        String player1Name = 
                JOptionPane.showInputDialog("What is the name of player 1?");
        String player2Name = 
                JOptionPane.showInputDialog("What is the name of player 2?");
        
        JPanel namePane = new JPanel(new GridLayout(2,1));
        
        JPanel name1Panel = new JPanel();
        JLabel name1Text = new JLabel(player1Name);
        Font f1 = new Font("Verdana", Font.PLAIN, 14);
        name1Text.setFont(f1);
        name1Text.setForeground(Color.ORANGE);
        name1Panel.add(name1Text);
        Border border1 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        name1Panel.setBorder(border1);
        namePane.add(name1Panel);
        
        JPanel name2Panel = new JPanel();
        name2Panel.setBorder(BorderFactory.createBevelBorder(
                                BevelBorder.RAISED, Color.YELLOW
                                , Color.BLACK));
        JLabel name2Text = new JLabel(player2Name);
        name2Text.setFont(new Font("Tahoma", Font.ITALIC, 14));
        name2Text.setForeground(Color.BLUE);
        name2Panel.add(name2Text);
        namePane.add(name2Panel);
        
        JPanel gamePane = new JPanel(new GridLayout(8,8));
        
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
                gamePane.add(b);
            }
        }
        
        JPanel mainPanel = new JPanel(new GridLayout(2,1));
        mainPanel.add(namePane);
        mainPanel.add(gamePane);
        
        add(mainPanel);
        
        //set everything visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setSize(400,400);
        this.setTitle("Best Game Ever");
        this.setBounds(250,250,400,400);
        this.setVisible(true);
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

