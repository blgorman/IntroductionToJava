import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Brian
 */
public class AddVehicle extends BaseForm {
    JPanel pnlAddVehicle;
    JLabel lblType;
    JLabel lblVIN;
    JLabel lblMake;
    JLabel lblModel;
    JLabel lblYear;
    JLabel lblMileage;
    JLabel lblTopSpeed;
    JLabel lblFourWheelDrive;
    
    JTextField txtVIN;
    JTextField txtMake;
    JTextField txtModel;
    JTextField txtYear;
    JTextField txtMileage;
    JTextField txtTopSpeed;
    JTextField txtFourWheelDrive;
    
    final JRadioButton rdoCar = new JRadioButton("Car");;
    final JRadioButton rdoTruck = new JRadioButton("Truck");
    final JRadioButton rdoMotorcycle = new JRadioButton("MotorCycle");
    
    ButtonGroup vehTypeGroup = new ButtonGroup();
    
    public AddVehicle()
    {
        super();
        SetupForm();
    }
    
    private void SetupForm()
    {
        pnlAddVehicle = new JPanel();
        pnlAddVehicle.setLayout(null);

        lblType = new JLabel("Type:");
        lblType.setBounds(30, 29, 46, 14);
        pnlAddVehicle.add(lblType);

        lblVIN = new JLabel("VIN:");
        lblVIN.setBounds(30, 60, 98, 14);
        pnlAddVehicle.add(lblVIN);

        txtVIN = new JTextField();
        txtVIN.setColumns(10);
        txtVIN.setBounds(138, 57, 194, 20);
        pnlAddVehicle.add(txtVIN);

        lblMake = new JLabel("Make:");
        lblMake.setBounds(30, 91, 98, 14);
        pnlAddVehicle.add(lblMake);

        txtMake = new JTextField();
        txtMake.setColumns(10);
        txtMake.setBounds(138, 88, 194, 20);
        pnlAddVehicle.add(txtMake);

        lblModel = new JLabel("Model:");
        lblModel.setBounds(30, 119, 98, 14);
        pnlAddVehicle.add(lblModel);

        txtModel = new JTextField();
        txtModel.setColumns(10);
        txtModel.setBounds(138, 116, 194, 20);
        pnlAddVehicle.add(txtModel);

        lblYear = new JLabel("Year:");
        lblYear.setBounds(30, 147, 98, 14);
        pnlAddVehicle.add(lblYear);

        txtYear = new JTextField();
        txtYear.setColumns(10);
        txtYear.setBounds(138, 144, 194, 20);
        pnlAddVehicle.add(txtYear);

        lblMileage = new JLabel("Mileage:");
        lblMileage.setBounds(30, 179, 98, 14);
        pnlAddVehicle.add(lblMileage);

        txtMileage = new JTextField();
        txtMileage.setColumns(10);
        txtMileage.setBounds(138, 176, 194, 20);
        pnlAddVehicle.add(txtMileage);

        lblTopSpeed = new JLabel("Top Speed:");
        lblTopSpeed.setBounds(30, 210, 98, 14);
        pnlAddVehicle.add(lblTopSpeed);

        txtTopSpeed = new JTextField();
        txtTopSpeed.setColumns(10);
        txtTopSpeed.setBounds(138, 207, 194, 20);
        pnlAddVehicle.add(txtTopSpeed);

        lblFourWheelDrive = new JLabel("Four Wheel Drive:");
        lblFourWheelDrive.setBounds(30, 240, 109, 14);
        pnlAddVehicle.add(lblFourWheelDrive);

        txtFourWheelDrive = new JTextField();
        txtFourWheelDrive.setColumns(10);
        txtFourWheelDrive.setBounds(138, 237, 194, 20);
        pnlAddVehicle.add(txtFourWheelDrive);

        vehTypeGroup.add(rdoCar);
        vehTypeGroup.add(rdoTruck);
        vehTypeGroup.add(rdoMotorcycle);
        

        rdoCar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    txtTopSpeed.setEditable(true);
                    txtTopSpeed.setText("");
                    txtFourWheelDrive.setEditable(false);
                    txtFourWheelDrive.setText("");
                }
        });
        rdoCar.setBounds(134, 25, 61, 23);
        pnlAddVehicle.add(rdoCar);

        //rdoTruck = new JRadioButton("Truck");
        rdoTruck.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    txtTopSpeed.setEditable(false);
                    txtTopSpeed.setText("");
                    txtFourWheelDrive.setEditable(true);
                    txtFourWheelDrive.setText("");
                }
        });
        rdoTruck.setBounds(206, 25, 61, 23);
        pnlAddVehicle.add(rdoTruck);

        //rdoMotorcycle = new JRadioButton("Motorcycle");
        rdoMotorcycle.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    txtTopSpeed.setEditable(false);
                    txtTopSpeed.setText("");
                    txtFourWheelDrive.setEditable(false);
                    txtFourWheelDrive.setText("");
                }
        });
        rdoMotorcycle.setBounds(281, 25, 61, 23);
        pnlAddVehicle.add(rdoMotorcycle);
        
        
        JButton btnAddVehicle = new JButton("Add Vehicle");
        btnAddVehicle.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    AutolotControllers.Vehicle v;
                    
                    if (rdoCar.isSelected())
                    {
                        v = new AutolotControllers.Car();
                        ((AutolotControllers.Car)v).setTopSpeed(
                                Double.parseDouble(txtTopSpeed.getText()));
                    }
                    else if (rdoTruck.isSelected())
                    {
                        v = new AutolotControllers.Truck();
                        ((AutolotControllers.Truck)v).toggleFourWheelDrive(
                            Boolean.parseBoolean(txtFourWheelDrive.getText()));
                    }
                    else
                    {
                        v = new AutolotControllers.Motorcycle();
                    }
                    
                    v.setMake(txtMake.getText());
                    v.setModel(txtModel.getText());
                    v.setYear(Integer.parseInt(txtYear.getText()));
                    v.setMileage(Double.parseDouble(txtMileage.getText()));
                    v.setVIN(txtVIN.getText());
                    
                    boolean success = AutoLotSystem.theInventory.AddVehicle(v);
                    if (success)
                    {
                        JOptionPane.showMessageDialog(null, "Successfully"
                                + " added the new vehicle!");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Could not"
                                + " add the new vehicle!");
                    }
                }
        });
        
        btnAddVehicle.setBounds(243, 268, 150, 25);
        pnlAddVehicle.add(btnAddVehicle);
        
        getContentPane().add(pnlAddVehicle);
    }
}

