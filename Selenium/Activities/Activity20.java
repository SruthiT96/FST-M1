package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {
public static void main(String[] args) {
	WebDriver driver=new FirefoxDriver();
	driver.get("https://training-support.net/webelements/alerts");
	System.out.println("Title of the page is :"+driver.getTitle());
	driver.findElement(By.id("prompt")).click();
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().sendKeys("Awesome!");
	driver.switchTo().alert().accept();
	driver.quit();
	
}
}
