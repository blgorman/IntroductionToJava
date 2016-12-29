import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Brian
 */
public class SaveState extends BaseForm {
    private JPanel pnlSaveState;
    private JTextField txtFilePath;
    private JButton btnSaveFile;
    private JLabel lblPrompt;
    private JTextArea txtActionReport;
    
    public SaveState(){
        super();
        SetupForm();
    }
    
    private void SetupForm(){
    
        pnlSaveState = new JPanel();
        pnlSaveState.setLayout(null);

        lblPrompt = new JLabel("Please enter the name of the file to save including extension:");
        lblPrompt.setBounds(38, 41, 311, 14);
        pnlSaveState.add(lblPrompt);
        
        txtFilePath = new JTextField();
        txtFilePath.setBounds(40, 66, 309, 20);
        pnlSaveState.add(txtFilePath);
        txtFilePath.setColumns(10);

        btnSaveFile = new JButton("Save File");
        btnSaveFile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
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
                            AutoLotSystem.theInventory.SaveState(filePath);
                            sb.append("The file with state "
                                    + "was successfully saved.");
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
        btnSaveFile.setBounds(260, 97, 89, 23);
        pnlSaveState.add(btnSaveFile);

        txtActionReport = new JTextArea();
        txtActionReport.setEditable(false);
	txtActionReport.setText("[Action Report]");
	txtActionReport.setBackground(Color.GRAY);
	txtActionReport.setForeground(Color.CYAN);
	txtActionReport.setBounds(40, 158, 309, 103);
        pnlSaveState.add(txtActionReport);
        
        getContentPane().add(pnlSaveState);
    }
}
