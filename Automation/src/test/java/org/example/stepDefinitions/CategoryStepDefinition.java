package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Category_P;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class CategoryStepDefinition {
    SoftAssert verifyLink = new SoftAssert();
    Category_P Category = new Category_P();
    @When("user chooses category randomly")
    public void user_chooses_category_randomly() {
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(Category.ChoosingMenuElement());
        actions.moveToElement(Category.ChoosingSubMenuElement());
        Hooks.sleep(20);
        actions.click().build().perform();
    }
    @Then("user return to the chose category page")
    public void user_return_to_the_chose_category_page() {
        String expectedResult = "https://demo.nopcommerce.com/shoes";
        verifyLink.assertEquals(Hooks.driver.getCurrentUrl(), expectedResult, "Wrong Page");
        verifyLink.assertAll();
    }
}
