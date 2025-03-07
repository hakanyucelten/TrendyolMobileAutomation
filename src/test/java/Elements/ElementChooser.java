package Elements;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.lang.reflect.Field;

public class ElementChooser {
    // Elements
    By TrendyolApp = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Trendyol\")");
    By SepetimButton = MobileBy.xpath("//*[@text='Sepetim']");
    By AnasayfaButton = MobileBy.xpath("//*[@text='Anasayfa']");
    By GomlekFromResults = MobileBy.xpath("//*[@text='erkek gömlek']");
    By product1 = MobileBy.xpath("(//androidx.compose.ui.platform.ComposeView[@resource-id=\"trendyol.com:id/composeViewProductStampFrame\"])[1]/android.view.View\n");
    By searchButtonAndroid = By.xpath("//android.widget.Button[@text='Search']");
    By AddToBasketButton = By.xpath("//*[@text='Sepete Ekle']");
    By ChooseSize = By.xpath("//android.widget.TextView[@content-desc=\"L Seçili değil\"]\n");
    By YemekButton = MobileBy.xpath("(//android.widget.LinearLayout[@resource-id='trendyol.com:id/layoutSliderBannerItemTitle'])[2]");
    By SearchButton = MobileBy.xpath("//android.widget.EditText[@content-desc='Ara']");
    By SepetimDeleteButton = MobileBy.xpath("//android.widget.ImageButton[@content-desc='Ürünü sil']");
    By DeleteOnayButton = MobileBy.xpath("//android.widget.TextView[@resource-id='trendyol.com:id/textViewBasketRemoveAction']");
    By EmptyBasketMessage = MobileBy.xpath("//android.widget.TextView[@resource-id=\"trendyol.com:id/textViewMessage\"]");
    By ServicesMessage = MobileBy.xpath("//android.widget.TextView[@resource-id=\"trendyol.com:id/textViewTitle\" and @text=\"Hizmetlerimizi Keşfet\"]");



    public ElementChooser() {

    }

    public By getElementByName(String name) {
        try {

            Field field = this.getClass().getDeclaredField(name);

            field.setAccessible(true);
            return (By) field.get(this);
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException("No element found for name: " + name);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access the field: " + name, e);
        }
    }
}
