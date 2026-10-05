package Examples;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.File;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class FirstTest {
	
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		File testApp = new File("src/test/resources/Calculator.apk");
		//Set the options/desired capabilities
		 UiAutomator2Options options = new UiAutomator2Options();
		 options.setPlatformName("Android");
		 options.setAutomationName("UiAutomator2");
		 options.setApp(testApp.getAbsolutePath());
		 //C:\Users\SankeerthanaMarupall\eclipse-workspace\Eclipse\FST-Appium\src\test\resources\Calculator.apk
		 //options.noReset();
		 //set appium server URL
		 URL serverUrl = new URI("http://localhost:4723").toURL();
		 driver = new AndroidDriver(serverUrl, options);
	}
	
	@Test
	public void testMethod() {
		//Test code
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
