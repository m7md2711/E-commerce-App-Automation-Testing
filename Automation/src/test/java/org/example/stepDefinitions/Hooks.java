package org.example.stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Register_P;
import org.example.pages.Wishlist_P;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {
 public static WebDriver driver;
    static public String userFirstName = "automation";
    static public String userLastName = "tester";
    static public String userValidEmail = "mohamed@example.com";
    static public String userValidPassword = "P@ssw0rd";
    static public SoftAssert verifyRegistration = new SoftAssert();
    static public boolean CheckRegistration = false;
    public static void sleep(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
    @BeforeAll
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @Given("open home page again")
    public void open_home_page_again() {
        driver.get("https://demo.nopcommerce.com/");
    }
    @Given("user goes to home page")
    public void user_goes_to_home_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/", "Wrong HomePage Link");
    }
    @When("user enters email address")
    public void user_enters_email_address() throws InterruptedException {
        Register_P.GettingUserEmailAddress().clear();

        while (!(userValidEmail.contains("@")));
        Register_P.GettingUserEmailAddress().sendKeys(userValidEmail);
    }
    @When("user enters password")
    public void user_enters_password() {
        Register_P.GettingUserPassword().sendKeys(userValidPassword);
    }
    @Then("user pressed on Log-out link")
    public void user_pressed_on_Log_out_link() {
        Register_P.PressingLogOutBtn().click();
    }
    @When("user scrolls down to products")
    public void user_scrolls_down_to_products() {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("arguments[0].scrollIntoView();", Wishlist_P.DisplayingSpecificProduct());
        Hooks.sleep(20);
    }
    @AfterAll
    public static void closeDriver() {
        sleep(30);
        driver.quit();
    }
}
