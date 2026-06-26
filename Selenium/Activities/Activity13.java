package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
	    driver.get("https://training-support.net/webelements/tables");
		System.out.println("Title of the page is :"+driver.getTitle());
		List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println(rows.size());
		List<WebElement> columns=driver.findElements(By.xpath("//table/thead/tr/th"));
		System.out.println(columns.size());
		List<WebElement> thirdRow=driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
		for(WebElement val: thirdRow) {
			System.out.println(val.getText());
		}
		WebElement secondRowSecondcolumn=driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
			System.out.println(secondRowSecondcolumn.getText());
		driver.quit();
	}
}
