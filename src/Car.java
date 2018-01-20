
public class Car extends Vehicle
{
	private boolean isConvertible;
	
	public Car() {
		
	}
	
	public Car(String startVin, String startMake, String startModel, int startYear, String startColor, double startMileage, boolean startIsConvertible)
	{
		super(startVin, startMake, startModel, startYear, startColor, startMileage);
		isConvertible = startIsConvertible;
	}
	
	public boolean getIsConvertible() {
		return isConvertible;
	}
	
	public void setIsConvertible(boolean value) {
		isConvertible = value;
	}
	
	public String toString() {
		return String.format("%s\tIs a Convertible: %b"
								, super.toString()
								, this.getIsConvertible());
	}
	
}
