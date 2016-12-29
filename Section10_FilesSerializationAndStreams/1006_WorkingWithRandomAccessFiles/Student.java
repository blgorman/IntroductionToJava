import java.io.Serializable;
/**
 * A Student.
 * @author Brian
 */
public class Student implements Serializable
{
    private int _SID;
    private double _score;
    
    /**
     * Student default Constructor.
     */
    public Student()
    {
        //do nothing..
    }
    
    /**
     * Explicit Constructor.
     * @param ID the id of the student
     * @param points the current earned points for the student.
     */
    public Student(int ID, double points)
    {
        _SID = ID;
        _score = points;
    }
    
    /**
     * Get the student id.
     * @return the student id
     */
    public int getID()
    {
        return _SID;
    }
    
    /**
     * Set the student id.
     * @param value the value for student id.
     */
    public void setID(int value)
    {
        _SID = value;
    }
    
    /**
     * The student's current score.
     * @return the score.
     */
    public double getScore()
    {
        return _score;
    }
    
    /**
     * The value for the score.
     * @param value current points.
     */
    public void setScore(double value)
    {
        _score = value;
    }
    
    /**
     * Student as a String.
     * @return String representing student id and score
     */
    public String toString()
    {
        return String.format("%d:\t%.2f"
                , getID(), getScore());
    }
}
