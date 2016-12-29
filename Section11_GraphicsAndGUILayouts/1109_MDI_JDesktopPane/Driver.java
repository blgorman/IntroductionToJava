/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mdi_jdesktoppane;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Brian
 */
public class Driver {
    public static final int width = 640;
    public static final int height = 480;
    
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MDI_JDesktopPane g = new MDI_JDesktopPane();
                    g.setLocation(150,25);
                    g.setSize(Driver.width+20,Driver.height+60);
                    g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    g.setTitle("Best Application Ever");
                    g.setBounds(0, 0, Driver.width,Driver.height);
                    g.setVisible(true);
                } catch (Exception e) {
                        e.printStackTrace();
                }
            }
        });
    }
}
