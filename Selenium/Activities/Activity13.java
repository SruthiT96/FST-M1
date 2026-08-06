package activity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity13 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/tables");
        driver.manage().window().maximize();
        System.out.println("Page Title: " + driver.getTitle());

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("Number of Rows: " + rows.size());

        List<WebElement> columns = driver.findElements(By.xpath("//table/thead/tr/th"));
        System.out.println("Number of Columns: " + columns.size());
        System.out.println("\nValues in Third Row:");

        List<WebElement> thirdRowCells = driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
            for (WebElement cell : thirdRowCells) {
                System.out.print(cell.getText() + " ");
            }

        WebElement cellValue = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        System.out.println("\n\nValue at Row 2, Column 2: " + cellValue.getText());

        driver.quit();
        
    }
}
