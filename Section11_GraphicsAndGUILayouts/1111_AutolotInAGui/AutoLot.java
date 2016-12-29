import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Brian
 */
public class AutoLot extends JFrame{
    private JDesktopPane desktopPane;
    private JInternalFrame jifVehicleView;
    private JInternalFrame jifAddVehicle;
    private JInternalFrame jifRemoveVehicle;
    private JInternalFrame jifSaveState;
    private JInternalFrame jifRestoreState;
    private JInternalFrame jifImportData;
    
    public AutoLot(){
        
        desktopPane = new JDesktopPane();
        desktopPane.setBounds(0,0, Driver.width, Driver.height);
        getContentPane().add(desktopPane);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu mnFile = new JMenu("File");
        mb.add(mnFile);
        
        JMenuItem mnitemExit = new JMenuItem("Exit");
        mnitemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //exit
                int close = JOptionPane.showConfirmDialog(null
                                , "Are you sure you want to exit?"
                                , "End Application?"
                                , JOptionPane.YES_NO_OPTION
                                , JOptionPane.INFORMATION_MESSAGE);
                if (close == 1) return;
                System.exit(0);
            }
        });
        mnFile.add(mnitemExit);
        
        JMenu mnitemApplications = new JMenu("Actions");
        mb.add(mnitemApplications);
        
        /** view vehicles **/
        JMenuItem mnitemVehicleView = new JMenuItem("View/Update/Remove Vehicles");
        mnitemVehicleView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jifVehicleView = new VehicleView();
                jifVehicleView.setBounds(0, 0, Driver.width, Driver.height);
                desktopPane.add(jifVehicleView);
            }
        });
        
        mnitemApplications.add(mnitemVehicleView);
        
        /** add a new vehicle **/
        JMenuItem mnitemAddVehicle = new JMenuItem("Add Vehicle");
        mnitemAddVehicle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jifAddVehicle = new AddVehicle();
                jifAddVehicle.setBounds(0, 0, Driver.width, Driver.height);
                desktopPane.add(jifAddVehicle);
            }
        });
        mnitemApplications.add(mnitemAddVehicle);
        
        
        /** Data Operations **/
        JMenu mnitemDataOps = new JMenu("Data Operations");
        mb.add(mnitemDataOps);
        
        /** Save the lot **/
        JMenuItem mnitemSaveLot = new JMenuItem("Save Current State");
        mnitemSaveLot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jifSaveState = new SaveState();
                jifSaveState.setBounds(0, 0, Driver.width, Driver.height);
                desktopPane.add(jifSaveState);
            }
        });
        mnitemDataOps.add(mnitemSaveLot);
        
        /** Restore the lot **/
        JMenuItem mnitemRestoreLot = new JMenuItem("Restore Saved State");
        mnitemRestoreLot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jifRestoreState = new RestoreState();
                jifRestoreState.setBounds(0, 0, Driver.width, Driver.height);
                desktopPane.add(jifRestoreState);
            }
        });
        mnitemDataOps.add(mnitemRestoreLot);
        
        /** Import Data **/
        JMenuItem mnitemImportData = new JMenuItem("Import Vehicle Data");
        mnitemImportData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jifImportData = new ImportData();
                jifImportData.setBounds(0, 0, Driver.width, Driver.height);
                desktopPane.add(jifImportData);
            }
        });
        mnitemDataOps.add(mnitemImportData);
    }
}
