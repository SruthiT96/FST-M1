package activity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class Activity17 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.get(" https://training-support.net/webelements/selects");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());

        WebElement multiSelectElement = driver.findElement(By.xpath("(//select)[2]"));
        Select multiSelect = new Select(multiSelectElement);
        if (multiSelect.isMultiple()) {
        multiSelect.selectByVisibleText("HTML");
        multiSelect.selectByIndex(3);
        multiSelect.selectByIndex(4);
        multiSelect.selectByIndex(5);
        multiSelect.selectByValue("nodejs");
        multiSelect.deselectByIndex(5);
        System.out.println("Multi-select operations completed successfully.");
        } else {
            System.out.println("This dropdown does not support multiple selection.");
        }
        
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }
        driver.quit();
    }
}
