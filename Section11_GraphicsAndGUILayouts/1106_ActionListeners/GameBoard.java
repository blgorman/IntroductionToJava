/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package actionlisteners;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Brian
 */
public class GameBoard extends JPanel 
{
    JLabel labelP1;
    JLabel labelP2;
    JLabel labelResults;
    JTextField jtfP1;
    JTextField jtfP2;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    final String p1LabelName = "player1label";
    final String p2LabelName = "player2label";
    final String bNextName = "next";
    final String bFirstName = "first";
    final String bPrevName = "prev";
    final String bLastName = "last";
    int p1ClickCount = 0;
    int p2ClickCount = 0;
    int bClickCount = 0;
    
    public GameBoard(){
        this.setSize(400,400);
        
        //use a label to display static text
        labelP1 = new JLabel("Please Enter the name of Player 1:");
        labelP1.setName(p1LabelName);
        MouseListener al1 = new inputChange();
        labelP1.addMouseListener(al1);
        
        labelP2 = new JLabel("Please Enter the name of Player 2:");
        labelP2.setName(p2LabelName);
        MouseListener al2 = new inputChange();
        labelP2.addMouseListener(al2);
        
        //use JTextField to take input from the user:
        jtfP1 = new JTextField(10);
        jtfP2 = new JTextField(10);
        
        //add some buttons
        b1 = new JButton("Save Input");
        b1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean enabled = false;
                String message ="";
                
                switch(bClickCount % 2)
                {
                    case 0:
                        message = "Player names Set!";
                        enabled = false;
                        b1.setText("Unlock Players");
                        break;
                    case 1:
                        message = "Player names Unlocked!";
                        enabled = true;
                        b1.setText("Save Input");
                        break;
                    default:
                        break;
                }
                jtfP1.setEnabled(enabled);
                jtfP2.setEnabled(enabled);
                JOptionPane.showMessageDialog(null, message, "Players"
                                            , JOptionPane.INFORMATION_MESSAGE);
                bClickCount++;
            }
        });
        
        
        this.add(labelP1);
        this.add(jtfP1);
        this.add(labelP2);
        this.add(jtfP2);
        this.add(b1);
        
        ActionListener navButtonEvent = new NavigationButtonPressEvent();
        b2 = new JButton(" << first ");
        b2.setName(bFirstName);
        b2.addActionListener(navButtonEvent);
        b3 = new JButton(" < prev ");
        b3.setName(bPrevName);
        b3.addActionListener(navButtonEvent);
        b4 = new JButton(" > next ");
        b4.setName(bNextName);
        b4.addActionListener(navButtonEvent);
        b5 = new JButton(" >> last ");
        b5.setName(bLastName);
        b5.addActionListener(navButtonEvent);
        
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        
        labelResults = new JLabel();
        this.add(labelResults);
        
        this.setVisible(true);
    }
    
    class NavigationButtonPressEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            if (src instanceof JButton)
            {
                JButton b = (JButton)src;
                String bName = b.getName();
                String message = "";
                if (bName.equals(bFirstName))
                {
                    message = "Button First Pressed.";
                }
                else if (bName.equals(bLastName))
                {
                    message = "Button Last Pressed.";
                }
                else if (bName.equals(bPrevName))
                {
                    message = "Button Previous Pressed.";
                }
                else if (bName.equals(bNextName))
                {
                    message = "Button Next Pressed.";
                }
                labelResults.setText(message);
            }
        }
    
    }
    
    class inputChange implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            Object src = e.getSource();
            if (src instanceof JLabel)
            {
                JLabel aLabel = (JLabel)src;
                if (aLabel.getName().equals(p1LabelName))
                {
                    switch (p1ClickCount % 2)
                    {
                        case 0:
                            aLabel.setForeground(Color.GREEN);
                            break;
                        case 1:
                            aLabel.setForeground(Color.BLACK);
                            break;
                        default:
                            break;
                    }
                    p1ClickCount++;
                }
                else if (aLabel.getName().equals(p2LabelName))
                {
                    switch (p2ClickCount % 2)
                    {
                        case 0:
                            aLabel.setFont(new Font("Verdana", Font.BOLD, 12));
                            break;
                        case 1:
                            aLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
                            break;
                        default:
                            break;
                    }
                    p2ClickCount++;
                }    
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
    
    }
}
