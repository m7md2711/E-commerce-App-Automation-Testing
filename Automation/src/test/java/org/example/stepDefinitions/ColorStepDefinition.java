package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.Color_P;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static org.example.pages.Category_P.ChoosingMenuElement;
import static org.example.pages.Category_P.ChoosingSubMenuElement;

public class ColorStepDefinition {
    Color_P filterColor = new Color_P();
    @And("user chooses Category and hover to open sub-Category")
    public void user_choose_Category_hover_to_open_subCategory() throws InterruptedException {
        Actions act = new Actions(Hooks.driver);
        act.moveToElement(ChoosingMenuElement()).moveToElement(ChoosingSubMenuElement()).click().build().perform();
    }
    @And("user can filter sub-Category with color")
    public void user_can_filter_subCategory_with_color() {
        filterColor.colorFilterProduct().click();
    }
    @Then("user will find product with the selected color")
    public void user_will_find_product_with_the_selected_color() {
        Hooks.sleep(15);
        Assert.assertTrue(filterColor.colorCheckProduct().isDisplayed(), "Error Message: Selected Color Not Found!");
    }
}
