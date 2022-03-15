package pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class transferPage {

    AndroidDriver<MobileElement> driver;

    public transferPage(AndroidDriver driver){
        this.driver= driver;
    }

    By transferButton =  By.id("com.monefy.app.lite:id/keyboard_action_button");
    By fromAccountButton = By.id("com.monefy.app.lite:id/spinnerAccountFrom");
    By toAccountButton = By.id("com.monefy.app.lite:id/spinnerAccountTo");
    By cashOption = By.xpath("//android.widget.TextView[@text='Cash']");
    By cardOption = By.xpath("//android.widget.TextView[@text='Payment card']");

    public void confirmTransferButtonClick() {
        driver.findElement(transferButton).click();
    }
    public void fromAccountButtonClick() {
        driver.findElement(fromAccountButton).click();
    }
    public void toAccountButtonClick() {
        driver.findElement(toAccountButton).click();
    }
    public void cashOptionClick() {
        driver.findElement(cashOption).click();
    }
    public void cardOptionClick() {
        driver.findElement(cardOption).click();
    }

}
