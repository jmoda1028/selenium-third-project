package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class ValidatePageTitle extends BaseTest {

    @Test
    public void validatePageTitle()
    {
        HomePage h = new HomePage(driver);
        String actualPageTitle = h.getPageTitle().getText();
        String expectedPageTitle = "GREENKART";

        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

}
