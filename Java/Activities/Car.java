package activities;

public class Car {
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	public Car(String color, String transmission, int make){
		this.color=color;
		this.transmission=transmission;
		this.make=make;
		this.tyres=4;
		this.doors=4;
	}
	
	public void displayCharacteristics() {
		System.out.println("Car color is "+color);
		System.out.println("Car transmission is "+transmission);
		System.out.println("Car make is "+make);
		System.out.println("Car tyres are "+tyres);
		System.out.println("Car doors are "+doors);
	}
	
	public void accelarate() {
		System.out.println("Car is moving forward.");
	}
	
	public void brake() {
		System.out.println("Car has stopped.");
	}
}
