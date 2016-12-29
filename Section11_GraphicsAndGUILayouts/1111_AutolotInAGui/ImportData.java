import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Brian
 */
public class ImportData extends BaseForm 
{
    private JPanel pnlFilePrompt;
    private JTextField txtFilePath;
    private JLabel lblPrompt;
    private JButton btnChooseFile;
    private JTextArea txtActionReport;
    
    public ImportData(){
        super();
        SetupForm();
    }
    
    /**
     * Create the form to view vehicles.
     */
    private void SetupForm(){
        getContentPane().setFont(new Font("Verdana", Font.PLAIN, 12));
        getContentPane().setBackground(Color.WHITE);
        
        pnlFilePrompt = new JPanel();
        pnlFilePrompt.setLayout(null);  //going to use an absolute layout
        
        lblPrompt = new JLabel("Please Enter the path to the file, then select \"Choose File\" to load contents");
        lblPrompt.setVerticalAlignment(SwingConstants.TOP);
        lblPrompt.setBounds(20, 20, 375, 25);
        pnlFilePrompt.add(lblPrompt);
        
        txtFilePath = new JTextField();
        txtFilePath.setBounds(20, 50, 375, 25);
        txtFilePath.setColumns(10);
        pnlFilePrompt.add(txtFilePath);
        
        btnChooseFile = new JButton("Choose File");
	btnChooseFile.setBounds(292, 80, 100, 25);
        btnChooseFile.addActionListener(new ChooseFilePressed());
        
	pnlFilePrompt.add(btnChooseFile);
        
        txtActionReport = new JTextArea();
	txtActionReport.setText("[Action Report]");
	txtActionReport.setForeground(Color.BLUE);
	txtActionReport.setBackground(Color.LIGHT_GRAY);
	txtActionReport.setBounds(20, 110, 375, 150);
        txtActionReport.setEditable(false);
        pnlFilePrompt.add(txtActionReport);
        
        getContentPane().add(pnlFilePrompt);
    }
    
    /**
     * Handle the user selection of a button for loading vehicles.
     */
    class ChooseFilePressed implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder actionReport = new StringBuilder();
            String filePath = txtFilePath.getText();
            if (filePath == null || filePath.equals(""))
            {
                actionReport.append("No valid file chosen, operation exited.");
            }
            else
            {
                actionReport.append(String.format("Now loading data from "
                                            + "file: %s\n", 
                                            filePath));
            }
            txtActionReport.setText(actionReport.toString());
            
            //use the autolot system to import cars directly
            boolean success = false;
            try
            {
                AutoLotSystem.theInventory.ImportDataFromFile(filePath);
                success = true;
            }
            catch (Exception ex)
            {
                actionReport.append("Error: " + ex.getMessage());
            }
            
            if (success)
            {
                int vehicleCount = AutoLotSystem.theInventory.getVehicleCount();
                actionReport.append(String.format("Successfully loaded "
                        + "vehicles.  There are now %d vehicles"
                        + " in the system!", vehicleCount));
            }
            txtActionReport.setText(actionReport.toString());
        }
    
    }
}


