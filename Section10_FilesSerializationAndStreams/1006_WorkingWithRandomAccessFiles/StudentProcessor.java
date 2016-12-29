import java.io.*;

/**
 * Student Processor Class
 * @author Brian
 */
public class StudentProcessor implements Serializable 
{
    private RandomAccessFile studentData;
    public static final int INT_SIZE = 4;
    public static final int DOUBLE_SIZE = 8;
    public static final int RECORD_SIZE = INT_SIZE + DOUBLE_SIZE;
    
    /**
     * Create a new processor.
     */
    public StudentProcessor()
    {
        studentData = null;
    }

    /**
     * open the file for processing.
     * @param path the path to the file.
     * @throws IOException not responsible for path.
     */
    public void open(String path) throws IOException
    {
        if (studentData != null) studentData.close();
        studentData = new RandomAccessFile(path, "rw");
        //"rw" --> Read and Write permission
    }
    
    /**
     * Get the number of students.
     * @return number of students stored in file
     * @throws IOException not responsible for bad path.
     */
    public int numStudents() throws IOException
    {
        return (int)(studentData.length() / RECORD_SIZE);
    }
    
    /**
     * Close the file.
     * @throws IOException not responsible for path
     */
    public void close() throws IOException
    {
        if (studentData != null) studentData.close();
        studentData= null;
    }
    
    /**
     * Get a student by position
     * @param n the position to get the student from
     * @return the matching student from that position
     * @throws IOException not responsible for bad file.
     */
    public Student read(int n) throws IOException
    {
        studentData.seek(n * RECORD_SIZE);
        int SID = studentData.readInt();
        double score = studentData.readDouble();
        return new Student(SID, score);
    }
    
    /**
     * Find a student by ID
     * @param SID the id to match
     * @return position of matching student
     */
    public int find(int SID) throws IOException
    {
        for (int i = 0; i < numStudents(); i++)
        {
            studentData.seek(i * RECORD_SIZE);
            int nextSID = studentData.readInt();
            if (nextSID == SID)
            {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Save a student by overwriting at position or adding at position.
     * @param n the position to write to
     * @param s the student data to write
     * @throws IOException not responsible for bad file info.
     */
    public void saveData(int n, Student s) throws IOException
    {
        studentData.seek(n * RECORD_SIZE);
        studentData.writeInt(s.getID());
        studentData.writeDouble(s.getScore());
    }
    
    /**
     * Get the current data as a String for display
     * @return 
     */
    public String getData() throws IOException
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numStudents(); i++)
        {
            studentData.seek(i * RECORD_SIZE);
            int nextSID = studentData.readInt();
            double nextScore = studentData.readDouble();
            Student s = new Student(nextSID, nextScore);
            sb.append(String.format("%s\n", s));
        }
        return sb.toString();
    }
}
