package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Cart_P {
    public static WebElement ChooseingAnyProduct() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/apple-macbook-pro-13-inch\"]"));
    }
    public static WebElement AddingSpecificProductBtn() {
        return Hooks.driver.findElement(By.id("add-to-cart-button-4"));
    }
    public static WebElement DisplayingMessage() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }
}