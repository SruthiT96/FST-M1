package activities;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class Activity11 {
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
	public String[][] data() throws IOException, CsvException{
		XSSFWorkbook reader=new XSSFWorkbook(new FileInputStream("C:\\Users\\PoojaL\\Downloads\\datasetActivity10.csv.xlsx")); 
		XSSFSheet sheet1=reader.getSheetAt(0);
		int rowsNum=sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		String[][] data = new String[rowsNum][4];
		for(int i=1;i<(rowsNum+1);i++) {
			String name=sheet1.getRow(i).getCell(0).getStringCellValue();
			String email=sheet1.getRow(i).getCell(1).getStringCellValue();
			String date=sheet1.getRow(i).getCell(2).getLocalDateTimeCellValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			String details=sheet1.getRow(i).getCell(3).getStringCellValue();
			System.out.println(name+" "+email+" "+" "+date+" "+details);
			int j=i-1;
			data[j][0]=name;
			data[j][1]=email;
			data[j][2]=date;
			data[j][3]=details;
		}
	
		reader.close();
		return data;
		
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}

}
