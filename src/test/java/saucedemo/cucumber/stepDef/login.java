package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class login {
    WebDriver Driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login saucedemo")
    public void halaman_login_saucedemo() {
        WebDriverManager.firefoxdriver().setup();
        Driver = new FirefoxDriver();
        Driver.get(baseUrl);
    }

    @When("Input username")
    public void input_username()
    {
        Driver.findElement(By.name("user-name")).sendKeys("visual_user");
    }

    @And("Input password")
    public void input_password()
    {
        Driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void click_login_button() {
        Driver.findElement(By.id("login-button")).click();
    }

    @Then("User direct to Dashboard Page")
    public void user_direct_to_Dashboard_Page() {
        WebElement judul = Driver.findElement(By.className("app_logo"));
        Assert.assertEquals("Swag Labs", judul.getText());
    }

    @And("Input Invalid password")
    public void input_invalid_password() {
        Driver.findElement(By.id("password")).sendKeys("secret_caebe");
    }

    @Then("User get error message")
    public void user_get_error_message() {
        String errorMessage = Driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String error = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(errorMessage, error);
    }

    @When("User click burger menu")
    public void userClickBurgerMenu() {
        Driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("User click Logout")
    public void userClickLogout() {
        Driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User Logout")
    public void userLogout() {

    }

    @And("User Add Product")
    public void userAddProduct() {
        Driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("User Click Icon Cart")
    public void userClickIconCart() {
        Driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("User Direct to Page Cart")
    public void userDirectToPageCart() {
    }

    @And("User Click Checkout Button")
    public void userClickCheckoutButton() {
        Driver.findElement(By.id("checkout")).click();
    }

    @When("User Input Firts Name")
    public void userInputFirtsName() {
        Driver.findElement(By.id("first-name")).sendKeys("NurSalim");
        pause(1000);
    }

    @And("User Input Last Name")
    public void userInputLastName() {
        Driver.findElement(By.id("last-name")).sendKeys("Rozak");
        pause(1000);
    }

    @And("User Input PostCode")
    public void userInputPostCode() {
        Driver.findElement(By.id("postal-code")).sendKeys("3464662");
        pause(1000);
    }

    @And("User Click Continue Button")
    public void userClickContinueButton() {
        Driver.findElement(By.id("continue")).click();
    }

    @Then("User Directed to Overview Page")
    public void userDirectedToOverviewPage() {
    }

    @And("User Click Finish Button")
    public void userClickFinishButton() {
        Driver.findElement(By.id("finish")).click();
    }

    @Then("User Directed to Complete Order Page")
    public void userDirectedToCompleteOrderPage() {
    }

    @When("User Click Back Home Button")
    public void userClickBackHomeButton() {
        Driver.findElement(By.id("back-to-products")).click();
    }

    @Then("User Back to Home Page")
    public void userBackToHomePage() {
    }

    public static void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
