package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
	    driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Title of the page is :"+driver.getTitle());
		WebElement text_Input = driver.findElement(By.id("textInput"));
	    System.out.println("Checkbox is enabled " + text_Input.isEnabled());
	
	    driver.findElement(By.id("//textInputButton")).click();
	    System.out.println("Checkbox is enabled " + text_Input.isEnabled());

	    
	    driver.quit();
	    
	}
}