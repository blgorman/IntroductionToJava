
public class Driver {
	private static String VIN = "235423523asdfasda235235";
	//MAKE
	private static String MAKE = "Ford";
	//MODEL
	private static String MODEL = "Mustang GT";
	//YEAR
	private static int YEAR = 2021;
	//COLOR
	private static String COLOR = "Blue";
	//Mileage
	private static double MILEAGE = 25.0;
	private static double DELTA = 0.00001;
	
	private static boolean ISCONVERTIBLE = true;
	
	public static void main(String[] args) {
		
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle(VIN, MAKE, MODEL, YEAR, COLOR, MILEAGE);
		
		Car c1 = new Car();
		Car c2 = new Car(VIN, MAKE, MODEL, YEAR, COLOR, MILEAGE, ISCONVERTIBLE);
		
		Truck t1 = new Truck();
		Truck t2 = new Truck(VIN, MAKE, MODEL, YEAR, COLOR, MILEAGE);
		
		
		Vehicle[] myAutos = new Vehicle[6];
		myAutos[0] = v1;
		myAutos[1] = v2;
		
		myAutos[2] = c1;
		myAutos[3] = c2;
		
		myAutos[4] = t1;
		myAutos[5] = t2;
		
		for(Vehicle v : myAutos)
		{
			System.out.println(v);
			
			if (v instanceof Car)
			{
				Car c = (Car)v;
				System.out.println(c.getIsConvertible());
			}
		}
	}

}
