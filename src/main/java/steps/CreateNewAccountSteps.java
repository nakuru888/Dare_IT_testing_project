package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateAnAccountPage;
import pages.LandingPage;
import pages.MyAccountPage;

import java.util.concurrent.TimeUnit;

public class CreateNewAccountSteps {
    WebDriver driver;

    @Given("New user is on {string}")
    public void new_user_is_on(String url){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);


    }
    @When("User clicks on Create an Account in the top menu bar")
    public void user_clicks_on_create_an_account_in_the_top_menu_bar() {
        LandingPage onLandingPage = new LandingPage(driver);
        onLandingPage.createAnAccountButton();

    }
    @When("User enters {string}, {string}, {string}, {string}, {string}")
    public void user_enters(String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException{
        CreateAnAccountPage onCreateAnAccountPage = new CreateAnAccountPage(driver);
        onCreateAnAccountPage.fillInTheForm(firstname, lastname,email,password,confirmPassword);

    }
    @When("Clicks on Create and Account button")
    public void cliks_on_create_and_account_button() {
        CreateAnAccountPage onCreateAnAccountPage = new CreateAnAccountPage (driver);
        onCreateAnAccountPage.createAnAccountButton();


    }
    @Then("User account has been created nad user is logged into his account")
    public void user_account_has_been_created_nad_user_is_logged_into_his_account() {
        MyAccountPage onMyAccountPage = new MyAccountPage(driver);
        onMyAccountPage.confirmationOfRegistration();
        Assertions.assertEquals(firstLastName, userName);

    }


    }


