package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
	    driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Title of the page is :"+driver.getTitle());
		WebElement checkBox = driver.findElement(By.id("checkbox"));
	    System.out.println("Checkbox is selected " + checkBox.isSelected());
	
	    checkBox.click();
	    System.out.println("Checkbox is selected " + checkBox.isSelected());

	    
	    driver.quit();
	    
	}
}