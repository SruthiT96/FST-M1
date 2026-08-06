package ActivityF;

public class Activity6 {

    public static void main(String[] args) {

        try {
            // Create Plane object with maxPassengers = 10
            Plane plane = new Plane(10);

            // Add passengers
            plane.onboard("Aanchal");
            plane.onboard("Rahul");
            plane.onboard("Priya");
            plane.onboard("Karan");

            // Take off
            System.out.println("Plane took off at: " + plane.takeOff());

            // Display passengers
            System.out.println("Passengers onboard: " + plane.getPassengers());

            // Wait for 5 seconds (simulate flight)
            Thread.sleep(5000);

            // Land the plane
            plane.land();

            // Print landing time
            System.out.println("Plane landed at: " + plane.getLastTimeLanded());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
