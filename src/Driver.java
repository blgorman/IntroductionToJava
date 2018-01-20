
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
	
	public static void main(String[] args) {
		
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle(VIN, MAKE, MODEL, YEAR, COLOR, MILEAGE);
		
		Car c1 = new Car();
		Car c2 = new Car(VIN, MAKE, MODEL, YEAR, COLOR, MILEAGE);
		
		Truck t1 = new Truck();
		Truck t2 = new Truck(VIN, MAKE, MODEL, YEAR, COLOR, MILEAGE);
		
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(t1);
		System.out.println(t2);
		
		/*
		String[] myString = new String[10];
		myString[0] = 25;
		
		int[] myInts = new int[10];
		myInts[0] = "asdfasdf";
		
		Vehicle[] myAutos = new Vehicle[10];
		myAutos[0] = new Vehicle();
		*/
		
	}

}
