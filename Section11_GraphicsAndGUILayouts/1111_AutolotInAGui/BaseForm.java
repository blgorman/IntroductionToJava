import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Common functionality for all forms
 * @author Brian
 */
public abstract class BaseForm extends JInternalFrame {
    /**
     * Default Constructor for all forms.
     */
    public BaseForm()
    {
        SetupForm();
    }
    
    /**
     * Common Setup features for all of our forms.
     */
    private void SetupForm()
    {
        setBackground(Color.WHITE);
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        
        //pack and show:
        pack();
        setVisible(true);
    }
}
