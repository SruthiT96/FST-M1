package AppiumActivities;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class ActionBase {

    private final PointerInput finger =
            new PointerInput(Kind.TOUCH, "finger");

    public void doSwipe(
            AppiumDriver driver,
            long duration,
            Point start,
            Point end) {

        Sequence swipe = new Sequence(finger, 1);

        // Move finger to start position
        swipe.addAction(
                finger.createPointerMove(
                        ofMillis(0),
                        viewport(),
                        start.getX(),
                        start.getY()
                )
        );

        // Finger down
        swipe.addAction(
                finger.createPointerDown(
                        MouseButton.LEFT.asArg()
                )
        );

        // Move finger to end position
        swipe.addAction(
                finger.createPointerMove(
                        ofMillis(duration),
                        viewport(),
                        end.getX(),
                        end.getY()
                )
        );

        // Finger up
        swipe.addAction(
                finger.createPointerUp(
                        MouseButton.LEFT.asArg()
                )
        );

        driver.perform(Arrays.asList(swipe));
    }
}