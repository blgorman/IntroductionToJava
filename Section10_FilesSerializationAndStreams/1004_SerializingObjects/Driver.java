import java.io.*;
/**
 *
 * @author Brian
 */
public class Driver {

    //why might we serialize an object?
    //Most importantly: It's not just for FILE storage --
    //but that is the main reason we are doing it in this section
    
    public static void main(String[] args)
    {
        //reason number 1: Communication:
        //when we serialize an object, we translate the object
        //to a binary stream.  That stream can be sent anywhere
        //and can be reinstantiated (as long as the receiver understands
        //what the stream is supposed to contain!).
        //So, if i'm sending data over the web, or between networked machines
        //my best course of action would be to serialize it, then transmit
        //then reserialize it.  
        
        //reason number 2: To save state -- either in a file, or in cache 
        //or memory. 
        //By saving to a file we can rebuild the object from the file by reading it in 
        //as a stream -- let's do that here (just remember this is not the ONLY
        //use of serialization).
        
        //First note -- in order to work, all objects must be serializable!
        //Second note -- when working with binary objects, we have to use
        //               Streams, NOT the plain old text file reader and writer
        //               this is critical.  We are no longer reading/writing text
        //               we are reading/writing BYTES.  BYTES ARE NOT CHARACTERS!
        
        //first, let's create a serializable Doctor object
        Doctor d = new Doctor("Leonard", "McCoy", 52, "Surgeon");
        
        //next, let's create an Object output stream and 
        //a  FileOutputStream object to create an output file
        //that saves the doctor state in binary:
        ObjectOutputStream outStream = null;
        FileOutputStream fileOutStream = null;
        String filePath = "DoctorMcCoy.bin";
        try
        {
            //instantiate the file stream
            fileOutStream = new FileOutputStream(filePath);
            outStream = new ObjectOutputStream(fileOutStream);
            //write object to file as binary
            outStream.writeObject(d);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if (outStream != null) outStream.close();
                if (fileOutStream != null) fileOutStream.close();
            }
            catch (Exception innerEx)
            {
                System.out.println(innerEx.getMessage());
            }
        }
        outStream = null;
        fileOutStream = null;
        
        //now open it and read in a new doctor from the old one,
        //then see if they are equal:
        ObjectInputStream inStream = null;
        FileInputStream fileInputStream = null;
        try
        {
            fileInputStream = new FileInputStream(filePath);
            inStream = new ObjectInputStream(fileInputStream);
            
            //now here is where the 'receiver' must KNOW the type
            //because we can only read it in as an object. 
            //however, we 'know' that this file is only storing one
            //doctor in it, so we can cast the object back right away:
            Doctor d2 = (Doctor)inStream.readObject();
            
            //are they equal? [note: only works if equality is overridden!]
            boolean areEqual = d2.equals(d); 
            if (areEqual)
            {
                System.out.println("Our doctors appear to be the same!");
            }
            else
            {
                System.out.println("Was not able to get the data about"
                        + " our doctor from the file!");
            }
            System.out.println(d);
            System.out.println(d2);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if (inStream != null) inStream.close();
                if (fileInputStream != null) fileInputStream.close();
            }
            catch (Exception innerEx)
            {
                System.out.println(innerEx.getMessage());
            }
        }
        fileInputStream = null;
        inStream = null;
    }
    
}
