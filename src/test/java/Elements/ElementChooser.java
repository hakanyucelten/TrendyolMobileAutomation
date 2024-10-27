package Elements;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.lang.reflect.Field;

public class ElementChooser {
    // Elements
    By TrendyolApp = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Trendyol\")");
    By SepetimButton = MobileBy.xpath("//*[@text='Sepetim']");

    By YemekButton = MobileBy.xpath("(//android.widget.LinearLayout[@resource-id='trendyol.com:id/layoutSliderBannerItemTitle'])[2]");
    By SearchButton = MobileBy.xpath("//android.widget.EditText[@content-desc='Ara']");


    public ElementChooser() {

    }

    public By getElementByName(String name) {
        try {
            // Use reflection to get the field by name
            Field field = this.getClass().getDeclaredField(name);
            // Ensure the field is accessible
            field.setAccessible(true);
            return (By) field.get(this); // Return the By object
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException("No element found for name: " + name);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access the field: " + name, e);
        }
    }
}
