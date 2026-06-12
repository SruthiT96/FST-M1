package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Activity6 {
	public static void main(String[] args) throws InterruptedException {
		Plane plane = new Plane(10);
		plane.onboard("Passenger1");
		plane.onboard("Passenger2");
		plane.onboard("Passenger3");
		plane.onboard("Passenger4");
		plane.takeOff();
        System.out.println("People on the plane: " + plane.getPassengers());
		plane.getPassengers();
		Thread.sleep(5000); 
		plane.land();
		plane.getLastTimeLanded();
        System.out.println("People on the plane after landing: " + plane.getPassengers());
	}
}

class Plane {
	private List<String> passengers;
	private int maxPassengers;
	private Date lastTimeTookOf;
	private Date lastTimeLanded;

	public Plane(int maxPassengers) {
		this.maxPassengers = maxPassengers;
		this.passengers = new ArrayList<>(maxPassengers);

	}

	public void onboard(String passengerName) {
        if(passengers.size() <= maxPassengers) {
            this.passengers.add(passengerName);
        } else {
            System.out.println("Plane is full");
        }
	}

	public void takeOff() {
		Date currentDateTime = new Date();
		this.lastTimeTookOf=currentDateTime;
		System.out.println("Take off Date and time: " + lastTimeTookOf);

	}

	public void land() {
		Date currentDateTime = new Date();
		this.lastTimeLanded = currentDateTime;
		System.out.println("Landing Date and time: " + lastTimeLanded);
		this.passengers.clear();
	}

	public Date getLastTimeLanded() {
		return this.lastTimeLanded;
	}

	public List<String> getPassengers() {
		return this.passengers;
	}
}
