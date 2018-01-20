/**
 * A Vehicle.
 * @author Brian
 *
 */
public class Vehicle 
{
	//VIN
	private String vin;
	//MAKE
	private String make;
	//MODEL
	private String model;
	//YEAR
	private int year;
	//COLOR
	private String color;
	//Mileage
	private double mileage;
	
	public Vehicle() {
		//do nothing
	}
	
	public Vehicle(String startVin, String startMake, String startModel, int startYear, String startColor, double startMileage)
	{
		vin = startVin;
		make = startMake;
		model = startModel;
		year = startYear;
		color = startColor;
		mileage = startMileage;
	}
	
	//
	public String getVin()
	{
		return vin;
	}
	public void setVin(String value)
	{
		vin = value;
	}
	
	//make
	public String getMake()
	{
		return make;
	}
	public void setMake(String value)
	{
		make = value;
	}
	
	//model
	public String getModel()
	{
		return model;
	}
	public void setModel(String value)
	{
		model = value;
	}
	
	//year
	public int getYear()
	{
		return year;
	}
	public void setYear(int value)
	{
		year = value;
	}
	
	//color
	public String getColor()
	{
		return color;
	}
	public void setColor(String value)
	{
		color = value;
	}
	
	//mileage
	public double getMileage()
	{
		return mileage;
	}
	
	public void setMileage(double value)
	{
		mileage = value;
	}
	
}
