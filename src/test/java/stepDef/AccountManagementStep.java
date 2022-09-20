package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AccountManagementStep {
    WebDriver webDriver;
    @Given("user access My Account page")
    public void userAccessMyAccountPage() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://qa.cilsy.id:8080/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
    }

    @When("user set Email{string}")
    public void userSetEmail(String Email) {
        webDriver.findElement(By.id("email")).sendKeys(Email);
    }

    @And("User set password{string}")
    public void userSetPassword(String Password) {
        webDriver.findElement(By.id("passwd")).sendKeys(Password);
        webDriver.findElement(By.xpath("//button[@id='SubmitLogin']/span[contains(.,'Sign in')]")).click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("user access My Addresses")
    public void userAccessMyAddresses() {
        webDriver.findElement(By.xpath("//a[.='My addresses']")).click();
    }

    @And("user add a new address")
    public void userAddANewAddress() {
        webDriver.findElement(By.xpath("//a[.='Add a new address']")).click();
    }

    @And("input Company{string}")
    public void inputCompany(String company) {
        webDriver.findElement(By.id("company")).sendKeys(company);
    }

    @And("input address{string}")
    public void inputAddress(String address) {
        webDriver.findElement(By.id("address1")).sendKeys(address);
    }

    @And("input city{string}")
    public void inputCity(String city) {
        webDriver.findElement(By.id("city")).sendKeys(city);
    }

    @And("input state{string}")
    public void inputState(String state) {
        WebElement selectState = webDriver.findElement(By.id("id_state"));
        Select chooseState = new Select(selectState);
        chooseState.selectByVisibleText(state);
    }

    @And("input zip code{string}")
    public void inputZipCode(String zipCode) {
        webDriver.findElement(By.id("postcode")).sendKeys(zipCode);
    }

    @And("input home phone{string}")
    public void inputHomePhone(String homePhone) {
        webDriver.findElement(By.id("phone")).sendKeys(homePhone);
    }
    @And("input mobile phone{string}")
    public void inputMobilePhone(String mobilePhone) {
        webDriver.findElement(By.id("phone_mobile")).sendKeys(mobilePhone);
    }
    @And("input address title{string}")
    public void inputAddressTitle(String addressTitle) {
        webDriver.findElement(By.id("alias")).clear();
        webDriver.findElement(By.id("alias")).sendKeys(addressTitle);
    }
    @Then("new address has added")
    public void newAddressHasAdded() {
        webDriver.findElement(By.xpath("//span[contains(.,'Save')]")).click();

        Assert.assertNotNull(webDriver.findElement(By.className("page-subheading")));

        webDriver.quit();
    }

    @And("delete address")
    public void deleteAddress() {
        webDriver.findElement(By.xpath("//span[.='Delete']")).click();
        webDriver.switchTo().alert().accept();
    }

    @Then("address has been deleted")
    public void addressHasBeenDeleted() {
        Assert.assertEquals("No addresses are available. Add a new address",webDriver.findElement(By.cssSelector(".alert")).getText());

        webDriver.quit();
    }

    @And("user access My Personal Information")
    public void userAccessMyPersonalInformation() {
        webDriver.findElement(By.xpath("//span[.='My personal information']")).click();
    }

    @And("user change first name{string}")
    public void userChangeFirstName(String firstName) {
        webDriver.findElement(By.id("firstname")).clear();
        webDriver.findElement(By.id("firstname")).sendKeys(firstName);
    }

    @And("user change last name{string}")
    public void userChangeLastName(String lastname) {
        webDriver.findElement(By.id("lastname")).clear();
        webDriver.findElement(By.id("lastname")).sendKeys(lastname);
    }
    @And("user input password{string}")
    public void userInputPassword(String password) {
        webDriver.findElement(By.id("old_passwd")).sendKeys(password);
    }
    @Then("personal information has been changed")
    public void personalInformationHasBeenChanged() {
        webDriver.findElement(By.xpath("//span[.='Save']")).click();
        Assert.assertEquals("Your personal information has been successfully updated.",webDriver.findElement(By.cssSelector(".alert")).getText());
        webDriver.quit();
    }
    @And("user change date of birth{string}{string}{string}")
    public void userChangeDateOfBirth(String date, String month, String year) {
        WebElement selectDay = webDriver.findElement(By.id("days"));
        Select chooseDay = new Select(selectDay);
        chooseDay.selectByValue(date);

        WebElement selectMonth = webDriver.findElement(By.id("months"));
        Select chooseMonth = new Select(selectMonth);
        chooseMonth.selectByValue(month);

        WebElement selectYear = webDriver.findElement(By.id("years"));
        Select chooseYear = new Select(selectYear);
        chooseYear.selectByValue(year);
    }

    @And("user change email{string}")
    public void userChangeEmail(String email) {
        webDriver.findElement(By.id("email")).clear();
        webDriver.findElement(By.id("email")).sendKeys(email);
    }

    @And("user input new password{string}")
    public void userInputNewPassword(String newPassword) {
        webDriver.findElement(By.id("passwd")).sendKeys(newPassword);
        webDriver.findElement(By.id("confirmation")).sendKeys(newPassword);
    }
}
