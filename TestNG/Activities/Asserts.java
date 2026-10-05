package Activities_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Asserts {
	WebDriver driver;
	
	@Test
	public void testcase()
	{
		driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		WebElement aboutUsButton = driver.findElement(By.linkText("About"));
		Assert.assertTrue(aboutUsButton.isDisplayed());
		aboutUsButton.click();
		driver.close();
	}
	

}
