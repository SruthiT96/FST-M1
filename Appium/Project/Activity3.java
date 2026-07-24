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
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {
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
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/ListSpinnerCategory")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"All\"]")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.xmission.trevin.android.todo:id/ToDoItemChecked\").instance(0)")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.xmission.trevin.android.todo:id/ToDoItemChecked\").instance(1)")).click();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/menuShowCompleted")).click();
		String todoTask=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Complete Activity 3\")")).getText();
		Assert.assertEquals(todoTask, "Complete Activity 3");	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
