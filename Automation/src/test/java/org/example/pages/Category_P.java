package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Category_P {
    public static WebElement ChoosingMenuElement() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/apparel\"]"));
    }
    public static WebElement ChoosingSubMenuElement() {
        return Hooks.driver.findElement(By.cssSelector("a[href=\"/shoes\"]"));
    }
}