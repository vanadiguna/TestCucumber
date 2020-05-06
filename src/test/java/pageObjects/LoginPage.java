package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @FindBy(id = "Email")
    @CacheLookup
    WebElement textEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement textPassword;

    @FindBy(xpath = "//input[@value='Log in']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath = "//a[contains(@href, '/logout')]")
    @CacheLookup
    WebElement btnLogout;

    public void setUsername(String username){
        textEmail.clear();
        textEmail.sendKeys(username);
    }

    public void setPassword(String pwd){
        textPassword.clear();
        textPassword.sendKeys(pwd);
    }

    public void clickBtnLogin(){
        btnLogin.click();
    }

    public void clickBtnLogout(){
        btnLogout.click();
    }

}
