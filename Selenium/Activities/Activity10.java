package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
	    driver.get("https://training-support.net/webelements/mouse-events");
		System.out.println("Title of the page is :"+driver.getTitle());
		Actions actions=new Actions(driver);
		WebElement lock_button=driver.findElement(By.xpath("//*[@id='stage']/div/div[1]/div"));
		WebElement toml_button=driver.findElement(By.xpath("//*[@id='stage']/div/div[2]/div"));

	    actions.click(lock_button).moveToElement(toml_button).click().build().perform();
	    String cargo_lock_result_text=driver.findElement(By.id("result")).getText();
	    System.out.println(cargo_lock_result_text);
	    WebElement src=driver.findElement(By.xpath("//*[@id='stage']/div/div[3]/div"));
	    WebElement target=driver.findElement(By.xpath("//*[@id='stage']/div/div[4]/div"));
	    actions.doubleClick(src).contextClick(target).build().perform();
	    actions.click(driver.findElement(By.xpath("//*[@id='menu']/div/ul/li[1]/button"))).build().perform();
	    String cargo_target_result_text=driver.findElement(By.id("result")).getText();
	    System.out.println(cargo_target_result_text);
	    driver.quit();

		
	}
}
