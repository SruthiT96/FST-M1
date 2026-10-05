package Activities_TestNG;

import org.testng.annotations.Test;

public class Grouping {
	@Test (groups = { "Car" })
	public void Car1() {
	    System.out.println("Batch Car - Test car 1");
	}

	@Test (groups = { "Car" })
	public void Car2() {
	    System.out.println("Batch Car - Test car 2");
	}

}
