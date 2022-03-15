package pageObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

public class homePage{

 AndroidDriver<MobileElement> driver;

    public homePage(AndroidDriver driver){
        this.driver= driver;
    }

    By continueButton = By.id("com.monefy.app.lite:id/buttonContinue");
    By closeButton = 	By.id("com.monefy.app.lite:id/buttonClose");
    By incomeButton =   By.id("com.monefy.app.lite:id/income_button");
    By expenseButton =  By.id("com.monefy.app.lite:id/expense_button");
    By transferButton = By.id("com.monefy.app.lite:id/transfer_menu_item");
    By popUp =          By.id("com.monefy.app.lite:id/snackbar_text");
    By leftMenu =       By.id("com.monefy.app.lite:id/overflow");
    By accountsButton = By.id("com.monefy.app.lite:id/accounts_panel");
    By addAccountButton = By.id("com.monefy.app.lite:id/imageButtonAddCategory");
    By searchButton = By.id("com.monefy.app.lite:id/menu_search");
    By searchField = By.id("com.monefy.app.lite:id/et_search");
    By searchElement = By.id("com.monefy.app.lite:id/note_text_view");

    public void continueButtonClick() throws InterruptedException {
        Thread.sleep(100);
        driver.findElement(continueButton).click();
    }
    public void incomeButtonClick() throws InterruptedException {
        Thread.sleep(200);
        driver.findElement(incomeButton).click();
        Thread.sleep(100);
    }
    public void expenseButtonClick() throws InterruptedException {
        Thread.sleep(100);
        driver.findElement(expenseButton).click();
    }
    public void closeButtonClick() throws InterruptedException {
        Thread.sleep(100);
        driver.findElement(closeButton).click();
        Thread.sleep(100);
    }
    public void leftMenuClick() throws InterruptedException {
        driver.findElement(leftMenu).click();
    }
    public void transferButtonClick() throws InterruptedException {
        Thread.sleep(200);
        driver.findElement(transferButton).click();
        Thread.sleep(100);
    }
    public void accountsButtonClick() throws InterruptedException {
        driver.findElement(accountsButton).click();
    }
    public void addAccountsButtonClick() throws InterruptedException {
        driver.findElement(addAccountButton).click();
    }
    public void searchButtonClick() throws InterruptedException {
        driver.findElement(searchButton).click();
    }
    public void searchFieldInput(String text) throws InterruptedException {
        driver.findElement(searchField).sendKeys(text);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void searchElementClick() throws InterruptedException {
        driver.findElement(searchElement).click();
    }
    public String getPopupConfirmation() throws InterruptedException {
        Thread.sleep(100);
        String text = driver.findElement(popUp).getText();
        return text;
    }
    public void skipOnboard() throws InterruptedException {
        continueButtonClick();
        continueButtonClick();
        continueButtonClick();
        closeButtonClick();
    }
}
