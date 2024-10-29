package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageTitle {

    public WebDriver driver;

    By pageTitle = By.xpath("//div[@class='brand greenLogo']");

    public PageTitle(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
    }

    public WebElement getTitle() {
        return driver.findElement(pageTitle);
    }

}
