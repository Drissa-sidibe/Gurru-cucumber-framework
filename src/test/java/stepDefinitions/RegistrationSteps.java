//package stepDefinitions;
//
//import PageObjects.RegistrationPage;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//
//import java.time.Duration;
//import java.util.ResourceBundle;
//
//public class RegistrationSteps {
//
//    WebDriver driver;
//    RegistrationPage registrationPage;
//    Logger logger;
//    ResourceBundle bundle;
//    String browser;
//    String password = randomPassword();
//
//    @Before
//    public void setup(){
//        logger = LogManager.getLogger(this.getClass());
//        bundle = ResourceBundle.getBundle("config");
//        browser=bundle.getString("browser");
//    }
//    @After
//    public void tearDown(Scenario scenario) throws InterruptedException {
//        Thread.sleep(5000);
//        System.out.println("Scenario status:*****");
//        if(scenario.isFailed()){
//            scenario.getStatus();
//            scenario.getName();
////            TakesScreenshot ts =(TakesScreenshot) driver;
////            byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
////            scenario.attach(screenshot,"image/png", scenario.getName());
//            driver.quit();
//        }
//    }
//
//
//    public String randomRegistrationEmail(){
//        String registrationEmail = RandomStringUtils.randomAlphabetic(5);
//        return (registrationEmail);
//    }
//    public String randomRegistrationUserFirstName(){
//        String randomUser = RandomStringUtils.randomAlphabetic(8);
//        return (randomUser);
//    }
//    public String randomRegistrationSirName(){
//        String randomSirName = RandomStringUtils.randomAlphabetic(4);
//        return (randomSirName);
//    }
//
//    public String randomRegistrationPhone(){
//        String randomPhone = RandomStringUtils.randomNumeric(9);
//        return (randomPhone);
//    }
//    public String randomPassword(){
//        String str = RandomStringUtils.randomAlphabetic(5);
//
//        String num = RandomStringUtils.randomAlphanumeric(4);
//        return (str+"@"+num);
//    }
//    @AfterClass(groups = {"Master","Sanity","Regression"})
//    public void tearDown() throws InterruptedException {
//        logger.info("Tearing down. Test finished");
//        Thread.sleep(15000);
//        driver.quit();
//    }
//
//
//    @Given("User Launches browser")
//    public void user_launches_browser() {
//        if (browser.equals("chrome")) {
//            driver=new ChromeDriver();
//        }else if (browser.equals("edge")){
//            driver=new EdgeDriver();
//        }else if(browser.equals("firefox")){
//            driver=new FirefoxDriver();
//        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//    @Given("opens GuruURL {string}")
//    public void opensGuruURL(String guruUrl) {
//        driver.get(guruUrl);
//        driver.manage().window().maximize();
//    }
//    @Given("User Clicks on Register button")
//    public void user_clicks_on_register_button() {
//        registrationPage = new RegistrationPage(driver);
//        registrationPage .clickOnRegisterButton();
//    }
//    @Given("User selects user title")
//    public void user_selects_user_title() throws InterruptedException {
//       registrationPage.selectUserTitle("Miss");
//    }
//    @Given("User enters first name")
//    public void user_enters_first_name() throws InterruptedException {
//        registrationPage.setUserFirstName(randomRegistrationUserFirstName());
//    }
//    @Given("User enters sir name")
//    public void user_enters_sir_name() throws InterruptedException {
//        registrationPage.setUserSirName(randomRegistrationSirName());
//    }
//    @Given("User user phone number")
//    public void user_user_phone_number() throws InterruptedException {
//        registrationPage.setUserPhoneNumber(randomRegistrationPhone());
//    }
//    @Given("User selects birth year")
//    public void user_selects_birth_year() throws InterruptedException {
//        registrationPage.selectBirthYear(4);
//    }
//    @Given("User selects birth month")
//    public void user_selects_birth_month() throws InterruptedException {
//        registrationPage.selectBirthMonth("November");
//    }
//    @Given("User selects birth date")
//    public void user_selects_birth_date() throws InterruptedException {
//      registrationPage.selectBirthDate(4);
//    }
//    @Given("User selects licence period")
//    public void user_selects_licence_period() throws InterruptedException {
//        registrationPage.selectLicencePeriod(4);
//    }
//    @Given("User selects occupation")
//    public void user_selects_occupation() throws InterruptedException {
//       registrationPage.selectOcupation(4);
//    }
//    @Given("User enters street number")
//    public void user_enters_street_number() throws InterruptedException {
//        registrationPage.insertStreet("123454");
//    }
//    @Given("User enters city name")
//    public void user_enters_city_name() throws InterruptedException {
//       registrationPage.setCity("London");
//    }
//    @Given("User enters county name")
//    public void user_enters_county_name() throws InterruptedException {
//       registrationPage.setCounty("BerkBeley");
//    }
//    @Given("User enters post code")
//    public void user_enters_post_code() throws InterruptedException {
//      registrationPage.setPosteCode("bk25 bye");
//    }
//    @Given("User enters email")
//    public void user_enters_email() throws InterruptedException {
//       registrationPage.setEmail(randomRegistrationEmail()+"@gmail.com");
//    }
//    @Given("User enters password")
//    public void user_enters_password() throws InterruptedException {
//        registrationPage.setPassword(password);
//    }
//    @Given("User confirms password")
//    public void user_confirms_password() throws InterruptedException {
//       registrationPage.setPasswordConfirmation(password);
//    }
//    @When("User clicks on create button")
//    public void user_clicks_on_create_button() throws InterruptedException {
//       registrationPage.clickCreateOnCreateButton();
//    }
//
//    @Then("Validates User views Login Page Text")
//    public void validates_user_views_login_page_text() {
//        if (registrationPage.validateRegistration()==true){
//            Assert.assertTrue(true);
//        }else {
//            Assert.assertTrue(false);
//        }
//    }
//}
