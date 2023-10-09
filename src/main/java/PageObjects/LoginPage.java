package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
        //hana@gmail.com
        //123password

    }
    @FindBy(id = "email") WebElement loginEmail;

    @FindBy(id = "password") WebElement loginPassword;

    @FindBy(xpath = "//input[@name='submit']") WebElement loginBtn;

    //input[@value='Log out']

    public void setLoginEmail(String email) throws InterruptedException {
        Thread.sleep(5000);
        loginEmail.sendKeys(email);
    }
    public void setLoginPassword(String password) throws InterruptedException {
        Thread.sleep(5000);
        loginPassword.sendKeys(password);
    }


    public void clickOnLogin() throws InterruptedException {
        Thread.sleep(5000);
        loginBtn.click();
    }

}
