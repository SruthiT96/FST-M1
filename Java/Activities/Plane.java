package ActivityF;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Plane {

    // Private variables (Encapsulation)
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOff;
    private Date lastTimeLanded;

    // Constructor
    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    // Add passenger
    public void onboard(String passengerName) {
        if (passengers.size() < maxPassengers) {
            passengers.add(passengerName);
        } else {
            System.out.println("Cannot add " + passengerName + " - Plane is full.");
        }
    }

    // Take off
    public Date takeOff() {
        lastTimeTookOff = new Date();
        return lastTimeTookOff;
    }

    // Land
    public void land() {
        lastTimeLanded = new Date();
        passengers.clear(); // remove all passengers
    }

    // Getter for landing time
    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    // Getter for passengers
    public List<String> getPassengers() {
        return passengers;
    }
}