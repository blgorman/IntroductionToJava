import java.util.*;
import java.io.*;

/**
 *
 * @author Brian
 */
public class Driver 
{
    public static AutoLot theInventory;
    public static Scanner in;
    private static int maxYear = 2100;
    private static int minYear = 1900;
    private static double maxMileage = 5000000.0;
    private static double minMileage = 0.0;
    private static double minFuel = 0.0;
    private static double maxFuel = 18.0;
    private static String filePath = "AutolotData.dat";
    
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
            //System.out.println(menu);
            int option = ValidateUserInputInteger(menu, 1, 8);
                    //Integer.parseInt(in.nextLine());
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
                case 4:
                    DriveAVehicle();
                    break;
                case 5:
                    AddFuelToVehicle();
                    break;
                case 6:
                    RestoreAutolotState();
                    break;
                case 7:
                    SaveAutolotState();
                    break;
                case 8:
                    System.out.println("Importing...");
                    ImportDataFromFile();
                    break;
                default:
                    break;
            }
            
            System.out.println(Common.CharacterGeneration(50, "-"));
            String answer = ValidateUserInputString("Would you like to do "
                    + "more today?");
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
        sb.append(Common.CharacterGeneration(50, "*"));
        sb.append("\n");
        sb.append("What would you like to do today?\n");
        sb.append(Common.CharacterGeneration(50, "-"));
        sb.append("\n");
        sb.append("* 1) List Vehicles [Enter 1]                     *\n");
        sb.append("* 2) Add A Vehicle [Enter 2]                     *\n");
        sb.append("* 3) Remove A Vehicle [Enter 3]                  *\n");
        sb.append("* 4) Drive A Vehicle [Enter 4]                   *\n");
        sb.append("* 5) Add Fuel to a Vehicle [Enter 5]             *\n");
        sb.append("* 6) Restore the Autolot from last save [Enter 6]*\n");
        sb.append("* 7) Save the current Autolot state [Enter 7]    *\n");
        sb.append("* 8) Import FastLoad of VehicleInfo [Enter 8]    *\n");
        sb.append(Common.CharacterGeneration(50, "-"));
        sb.append("\n");
        sb.append(Common.CharacterGeneration(50, "-"));
        sb.append("\n");
        return sb.toString();
    }
    
    /**
     * List Vehicles
     */
    public static void ListVehicles()
    {
        System.out.println(Common.CharacterGeneration(50, "*"));
        System.out.println("Here are the vehicles currently for sale:");
        System.out.println(Common.CharacterGeneration(50, "-"));
        System.out.println(theInventory.toString());
        System.out.println(Common.CharacterGeneration(50, "*"));
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
        StringBuilder sb = new StringBuilder();
        sb.append("What type of vehicle is this?\n");
        sb.append(" - Enter 1 for 'Car'\n");
        sb.append(" - Enter 2 for 'Truck'\n");
        sb.append(" - Enter 3 for 'Motorcycle'\n");
        int vType = ValidateUserInputInteger(sb.toString(), 1, 3);
        
        Vehicle v = null;
        switch (vType)
        {
            case 1:
                v = new Car();
                break;
            case 2:
                v = new Truck();
                String s = ValidateUserInputString("Is this a four "
                        + "wheel drive [y/n]?");
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
        v.setVIN(ValidateUserInputString("What is the VIN?"));
        v.setMake(ValidateUserInputString("What is the Make?"));
        v.setModel(ValidateUserInputString("What is the Model?"));
        v.setYear(ValidateUserInputInteger("What is the Year"
                                            , minYear, maxYear));
        v.setMileage(ValidateUserInputDouble("What is the Mileage"
                        ,minMileage, maxMileage));
        return v;
    }
    
    /**
     * Remove a Vehicle
     */
    public static boolean RemoveAVehicle()
    {
        //here we should just get an ID number from the user, then send that
        //to the program to remove the vehicle by ID
        //System.out.println("What is the VIN for the vehicle you just sold?");
        String VIN = ValidateUserInputString("What is the "
                + "VIN for the vehicle you just sold?");
        //boolean success = theInventory.RemoveVehicle(VIN);
        //return success;
        return theInventory.RemoveVehicle(VIN);
    }
    
    /**
     * Make sure the user gives a valid String for a response
     * @param prompt The prompt to ask the user.
     * @return the valid input from the user.
     */
    private static String ValidateUserInputString(String prompt)
    {
        String response = "";
        while (response == null || response.equals(""))
        {
            System.out.println(prompt);
            try
            {
                response = in.nextLine();
            }
            catch (Exception ex)
            {
                System.out.println("Please enter a valid response");
            }
        }
        return response;
    }
    
    /**
     * Make sure the user puts in an integer of the correct value
     * @param prompt What to print to ask the user for input
     * @param validMin the minimum acceptable integer
     * @param validMax the maximum acceptable integer
     * @return a valid integer response from the user.
     */
    private static int ValidateUserInputInteger(String prompt, int validMin, 
                                                    int validMax)
    {
        int response = -999999999;
        while (response < validMin || response > validMax)
        {
            try
            {
                System.out.println(prompt);
                String r = in.nextLine();
                response = Integer.parseInt(r);
            }
            catch(Exception ex)
            {
                System.out.printf("Please enter a valid input between %d and %d\n"
                                    , validMin, validMax);
                response = -999999999;
            }
        }
        return response;
    }
    
    /**
     * Make sure the user inputs a valid double.
     * @param prompt The prompt to issue to the user
     * @param validMin the minimum acceptable value
     * @param validMax the maximum acceptable value
     * @return 
     */
    public static double ValidateUserInputDouble(String prompt
                                    , double validMin, double validMax)
    {
        double response = -9999999999999999.9;
        while (response < validMin || response > validMax)
        {
            try
            {
                System.out.println(prompt);
                String r = in.nextLine();
                response = Double.parseDouble(r);
            }
            catch(Exception ex)
            {
                System.out.printf("Please enter a valid input between %d and %d\n"
                                    , validMin, validMax);
                response = -9999999999999999.9;
            }
        }
        return response;
    }
    
    /**
     * Drive one of the vehicles.
     */
    public static void DriveAVehicle()
    {
        String VIN = ValidateUserInputString("What is the "
                + "VIN for the vehicle to drive?");
        Vehicle v = theInventory.FindVehicle(VIN);
        if (v != null)
        {
            System.out.println(v.Drive());
        }
        else
        {
            System.out.println("Could not find the vehicle to drive.");
        }
    }
    
    /**
     * Add fuel to a vehicle
     */
    public static void AddFuelToVehicle()
    {
        String VIN = ValidateUserInputString("What is the "
                + "VIN for the vehicle to drive?");
        Vehicle v = theInventory.FindVehicle(VIN);
        if (v != null)
        {
            double amount = ValidateUserInputDouble("How much "
                    + "Fuel are you adding?", minFuel, maxFuel);
            v.setFuel(amount);
        }
        else
        {
            System.out.println("Could not find the vehicle to add fuel.");
        }
    }
    
    /**
     * Restore the autolot from last save.
     */
    public static void RestoreAutolotState()
    {
        //we'll be saving everything simply using a seriled object stream
        //so we can read it back in, casting to an autolot, replacing inventory:
        System.out.println("Warning: This action will replace the current "
                + "auto lot. If you have any changes they will be lost.  "
                + "continue [y/n]?");
        String goOn = in.nextLine();
        if (goOn.toUpperCase().contains("Y"))
        {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try
            {
                fis = new FileInputStream(filePath);
                ois = new ObjectInputStream(fis);
                theInventory = (AutoLot)ois.readObject();
                System.out.println("AutoLot Restored from previous save!");
            }
            catch (Exception ioex)
            {
                System.out.println(ioex.getMessage());
            }
            finally
            {
                try
                {
                    if (fis != null) fis.close();
                    if (ois != null) ois.close();
                }
                catch (Exception innerEx)
                {
                    System.out.println(innerEx.getMessage());
                }
                fis = null;
                ois = null;
            }
        }
        else
        {
            System.out.println("Action cancelled");
        }
    }
           
    /**
     * Save the autolot state.
     */
    public static void SaveAutolotState()
    {
        //since all of the classes are serializable, it's now possible to 
        //save the entire object in state
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try
        {
            fos = new FileOutputStream(filePath);
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(theInventory);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if (fos != null) fos.close();
                if (oos != null) oos.close();
            }
            catch (Exception innerEx)
            {
                System.out.println(innerEx.getMessage());
            }
            fos = null;
            oos = null;
        }
    }
    
    /**
     * Bulk load vehicles using a pipe-delimited text file.
     */
    public static void ImportDataFromFile()
    {
        //just load from default file -- could allow user input of filename too.
        String bulkFilePath = "VehicleList.txt";
        FileReader fr = null;
        BufferedReader br = null;
        System.out.println("HERE");
        try
        {
            fr = new FileReader(bulkFilePath);
            br = new BufferedReader(fr);
            //read in each from the file
            String line = br.readLine();
            while (line != null)
            {
                //parse on the |
                String[] tokens = line.split("\\|");
                
                
                //get the type from the first token
                if (tokens.length < 6) 
                {
                    //continue -- bad input
                    continue;
                }
                
                Vehicle v = null;
                
                String type = tokens[0];
                String make = tokens[1];
                String model = tokens[2];
                String year = tokens[3];
                String mileage = tokens[4];
                String vin = tokens[5];
                
                if (type.toUpperCase().equals("CAR"))
                {
                    Double topSpeed = Double.parseDouble(tokens[6]);
                    v = new Car(make, model, Integer.parseInt(year)
                                , Double.parseDouble(mileage), vin);
                    ((Car)v).setTopSpeed(topSpeed);
                }
                else if (type.toUpperCase().equals("TRUCK"))
                {
                    boolean isFWD = Boolean.parseBoolean(tokens[6]);
                    v = new Truck(make, model, Integer.parseInt(year)
                                , Double.parseDouble(mileage), vin, isFWD);
                }
                else if (type.toUpperCase().equals("MOTORCYCLE"))
                {
                    v = new Motorcycle(make, model, Integer.parseInt(year)
                            , Double.parseDouble(mileage), vin);
                }
                
                //add to inventory
                theInventory.AddVehicle(v);
                
                //read in the next auto
                line = br.readLine();
            }
            
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if (br != null) br.close();
                if (fr != null) fr.close();
            }
            catch (Exception innerEx)
            {
                System.out.println(innerEx.getMessage());
            }
            fr = null;
            br = null;
        }
    }
}
