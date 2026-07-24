package project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		//File object for application
		File testApp=new File("src/test/resources/ToDo.apk");

		//set desired capabilities or options
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp(testApp.getAbsolutePath());
		options.noReset();		
		//set server url
		URL serverurl=new URI("http://localhost:4723").toURL();//local host=127.0.0.1
		driver=new AndroidDriver(serverurl,options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@Test(dataProvider="todoDetails")
	public void todoList1(String description,String priority,String dueDate) {
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/ListButtonNew")).click();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextDescription")).sendKeys(description);
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextPriority")).clear();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextPriority")).sendKeys(priority);
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonDueDate")).click();
		String dueDateLocator="new UiSelector().text(\""+dueDate+"\")";
		driver.findElement(AppiumBy.androidUIAutomator(dueDateLocator)).click();

		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonOK")).click();
		String response="new UiSelector().text(\""+description+"\")";
		String todoTask=driver.findElement(AppiumBy.androidUIAutomator(response)).getText();
		Assert.assertEquals(todoTask, description);
	}
	
	@DataProvider(name="todoDetails")
	public Object[][] data(){
		return new Object[][] {
			{"Complete Activity 1","1","7/22 – Wednesday"},
			{"Complete Activity 2","2","7/22 – Wednesday"},
			{"Complete Activity 3","3","7/23 – Thursday"}
		};
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
