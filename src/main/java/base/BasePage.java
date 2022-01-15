package base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtils;

import java.util.concurrent.TimeUnit;

public class BasePage {

    /**

     * All WebElements are identified by @FindBy annotation

     */

    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void waitElement(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void waitForVisibility(WebElement e){
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public String getText(WebElement e, String attribute){
        waitForVisibility(e);
        return e.getText();
    }

    public String getAttribute(WebElement e, String attribute){
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public void waitElementLong(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public void currentUrl() {
        driver.getCurrentUrl();

    }

    public void alertLogin() throws NoAlertPresentException {
        try {
            new WebDriverWait(driver, 60)
                    .until(ExpectedConditions.alertIsPresent());
            Alert alertklik = driver.switchTo().alert();
            alertklik.accept();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

//    public void getMessageAlertLogin() {
//    	String alertMessage = driver.switchTo().alert().getText();
//    	System.out.println(alertMessage);
//    }
//

    public void waitElementClickable (WebElement element) {
        WebElement firstResult = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(element));
    }


    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/iframe[1]")
    public WebElement framePayment;
    public void PaymentCenterFrame() {

        driver.switchTo().frame("paymentCenterFrame");

    }
    public void PaymentCenterFrame_Payment() {

        driver.switchTo().frame(framePayment);

    }

    public void defaultContent() {
        driver.switchTo().defaultContent();
    }

    public void sendKeys(WebElement e, String txt){
        waitForVisibility(e);
        e.sendKeys(txt);
    }
}
