package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.time.Duration;
import java.util.List;

public class SearchProduct extends BaseTest {

    @Test
    public void searchProduct() throws InterruptedException {
        HomePage h = new HomePage(driver);
        h.getSearchInputBox().clear();
        h.getSearchInputBox().sendKeys("cucumber");
        Thread.sleep(2000);

        String actualProductName = h.getSearchedProduct().getText();
        String expectedProductName = "Cucumber - 1 Kg";

        System.out.println(actualProductName);

        Assert.assertEquals(actualProductName, expectedProductName);

        // Wait for search results to load
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product fadeIn-leave fadeIn-leave-active")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product")));

//        List<WebElement> fadeEls = driver.findElements(By.cssSelector("div.product fadeIn-leave fadeIn-leave-active"));
//
//        for (WebElement fadeEl : fadeEls) {
//           if (fadeEl.isDisplayed()) {
//            System.out.println("The element is displayed.");
//        } else {
//            System.out.println("The element is not displayed.");
//        }
//        }

    }
}
