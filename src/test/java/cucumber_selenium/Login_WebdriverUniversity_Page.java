package cucumber_selenium;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import static driver.DriverFactory.getDriver;


public class Login_WebdriverUniversity_Page {

    private WebDriver driver = getDriver();
    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() throws InterruptedException {
        driver.get("http://www.webdriveruniversity.com/Login-Portal/index.html");

    }
    @When("I enter a username {}")
    public void i_enter_a_username(String userName) {

        driver.findElement(By.cssSelector("#text")).sendKeys(userName);
    }
    @When("I enter a password {}")
    public void i_enter_a_password(String passWord) {
        driver.findElement(By.id("password")).sendKeys(passWord);
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("I should get the successful login message")
    public void i_should_get_the_successful_login_message() {

        String LoginMessage=null;
        try{
        Alert alert=driver.switchTo().alert();
        LoginMessage = alert.getText();
        alert.accept();
        }catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(LoginMessage,"validation succeeded");
    }

    @Then("I should get the unsuccessful login message")
    public void i_should_get_the_unsuccessful_login_message() {
        String LoginMessage=null;
        try{
            Alert alert=driver.switchTo().alert();
            LoginMessage = alert.getText();
            alert.accept();
        }catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(LoginMessage,"validation failed");
    }

    @Then("I should get the following login message with {}")
    public void i_should_get_the_following_login_message_with(String expectedMessage) {
        String LoginMessage=null;
        try{
            Alert alert=driver.switchTo().alert();
            LoginMessage = alert.getText();
            alert.accept();
        }catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(LoginMessage, expectedMessage);

    }
}
