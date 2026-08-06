package activity;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/alerts");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());
        
        driver.findElement(By.xpath("//button[contains(text(),'Simple')]")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.accept();
        System.out.println("Alert accepted successfully.");
        
        driver.quit();
    }
}
