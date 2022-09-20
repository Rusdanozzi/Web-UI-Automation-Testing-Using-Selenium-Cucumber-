package base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFunction {
    public static WebDriver webDriver;
    public RegistrationFunction(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    private WebElement buttonLogin;
    @FindBy(id = "email_create")
    private WebElement inputEmail;
    @FindBy(xpath = "//span[contains(.,'Create an account')]")
    private WebElement buttonCreateAccount;
    @FindBy(id = "id_gender1")
    private WebElement buttonMale;
    @FindBy(id = "id_gender2")
    private WebElement buttonFemale;
    @FindBy(id = "customer_firstname")
    private WebElement inputFirstName;
    @FindBy(id = "customer_lastname")
    private WebElement inputLastName;
    @FindBy(id = "passwd")
    private WebElement inputPassword;
    @FindBy(id = "days")
    private WebElement setDate;
    @FindBy(id = "months")
    private WebElement setMonth;
    @FindBy(id = "years")
    private WebElement setYear;
    @FindBy(xpath = "//span[contains(.,'Register')]")
    private WebElement buttonRegister;
    @FindBy(className = "alert alert-success")
    private WebElement textSuccessCreateAccount;



    public void clickLogin(){buttonLogin.click();}

    public void inputEmail(String Email){inputEmail.sendKeys(Email);}

    public void clickCreateAccount(){buttonCreateAccount.click();}

    public void selectGender(String gender){

        switch (gender) {
            case "Mr":
                buttonMale.click();
                break;
            case "Mrs":
                buttonFemale.click();
        }
    }

    public void inputFirstName(String firstName){inputFirstName.sendKeys(firstName);}

    public void inputLastName(String lastName){inputLastName.sendKeys(lastName);}

    public void inputpassword(String password){inputPassword.sendKeys(password);}

    public void setDateBirth(String date, String month, String year){
        WebElement selectDay = setDate;
        Select chooseDay = new Select(selectDay);
        chooseDay.selectByValue(date);

        WebElement selectMonth = setMonth;
        Select chooseMonth = new Select(selectMonth);
        chooseMonth.selectByValue(month);

        WebElement selectYear = setYear;
        Select chooseYear = new Select(selectYear);
        chooseYear.selectByValue(year);

        buttonRegister.click();
    }

    public void successCreate(){
        Assert.assertEquals("Your account has been created.",textSuccessCreateAccount.getText());

    }

}
