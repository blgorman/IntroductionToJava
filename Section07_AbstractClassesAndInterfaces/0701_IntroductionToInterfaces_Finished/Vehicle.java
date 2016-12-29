//1) What are the common properties of all vehicles?
//   a)Make ==> Chevy/Ford/Toyota
//   b)Model ==> Camaro/Mustang/Camry
//   c)Year
//   d)Mileage ==> 0.0, 256.2, 127,568.3
//   e)VIN number ==> ID number

//2) How would we store them/represent them in a variable?
//   a) String
//   b) String
//   c) int
//   d) double
//   e) String
package introductiontointerfaces;

/**
 *
 * @author Brian
 */
public interface Vehicle 
{
    /**
     * Gets the make of the vehicle
     * @return String make
     */
    String getMake();
    
    /**
     * Set the make of the vehicle
     * @param value the make of the vehicle.
     */
    void setMake(String value);
    
    /**
     * Get the model of the vehicle
     * @return String model
     */
    String getModel();
    
    /**
     * Set the model of the vehicle
     * @param value 
     */
    void setModel(String value);
    
    /**
     * Get the year of the vehicle
     * @return int year 
     */
    int getYear();
    
    /**
     * Set the year of the vehicle
     * @param value the year of the vehicle
     */
    void setYear(int value);
    
    /**
     * Get the mileage of the vehicle
     * @return 
     */
    double getMileage();
    
    /**
     * Set the mileage of the vehicle
     * @param value the mileage of the vehicle
     */
    void setMileage(double value);
    
    /**
     * Get the VIN of the vehicle
     * @return String VIN
     */
    String getVIN();
    
    /**
     * Set the VIN of the vehicle
     * @param value 
     */
    void setVIN(String value);
}
