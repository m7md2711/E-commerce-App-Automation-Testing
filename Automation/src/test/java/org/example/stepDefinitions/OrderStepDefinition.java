package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Order_P;
import org.openqa.selenium.support.ui.Select;

public class OrderStepDefinition {
    Order_P orderCheckOut = new Order_P();
    public static String city = "Alexanderia";
    public static String address1 = "al ibrahimeia";
    public static String postCode = "1000000";
    public static String phoneNo = "012345678910";
    public static String faxNo = "12345678";
    public static String cardHolderName = "Mohamed yasser";
    public static String cardNumber = "526405070607";
    public static String cardCode = "165";

    @And("open shopping page")
    public void open_shopping_page(){
        Hooks.driver.get("https://demo.nopcommerce.com/cart");
    }
    @When("user agrees with terms and proceed to Checkout")
    public void user_agrees_with_terms_and_proceed_to_Checkout()  {
        orderCheckOut.checkoutTermsPOM().click();
        orderCheckOut.checkoutBtnPOM().click();

    }
    @And("user types Billing address to Create Order")
    public void user_types_Billing_address_to_Create_Order() {
        // Enter First Name //
        orderCheckOut.checkoutFNamePOM().click();
        orderCheckOut.checkoutFNamePOM().clear();
        orderCheckOut.checkoutFNamePOM().sendKeys(Hooks.userFirstName);
        orderCheckOut.checkoutLNamePOM().click();
        orderCheckOut.checkoutLNamePOM().clear();
        orderCheckOut.checkoutLNamePOM().sendKeys(Hooks.userLastName);
        orderCheckOut.checkoutMailPOM().click();
        orderCheckOut.checkoutMailPOM().clear();
        orderCheckOut.checkoutMailPOM().sendKeys(Hooks.userValidEmail);
        Select country = new Select(orderCheckOut.checkoutCountryPOM());
        country.selectByVisibleText("Egypt"); //Select Country Name using visible text
        Hooks.sleep(5000);
        orderCheckOut.checkoutCityPOM().click();
        orderCheckOut.checkoutCityPOM().clear();
        orderCheckOut.checkoutCityPOM().sendKeys(city);
        orderCheckOut.checkoutAddressPOM().click();
        orderCheckOut.checkoutAddressPOM().clear();
        orderCheckOut.checkoutAddressPOM().sendKeys(address1);
        orderCheckOut.checkoutPostCodePOM().click();
        orderCheckOut.checkoutPostCodePOM().clear();
        orderCheckOut.checkoutPostCodePOM().sendKeys(postCode);
        orderCheckOut.checkoutPhoneNoPOM().click();
        orderCheckOut.checkoutPhoneNoPOM().clear();
        orderCheckOut.checkoutPhoneNoPOM().sendKeys(phoneNo);
        orderCheckOut.checkoutFaxNoPOM().click();
        orderCheckOut.checkoutFaxNoPOM().clear();
        orderCheckOut.checkoutFaxNoPOM().sendKeys(faxNo);
    }
    @And("user confirms Billing address")
    public void user_confirms_Billing_address() {
        orderCheckOut.checkoutBillAddSaveBtnPOM().click();
        Hooks.sleep(3000);
    }
    @And("user chooses Shipping Method to Continue")
    public void user_chooses_Shipping_Method_to_Continue() {
        orderCheckOut.checkoutShipMethSelPOM().click();
        orderCheckOut.checkoutShipMethSaveBtnPOM().click();
        Hooks.sleep(3000);
    }
    @And("user chooses Payment Method to Continue")
    public void user_chooses_Payment_Method_to_Continue() {
        orderCheckOut.checkoutPayMethSelPOM().click();
        orderCheckOut.checkoutPayMethSaveBtnPOM().click();
        Hooks.sleep(3000);
    }
    @And("user fills out Payment Information")
    public void user_fills_out_Payment_Information() {
        Select card = new Select(orderCheckOut.checkoutCardTypePOM());
        card.selectByValue("MasterCard"); //Select Credit Card Type from Value
        orderCheckOut.checkoutCardHolderNamePOM().click();
        orderCheckOut.checkoutCardHolderNamePOM().clear();
        orderCheckOut.checkoutCardHolderNamePOM().sendKeys(cardHolderName);
        orderCheckOut.checkoutCardNoPOM().click();
        orderCheckOut.checkoutCardNoPOM().clear();
        orderCheckOut.checkoutCardNoPOM().sendKeys(cardNumber);
        Select month = new Select(orderCheckOut.checkoutCardExpMonthPOM());
        month.selectByValue("8");
        Select year = new Select(orderCheckOut.checkoutCardExpYearPOM());
        year.selectByValue("2024"); //Select Card Expiration Year from Value
        orderCheckOut.checkoutCardCodePOM().click();
        orderCheckOut.checkoutCardCodePOM().clear();
        orderCheckOut.checkoutCardCodePOM().sendKeys(cardCode);
        orderCheckOut.checkoutPaymentSaveBtnPOM().click();
        System.out.println("Create Successful Order!");
    }
    @Then("user confirms his order")
    public void user_confirms_his_order() {
        orderCheckOut.checkoutOrderConfirmBtnPOM().click();
        System.out.println("Your order has been successfully processed!");
    }
    @And("user checks order details")
    public void user_checks_order_details() {
        orderCheckOut.checkoutOrderDetailsPOM().click();
        System.out.println("Title of page is: " + Hooks.driver.getTitle());
    }
    @And("user saves invoice")
    public void user_saves_invoice() {
        orderCheckOut.checkoutInvoiceSavePOM().click();
        Hooks.sleep(3000);
        System.out.println("PDF Invoice has been downloaded Successfully");
    }
    @And("user prints invoice")
    public void user_prints_invoice() {
        orderCheckOut.checkoutInvoicePrintPOM().click();
        Hooks.sleep(3000);
        System.out.println("Invoice has been printed Successfully");
    }
}