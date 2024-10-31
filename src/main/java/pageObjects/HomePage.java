package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;

    By pageTitle = By.xpath("//div[@class='brand greenLogo']");
    By searchInputBox = By.cssSelector("input.search-keyword");
    By searchedProduct = By.cssSelector("h4[class='product-name']");

    public HomePage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }

    public WebElement getPageTitle() {
        return driver.findElement(pageTitle);
    }
    public WebElement getsearchInputBox() {
        return driver.findElement(searchInputBox);
    }
    public WebElement getsearchedProduct() {
        return driver.findElement(searchedProduct);
    }
}
