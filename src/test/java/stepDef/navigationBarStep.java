package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class navigationBarStep {
    WebDriver webDriver;


    @Given("user success access website")
    public void userSuccessAccessWebsite() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://qa.cilsy.id:8080/");
        webDriver.manage().window().maximize();

        webDriver.findElement(By.cssSelector(".nav_toggle")).click();
    }

    @When("user click home")
    public void userClickHome() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//a[.='Home']")).click();
    }

    @Then("show home of website")
    public void showHomeOfWebsite() {
        boolean home= webDriver.findElement(By.cssSelector(".header-hotel-name")).isDisplayed();
        Assert.assertEquals(true,home);

        webDriver.quit();
    }

    @When("user click interior")
    public void userClickInterior() {
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//a[.='Interior']")).click();
    }

    @Then("show interior of website")
    public void showInteriorOfWebsite() {
        boolean home= webDriver.findElement(By.xpath("//p[.='Interior']")).isDisplayed();
        Assert.assertEquals(true,home);

        webDriver.quit();
    }

    @When("user click amenties")
    public void userClickAmenties() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//a[.='Amenities']")).click();
    }

    @Then("show amenties of website")
    public void showAmentiesOfWebsite() {
        boolean home= webDriver.findElement(By.xpath("//p[.='Amenities']")).isDisplayed();
        Assert.assertEquals(true,home);

        webDriver.quit();
    }

    @When("user click rooms")
    public void userClickRooms() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//a[.='Rooms']")).click();
    }

    @Then("show rooms of website")
    public void showRoomsOfWebsite() {
        boolean home= webDriver.findElement(By.xpath("//p[.='Our Rooms']")).isDisplayed();
        Assert.assertEquals(true,home);

        webDriver.quit();
    }

    @When("user click testimonials")
    public void userClickTestimonials() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//a[.='Testimonials']")).click();
    }

    @Then("show testimonial of website")
    public void showTestimonialOfWebsite() {
        boolean home= webDriver.findElement(By.xpath("//p[.='What our Guest say?']")).isDisplayed();
        Assert.assertEquals(true,home);

        webDriver.quit();
    }

    @When("user click legal notice")
    public void userClickLegalNotice() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//li[6]/a[.='Legal Notice']")).click();
    }

    @Then("show legal notice of website")
    public void showLegalNoticeOfWebsite() {
        boolean home= webDriver.findElement(By.xpath("//h2[.='Legal']")).isDisplayed();
        Assert.assertEquals(true,home);
        Assert.assertEquals("Legal",webDriver.findElement(By.xpath("//h2[.='Legal']")).getText());

        webDriver.quit();
    }

    @When("user click about us")
    public void userClickAboutUs() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//li[7]/a[.='About us']")).click();
    }

    @Then("show about us of website")
    public void showAboutUsOfWebsite() {
        boolean home= webDriver.findElement(By.cssSelector(".page-heading")).isDisplayed();
        Assert.assertEquals(true,home);

        webDriver.quit();
    }

    @When("user click contact")
    public void userClickContact() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//a[.='Contact']")).click();
    }

    @Then("show contact of website")
    public void showContactOfWebsite() {
        boolean home= webDriver.findElement(By.cssSelector(".contact-header")).isDisplayed();
        Assert.assertEquals(true,home);
        Assert.assertEquals("Contact Us",webDriver.findElement(By.cssSelector(".contact-header")).getText());

        webDriver.quit();
    }
}
