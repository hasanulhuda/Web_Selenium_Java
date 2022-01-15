package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.util.Properties;

public class Utility {
    public String testUrl;
    public static WebDriver driver;
    public String URL= "https://skillacademy.com/";

    @BeforeSuite
    public void test()throws Exception{
        Properties prop = new Properties();
        prop.load( new FileInputStream("./src/main/resources/application.properties") );
        String browser = prop.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }
        if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "./driver/chromedriver97.exe");
//            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(URL);
        } else if ("firefox".equals(browser)) {
            System.setProperty("webdriver.gecko.driver", "./src/test/lib/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            //session = ((FirefoxDriver)driver).getSessionId();
            driver.get(URL);
        } else {
            throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }


    @AfterSuite
    public void closeApp() {
        driver.quit();
    }
}
