package project;

import java.awt.event.MouseAdapter;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class ActionsBase {

	private final PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

	public void doSwipe(AppiumDriver driver, int duration, Point start, Point end) {
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), start.getX(), start.getY()));
		swipe.addAction(finger.createPointerDown(MouseButton.LEFT.asArg())); // intsead of MouseButton.LEFT.asArg(), we
																				// can keep 0 which is left click
		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(duration), Origin.viewport(), end.getX(), end.getY()));
		swipe.addAction(finger.createPointerUp(MouseButton.LEFT.asArg())); // intsead of MouseButton.LEFT.asArg(), we
																			// can keep 0 which is left click

		// Perform the swipe
		driver.perform(Arrays.asList(swipe));

	}

	public void longPress(AppiumDriver driver, int duration, Point start, Point end) throws InterruptedException {
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), start.getX(), start.getY()));
		swipe.addAction(finger.createPointerDown(MouseButton.LEFT.asArg())); // intsead of MouseButton.LEFT.asArg(), we
																				// can keep 0 which is left click
		swipe.addAction(new Pause(finger, Duration.ofMillis(duration)));
		swipe.addAction(finger.createPointerUp(MouseButton.LEFT.asArg())); // intsead of MouseButton.LEFT.asArg(), we
																			// can keep 0 which is left click

		// Perform the swipe
		driver.perform(Arrays.asList(swipe));
	}

	public void scrollVertically(AppiumDriver driver, int verticalFrom, int verticalTo) {
		Dimension screenSize = driver.manage().window().getSize();
		int screenWidth = screenSize.getWidth();
//		int screenHeight = screenSize.getHeight();
		int horizontal = (int) (screenWidth*0.08); /*
												 * do scrolling on the right, as some links tend to appear in the left
												 * which gets clicked during scrolling
												 */
	        Sequence scroll = new Sequence(finger, 0);

	        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), horizontal, verticalFrom));
	        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        scroll.addAction(finger.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), horizontal, verticalTo));
	        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        driver.perform(List.of(scroll));
	}
	
	public void clickOnpopUP(AppiumDriver driver, int duration, int x, int y) throws InterruptedException {
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), x, y));
		swipe.addAction(finger.createPointerDown(MouseButton.LEFT.asArg())); // intsead of MouseButton.LEFT.asArg(), we
																				// can keep 0 which is left click
		swipe.addAction(new Pause(finger, Duration.ofMillis(duration)));
		swipe.addAction(finger.createPointerUp(MouseButton.LEFT.asArg())); // intsead of MouseButton.LEFT.asArg(), we
																			// can keep 0 which is left click

		// Perform the swipe
		driver.perform(Arrays.asList(swipe));
	}
	
	
}
