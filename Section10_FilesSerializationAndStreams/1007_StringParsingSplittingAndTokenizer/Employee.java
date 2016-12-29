/**
 * An Employee.
 * @author Brian
 */
public class Employee 
{
    private int id;
    private String name;
    private int age;
    private String pwd;
    
    /**
     * Default Constructor.
     */
    public Employee()
    {
    
    }
    
    /**
     * Explicit Constructor.
     * @param ID id
     * @param Name name
     * @param Age age
     * @param PWD password
     */
    public Employee(int ID, String Name, int Age, String PWD)
    {
        id = ID;
        name = Name;
        age = Age;
        pwd = PWD;
    }
    
    /**
     * Get the id.
     * @return employee id
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * Set the id.
     * @param value the employee id. 
     */
    public void setID(int value)
    {
        id = value;
    }
    
    /**
     * Get the name.
     * @return the name of the employee.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Set the name
     * @param value the name of the employee. 
     */
    public void setName(String value)
    {
        name = value;
    }
    
    /**
     * Get the age.
     * @return the age of the employee.
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     * Set the age.
     * @param value emp age. 
     */
    public void setAge(int value)
    {
        age = value;
    }
    
    /**
     * Get the password.
     * @return emp password.
     */
    public String getPWD()
    {
        return pwd;
    }
    
    /**
     * Set the password.
     * @param value the new password.
     */
    public void setPWD(String value)
    {
        pwd = value;
    }
    
    
    /**
     * Represent Employee as String
     * @return 
     */
    public String toString()
    {
        return String.format("%d|%s|%d|%s"
                , getID()
                , getName()
                , getAge()
                , getPWD());
    }
}
