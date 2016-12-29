import java.io.*;
import java.util.*;

/**
 * Drive the program.
 * @author Brian
 */
public class Driver 
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        StudentProcessor sp = new StudentProcessor();
        
        int SID = -1;
        double score = -1.0;
        int position = -1;
        Student s;
        
        try
        {
            sp.open("StudentData.dat");
            boolean done = false;
            while (!done)
            {
                System.out.println("********** STUDENTS ***********");
                String output = sp.getData();
                if (output.length() == 0)
                {
                    System.out.println("NO STUDENTS");
                }
                else
                {
                    System.out.println(output);
                }
                System.out.println("*******************************");
                
                System.out.println("Enter the StudentID: ");
                SID = input.nextInt();
                System.out.println("Enter the Score: ");
                score = input.nextDouble();
                input.nextLine(); //clear the buffer
                
                position = sp.find(SID);
                if (position >= 0)
                {
                    s = sp.read(position);
                    s.setScore(score);
                    System.out.println("Updated student score for existing "
                            + "student");
                }
                else
                {
                    s = new Student(SID, score);
                    position = sp.numStudents();
                    System.out.println("Added new student");
                }
                sp.saveData(position, s);
                System.out.println("Would you like to work with another "
                        + "student?");
                String userEntry = input.nextLine();
                if (userEntry.toUpperCase().contains("N")) done = true;
            }
        }
        catch (IOException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
        finally
        {
            try
            {
                sp.close();
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            System.out.println("Complete!");
        }
    }
}
