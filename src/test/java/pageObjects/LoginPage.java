package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{

    WebDriver ldriver ;
    public LoginPage(WebDriver rdriver)
    {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver,this);

    }

    @FindBy(name="Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(name="Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
    @CacheLookup
    WebElement btnLogin;


    @FindBy(xpath ="/html/body/div[3]/nav/div/ul/li[3]/a")
    @CacheLookup
    WebElement lnLogout;


    public void setUserName(String uname) {
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }

    public void setPassword(String pwd)
    {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickLogout() {
        lnLogout.click();
    }



}
