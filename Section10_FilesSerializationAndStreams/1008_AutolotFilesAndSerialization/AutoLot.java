
import java.io.Serializable;

/**
 * Autolot is the main system class to manage all autos on the lot.
 * @author Brian
 * Version: 9.5
 */
public class AutoLot implements Serializable
{
    //the maximum size: note, this can be changed later.
    private final int MAX_VEHICLES = 10;
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
        Vehicles = new Vehicle[MAX_VEHICLES];
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
        if (this.vehicleCount == this.MAX_VEHICLES)
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
}
