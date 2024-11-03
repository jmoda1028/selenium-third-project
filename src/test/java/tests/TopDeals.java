package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TopDeals extends BaseTest {

    @Test
    public void TopDealsTab() {
        HomePage h = new HomePage(driver);

        // Click on the Top Deals tab
        h.getTabTopDeals().click();

        // Wait for the new tab to be opened
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Get the current window handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Ensure there are at least 2 tabs open
        Assert.assertTrue(tabs.size() > 1, "Less than 2 tabs are open!");

        // Switch to the new tab
        driver.switchTo().window(tabs.get(1));

        // Verify the URL of the new tab
        String nwUrl = driver.getCurrentUrl();
        String expectedURL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
        Assert.assertEquals(nwUrl, expectedURL, "The URL of the new tab does not match the expected URL!");
        System.out.println("New Tab URL: " + nwUrl);


        driver.switchTo().window(tabs.get(0));

        // Verify the URL of the original tab
        String nwUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(nwUrl2, "https://rahulshettyacademy.com/seleniumPractise/#/", "The URL of the original tab does not match the expected URL!");
        System.out.println("Original Tab URL: " + nwUrl2);

    }
}
