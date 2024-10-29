package stepDefs;

import Elements.ElementChooser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.DriverFactory;
import org.openqa.selenium.By;

import java.time.Duration;

public class TrendyolStepDefinitions {
    ElementChooser elementChooser = new ElementChooser();
    AppiumDriver<MobileElement> driver = DriverFactory.getDriver();

    @When("Click to {string} Button")
    public void clickToButton(String buttonName) {

        By buttonLocator = elementChooser.getElementByName(buttonName);

        driver.findElement(buttonLocator).click();
    }
 
    @When("Send {string} text to element {string}")
    public void SendText(String textName,String buttonName) {

        By buttonLocator = elementChooser.getElementByName(buttonName);

        driver.findElement(buttonLocator).sendKeys(textName);
    }

//    @When("Click Enter")
//    public void ClickEnter(String buttonName) {
//        By buttonLocator = elementChooser.getElementByName(buttonName);
//       driver.findElement(buttonLocator).sendKeys("\n");
//    }

    @Then("Check to {string} Button is Available in Login Page")
    public void checkToButtonIsAvailableInLoginPage(String buttonName) {

        By buttonLocator = elementChooser.getElementByName(buttonName);
        boolean isVisible = driver.findElement(buttonLocator).isDisplayed();
        assert isVisible : buttonName + " button is not visible on the login page."; // Assertion to check visibility
    }

    // Scroll down action
    @When("Scroll down")
    public void scrollDown() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        new TouchAction(driver)
                .press(PointOption.point(width / 2, height * 3 / 4))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(width / 2, height / 4))
                .release()
                .perform();
    }

    @When("Wait for {int} seconds")
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Swipe right action
    @When("Swipe right")
    public void swipeRight() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        new TouchAction(driver)
                .press(PointOption.point(width * 1 / 10, height / 2))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(width * 9 / 10, height / 2))
                .release()
                .perform();
    }
    // Swipe right from a specified element

    // Swipe right action
    @When("Swipe right from {string}")
    public void swipeRightFromElement(String startingElementName) {
        // Get the locator for the starting element using the friendly name
        By startingElementLocator = elementChooser.getElementByName(startingElementName);
        MobileElement startingElement = (MobileElement) driver.findElement(startingElementLocator);

        // Get the starting position
        int startX = startingElement.getLocation().getX(); // X coordinate of the starting element
        int startY = startingElement.getLocation().getY() + (startingElement.getSize().getHeight() / 2); // Center Y coordinate of the starting element
        int width = driver.manage().window().getSize().getWidth(); // Get the screen width

        // Perform the swipe action
        new TouchAction(driver)
                .press(PointOption.point(startX, startY)) // Start from the center of the located element
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))) // Wait for 1 second
                .moveTo(PointOption.point(width * 9 / 10, startY)) // Move to 90% width from the starting element
                .release()
                .perform();
    }

}
