package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    public WebDriver driver;

    By pageTitle = By.xpath("//div[@class='brand greenLogo']");
    By searchInputBox = By.cssSelector("input.search-keyword");
    By searchedProduct = By.cssSelector("h4[class='product-name']");
    By btnCart = By.cssSelector("a[class='cart-icon']");
    By btnProceedCheckout = By.xpath("//div/button[@type=\'button\' and contains(text(),\'PROCEED TO CHECKOUT\')]");
    By btnAddToCart = By.xpath("//button[contains(text(), 'ADD TO CART')]");
    By msgEmptyCart = By.xpath("//div[@class='cart-preview active']/div/div/div[@class='empty-cart']/h2");

    public HomePage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }

    public WebElement getPageTitle() {
        return driver.findElement(pageTitle);
    }

    public WebElement getSearchInputBox() {
        return driver.findElement(searchInputBox);
    }

    public WebElement getSearchedProduct() {
        return driver.findElement(searchedProduct);
    }

    public WebElement getBtnCart() { return driver.findElement(btnCart); }

    public WebElement getBtnProceedCheckout() {
        return driver.findElement(btnProceedCheckout);
    }

    public List<WebElement> getBtnAddToCart() {
        return driver.findElements(btnAddToCart);
    }

    public WebElement getMsgEmptyCart() {return driver.findElement(msgEmptyCart); }

    public List<WebElement> getProductsName() {
        return driver.findElements(searchedProduct);
    }

}
