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

public class RegistrationStep {
    WebDriver webDriver;
    @Given("user has accessed login page")
    public void userHasAccessedLoginPage() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://qa.cilsy.id:8080/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();

    }

    @When("user input email{string}")
    public void userInputValidEmail(String Email) {

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.id("email_create")).sendKeys(Email);
        webDriver.findElement(By.xpath("//span[contains(.,'Create an account')]")).click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("Choose Title{string}")
    public void chooseTitle(String gender) {
        switch (gender) {
            case "Mr":
                webDriver.findElement(By.id("id_gender1")).click();
                break;
            case "Mrs":
                webDriver.findElement(By.id("id_gender2")).click();
        }
    }

    @And("input First Name{string}")
    public void inputFirstName(String firstName) {

        webDriver.findElement(By.id("customer_firstname")).sendKeys(firstName);
    }


    @And("input Last Name{string}")
    public void inputLastName(String lastName) {
        webDriver.findElement(By.id("customer_lastname")).sendKeys(lastName);
    }

    @And("input Password{string}")
    public void inputPassword(String password) {
        webDriver.findElement(By.id("passwd")).sendKeys(password);
    }

    @And("input Date of Birth{string}{string}{string}")
    public void inputDateOfBirth(String date, String month, String year) {
        WebElement selectDay = webDriver.findElement(By.id("days"));
        Select chooseDay = new Select(selectDay);
        chooseDay.selectByValue(date);

        WebElement selectMonth = webDriver.findElement(By.id("months"));
        Select chooseMonth = new Select(selectMonth);
        chooseMonth.selectByValue(month);

        WebElement selectYear = webDriver.findElement(By.id("years"));
        Select chooseYear = new Select(selectYear);
        chooseYear.selectByValue(year);

        webDriver.findElement(By.xpath("//span[contains(.,'Register')]")).click();
    }

    @Then("User should be directed to My Account page")
    public void userShouldBeDirectedToMyAccountPage() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals("Your account has been created.",webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText());
        webDriver.quit();
    }

    @Then("show eror alert")
    public void showErorAlert() {
        Assert.assertEquals("An account using this email address has already been registered. Please enter a " +
                "valid password or request a new one.",webDriver.findElement
                (By.xpath("//li[contains(.,'An account using this email address has already been registered. Please enter a')]")).getText());
    webDriver.quit();
    }

    @Then("Show Password is invalid")
    public void showPasswordIsInvalid() {
        Assert.assertEquals("There is 1 error",webDriver.findElement(By.xpath("//p[.='There is 1 error']")).getText());

        webDriver.quit();
    }
}
