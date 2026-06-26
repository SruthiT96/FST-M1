package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;
	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@Test(groups="HeaderTests")
	public void headertest() {
		System.out.println(driver.getTitle());
		String thirdHeader=driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getTagName();
        Color fifthHeaderColor = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
		Assert.assertEquals(thirdHeader,"h3");
		Assert.assertEquals(fifthHeaderColor.asRgba(),"rgba(147, 51, 234, 1)");


		
	}
	@Test(groups="ButtonTests")
	public void buttontest() {
        WebElement emaraldButton = driver.findElement(By.xpath("//button[contains(text(), 'Emerald')]"));        
		Assert.assertEquals(emaraldButton.getText(),"Emerald");

	}

	
	@AfterClass(alwaysRun = true)
	public void teardown() {
		driver.close();
	}
}