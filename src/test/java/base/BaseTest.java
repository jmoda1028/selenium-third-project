package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.BrowserManager;

import java.io.File;
import java.io.IOException;

public class BaseTest extends BrowserManager {

//    @BeforeMethod
//    public void initialize() {
//        try {
//            initializeDriver(); // Initialize driver
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        if (driver == null) {
//            throw new IllegalStateException("WebDriver initialization failed.");
//        }
//        driver.get(bm.prop.getProperty("url")); // Ensure driver is not null before this line
//        driver.manage().window().maximize();
//    }

    @BeforeClass
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }


//    @AfterClass
//    public void teardown() {
//        driver.close();
//    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

//    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
//        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
//        File destination = new File(destinationFile);
//        String filepath = destination.getAbsolutePath();
//
//        FileUtils.copyFile(source, destination);
//
//        return filepath;
//    }

    public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;
    }
}
