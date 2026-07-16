package activities;

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

public class Activity4 {
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		//File object for application
		//set desired capabilities or options
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.contacts");
		options.setAppActivity("com.android.contacts.activities.PeopleActivity");
		options.noReset();		

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@Test
	public void addContact() {
//		driver.findElement(AppiumBy.id("com.google.android.contacts:id/floating_action_button")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"First name\"]")).sendKeys("Aaditya");

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Last name\"]")).sendKeys("Varma");
//		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(26)")).clear();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"+1\"]/android.view.View[2]")).clear();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"+1\"]/android.view.View[2]")).sendKeys("999148292");
		driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button")).click();
		
		String result=driver.findElement(AppiumBy.id("com.google.android.contacts:id/large_title")).getText();
		System.out.println(result);
		Assert.assertEquals(result, "Aaditya Varma");


	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
