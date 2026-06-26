package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {

public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new FirefoxDriver();
	driver.get("https://training-support.net/webelements/popups");
	System.out.println("Title of the page is :"+driver.getTitle());
	driver.findElement(By.id("launcher")).click();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.id("password")).sendKeys("password");
	driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
	String msg=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h1")).getText();
	System.out.println(msg);
	driver.quit();
	
}
}
