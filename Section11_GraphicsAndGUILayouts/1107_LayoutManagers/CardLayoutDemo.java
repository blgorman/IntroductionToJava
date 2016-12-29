/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package layoutmanagers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Brian
 */
public class CardLayoutDemo extends JFrame{
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JComboBox cardChanger;
    final String c1 = "Top Buttons";
    final String c2 = "Secondary Buttons";
    public JPanel displayCards;
    
    public CardLayoutDemo(){
        JPanel p1 = new JPanel(); //any layout could be used here.
        JPanel p2 = new JPanel(); //any layout could be used here.
        
        //create the buttons
        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");
        b4 = new JButton("Button 4");
        b5 = new JButton("Button 5");
        //add buttons to each "card" panel
        p1.add(b1);
        p1.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        //create the cards panel container
        displayCards = new JPanel(new CardLayout());
        displayCards.add(p1, c1);
        displayCards.add(p2, c2);
        //create a combobox to change the cards at will
        String choices[] = { c1, c2 };
        cardChanger = new JComboBox(choices);
        cardChanger.setEditable(false);
        cardChanger.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
        
                CardLayout cl = (CardLayout)(displayCards.getLayout());
                cl.show(displayCards, (String)e.getItem());
            }
        });
        //display the combo box and the cards that can be changed
        JPanel display = new JPanel();
        display.add(cardChanger);
        display.add(displayCards);
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

