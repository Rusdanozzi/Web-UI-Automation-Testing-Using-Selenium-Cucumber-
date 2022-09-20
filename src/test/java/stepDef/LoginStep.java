package stepDef;

import base.LoginFunction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginStep {
    private WebDriver webDriver;

    public LoginStep(){
        super();
        this.webDriver = Hook.webDriver;
    }

    @Given("user access login page1")
    public void userAccessLoginPage1() {

        webDriver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
    }
    @When("user input Email{string}")
    public void userInputEmail(String Email) {
        webDriver.findElement(By.id("email")).sendKeys(Email);
    }
    @And("User input password{string}")
    public void userInputPassword(String password) {
        webDriver.findElement(By.id("passwd")).sendKeys(password);
        webDriver.findElement(By.xpath("//button[@id='SubmitLogin']/span[contains(.,'Sign in')]")).click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("User should be directed to Account page")
    public void userShouldBeDirectedToAccountPage() {
        Assert.assertEquals("MY ACCOUNT",webDriver.findElement(By.className("page-heading")).getText());
        webDriver.quit();
    }


    @Then("user fail login")
    public void userFailLogin() {
        Assert.assertEquals("There is 1 error",webDriver.findElement(By.xpath("//p[.='There is 1 error']")).getText());
    }

    @And("show Authentication fail")
    public void showAuthenticationFail() {
        Assert.assertEquals("Authentication failed.",webDriver.findElement(By.xpath("//li[.='Authentication failed.']")).getText());
        webDriver.quit();
    }

    @And("show Password is Required")
    public void showPasswordIsRequired() {
        Assert.assertEquals("Password is required.",webDriver.findElement(By.xpath("//li[.='Password is required.']")).getText());
        webDriver.quit();
    }


    @And("user success login")
    public void userSuccessLogin() {
        Assert.assertEquals("MY ACCOUNT",webDriver.findElement(By.className("page-heading")).getText());
    }

    @And("user Logout")
    public void userLogout() {
        webDriver.findElement(By.id("user_info_acc")).click();
        webDriver.findElement(By.xpath("//a[.='Logout']")).click();
    }

    @Then("user success logout")
    public void userSuccessLogout() {
        Assert.assertEquals("Sign in",webDriver.findElement(By.cssSelector(".hide_xs")).getText());
        webDriver.quit();
    }




    @Given("login page")
    public void loginPage() {

        LoginFunction loginFunction=new LoginFunction(webDriver);
        loginFunction.clickLogin();
    }

    @When("Email{string}")
    public void email(String mail) {
        LoginFunction loginFunction=new LoginFunction(webDriver);
        loginFunction.setInputEmail(mail);
    }

    @And("password{string}")
    public void password(String pass) {
        LoginFunction loginFunction=new LoginFunction(webDriver);
        loginFunction.setInputPassword(pass);
        loginFunction.clickSignin();
    }

    @Then("Account page")
    public void accountPage() {
        LoginFunction loginFunction=new LoginFunction(webDriver);
        loginFunction.setSuccessLogin();
    }
}
