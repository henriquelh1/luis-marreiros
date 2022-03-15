package pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class categoryPage {

    AndroidDriver<MobileElement> driver;

    public categoryPage(AndroidDriver driver){
        this.driver= driver;
    }

    By categoryIcon = By.id("com.monefy.app.lite:id/categories_imagebutton");
    By billsIcon = 	By.xpath("//android.widget.TextView[@text='Bills']");
    By deleteButton =   By.id("com.monefy.app.lite:id/delete");
    By okButton =  By.id("android:id/button1");

    public void categoryIconClick() {
        driver.findElement(categoryIcon).click();
    }
    public void billsIconClick() {
        driver.findElement(billsIcon).click();
    }
    public void deleteButtonClick() {
        driver.findElement(deleteButton).click();
    }
    public void okButtonClick() {
        driver.findElement(okButton).click();
    }
}
