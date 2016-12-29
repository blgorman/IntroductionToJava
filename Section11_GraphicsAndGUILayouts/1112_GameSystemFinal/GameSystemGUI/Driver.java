package GameSystemGUI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MajorGuidance
 */
public class Driver {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //create the GameSystem GUI on run
                    GameSystem gs = new GameSystem();
                    
                    JPanel panel = new JPanel();
                    panel.setBounds(0, 0, 800, 800);
                    gs.getContentPane().add(panel);
                    gs.setVisible(true);
                    gs.setLocation(250,250);
                    gs.setSize(Constants.width+20,Constants.height+60);
                    gs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gs.setTitle("Java Games");
                    gs.setBounds(0, 0, Constants.width+20,Constants.height+60);
                    gs.setVisible(true);
                } 
                catch (Exception e) {
                        e.printStackTrace();
                }
            }
        });
    }
}
