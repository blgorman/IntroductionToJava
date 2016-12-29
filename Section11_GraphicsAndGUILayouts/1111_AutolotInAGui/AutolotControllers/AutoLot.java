package AutolotControllers;


import java.io.*;

/**
 * Autolot is the main system class to manage all autos on the lot.
 * @author Brian
 * Version: 9.5
 */
public class AutoLot implements Serializable
{
    private int vehicleCount;
    //use an array to store the vehicles
    private Vehicle[] Vehicles;
    
    /**
     * Construct an autolot.
     */
    public AutoLot()
    {
        //use the size int so that if we change this later
        //we don't have to change it here too.
        Vehicles = new Vehicle[Constants.MAX_VEHICLES];
        vehicleCount = 0;
    }
    
    /**
     * Get the actual number of vehicles in the system.
     * @return The count of Vehicles for sale.
     */
    public int getVehicleCount()
    {
        return this.vehicleCount;
    }
    
    /**
     * Access to the inventory for easy use in display.
     * @return the vehicle array.  Do not clone.  All changes will propagate
     * due to reference!
     */
    public Vehicle[] getVehicles()
    {
        return Vehicles;
    }
    
    /**
     * Add a vehicle to the system.
     * @param v the Vehicle to add
     * @return true if successful, else false.
     */
    public boolean AddVehicle(Vehicle v)
    {
        //make sure v is not null
        if (v == null)
        {
            return false;
        }
        
        //also, we should not duplicate a vehicle, so we need to make
        //sure this vehicle is not already in the system
        Vehicle v2 = FindVehicle(v.getVIN());
        if (v2 != null)
        {
            return false;
        }
        
        //additionally, we need to make sure the lot is not already full
        //since the indexes are 0 based, we need to check at count.
        //testing revealed an original off by one error.
        if (this.vehicleCount == Constants.MAX_VEHICLES)
        {
            //the system is full.
            return false;
        }
        
        //now we are ready to add
        this.Vehicles[this.vehicleCount] = v;
        
        //increment the count
        this.vehicleCount++;
        
        //the vehicle is added, return true
        return true;
    }
    
    /**
     * Update a vehicle in the system.
     * @param v the vehicle to update
     * @return true on success else false
     */
    public boolean UpdateVehicle(Vehicle v)
    {
        int i = 0;
        for (Vehicle veh : Vehicles)
        {
            if (v.getVIN().equalsIgnoreCase(
                    veh.getVIN()))
            {
                veh.setMake(v.getMake());
                veh.setModel(v.getModel());
                veh.setYear(v.getYear());
                veh.setMileage(v.getMileage());
                if (veh instanceof Car)
                {
                    ((Car)veh).setTopSpeed(((Car)v).getTopSpeed());
                }
                if (veh instanceof Truck)
                {
                    ((Truck)veh).toggleFourWheelDrive(((Truck)v).isFourWheelDrive());
                }
                return true;
            }
            i++;
        }
        return false;
    }
    /**
     * Remove a vehicle from the system.
     * @param v the vehicle to remove.
     * @return true if successful, else false.
     */
    public boolean RemoveVehicle(String VIN)
    {
        //make sure incoming vehicle VIN is not null.
        if (VIN == null) 
        {
            return false;
        }
        
        //there are other ways to remove, but they would involve sliding
        //items to keep any null indexes from being in between valid vehicles
        //so instead, we'll do a swap with the last index of a valid vehicle
        //then null that out.  Order is not being stressed at this point 
        //so we don't need to worry about the overall order, but we have to 
        //keep indexes from being null.
        int match = FindVehicleIndex(VIN);
        if (match < 0)
        {
            //no matches
            return false;
        }
        //we're going to remove one and the indexes are zero-based
        //so the last valid index is vehiclecount -1
        //and order is not important so we can just move the last
        //to the match, thereby 'removing' the vehicle from the system.
        this.vehicleCount--;
        
        if (match < this.vehicleCount)
        {
            //need to swap
            Vehicles[match] = Vehicles[this.vehicleCount];
        }
        //set the last vehicle to null (no matter what we have to do this)
        //to finish the 'remove' operation.
        Vehicles[this.vehicleCount] = null;
        //the vehicle is removed, return true
        return true;
    }
    
    /**
     * Search through the inventory to find a specific vehicle.
     * @param VIN The unique identifier for the Vehicle.
     * @return matching Vehicle or null if no match.
     */
    public Vehicle FindVehicle(String VIN)
    {
        if (VIN == null || VIN.equals(""))
        {
            throw new IllegalArgumentException("VIN cannot be null or empty"
                    + " in FindVehicleIndex");
        }
        //iterate the entire collection
        for (Vehicle v : this.Vehicles)
        {
            if (v == null) 
            {
                continue;
            }
            
            //determine if the current vehicle
            //is the one requested
            if (v.getVIN().equalsIgnoreCase(VIN))
            {
                //if matched, return it
                return v;
            }
        }
        //no matches, return null.
        return null;
    }
    
    /**
     * Find the index of a vehicle in the system.
     * @param v The vehicle to find the index for.
     * @return -1 if not found, else index
     */
    private int FindVehicleIndex(String VIN)
    {
        if (VIN == null || VIN.equals(""))
        {
            throw new IllegalArgumentException("VIN cannot be null or empty"
                    + " in FindVehicleIndex");
        }
        for (int i = 0; i < this.vehicleCount; i++)
        {
            if ((Vehicles[i]).getVIN().equalsIgnoreCase(VIN))
            {
                //if matched, return it
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Get the inventory as a String
     * @return String representing all vehicles in the lot.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if (this.vehicleCount == 0)
        {
            sb.append("There are currently no vehicles for sale");
        }
        else
        {
            for (int i = 0; i < this.vehicleCount; i++)
            {
                sb.append(this.Vehicles[i].toString());
            }
        }
        return sb.toString();
    }
    
    /**
     * Bulk load vehicles using a pipe-delimited text file.
     */
    public void ImportDataFromFile(String bulkFilePath) throws IOException
    {
        FileReader fr = null;
        BufferedReader br = null;
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
                this.AddVehicle(v);
                
                //read in the next auto
                line = br.readLine();
            }
        }
        catch(Exception ex)
        {
            //if any exceptions happen log it and throw it to the caller
            //we're not doing any logging...
            throw ex;
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
                //if any exceptions happen log it and throw it to the caller
                //we're not doing any logging...
                throw innerEx;
            }
            fr = null;
            br = null;
        }
    }

    /**
     * Save the state of the lot.
     * @param savePath the file to save to.
     * @throws IOException when file is not valid or other IO exception happens.
     */
    public void SaveState(String savePath) throws IOException
    {
        //since all of the classes are serializable, it's now possible to 
        //save the entire object in state
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try
        {
            fos = new FileOutputStream(savePath);
            oos = new ObjectOutputStream(fos);
            
            //since we are saving ourselves, simply write out 'this' object:
            oos.writeObject(this);
        }
        catch (Exception ex)
        {
            throw ex;
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
                throw innerEx;
            }
            fos = null;
            oos = null;
        }
    }
    
    /**
     * Return an autolot loaded from state.
     * @param restorePath the path to the state saved file.
     * @return a full autolot object.
     * @throws IOException when file io is bad.
     */
    public AutoLot RestoreState(String restorePath) throws IOException
    {
        AutoLot al = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try
        {
            fis = new FileInputStream(restorePath);
            ois = new ObjectInputStream(fis);
            al = (AutoLot)ois.readObject();
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
        return al;
    }
}
