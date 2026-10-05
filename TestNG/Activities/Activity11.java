package Activities_TestNG;

import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity11 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open browser
		driver.get("https://training-support.net/webelements/simple-form");
	}

	public static List<List<String>> readExcel(String filePath) {
		// Creating the base list
		List<List<String>> data = new ArrayList<>();

		// Create the workbook object
		Workbook excelFile;
		try {
			excelFile = new XSSFWorkbook(new FileInputStream(filePath));

			// Select the sheet from the workbook
			Sheet sheet1 = excelFile.getSheetAt(0);

			// Iterate through the rows in the sheet
			for (Row rows : sheet1) {
				// To skip the first row
				if (rows.getRowNum() == 0) {
					continue;
				}
				// Create a temp list to store one row's data
				List<String> rowData = new ArrayList<>();
				// Iterate through the cells in each row
				for (Cell cells : rows) {
					switch (cells.getCellType()) {
					case STRING:
						// To get string values
						rowData.add(cells.getStringCellValue().trim());
						break;

					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cells)) {
							// To get dates
							rowData.add(cells.getLocalDateTimeCellValue()
								.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
						} else {
							// To get numbers
							rowData.add(String.valueOf(cells.getNumericCellValue()));
						}
						break;
					default:
						// Add a placeholder string for empty cells
						rowData.add("-");
					}
				}

				// Add the temp list to the base list
				data.add(rowData);

				// Close the file
				excelFile.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		// Return the base list to the DataProvider
		return data;
	}

	@DataProvider(name = "excelDataProvider")
	public static Object[][] inputData() throws FileNotFoundException, IOException {
		// Data from the Excel file
		List<List<String>> inputData = readExcel("src/test/resources/input.xlsx");

		// Convert the data into a 2D array dataset
		// This is the dataset that will be passed to the test functions
		Object[][] data = new Object[inputData.size()][];
		for (int i = 0; i < inputData.size(); i++) {
			data[i] = inputData.get(i).toArray();
		}

		// Return the dataset
		return data;
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		// Assert the page title
		assertEquals(driver.getTitle(), "Selenium: Simple Form");
	}

	@Test(priority = 2, dataProvider = "excelDataProvider")
	public void registerTest(String[] rows) throws InterruptedException {
		// Locate the full name field and add the full from the rows
		// Find the input fields and enter text
		driver.findElement(By.id("full-name")).sendKeys(rows[0]);
		// Enter the email
		driver.findElement(By.id("email")).sendKeys(rows[1]);
		// Enter the Date of the event
		driver.findElement(By.name("event-date")).sendKeys(rows[2]);
		// Enter additional details
		driver.findElement(By.id("additional-details")).sendKeys(rows[3]);

		// Click Submit
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		// Confirm booking
		String message = driver.findElement(By.id("action-confirmation")).getText();
		assertEquals(message, "Your event has been scheduled!");

		// Refresh the page
		driver.navigate().refresh();
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}