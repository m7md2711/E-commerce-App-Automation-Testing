package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.ResetPassword_P;
import org.testng.Assert;

public class ResetPasswordStepDefinition {
    ResetPassword_P resetPassword = new ResetPassword_P();
    @When("user presses on forgot password link")
    public void user_presses_on_forgot_password_link() {
        resetPassword.PressingOnForgetPasswordLink().click();
    }
    @When("user presses on Recover button")
    public void user_presses_on_recover_button() {
        resetPassword.PressingOnRecoverBtnLink().click();
    }
    @Then("display message \"Email with instructions has been sent to you.\"at the top for user")
    public void display_message_email_with_instructions_has_been_sent_to_you_at_the_top_for_user() {
        String expectedResult = "Email with instructions has been sent to you.";
        Assert.assertTrue(resetPassword.DisplayingMessage().getText().contains(expectedResult));
    }
}