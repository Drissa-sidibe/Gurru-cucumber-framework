package stepDefinitions;

import PageObjects.BrokerInsuranceWebPage;
import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import utilities.DataReaders;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    BrokerInsuranceWebPage brokerPage;
    Logger logger;
    ResourceBundle bundle;
    String browser;

    @Before
    public void setup() {
        logger = LogManager.getLogger(this.getClass());
        bundle = ResourceBundle.getBundle("config");
        browser = bundle.getString("browser");
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        Thread.sleep(15);
        System.out.println("Scenario status ======>"+scenario.getStatus());
        if(scenario.isFailed()) {
            byte[] screenshot =((TakesScreenshot)driver) .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());
        }
        driver.quit();
    }

    @Given("User Launch browser")
    public void user_launch_browser() {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("opens URL {string}")
    public void opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @And("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pass) throws InterruptedException {
        logger.info("Entering***Email");

        loginPage = new LoginPage(driver);
        loginPage.setLoginEmail(email);
        logger.info("Entering***password");
        loginPage.setLoginPassword(pass);
    }

    @And("clicks on Login button")
    public void clicks_on_login_button() throws InterruptedException {
        logger.info("Clicking on login button");
        loginPage.clickOnLogin();
    }

    @Then("User navigates to Broker Insurance Webpage")
    public void user_navigates_to_broker_insurance() {
        // Write code here that turns the phrase above into concrete actions
        brokerPage = new BrokerInsuranceWebPage(driver);
        boolean insuranceWebPage = brokerPage.insuranceWebPage();
        if(insuranceWebPage){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
   }
}


