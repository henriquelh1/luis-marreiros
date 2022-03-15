package pageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amountPage {

    AndroidDriver<MobileElement> driver;

    static WebDriverWait wait;

    public amountPage(AndroidDriver driver){
        this.driver= driver;
    }

    By noteField = By.id("com.monefy.app.lite:id/textViewNote");
    By chooseCategoryButton = By.id("com.monefy.app.lite:id/keyboard_action_button");
    By currencyIcon = By.id("com.monefy.app.lite:id/icon");
    By cardIcon = By.xpath("//android.widget.TextView[@text='Payment card']");
    By salaryButton = By.xpath("//*[@text='Salary']");
    By billsButton = By.xpath("//android.widget.TextView[@text='Bills']");
    By sportCategory = By.xpath("//android.widget.ImageView[@index='22']");
    By deleteButton = By.id("com.monefy.app.lite:id/delete");
    By minusButton = By.id("com.monefy.app.lite:id/buttonKeyboardMinus");
    By equalsButton = By.id("com.monefy.app.lite:id/buttonKeyboardEquals");
    By amountText = By.id("com.monefy.app.lite:id/amount_text");

    public void inputNote(String text) {
        driver.findElement(noteField).clear();
        driver.findElement(noteField).sendKeys(text);
    }
    public MobileElement noteField() {
        return driver.findElement(noteField);
    }
    public String getNoteText() {
        return driver.findElement(noteField).getText();
    }
    public void minusButtonClick() {
        driver.findElement(minusButton).click();
    }
    public void equalsButtonClick() {
        driver.findElement(equalsButton).click();
    }
    public void getAmountField() {
        driver.findElement(amountText).click();
    }
    public String getAmountText() {
        return driver.findElement(amountText).getText();
    }
    public void numberClick(int num){
        String number = String.valueOf(num);
        for(int i = 0; i < number.length(); i++) {
            int j = Character.digit(number.charAt(i), 10);
            driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard"+j)).click();
        }
    }
    public void chooseCategoryButtonClick(){
        driver.findElement(chooseCategoryButton).click();
    }
    public void currencyIconClick(){
        driver.findElement(currencyIcon).click();
    }
    public void cardIconClick() {
        driver.findElement(cardIcon).click();
    }
    public MobileElement salaryButton() {
        return driver.findElement(salaryButton);
    }
    public void billsButtonClick() {
        driver.findElement(billsButton).click();
    }
    public void sportCategoryClick() {
        driver.findElement(sportCategory).click();
    }
    public void deleteButtonClick() throws InterruptedException {
        driver.findElement(deleteButton).click();
    }
}