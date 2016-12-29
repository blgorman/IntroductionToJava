/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Encounter a custom exception.
 * @author Brian
 */
public class Driver {

    public static void main(String[] args)
    {
        System.out.println("Creating a new Doctor...");
        try
        {
            Doctor d = new Doctor("Julius", "Irving", 63, "Basketball");
        }
        catch (DoctorSpecialtyException dse)
        {
            //dse.printStackTrace();
            System.out.println("Invalid specialty...");
        }
        catch (IllegalArgumentException iaex)
        {
            System.out.println("Put in better arguments please...");
        }
        catch (Exception ex)
        {
            System.out.println("...Massive System Failure...");
        }
        
        
        try
        {
            Doctor d = new Doctor("Julius", "Irving", 63, null);
        }
        catch (DoctorSpecialtyException dse)
        {
            System.out.println("Invalid specialty...");
        }
        catch (IllegalArgumentException iaex)
        {
            System.out.println("Put in better arguments please...");
        }
        catch (Exception ex)
        {
            System.out.println("...Massive System Failure...");
        }
        
        //other failure
        try
        {
            Doctor d = new Doctor("Julius", "Irving", 63, "Physician");
            int x = 32/0;
        }
        catch (DoctorSpecialtyException dse)
        {
            System.out.println("Invalid specialty...");
        }
        catch (IllegalArgumentException iaex)
        {
            System.out.println("Put in better arguments please...");
        }
        catch (Exception ex)
        {
            System.out.println("...Massive System Failure...");
        }
        finally
        {
            System.out.println("Were you able to create a doctor?");
        }
    }
}
