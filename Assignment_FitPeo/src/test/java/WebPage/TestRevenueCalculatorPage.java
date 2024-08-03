package WebPage;

import Pages.HomePage;
import SetUp.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Interfaces.ClassObjects.*;

public class TestRevenueCalculatorPage extends BaseTest {
    @Test(description = "validate Revenue calculator page")
    public void testRevenueCalculatorPage() throws InterruptedException {
        homepage.goToRevenueCalculator();
        revenuecalculatorpage.setSliderValue();
        revenuecalculatorpage.updateSliderValue();
        Thread.sleep(5000);
        revenuecalculatorpage.selectCPTCodes();
        revenuecalculatorpage.validateTotalRecurringReimbursement();
    }







}