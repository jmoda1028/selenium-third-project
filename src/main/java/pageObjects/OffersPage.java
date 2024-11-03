package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OffersPage {

    public WebDriver driver;

    By vegesList = By.xpath("//table[@class='table table-bordered']/tbody/tr");
    By dropdownPageOptions = By.cssSelector("select[id='page-menu']");
    By optionPageSizeTen = By.cssSelector("option[value='10']");
    By optionPageSizeTwenty = By.cssSelector("option[value='20']");

    public OffersPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }

    public List<WebElement> getVegesList() {
        return driver.findElements(vegesList);
    }
    public WebElement getDropdownPageOptions() {
        return driver.findElement(dropdownPageOptions);
    }
    public WebElement getOptionPageSizeTen() {
        return driver.findElement(optionPageSizeTen);
    }
    public WebElement getOptionPageSizeTwenty() {
        return driver.findElement(optionPageSizeTwenty);
    }
}
