
package stepDefinitions;


import PageObjects.BrokerInsuranceWebPage;
import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class ExcelLoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    BrokerInsuranceWebPage brokerPage;
    List<HashMap<String, String>> datamap;
    Logger logger;
    ResourceBundle bundle;
    String browser;

    @Before
    public void setup() {
        logger = LogManager.getLogger(this.getClass());
        bundle = ResourceBundle.getBundle("config");
        browser = bundle.getString("browser");
        brokerPage =new BrokerInsuranceWebPage(driver);
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        Thread.sleep(15);
        System.out.println("Scenario status ======>" + scenario.getStatus());
        if (scenario.isFailed()) {
            scenario.getStatus();
            scenario.getName();

            byte[] screenshot =((TakesScreenshot)driver) .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
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

    @Given("User enters Email and Password with excel {string}")
    public void user_enters_email_and_password_with_excel( String indexRows) throws InterruptedException {
        try {
            datamap = DataReaders.data(System.getProperty("user.dir") + "\\testData\\loginData.xlsx", "Sheet1");

            int index = Integer.parseInt(indexRows)-1;

            String email = datamap.get(index).get("Email");

            String pwd = datamap.get(index).get("Password");
            logger.info("Inserting Email");
            loginPage = new LoginPage(driver);
            loginPage.setLoginEmail(email);
            System.out.println("The following email is being entered*********"+ email);
            logger.info("Inserting Password");
            loginPage.setLoginPassword(pwd);
            System.out.println("The following password is is being entered******"+ pwd);

        }catch (Exception e){
            e.getMessage();
        }
    }
    @Given("User clicks on Login button")
    public void clicks_on_login_button() throws InterruptedException {
        logger.info("Clicking Loggin********");
        loginPage = new LoginPage(driver);
                loginPage.clickOnLogin();
    }

    @Then("User navigates to Broker Insurance")
    public void userNavigatesToBrokerInsurance() throws InterruptedException {
        Thread.sleep(10000);
       brokerPage = new BrokerInsuranceWebPage(driver);
        boolean insuranceWebPage = brokerPage.insuranceWebPage();
            if (insuranceWebPage) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
    }
}
