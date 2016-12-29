package mdi_jdesktoppane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Brian
 */
public class MDI_JDesktopPane extends JFrame {

    private JDesktopPane desktopPane;
    private JInternalFrame jifSudoku;
    private JInternalFrame jifCheckers;
    
    public MDI_JDesktopPane(){
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
        
        JMenu mnitemApplications = new JMenu("Games");
        mb.add(mnitemApplications);
        
        JMenuItem mnitemSudoku = new JMenuItem("Sudoku");
        mnitemSudoku.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jifSudoku = new Sudoku();
                jifSudoku.setBounds(0, 0, Driver.width, Driver.height);
                desktopPane.add(jifSudoku);
            }
        });
        
        mnitemApplications.add(mnitemSudoku);
        
        JMenuItem mnitemCheckers = new JMenuItem("Checkers");
        mnitemCheckers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jifCheckers = new Checkers();
                jifCheckers.setBounds(0, 0, Driver.width, Driver.height);
                desktopPane.add(jifCheckers);
            }
        });
        mnitemApplications.add(mnitemCheckers);
        
        
        
    }
}
