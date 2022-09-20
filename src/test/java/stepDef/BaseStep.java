package stepDef;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseStep {
    WebDriver webDriver;

    @BeforeClass
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://qa.cilsy.id:8080/");
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public void closeChrome(){
        webDriver.close();
    }

}
