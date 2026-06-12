package activities;

public class Activity7 {
	public static void main(String args[]) {
		MountainBike mb = new MountainBike(3, 0, 25);
		System.out.println(mb.bicycleDesc());
		mb.speedUp(20);
		mb.applyBrake(5);

	}
}

interface BicycleParts {
	public static final int tyres = 0;
	public static final int maxSpeed = 0;
}

interface BicycleOperations {
	public void applyBrake(int decrement);
	public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations {
	public int gears;
	public int currentSpeed;

	public Bicycle(int gears, int currentSpeed) {
		this.gears = gears;
		this.currentSpeed = currentSpeed;
	}

	@Override
	public void applyBrake(int decrement) {
		// TODO Auto-generated method stub
		this.currentSpeed -= decrement;
		System.out.println("Current speed: " + currentSpeed);
	}

	@Override
	public void speedUp(int increment) {
		// TODO Auto-generated method stub
		this.currentSpeed += increment;
		System.out.println("Current speed: " + currentSpeed);
	}

	public String bicycleDesc() {
		return ("No of gears are " + gears + "\nSpeed of bicycle is " + maxSpeed);
	}

}

class MountainBike extends Bicycle {
	private int seatHeight;

	public MountainBike(int gears, int currentSpeed, int seatHeight) {
		super(gears, currentSpeed);
		this.seatHeight = seatHeight;
		// TODO Auto-generated constructor stub
	}

	public void setHeight(int newValue) {
		seatHeight = newValue;
	}

	@Override
	public String bicycleDesc() {
		return ("No of gears are " + gears + "\nSpeed of bicycle is " + maxSpeed + "\nSeat Height of Mountain Bike is "
				+ seatHeight);
	}
}