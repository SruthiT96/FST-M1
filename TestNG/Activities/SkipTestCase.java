package Activities_TestNG;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTestCase {
	@Test
	public void aSkipTest() throws SkipException {
		String condition = "Skip Test";
		
		if(condition.equals("Skip Test")) {
			throw new SkipException("Skipping this testcase since it is not ready to test");
					}
		else {
			
		}
	}

}
