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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckoutStep {
    WebDriver webDriver;
    WebDriverWait wait;

    @Given("user login")
    public void userLogin() {



    }
    @Given("user login with Email{string}and password{string}")
    public void userLoginWithEmailAndPassword(String Email, String password) {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://qa.cilsy.id:8080/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();

        webDriver.findElement(By.id("email")).sendKeys(Email);
        webDriver.findElement(By.id("passwd")).sendKeys(password);
        webDriver.findElement(By.xpath("//button[@id='SubmitLogin']/span[contains(.,'Sign in')]")).click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.findElement(By.cssSelector("[alt='Sekolah QA']")).click();
    }
    @When("user choose the hotel")
    public void userChooseTheHotel() {
        webDriver.findElement(By.id("id_hotel_button")).click();
        webDriver.findElement(By.xpath("//li[@data-id-hotel='1']")).click();

    }


    @And("date check in{string}{string}{string}")
    public void dateCheckIn(String date, String month, String year) {
        webDriver.findElement(By.id("check_in_time")).click();
        WebElement dateWidgetFrom = webDriver.findElement(By.className("ui-datepicker-calendar"));
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
        DateUtil.clickGivenDay(columns,date);
    }

    @And("date check out{string}{string}{string}")
    public void dateCheckOut(String date, String month, String year) {
        webDriver.findElement(By.id("check_out_time")).click();
        WebElement dateWidgetFrom = webDriver.findElement(By.className("ui-datepicker-calendar"));
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
        DateUtil.clickGivenDay(columns,date);

        webDriver.findElement(By.id("search_room_submit")).click();
    }


    @And("choose room")
    public void chooseRoom() {
        webDriver.findElement(By.xpath("//a[@data-id-product='3']")).click();
    }

    @And("proceed to checkout")
    public void proceedToCheckout() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("[title='Proceed to checkout']")).click();
    }

    @Then("show total amount that have to pay")
    public void showTotalAmountThathHaveToPay() {
        Assert.assertEquals("$2,000.00",webDriver.findElement(By.xpath("//div[@class='total_price_block']/p[@class='room_total_price']")).getText());
        webDriver.findElement(By.xpath("//div[@class='col-sm-12 proceed_btn_block']//span[contains(.,'Proceed')]")).click();

        webDriver.quit();
    }

    @Given("user order room")
    public void userOrderRoom() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://qa.cilsy.id:8080/");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.id("id_hotel_button")).click();
        webDriver.findElement(By.xpath("//li[@data-id-hotel='1']")).click();

    }
    @And("input First Name in Quick Order{string}")
    public void inputFirstNameInQuickOrder(String firstName) {
        webDriver.findElement(By.id("customer_firstname")).sendKeys(firstName);
    }

    @And("input Last Name in Quick Order{string}")
    public void inputLastNameInQuickOrder(String lastName) {
        webDriver.findElement(By.id("customer_lastname")).sendKeys(lastName);
    }

    @And("user input Email in Quick Order{string}")
    public void userInputEmailInQuickOrder(String Email) {
        webDriver.findElement(By.id("email")).sendKeys(Email);
    }

    @And("input Password in Quick Order{string}")
    public void inputPasswordInQuickOrder(String Password) {
        webDriver.findElement(By.id("passwd")).sendKeys(Password);
    }

    @And("input Mobile Number in Quick Order{string}")
    public void inputMobileNumberInQuickOrder(String mobileNumber) {
        webDriver.findElement(By.id("phone_mobile")).sendKeys(mobileNumber);
        webDriver.findElement(By.id("submitAccount")).click();
    }


    @Then("Show payment and guest information")
    public void showPaymentAndGuestInformation() {
        Assert.assertEquals("Guest Information",webDriver.findElement(By.xpath("//span[.='Guest Information']")).getText());
        Assert.assertEquals("Payment Information",webDriver.findElement(By.xpath("//span[.='Payment Information']")).getText());
        webDriver.quit();
    }


    @When("user create an Account after checkout")
    public void userCreateAnAccountAfterCheckout() {
        webDriver.findElement(By.xpath("//div[@class='col-sm-12 proceed_btn_block']/a[contains(.,'Proceed')]")).click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @And("Continue shopping")
    public void continueShopping() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']/span[contains(.,'Continue shopping')]")).click();
    }

    @And("choose second room")
    public void chooseSecondRoom() {
        webDriver.findElement(By.xpath("//a[@data-id-product='4']")).click();
    }

    @And("checkout")
    public void checkout() {
        webDriver.findElement(By.xpath("//div[@class='shopping_cart']/a[@href='http://qa.cilsy.id:8080/quick-order']")).click();
        webDriver.findElement(By.xpath("//div[@class='col-sm-12 proceed_btn_block']/a[contains(.,'Proceed')]")).click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("show total amount for rooms")
    public void showTotalAmountForRooms() {
        Assert.assertEquals("$4,500.00",webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/p[1]/span[2]")).getText());
        webDriver.quit();

    }

    @Then("show total amount for different date")
    public void showTotalAmountForDifferentDate() {
        Assert.assertEquals("$4,000.00",webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/p[1]/span[2]")).getText());
        webDriver.quit();
    }

    @And("remove one room")
    public void removeOneRoom() {
        webDriver.findElement(By.xpath("//div[@class='shopping_cart']/a[@href='http://qa.cilsy.id:8080/quick-order']")).click();

        Actions action = new Actions(webDriver);
        WebElement we = webDriver.findElement(By.xpath("//div[@class='shopping_cart']/a[@href='http://qa.cilsy.id:8080/quick-order']"));
        action.moveToElement(we).build().perform();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.findElement(By.cssSelector(".ajax_cart_block_remove_link")).click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("show total amount after remove room")
    public void showTotalAmountAfterRemoveRoom() {
        Assert.assertEquals("$2,500.00",webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/p[1]/span[2]")).getText());
        webDriver.quit();
    }
}
