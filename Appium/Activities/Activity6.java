package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {
	
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		//File object for application
		//set desired capabilities or options
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();		
		//set server url
		URL serverurl=new URI("http://localhost:4723").toURL();//local host=127.0.0.1
		driver=new AndroidDriver(serverurl,options);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	
	@Test(dataProvider = "input")
	public void slideAction(Point start, Point end, String output) {
		driver.get("https://training-support.net/webelements/sliders");
		ActionsBase base=new ActionsBase();
		base.doSwipe(driver, 1500, start, end);
		String volumeText=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"50%\"]")).getText();
		
		Assert.assertEquals(volumeText, output);
	}

	@DataProvider(name="input")
	public Object[][] inputValues(){
		
		Point start_25=new Point(540,1800);
		Point end_25=new Point(734,1800);

		
		Point start_75=new Point(540,1800);
		Point end_75=new Point(372,1800);


		return new Object[][] {
			{start_25,end_25,"25%"},
			{start_75,end_75,"75%"}};
		}
	}
