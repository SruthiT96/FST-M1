package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@Test
	public void testmethod() {
		System.out.println("Title of the page is :"+driver.getTitle());
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("password");
		driver.findElement(By.xpath("//button[@class=\"svelte-1pdjkmx\"]")).click();
		String msg=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h1")).getText();
		Assert.assertEquals("Login Success!",msg);
		
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        Assert.assertEquals("Welcome Back, Admin!", loginMessage);

		
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
}
