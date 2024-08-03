package Utilities;



import SetUp.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtils extends BaseTest {

    public static void waitTillElementIsDisplayed(WebElement element, int time) {

        if (driver != null) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }


    public static void clickOnElement(WebElement element, String buttonName) {
        waitTillElementIsDisplayed(element, 20);
        try {
            element.click();
            Utilities.Log.info("Tap on " + buttonName);

        } catch (Exception e) {
            try {

                if (driver != null) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                    Utilities.Log.info("Tap on " + buttonName);

                }
            } catch (Exception e2) {
                Log.error(e2.getMessage());

            }
        }
    }


    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void enterText(WebElement element, String textToEnter, String fieldName) {
        waitTillElementIsDisplayed(element, 20);
        try {
            Log.info(" Entering text : " + textToEnter + " in " + fieldName);
            element.sendKeys(textToEnter);
            Log.info(textToEnter + " is entered in " + fieldName);

        } catch (Exception e2) {
            Log.error("Failed to enter text : " + textToEnter + " in " + fieldName);
        }
    }

}
