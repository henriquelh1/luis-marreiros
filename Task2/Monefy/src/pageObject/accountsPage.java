package pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class accountsPage {

    AndroidDriver<MobileElement> driver;

    public accountsPage(AndroidDriver driver){
        this.driver= driver;
    }

    By saveButton =         By.id("com.monefy.app.lite:id/save");
    By accountNameField = 	By.id("com.monefy.app.lite:id/editTextCategoryName");
    By imageIcon =          By.xpath("//android.widget.ImageView[@index='0']");

    public MobileElement saveButton() throws InterruptedException {
        return driver.findElement(saveButton);
    }
    public void accountNameFieldInput(String text) throws InterruptedException {
        driver.findElement(accountNameField).clear();
        driver.findElement(accountNameField).sendKeys(text);
    }
    public void imageIConClick() throws InterruptedException {
        driver.findElement(imageIcon).click();
    }
    public void accountNameClick(String text) throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+text+"']")).click();
    }
}
