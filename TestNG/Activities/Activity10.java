package activities;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity10 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setup() {
		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(dataProvider="credentials")
	public void testmethod(String[] rows) {
	    driver.get("https://training-support.net/webelements/dynamic-attributes");

		System.out.println("Title of the page is :"+driver.getTitle());
		driver.findElement(By.xpath("//input[contains(@id,'full-name-')]")).sendKeys(rows[0]);
		driver.findElement(By.xpath("//input[contains(@id,'-email')]")).sendKeys(rows[1]);
		driver.findElement(By.xpath("//input[contains(@type,'date')]")).sendKeys(rows[2]);
		driver.findElement(By.xpath("//textarea[contains(@id,'-additional-details-')]")).sendKeys(rows[3]);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		   WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("action-confirmation"))));
		    System.out.println("Success message: "+message.getText());		
	}
	
	@DataProvider(name="credentials")
	public Object[][] data() throws IOException, CsvException{
		CSVReader reader=new CSVReader(new FileReader("C:\\Users\\PoojaL\\Downloads\\datasetActivity10.csv")); 
		reader.skip(1);
		List<String[]> allRows=reader.readAll();
		
		Object[][] data=new Object[allRows.size()][];
		for(int i=0;i<allRows.size();i++) {
			data[i]=allRows.get(i);
		}
		reader.close();
		return data;
		
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}

}
