
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
	
	/*
	//While adding an override is not necessarily a violation of Liskov
	//adding a method that does more than change direction (i.e. changing the speed)
	//is a violation of the Liskov Substitution Principle.
	//ultimately, if we change behavior of an object in an override in the subtype
	//outside of the expected behavior modification, we violate the Liskov Sub. Principle.
	//just like when a square affects both length and width instead of just width OR length
	//when trying to inherit from a rectangle.
	public void changeDirection(double value)
	{
		this.accellerate(value);
		this.changeDirection(value);
	}
	*/
}
