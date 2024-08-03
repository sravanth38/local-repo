package Pages;

import SetUp.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static Utilities.TestUtils.*;

public class HomePage extends BaseTest {
    WebDriverWait wait;
    public HomePage(){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(xpath = "//div[contains(text(),'Revenue Calculator')]")
    WebElement revenueCalculatorLink;

    public void goToRevenueCalculator() {
        waitTillElementIsDisplayed(revenueCalculatorLink,5);
        revenueCalculatorLink.click();
    }


}
