package activity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity16 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.get(" https://training-support.net/webelements/selects");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());

        WebElement singleSelectElement = driver.findElement(By.cssSelector("select.h-10"));
        Select singleSelect = new Select(singleSelectElement);
        singleSelect.selectByVisibleText("Two");
        //singleSelect.selectByIndex(2);
        singleSelect.selectByIndex(3);
        singleSelect.selectByValue("four");

        List<WebElement> options = singleSelect.getOptions();
        System.out.println("\nAvailable Options:");
        for (WebElement option : options) {
                System.out.println(option.getText());
            }

       driver.quit();
    }
}