import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Brian
 */
public class RestoreState extends BaseForm {
    private JPanel pnlRestoreState;
    private JTextField txtFilePath;
    private JButton btnRestoreFile;
    private JLabel lblPrompt;
    private JTextArea txtActionReport;
    
    public RestoreState(){
        super();
        SetupForm();
    }
    
    private void SetupForm(){
    
        pnlRestoreState = new JPanel();
        pnlRestoreState.setLayout(null);

        JLabel lblPrompt = new JLabel("Please enter the name of the file to "
                + "restore state from, including extension:");
        lblPrompt.setBounds(38, 41, 376, 14);
        pnlRestoreState.add(lblPrompt);
        
        txtFilePath = new JTextField();
        txtFilePath.setBounds(40, 66, 309, 20);
        pnlRestoreState.add(txtFilePath);
        txtFilePath.setColumns(10);

        txtActionReport = new JTextArea();
        txtActionReport.setEditable(false);
        txtActionReport.setText("[Action Report]");
        txtActionReport.setBackground(Color.GRAY);
        txtActionReport.setForeground(Color.CYAN);
        txtActionReport.setBounds(40, 158, 309, 103);
        pnlRestoreState.add(txtActionReport);
        
        btnRestoreFile = new JButton("Restore File");
        btnRestoreFile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //restore the inventory from the file
                    //save the state to the file listed
                    String filePath = txtFilePath.getText();
                    StringBuilder sb = new StringBuilder();
                    
                    if (filePath == null || filePath.equals(""))
                    {
                        sb.append("Invalid File Selected.  No action taken.");
                    }
                    else
                    {
                        try
                        {
                            AutoLotSystem.theInventory = 
                              AutoLotSystem.theInventory.RestoreState(filePath);
                            sb.append("The system was successfully restored.");
                        }
                        catch (Exception ex)
                        {
                            sb.append(String.format("ERROR: %s\n"
                                    , ex.getMessage()));
                        }
                    }
                    txtActionReport.setText(sb.toString());
                }
        });
        btnRestoreFile.setBounds(260, 97, 89, 23);
        pnlRestoreState.add(btnRestoreFile);
        
        getContentPane().add(pnlRestoreState);
    }
}

