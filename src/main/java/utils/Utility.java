package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class Utility {
    public String testUrl;
    public static RemoteWebDriver driver;
    public String URL= "https://skillacademy.com/";

    //region browser

    //Get Chrome Options
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--incognito");
        return options;
    }
    //Get Firefox Options
    public static FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

    //endregion

    @BeforeSuite
//    @Parameters(value={"browser"})
    public void testGrid() throws MalformedURLException, InterruptedException {

        CapabilityFactory capabilityFactory = new CapabilityFactory();
        ChromeOptions opt = new ChromeOptions();
        DesiredCapabilities cap = new DesiredCapabilities();
        driver = new RemoteWebDriver(new URL("http://192.168.1.75:4444/"), cap);
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.get(URL);
    }

//    @BeforeSuite
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
//        driver.quit();
    }
}
