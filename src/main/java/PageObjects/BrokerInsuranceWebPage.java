package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokerInsuranceWebPage extends BasePage {
    @FindBy(xpath = "//input[@value='Log out']") WebElement logoutBtn;

    public void clickLogout(){
        logoutBtn.click();
    }
    @FindBy(xpath = "//h2[normalize-space()='Broker Insurance WebPage']")
    WebElement bkrInsuranceWebPage; //to validate login

    public BrokerInsuranceWebPage(WebDriver driver) {
        super(driver);
    }

    public boolean insuranceWebPage(){
        try{
            return bkrInsuranceWebPage.isDisplayed();
        }catch (Exception e){
            e.getMessage();
        }
        return false;
    }
}
