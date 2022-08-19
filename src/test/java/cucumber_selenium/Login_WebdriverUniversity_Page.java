package cucumber_selenium;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Login_WebdriverUniversity_Page {
    private WebDriver driver;
    @Before
    public void intialization(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    @After
    public void teardown(){
        driver.quit();
    }
    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("http://www.webdriveruniversity.com/Login-Portal/index.html");
    }
    @When("I enter a username {string}")
    public void i_enter_a_username(String userName) {
        driver.findElement(By.id("text")).sendKeys(userName);
    }
    @When("I enter a password {string}")
    public void i_enter_a_password(String passWord) {
        driver.findElement(By.id("password")).sendKeys(passWord);
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("I should get the successful login message")
    public void i_should_get_the_successful_login_message() {
        String LoginMessage=driver.switchTo().alert().getText();
        Assert.assertEquals(LoginMessage,"validation succeeded");
    }
}
