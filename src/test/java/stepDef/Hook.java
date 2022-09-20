package stepDef;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {
    public static WebDriver webDriver;
    @Before
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://qa.cilsy.id:8080/");
        webDriver.manage().window().maximize();
    }

    @After
    public static void closeBrowser(){
        webDriver.quit();
    }
}
