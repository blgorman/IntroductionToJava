
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Driver for AutoLot program.
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
                    //create a new autolot on run:
                    AutoLotSystem.theInventory = new AutolotControllers.AutoLot();
                    
                    //create the autolot GUI on run
                    AutoLot al = new AutoLot();
                    
                    JPanel panel = new JPanel();
                    panel.setBounds(0, 0, 800, 800);
                    al.getContentPane().add(panel);
                    al.setVisible(true);
                    al.setLocation(250,250);
                    al.setSize(Driver.width+20,Driver.height+60);
                    al.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    al.setTitle("The Autolot");
                    al.setBounds(0, 0, Driver.width+20,Driver.height+60);
                    al.setVisible(true);
                } catch (Exception e) {
                        e.printStackTrace();
                }
            }
        });
    }
}
