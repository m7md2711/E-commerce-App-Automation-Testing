package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.Cart_P;
import org.testng.asserts.SoftAssert;

public class CartStepDefinition {
    Cart_P shoppingCart_P = new Cart_P();
    @And("user chooses product randomly")
    public void user_chooses_product_randomly() {
        shoppingCart_P.ChooseingAnyProduct().click();
    }
    @And("press on ADD TO CART button")
    public void press_on_add_to_cart_button() {
        shoppingCart_P.AddingSpecificProductBtn().click();
    }
    @Then("the product is added to the user's shopping cart and message appears says The product has been added to your shopping cart")
    public void the_product_is_added_to_the_user_s_shopping_cart_and_message_appears_says_the_product_has_been_added_to_your_shopping_cart() {
        SoftAssert wishlistAssertion = new SoftAssert();
        if (shoppingCart_P.DisplayingMessage().isDisplayed()) {
            wishlistAssertion.assertEquals(shoppingCart_P.DisplayingMessage().getText(), "The product has been added to your shopping cart");
            wishlistAssertion.assertEquals(shoppingCart_P.DisplayingMessage().getCssValue("background-color"), "rgba(75, 176, 122, 1)");
            wishlistAssertion.assertAll();
        }
    }
}