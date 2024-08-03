package Pages;

import SetUp.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.*;


import javax.swing.*;
import java.time.Duration;

import static Utilities.TestUtils.*;
import static java.time.Duration.*;

public class RevenueCalculatorPage extends BaseTest {
    @FindBy(xpath = "//span[contains(@class,'MuiSlider-thumb')]")
    WebElement slider;

    @FindBy(xpath = "//*[@type=\"number\"]")
    WebElement sliderInputValue;

    @FindBy(xpath = "//*[@type=\"checkbox\"][1]")
    WebElement cpt99091CheckBox;

    @FindBy(xpath = "//*[@type=\"checkbox\"and @xpath=\"1\"]")
    WebElement cpt99453CheckBox;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div[1]/label/span[1]/span")
    WebElement cpt99454CheckBox;

    @FindBy(xpath = "(//input[@type='checkbox'])[8]")
    WebElement cpt99474CheckBox;

    @FindBy(xpath = "//*[contains(@class,'MuiTypography-root MuiTypography-body2 inter css-1xroguk')][4]")
    WebElement totalRiembursementText;

    WebDriverWait wait;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public RevenueCalculatorPage(){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setSliderValue() throws InterruptedException {


        int width= slider.getSize().getWidth();
        Actions action = new Actions(driver) ;
        Thread.sleep(2000);
        //action.moveToElement(slider,93,0).click().build().perform();
        action.dragAndDropBy(slider,93,0).build().perform();
        Thread.sleep(2000);
        String a= sliderInputValue.getAttribute("value");
        System.out.println(a);
    }

    public void updateSliderValue() throws InterruptedException {
        sliderInputValue.clear();

        enterText(sliderInputValue,"560","value");
        js.executeScript("window.scrollBy(0,750)");


    }

    public void selectCPTCodes() throws InterruptedException {
        cpt99091CheckBox.click();
        List<WebElement> chList = driver.findElements(By.xpath("//*[@type=\"checkbox\"]"));
        for(int i=0;i<3;i++) {
            chList.get(1).click();
            chList.get(2).click();

        }
        js.executeScript("window.scrollBy(0,250)");
        cpt99474CheckBox.click();

        Thread.sleep(2000);


    }

    public void validateTotalRecurringReimbursement(){
        String actual= totalRiembursementText.getText().toString();
        Assert.assertEquals(actual,"Total Recurring Reimbursement for all Patients Per Month:\n" +
                "$110700");

    }



















}
