package project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
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
	
	@Test
	public void todoList2() throws InterruptedException {
		String newCategrory="Categrory1";
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/ListSpinnerCategory")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/CategoryListButtonNew")).click();
//		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/CategoryListItemID")).clear();
		driver.findElement(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"com.xmission.trevin.android.todo:id/CategoryListItemID\"])[3]")).sendKeys(newCategrory);
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/CategoryListButtonOK")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Categrory1\"]"))));
		Boolean isDisplayed=driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Categrory1\"]")).isDisplayed();
		System.out.println(newCategrory+" is displayed is "+isDisplayed);
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"All\"]")).click();

		WebElement todo2=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Complete Activity 2\")"));
		new ActionsBase().longPress(driver,450,todo2.getLocation(),todo2.getLocation());
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailSpinnerCategory")).click();
		
		String newCategoryLocator="new UiSelector().text(\""+newCategrory+"\")";
		driver.findElement(AppiumBy.androidUIAutomator(newCategoryLocator)).click();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonOK")).click();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/ListSpinnerCategory")).click();
		driver.findElement(AppiumBy.androidUIAutomator(newCategoryLocator)).click();
		String todoTask=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Complete Activity 2\")")).getText();
		Assert.assertEquals(todoTask, "Complete Activity 2");	
		
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
