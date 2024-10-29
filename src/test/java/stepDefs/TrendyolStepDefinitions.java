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
import util.ElementHelper;
import org.openqa.selenium.By;

import java.time.Duration;

public class TrendyolStepDefinitions {
    ElementChooser elementChooser = new ElementChooser();
    AppiumDriver<MobileElement> driver = DriverFactory.getDriver();
    ElementHelper elementHelper = new ElementHelper(driver);

    @When("Click to {string} Button")
    public void clickToButton(String buttonName) {
        By buttonLocator = elementChooser.getElementByName(buttonName);
        elementHelper.waitForElementToBeClickable(buttonLocator).click();
        System.out.println("\033[32m[SUCCESS] Button clicked successfully: " + buttonName + "\033[0m");
    }

    @When("Send {string} text to element {string}")
    public void sendText(String textName, String elementName) {
        By elementLocator = elementChooser.getElementByName(elementName);
        elementHelper.waitForElementToBeVisible(elementLocator).sendKeys(textName);
        System.out.println("\033[32m[SUCCESS] Text sent successfully to: " + elementName + "\033[0m");
    }

    @Then("Check to {string} Button is Available in Login Page")
    public void checkToButtonIsAvailableInLoginPage(String buttonName) {
        By buttonLocator = elementChooser.getElementByName(buttonName);
        boolean isVisible = elementHelper.waitForElementToBeVisible(buttonLocator).isDisplayed();
        assert isVisible : buttonName + " button is not visible on the login page.";
        System.out.println("\033[32m[SUCCESS] " + buttonName + " button is visible.\033[0m");
    }


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
        System.out.println("\033[32m[SUCCESS] Scroll down.\033[0m");
    }

    @When("Wait for {int} seconds")
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\033[32m[SUCCESS] Waited for " + seconds + " seconds.\033[0m");
    }

    @Then("Press Android Back Button")
    public void pressAndroidBackButton() {
        driver.navigate().back();
        System.out.println("\033[32m[SUCCESS] Back button pressed successfully.\033[0m");
    }


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
        System.out.println("\033[32m[SUCCESS] Swiped right successfully.\033[0m");
    }


    @When("Swipe right from {string}")
    public void swipeRightFromElement(String startingElementName) {

        By startingElementLocator = elementChooser.getElementByName(startingElementName);
        MobileElement startingElement = (MobileElement) elementHelper.waitForElementToBeVisible(startingElementLocator);


        int startX = startingElement.getLocation().getX();
        int startY = startingElement.getLocation().getY() + (startingElement.getSize().getHeight() / 2);
        int width = driver.manage().window().getSize().getWidth();


        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(width * 9 / 10, startY))
                .release()
                .perform();
        System.out.println("\033[32m[SUCCESS] Swiped right from " + startingElementName + " successfully.\033[0m");
    }
}
