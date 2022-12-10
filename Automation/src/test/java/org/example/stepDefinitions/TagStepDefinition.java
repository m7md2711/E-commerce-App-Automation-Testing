package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Tag_P;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class TagStepDefinition {
    Tag_P selectTags = new Tag_P();
    @When("user chooses a popular tag")
    public void select_popular_tag() {
        selectTags.SelectedCoolTag().click();
        Hooks.sleep(8);
        String actualResult = selectTags.SelectedCoolItemPage().getText();
        String expectedResult = "Products tagged with 'cool'";
        Assert.assertEquals(actualResult, expectedResult, "Assertion False: ");
    }
    @And("user will find products")
    public void find_products()
    {

        List<WebElement> CoolPageCount = new ArrayList<>();
        CoolPageCount.add(selectTags.GetCoolPageCount());
        List<WebElement> CoolAsser = new ArrayList<>();
        CoolAsser.add(selectTags.DisplayCoolAsser());
        Assert.assertTrue(CoolPageCount.size() > 0); //6
        ArrayList<String> firstProductList = new ArrayList<>();
        for (int x = 0; x < CoolPageCount.size(); x++) {
            firstProductList.add(CoolPageCount.get(x).getText());
            Assert.assertTrue(CoolAsser.get(x).getText().toUpperCase().contains("ADD TO CART"), "Error Message: Cool Products Not Found");
        }
    }
    @Then("user chooses a different tag")
    public void select_a_different_tag() {
        selectTags.SelectedShirtTag().click();
        // Assert Shirt Tag Products //
        String actualResult = selectTags.SelectedShirtTag().getText();
        Hooks.sleep(8);
        String expectedResult = "shirt";
        Assert.assertEquals(actualResult, expectedResult, "Error Message: There are No Products");
    }
    @And("user will find another different products")
    public void find_another_different_products() {
        List<WebElement> ShirtCount = new ArrayList<>();
        ShirtCount.add(selectTags.GetShirtCount());
        List<WebElement> ShirtAsser = new ArrayList<>();
        ShirtAsser.add(selectTags.DisplayShirtAsser());
        Assert.assertTrue(ShirtCount.size() > 0); //3
        ArrayList<String> secondProductList = new ArrayList<>();
        for (int x = 0; x < ShirtCount.size() ; x++) {
            System.out.println(ShirtCount.get(x).getText());
            secondProductList.add(ShirtCount.get(x).getText());
            Assert.assertTrue(ShirtAsser.get(x).getText().contains("Shirt"), "Error Message: Shirt Products Not Found");
        }
    }
}