package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
	    driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Title of the page is :"+driver.getTitle());
		WebElement checkBox = driver.findElement(By.id("checkbox"));
	    System.out.println("Checkbox is displayed " + checkBox.isDisplayed());
	
	    checkBox.click();
	    System.out.println("Checkbox is displayed " + checkBox.isDisplayed());
	  
	    
	    driver.quit();
	    
	}
}