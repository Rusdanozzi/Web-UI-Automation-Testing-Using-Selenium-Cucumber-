package base;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginFunction{
    public static WebDriver webDriver;
    public LoginFunction(WebDriver webDriver) {
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    private WebElement buttonSigninHome;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "passwd")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@id='SubmitLogin']/span[contains(.,'Sign in')]")
    private WebElement buttonSignin;

    @FindBy(xpath = "page-heading")
    private WebElement successLogin;

    @FindBy(xpath = "//p[.='There is 1 error']")
    private WebElement textEror;

    @FindBy(xpath = "//li[.='Authentication failed.']")
    private WebElement textAuthenFail;

    @FindBy(xpath = "//li[.='Password is required.']")
    private WebElement textPasswordReq;

    @FindBy(xpath = "dropdown account_info_cont open")
    private WebElement dropDownUser;

    @FindBy(xpath = "//a[.='Logout']")
    private WebElement buttonLogout;

    public void clickLogin(){buttonSigninHome.click();}
    public void setInputEmail(String Email){inputEmail.sendKeys(Email);}
    public void setInputPassword(String Password){inputPassword.sendKeys(Password);}
    public void clickSignin(){buttonSignin.click();}
    public void setSuccessLogin(){
        Assert.assertEquals("MY ACCOUNT",successLogin.getText());
    }

    public void setTextEror(){
        Assert.assertEquals("There is 1 error",textEror.getText());
    }
    public void setTextAuthenFail(){
        Assert.assertEquals("Authentication failed.",textAuthenFail.getText());
    }
    public void setTextPasswordReq(){
        Assert.assertEquals("Password is required.",textPasswordReq.getText());
    }

    public void Logout(){
        dropDownUser.click();
        buttonLogout.click();
    }



}
