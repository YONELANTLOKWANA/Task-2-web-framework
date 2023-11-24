package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public  class BaseDriver {
    static String url = "http://www.way2automation.com/angularjs-protractor/webtables/";
    private static WebDriver driver;

    public static WebDriver GetDriver(){
    WebDriverManager.chromedriver().driverVersion("119.0.6045.160").setup();
    driver= new ChromeDriver();
    driver.get(url);
    return driver;
    }
    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }
}
