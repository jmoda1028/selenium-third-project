package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cart extends BaseTest {

    @Test
    public void BtnProceedCheckoutDisabled() {

        HomePage h = new HomePage(driver);

        h.getBtnCart().click();
        String actualOpacityValue = h.getBtnProceedCheckout().getCssValue("opacity");
        String expectedOpacityValue = "0.3";
        Assert.assertEquals(actualOpacityValue, expectedOpacityValue);
        String actualCursorValue = h.getBtnProceedCheckout().getCssValue("cursor");
        String expectedCursorValue = "not-allowed";
        Assert.assertEquals(actualCursorValue, expectedCursorValue);

        h.getMsgEmptyCart().getText();
        String actualMsgEC = h.getMsgEmptyCart().getText();
        String expectedMsgEC = "You cart is empty!";
        Assert.assertEquals(actualMsgEC, expectedMsgEC);

        // validation to check if proceed button is disabled
        String actualDisabledValue = h.getBtnProceedCheckout().getAttribute("class");
        String expectedDisabledValue = "disabled";
        Assert.assertEquals(actualDisabledValue, expectedDisabledValue);

//        System.out.println(disabledAttributeValue);


        h.getBtnCart().click();
//        Thread.sleep(10000);

//        System.out.println(actualOpacityValue);
//        System.out.println(actualCursorValue);
    }

    @Test(dependsOnMethods = "BtnProceedCheckoutDisabled")
    public void BtnProceedCheckoutClickable() {

        HomePage h = new HomePage(driver);
        if (h.getBtnAddToCart().size() > 0) {
            // Click the first product's action button
            h.getBtnAddToCart().get(1).click();
        } else {
            System.out.println("No action buttons found for products.");
        }

        h.getBtnCart().click();

        String opacity = h.getBtnProceedCheckout().getCssValue("opacity");

        String expectedOpacityValue = "1";

        Assert.assertEquals(opacity, expectedOpacityValue, "Opacity value match the expected value.");

        String actualCursorValue = h.getBtnProceedCheckout().getCssValue("cursor");
        String expectedCursorValue = "pointer";

        Assert.assertEquals(actualCursorValue, expectedCursorValue);

        // validation to check if proceed button is clickable
        String actualDisabledValue = h.getBtnProceedCheckout().getAttribute("class");
        String expectedDisabledValue = " ";
        Assert.assertEquals(actualDisabledValue, expectedDisabledValue);

        h.getBtnCart().click();
    }

    @Test(dependsOnMethods = {"BtnProceedCheckoutClickable", "BtnProceedCheckoutDisabled"})
    public void ClickingSpecificProduct() {

        HomePage h = new HomePage(driver);

        for (int i = 0; i < h.getProductsName().size(); i++) {
            String name = h.getProductsName().get(i).getText();

            if (name.contains("Cucumber")) {
                h.getBtnAddToCart().get(i).click();
                break;
            }
        }
    }

    @Test(dependsOnMethods = {"BtnProceedCheckoutClickable", "BtnProceedCheckoutDisabled", "ClickingSpecificProduct"})
    public void ClickingMultipleProducts() throws InterruptedException {

        HomePage h = new HomePage(driver);

        String[] itemsNeeded = {"Beans", "Brocolli", "Beetroot", "Pumpkin"};
        Thread.sleep(3000);
        addItems(driver, itemsNeeded);
    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        HomePage h = new HomePage(driver);
        Set<String> itemsNeededSet = new HashSet<>(Arrays.asList(itemsNeeded));
        int itemsAdded = 0;

        for (int i = 0; i < h.getProductsName().size(); i++) {
            String[] name = h.getProductsName().get(i).getText().split("-");
            String formattedName = name[0].trim();

            if (itemsNeededSet.contains(formattedName)) {
                try {
                    h.getBtnAddToCart().get(i).click();
                    itemsAdded++;
                    System.out.println(formattedName + " added to cart.");

                    if (itemsAdded == itemsNeeded.length) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Failed to add " + formattedName + " to cart: " + e.getMessage());
                }
            }
        }
    }

//    public static void addItems(WebDriver driver, String[] itemsNeeded) {
//
//        HomePage h = new HomePage(driver);
//
//        int j = 0;
//
//
//        for (int i = 0; i < h.getProductsName().size(); i++) {
//
//            String[] name = h.getProductsName().get(i).getText().split("-");
//
//            String formattedName = name[0].trim();
//
//            List itemsNeededList = Arrays.asList(itemsNeeded);
//
//
//            if (itemsNeededList.contains(formattedName)) {
//
//                j++;
//
//                h.getBtnAddToCart().get(i).click();
//
//                if (j == itemsNeeded.length) {
//
//                    break;
//
//                }
//
//
//            }
//
//        }
//
//    }
}
