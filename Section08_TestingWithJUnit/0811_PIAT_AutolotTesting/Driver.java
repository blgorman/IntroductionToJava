import java.util.*;

/**
 *
 * @author Brian
 */
public class Driver 
{
    public static AutoLot theInventory;
    public static Scanner in;
    
    public static void main(String[] args)
    {
        theInventory = new AutoLot();
        in = new Scanner(System.in);
        //this program will drive interaction with the auto lot
        boolean continueProgram = true;
        boolean success = false;
        while (continueProgram)
        {
            String menu = BuildMenu();
            System.out.println(menu);
            int option = Integer.parseInt(in.nextLine());
            switch (option)
            {
                case 1:
                    //list vehicles
                    ListVehicles();
                    break;
                case 2:
                    //add a vehicle
                    success = AddAVehicle();
                    if (success)
                    {
                        System.out.println("Successfully added the vehicle");
                    }
                    else
                    {
                        System.out.println("Could not add the vehicle");
                    }
                    ListVehicles();
                    break;
                case 3:
                    //remove a vehicle
                    success = RemoveAVehicle();
                    if (success)
                    {
                        System.out.println("Successfully removed the vehicle");
                    }
                    else
                    {
                        System.out.println("Could not remove the vehicle");
                    }
                    ListVehicles();
                    break;
                default:
                    break;
            }
            
            System.out.println(Common.Dashes(50));
            System.out.println("Would you like to do more today?");
            String answer = in.nextLine();
            if (answer.toUpperCase().indexOf("Y") == 0)
            {
                continueProgram = true;
            }
            else
            {
                continueProgram = false;
            }
        }
    }
    
    /**
     * Display a menu of options
     */
    public static String BuildMenu()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(Common.Stars(50));
        sb.append("\n");
        sb.append("What would you like to do today?\n");
        sb.append(Common.Dashes(50));
        sb.append("\n");
        sb.append("* 1) List Vehicles [Enter 1]     *\n");
        sb.append("* 2) Add A Vehicle [Enter 2]     *\n");
        sb.append("* 3) Remove A Vehicle [Enter 3]  *\n");
        sb.append(Common.Dashes(50));
        sb.append("\n");
        sb.append(Common.Stars(50));
        sb.append("\n");
        return sb.toString();
    }
    
    /**
     * List Vehicles
     */
    public static void ListVehicles()
    {
        System.out.println(Common.Stars(50));
        System.out.println("Here are the vehicles currently for sale:");
        System.out.println(Common.Dashes(50));
        System.out.println(theInventory.toString());
        System.out.println(Common.Stars(50));
    }
    
    /**
     * Add a Vehicle
     */
    public static boolean AddAVehicle()
    {
        //get vehicle details from the user:
        Vehicle v = GetNewVehicle();
        if (v == null)
        {
            return false;
        }
        
        //add the vehicle into the system
        boolean success = theInventory.AddVehicle(v);
        return success;
    }
    
    /**
     * Get the vehicle details from the user
     * @return A valid vehicle.
     */
    private static Vehicle GetNewVehicle()
    {
        System.out.println("What type of vehicle is this?");
        System.out.println(" - Enter 1 for 'Car'");
        System.out.println(" - Enter 2 for 'Truck'");
        System.out.println(" - Enter 3 for 'Motorcycle'");
        int vType = in.nextInt();
        in.nextLine(); //clear buffer or loop will break
        Vehicle v = null;
        switch (vType)
        {
            case 1:
                v = new Car();
                break;
            case 2:
                v = new Truck();
                System.out.println("Is this a four wheel drive?");
                String s = in.nextLine();
                if (s.toUpperCase().indexOf("Y") == 0)
                {
                    Truck t = (Truck)v;
                    t.toggleFourWheelDrive(true);
                }
                break;
            case 3:
                v = new Motorcycle();
                break;
        }
        System.out.println("What is the VIN?");
        v.setVIN(in.nextLine());
        System.out.println("What is the Make?");
        v.setMake(in.nextLine());
        System.out.println("What is the Model?");
        v.setModel(in.nextLine());
        System.out.println("What is the Year");
        v.setYear(in.nextInt());
        in.nextLine(); //clear buffer
        System.out.println("What is the Mileage");
        v.setMileage(in.nextDouble());
        in.nextLine(); //clear buffer
        return v;
    }
    
    /**
     * Remove a Vehicle
     */
    public static boolean RemoveAVehicle()
    {
        //here we should just get an ID number from the user, then send that
        //to the program to remove the vehicle by ID
        System.out.println("What is the VIN for the vehicle you just sold?");
        String VIN = in.nextLine();
        //boolean success = theInventory.RemoveVehicle(VIN);
        //return success;
        return theInventory.RemoveVehicle(VIN);
    }
}
