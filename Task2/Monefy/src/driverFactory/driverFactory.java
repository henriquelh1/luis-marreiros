package driverFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.homePage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;

public class driverFactory {

    private static AndroidDriver<MobileElement> driver;


//    static By continueButton1= By.id("com.monefy.app.lite:id/buttonContinue");
//    static By closeButton1= 	By.id("com.monefy.app.lite:id/buttonClose");

    static WebDriverWait wait;

    public static AndroidDriver<MobileElement>getDriver() throws InterruptedException {
        if(driver==null) {
            createDriver();

        }
        return driver;
    }


    private static void createDriver() {

        File appDir = new File("src");
        File app = new File(appDir, "monefy.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(DEVICE_NAME, "Pixel_3a_API_32_arm64-v8a");
        cap.setCapability(APP, app.getAbsolutePath());
        cap.setCapability(AUTOMATION_NAME, "uiautomator2");
        cap.setCapability("appPackage", "com.monefy.app.lite");
        cap.setCapability("appActivity", "com.monefy.activities.main.MainActivity_");
        cap.setCapability("noReset", true);

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
//
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver =null;
        }
    }

    public static void resetApp(){
        driver.resetApp();
    }

    public void launchApp() {
        driver.launchApp();
    }
}
