package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
	    driver.get("https://training-support.net/webelements/drag-drop");
		System.out.println("Title of the page is :"+driver.getTitle());
		WebElement ball=driver.findElement(By.id("ball"));
	    Actions actions=new Actions(driver);
	    WebElement dropzone1=driver.findElement(By.id("dropzone1"));
	    WebElement dropzone2=driver.findElement(By.id("dropzone2"));
	    actions.clickAndHold(ball).moveToElement(dropzone1).build().perform();
	    
	    if(driver.findElement(By.xpath("//*[@id='dropzone1']/span")).getText().equals("Dropped!")) {
        	System.out.println("Ball was dropped in Dropzone 1");
        }
	    
	    actions.dragAndDrop(ball,dropzone2).build().perform();
	    if(dropzone2.findElement(By.xpath("//*[@id='dropzone2']/span")).getText().equals("Dropped!")) {
        	System.out.println("Ball was dropped in Dropzone 2");
        }

	    driver.quit();
	}
}
