package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Search_P {
    public static WebElement PressingOnSearchBox() {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }
    public static WebElement PressingSearchBtn() {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }
    public static WebElement WrittingSearchSentance() {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }
    public static List<WebElement> DisplayingAllRelatedResult() {
        return Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]"));
    }
}