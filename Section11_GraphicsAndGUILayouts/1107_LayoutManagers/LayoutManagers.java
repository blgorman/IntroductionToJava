/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutmanagers;
import javax.swing.JOptionPane;
/**
 *
 * @author Riker
 */
public class LayoutManagers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String message = "";
        String optionBorder = "Border Layout => 1";
        String optionBox = "Box Layout ==> 2";
        String optionCard = "Card Layout ==> 3";
        String optionFlow = "Flow Layout ==> 4";
        String optionGrid = "Grid Layout ==> 5";
        
        message = String.format("Choose One: \n%s\n%s\n%s\n%s\n%s\n"
                    , optionBorder
                    , optionBox
                    , optionCard
                    , optionFlow
                    , optionGrid);
        int choice = Integer.parseInt(JOptionPane.showInputDialog(message));
    
        switch (choice)
        {
            case 1:
                BorderLayoutDemo bld = new BorderLayoutDemo();
                break;
            case 2:
                BoxLayoutDemo bld2 = new BoxLayoutDemo();
                break;
            case 3:
                CardLayoutDemo cld = new CardLayoutDemo();
                break;
            case 4:
                FlowLayoutDemo fld = new FlowLayoutDemo();
                break;
            case 5:
                GridLayoutDemo gld = new GridLayoutDemo();
                break;
            default:
                break;
        }
    }
}
