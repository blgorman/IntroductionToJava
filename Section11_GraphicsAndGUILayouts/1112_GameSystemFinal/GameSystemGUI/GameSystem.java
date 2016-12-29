package GameSystemGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GameSystem Shell.
 * @author Brian
 */
public class GameSystem extends JFrame {
    private JDesktopPane desktopPane;
    private JInternalFrame jifSudoku;
    
    public GameSystem(){
        SetupForm();
    }
    
    private void SetupForm() {
        desktopPane = new JDesktopPane();
        desktopPane.setBounds(0,0, Constants.width, Constants.height);
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
        
        JMenu menuItemApplications = new JMenu("Games");
        mb.add(menuItemApplications);
        
        /** view vehicles **/
        JMenuItem mnuItemSudokuGame = new JMenuItem("Sudoku");
        mnuItemSudokuGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jifSudoku = new Sudoku.SudokuGameFrame();
                jifSudoku.setBounds(0, 0, Constants.width, Constants.height);
                desktopPane.add(jifSudoku);
            }
        });
        menuItemApplications.add(mnuItemSudokuGame);
    }
}
