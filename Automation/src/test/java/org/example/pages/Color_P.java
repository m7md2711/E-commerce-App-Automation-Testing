package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Color_P {
    public static WebElement colorFilterProduct() {
        return Hooks.driver.findElement(By.id("attribute-option-15"));
    }
    public static WebElement colorCheckProduct() {
        return Hooks.driver.findElement(By.id("attribute-option-15"));
    }
}