package activities;

public class Activity1 {
	public static void main(String[] args) {
		
		Car Kia = new Car("Black", "Manual", 2024);
		
		Kia.displayCharacteristics();
		Kia.accelarate();
		Kia.brake();
	}
}