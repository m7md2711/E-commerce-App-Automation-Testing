package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Currency_P;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class CurrencyStepDefinition {
    Currency_P switchCurrency = new Currency_P();
    @When("user chooses from currency dropdown list")
    public void user_chooses_from_currency_dropdown_list() {
        if (switchCurrency.ChoosingFromListElement().isEnabled() && switchCurrency.ChoosingFromListElement().isDisplayed()) {
            System.out.println("DropList is Enabled and Visible");
        } else {
            System.out.println("DropList is not Visible");
        }
        Select select = new Select(switchCurrency.ChoosingFromListElement());
        select.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }
    @Then("verification process from currency")
    public void verificationProcess_from_currency() {
        SoftAssert productAssert = new SoftAssert();
        String expectedResult = "€";
        for (int i = 0; i < switchCurrency.DisplayingChoosedProductPrice().size(); i++) {
            productAssert.assertEquals(switchCurrency.DisplayingChoosedProductPrice().get(i).getText().substring(0, 1), expectedResult, "Error found different currency");
            productAssert.assertAll();
        }
    }
}