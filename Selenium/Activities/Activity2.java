package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new FirefoxDriver();
	driver.get("https://training-support.net/webelements/login-form");
	System.out.println("Title of the page is :"+driver.getTitle());
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.id("password")).sendKeys("password");
	driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button")).click();
	Thread.sleep(2000);
	driver.quit();
	

}
}
