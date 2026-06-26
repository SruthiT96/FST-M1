package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		Reporter.log("Page title is " + driver.getTitle() + " | ");
	}
	
	@Test(priority=1)
	public void simpleAlertTestCase(){
		System.out.println(driver.getTitle());
		driver.findElement(By.id("simple")).click();
		Reporter.log("clicked on simple button"+" | ");
		Reporter.log("Text on simple alert is"+driver.switchTo().alert().getText()+" | ");
        Assert.assertEquals("You've just triggered a simple alert!", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Reporter.log("Page title is " + driver.getTitle() + " |");
		
	}
	
	@Test(priority=2)
	public void confirmAlertTestCase(){
		driver.findElement(By.id("confirmation")).click();
		Reporter.log("clicked on confirm button"+" | ");
		Reporter.log("Text on confirm alert is "+driver.switchTo().alert().getText()+" | ");
		
		Assert.assertEquals("You've just triggered a confirmation alert!", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Reporter.log("Accepted"+" | ");

		driver.findElement(By.id("confirmation")).click();

		driver.switchTo().alert().dismiss();
		Reporter.log("Dismissed"+" | ");

		
	}
	@Test(priority=3)
	public void promptAlertTestCase(){
		driver.findElement(By.id("prompt")).click();
		Reporter.log("clicked on prompt button"+" | ");

		Reporter.log("Text on prompt alert is "+driver.switchTo().alert().getText()+" | ");
		
        Assert.assertEquals("I'm a Prompt! Type something into me!", driver.switchTo().alert().getText());
		Reporter.log("Sending text on prompt alert | ");
		driver.switchTo().alert().sendKeys("Awesome!");
		driver.switchTo().alert().accept();
		Reporter.log("Accepted"+" | ");

	}
	@BeforeMethod
	public void switchBack() {
		Reporter.log("Switched to default content | ");
		driver.switchTo().defaultContent();
	}
	@AfterClass
	public void teardown() {
		driver.close();
	}

}
