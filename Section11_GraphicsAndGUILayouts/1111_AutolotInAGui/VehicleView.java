import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Brian
 */
public class VehicleView extends BaseForm {

    private JPanel pnlVehicleDetails;
    private JTextField txtVIN;
    private JTextField txtMake;
    private JTextField txtModel;
    private JTextField txtYear;
    private JTextField txtMileage;
    private JTextField txtTopSpeed;
    private JTextField txtType;
    private JTextField txtFourWheelDrive;
    
    private JLabel lblVIN;
    private JLabel lblMake;
    private JLabel lblModel;
    private JLabel lblYear;
    private JLabel lblMileage;
    private JLabel lblTopSpeed;
    private JLabel lblType;
    private JLabel lblFourWheelDrive;
    
    private JButton btnFirst; 
    private JButton btnPrevious;
    private JButton btnNext;
    private JButton btnLast;
    private JButton btnUpdate;
    private JButton btnRemove;
    
    AutolotControllers.Vehicle[] theVehicles;
    private int CurrentVehicle;
    
    public VehicleView(){
        super();
        SetupForm();
    }
    
    private void SetupForm(){
        pnlVehicleDetails = new JPanel();
        pnlVehicleDetails.setLayout(null);

        btnFirst = new JButton("<< First");
        btnFirst.setName("btnFirst"); //used to identify button pressed!
        btnFirst.addActionListener(new VehicleRotator());
        btnFirst.setBounds(24, 11, 89, 23);
        pnlVehicleDetails.add(btnFirst);

        btnPrevious = new JButton("< Prev");
        btnPrevious.setName("btnPrevious"); //used to identify button pressed!
        btnPrevious.addActionListener(new VehicleRotator());
        btnPrevious.setBounds(134, 11, 89, 23);
        pnlVehicleDetails.add(btnPrevious);

        btnNext = new JButton("Next >");
        btnNext.setName("btnNext"); //used to identify button pressed!
        btnNext.addActionListener(new VehicleRotator());
        btnNext.setBounds(251, 11, 89, 23);
        pnlVehicleDetails.add(btnNext);

        btnLast = new JButton("Last >>");
        btnLast.setName("btnLast"); //used to identify button pressed!
        btnLast.addActionListener(new VehicleRotator());
        btnLast.setBounds(365, 11, 89, 23);
        pnlVehicleDetails.add(btnLast);

        txtVIN = new JTextField();
        txtVIN.setEditable(false);
        txtVIN.setBounds(171, 97, 194, 20);
        pnlVehicleDetails.add(txtVIN);
        txtVIN.setColumns(10);

        lblVIN = new JLabel("VIN:");
        lblVIN.setBounds(63, 100, 46, 14);
        pnlVehicleDetails.add(lblVIN);

        lblMake = new JLabel("Make:");
        lblMake.setBounds(63, 131, 46, 14);
        pnlVehicleDetails.add(lblMake);

        txtMake = new JTextField();
        txtMake.setColumns(10);
        txtMake.setBounds(171, 128, 194, 20);
        pnlVehicleDetails.add(txtMake);

        lblModel = new JLabel("Model:");
        lblModel.setBounds(63, 159, 46, 14);
        pnlVehicleDetails.add(lblModel);

        txtModel = new JTextField();
        txtModel.setColumns(10);
        txtModel.setBounds(171, 156, 194, 20);
        pnlVehicleDetails.add(txtModel);

        lblYear = new JLabel("Year:");
        lblYear.setBounds(63, 187, 46, 14);
        pnlVehicleDetails.add(lblYear);

        txtYear = new JTextField();
        txtYear.setColumns(10);
        txtYear.setBounds(171, 184, 194, 20);
        pnlVehicleDetails.add(txtYear);

        lblMileage = new JLabel("Mileage:");
        lblMileage.setBounds(63, 219, 46, 14);
        pnlVehicleDetails.add(lblMileage);

        txtMileage = new JTextField();
        txtMileage.setColumns(10);
        txtMileage.setBounds(171, 216, 194, 20);
        pnlVehicleDetails.add(txtMileage);

        lblTopSpeed = new JLabel("Top Speed:");
        lblTopSpeed.setBounds(63, 250, 66, 14);
        pnlVehicleDetails.add(lblTopSpeed);

        txtTopSpeed = new JTextField();
        txtTopSpeed.setColumns(10);
        txtTopSpeed.setBounds(171, 247, 194, 20);
        pnlVehicleDetails.add(txtTopSpeed);

        lblType = new JLabel("Type:");
        lblType.setBounds(63, 69, 46, 14);
        pnlVehicleDetails.add(lblType);

        txtType = new JTextField();
        txtType.setEditable(false);
        txtType.setColumns(10);
        txtType.setBounds(171, 66, 194, 20);
        pnlVehicleDetails.add(txtType);

        lblFourWheelDrive = new JLabel("Four Wheel Drive:");
        lblFourWheelDrive.setBounds(63, 280, 98, 14);
        pnlVehicleDetails.add(lblFourWheelDrive);

        txtFourWheelDrive = new JTextField();
        txtFourWheelDrive.setColumns(10);
        txtFourWheelDrive.setBounds(171, 277, 194, 20);
        pnlVehicleDetails.add(txtFourWheelDrive);

        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //just update the vehicle array it will propagate
                AutolotControllers.Vehicle v = 
                        AutoLotSystem.theInventory.FindVehicle(txtVIN.getText());
                if (v == null)
                {
                    return;
                }
                
                //update the properties
                v.setMake(txtMake.getText());
                v.setModel(txtModel.getText());
                v.setYear(Integer.parseInt(txtYear.getText()));
                v.setMileage(Double.parseDouble(txtMileage.getText()));
                if (v instanceof AutolotControllers.Car)
                {
                    ((AutolotControllers.Car)v).setTopSpeed(
                            Double.parseDouble(txtTopSpeed.getText()));
                }
                else if (v instanceof AutolotControllers.Truck)
                {
                    ((AutolotControllers.Truck)v).toggleFourWheelDrive(
                            Boolean.parseBoolean(txtFourWheelDrive.getText()));
                }
                
                boolean success = AutoLotSystem.theInventory.UpdateVehicle(v);
                if (success)
                {
                    JOptionPane.showMessageDialog(null, "Vehicle Updated!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Vehicle Update"
                            + " Failed!");
                }
                //refresh the data
                refreshVehicleData();
            }
        });
        btnUpdate.setBounds(276, 308, 89, 23);
        pnlVehicleDetails.add(btnUpdate);
        
        btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AutoLotSystem.theInventory.RemoveVehicle(txtVIN.getText());
            }
        });
        btnRemove.setBounds(171, 308, 89, 23);
        pnlVehicleDetails.add(btnRemove);
        
        getContentPane().add(pnlVehicleDetails);
        
        //Display the first vehicle on setup:
        DisplayFirstVehicle();
    }
    
    class VehicleRotator implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //cast the object coming in to get the specific button pressed:
            JButton button = (JButton)e.getSource();
            String option = button.getName();
            if (option.equalsIgnoreCase("btnFirst"))
            {
                DisplayFirstVehicle();
            }
            else if (option.equalsIgnoreCase("btnNext"))
            {
                DisplayNextVehicle();
            }
            else if (option.equalsIgnoreCase("btnPrevious"))
            {
                DisplayPrevVehicle();
            }
            else if (option.equalsIgnoreCase("btnLast"))
            {
                DisplayLastVehicle();
            }
        }
    }
    
    /**
     * Refresh the vehicle data to make sure it's current.
     */
    public void refreshVehicleData()
    {
        //refresh the array:
        theVehicles = AutoLotSystem.theInventory.getVehicles();
    }
    
    /**
     * Set the display for a passed in vehicle.
     * @param v the Vehicle to display
     */
    private void SetVehicleDisplay(AutolotControllers.Vehicle v)
    {
        if (v instanceof AutolotControllers.Car)
        {
            txtType.setText(AutolotControllers.Common.CARTYPE);
            txtTopSpeed.setEnabled(true);
            txtTopSpeed.setText(
                    String.format("%.1f"
                    , ((AutolotControllers.Car)v).getTopSpeed()));
            txtFourWheelDrive.setEnabled(false);
            txtFourWheelDrive.setText("");
        }
        else if (v instanceof AutolotControllers.Truck)
        {
            txtType.setText(AutolotControllers.Common.TRUCKTYPE);
            txtTopSpeed.setEnabled(false);
            txtFourWheelDrive.setEnabled(true);
            txtFourWheelDrive.setText(String.format("%b"
                    , ((AutolotControllers.Truck)v).isFourWheelDrive()));
            txtTopSpeed.setText("");
        }
        else if (v instanceof AutolotControllers.Motorcycle)
        {
            txtType.setText(AutolotControllers.Common.MOTORCYCLETYPE);
            txtTopSpeed.setEnabled(false);
            txtFourWheelDrive.setEnabled(false);
            txtTopSpeed.setText("");
            txtFourWheelDrive.setText("");
        }
        txtVIN.setText(v.getVIN());
        txtMake.setText(v.getMake());
        txtModel.setText(v.getModel());
        txtYear.setText(String.format("%d", v.getYear()));
        txtMileage.setText(String.format("%.1f", v.getMileage()));
    }
    
    /**
     * Display the first vehicle in the system.
     */
    public void DisplayFirstVehicle()
    {
        refreshVehicleData();
        CurrentVehicle = 0;
        AutolotControllers.Vehicle v = 
                (theVehicles[0] != null ? theVehicles[0] : null);
        if (v == null) return;
        
        SetVehicleDisplay(v);
    }
    
    /**
     * Display the next vehicle in the system.
     */
    public void DisplayNextVehicle()
    {
        refreshVehicleData();
        //loop if past max
        int nextVehicle = CurrentVehicle + 1;
        if (nextVehicle > AutoLotSystem.theInventory.getVehicleCount() -1)
        {
            DisplayFirstVehicle();
            return;
        }
        
        AutolotControllers.Vehicle v = 
                (theVehicles[nextVehicle] != null 
                    ? theVehicles[nextVehicle] 
                    : null);
        if (v == null) return;
        //set the display
        SetVehicleDisplay(v);
        //set current for tracking.
        CurrentVehicle = nextVehicle;
    }
    
    /**
     * Display the previous vehicle in the system.
     */
    public void DisplayPrevVehicle()
    {
        refreshVehicleData();
        //loop if past 0
        int nextVehicle = CurrentVehicle - 1;
        if (nextVehicle < 0)
        {
            DisplayLastVehicle();
            return;
        }
        
        AutolotControllers.Vehicle v = 
                (theVehicles[nextVehicle] != null 
                    ? theVehicles[nextVehicle] 
                    : null);
        if (v == null) return;
        //set the display
        SetVehicleDisplay(v);
        //set current for tracking.
        CurrentVehicle = nextVehicle;
    }
    
    /**
     *  Display the last vehicle in the system.
     */
    public void DisplayLastVehicle()
    {
        refreshVehicleData();
        //loop if past 0
        
        int nextVehicle = AutoLotSystem.theInventory.getVehicleCount() -1;

        AutolotControllers.Vehicle v = 
                (theVehicles[nextVehicle] != null 
                    ? theVehicles[nextVehicle] 
                    : null);
        if (v == null) return;
        //set the display
        SetVehicleDisplay(v);
        //set current for tracking.
        CurrentVehicle = nextVehicle;
    }
}
