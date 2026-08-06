package activity;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.get(" https://training-support.net/webelements/tabs");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());
        
        driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.sendKeys("Awesome!");
        alert.accept();
        System.out.println("Entered text and clicked OK.");
        
        driver.quit();
    }
}
