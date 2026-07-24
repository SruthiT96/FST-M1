package activities;

import java.awt.event.MouseAdapter;
import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class ActionsBase {
	
	private final PointerInput finger=new PointerInput(Kind.TOUCH, "finger");
	

	public void doSwipe(AppiumDriver driver, int duration, Point start, Point end) {
		Sequence swipe=new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),Origin.viewport(),start.getX(),start.getY()));
		swipe.addAction(finger.createPointerDown(MouseButton.LEFT.asArg())); // intsead of MouseButton.LEFT.asArg(), we can keep 0 which is left click
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(duration),Origin.viewport(),end.getX(),end.getY()));
		swipe.addAction(finger.createPointerUp(MouseButton.LEFT.asArg())); // intsead of MouseButton.LEFT.asArg(), we can keep 0 which is left click
		
		// Perform the swipe
		driver.perform(Arrays.asList(swipe));
		
	}
	

}
