package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import webElements.PageTitle;

public class ValidatePageTitle extends BaseTest {

    @Test
    public void validatePageTitle()
    {

        PageTitle pt = new PageTitle(driver);
        //compare the text from the browser with actual text.- Error..

        Assert.assertEquals(pt.getTitle().getText(), "Practi");
    }

}
