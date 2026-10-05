package StepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity4Steps extends BaseClass {

    @When("the user enters {string} and {string}")
    public void enterCredentialsFromInputs(
            String username,
            String password) {

        WebElement usernameField =
                driver.findElement(By.id("username"));

        WebElement passwordField =
                driver.findElement(By.id("password"));

        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @Then("get the confirmation text and verify message as {string}")
    public void confirmMessageAsInput(String expectedMessage) {

        String message;

        if (expectedMessage.contains("Invalid")) {

            message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("h2#subheading")
                )
            ).getText();

        } else {

            message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("h2.mt-5")
                )
            ).getText();
        }

        Assertions.assertEquals(expectedMessage, message);
    }
}