package tests;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.OffersPage;

import java.time.Duration;
import java.util.ArrayList;

public class TopDealsPageSize extends BaseTest{

    @Test
    public void PageSizeofFive() {

        HomePage h = new HomePage(driver);
        OffersPage o = new OffersPage(driver);

        h.getTabTopDeals().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));

        if (o.getVegesList().size() <= 5) {
            System.out.println("Test passed: Number of records is within the limit. Count: " + o.getVegesList().size());
        } else {
            System.out.println("Test failed: Number of records exceeds 5. Actual count: " + o.getVegesList().size());
        }
    }

    @Test
    public void PageSizeofTen() {

        OffersPage o = new OffersPage(driver);

        o.getDropdownPageOptions().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(o.getOptionPageSizeTen()));

        o.getOptionPageSizeTen().click();
        o.getDropdownPageOptions().click();

        wait.until(ExpectedConditions.visibilityOfAllElements(o.getVegesList()));

        if (o.getVegesList().size() <= 10) {
            System.out.println("Test passed: Number of records is within the limit. Count: " + o.getVegesList().size());
        } else {
            System.out.println("Test failed: Number of records exceeds 10. Actual count: " + o.getVegesList().size());
        }
    }

    @Test
    public void PageSizeofTwenty() throws InterruptedException {

        OffersPage o = new OffersPage(driver);

        o.getDropdownPageOptions().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(o.getOptionPageSizeTwenty()));

        o.getOptionPageSizeTwenty().click();
        o.getDropdownPageOptions().click();

        wait.until(ExpectedConditions.visibilityOfAllElements(o.getVegesList()));

        if (o.getVegesList().size() <= 20) {
            System.out.println("Test passed: Number of records is within the limit. Count: " + o.getVegesList().size());
        } else {
            System.out.println("Test failed: Number of records exceeds 20. Actual count: " + o.getVegesList().size());
        }

        Thread.sleep(10000);

    }
}
