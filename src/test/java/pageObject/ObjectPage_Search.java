package pageObject;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class ObjectPage_Search extends BasePage {
	public WebDriver driver;
	public ObjectPage_Search(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//img[@src='/assets/image/SkillAcademyLogo.png']")
	@CacheLookup
	public WebElement logo_SA;

	public void isLogoDisplayed(){
		try {
			waitElement();
			waitElementClickable(logo_SA);
			waitForVisibility(logo_SA);
			Boolean status = logo_SA.isDisplayed();
			Assert.assertTrue(status);
		}catch (NoSuchElementException e){
			Reporter.log("Asset logo tidak dapat ditemukan");
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//img[@src='/assets/image/HomeBannerLarge.png']")
	@CacheLookup
	public WebElement img_LargeBanner;

	public void isBannerDisplayed(){
		try {
			waitElement();
			waitElementClickable(img_LargeBanner);
			waitForVisibility(img_LargeBanner);
			Boolean status = img_LargeBanner.isDisplayed();
			Assert.assertTrue(status);
		}catch (NoSuchElementException e){
			Reporter.log("Asset Banner tidak dapat ditemukan");
			e.printStackTrace();
		}
	}



	//region Search Object
	@FindBy(xpath = "//span[contains(text(),'Hasil untuk')]")
	@CacheLookup
	public WebElement txt_SearchResult;
	public String get_TextSearhResult(){
		try {
			waitElement();
			waitForVisibility(txt_SearchResult);
		}catch (NoSuchElementException e){
			Reporter.log("tidak berhasil melakukan inputan");
			e.printStackTrace();
		}
		return getAttribute(txt_SearchResult, "Text");
	}

	@FindBy(xpath = "//input[@placeholder='Kamu ingin menguasai skill apa hari ini?']")
	@CacheLookup
	public WebElement insert_Search;
	public void setInsert_Search(String search){
		try {
			waitElement();
			waitElementClickable(insert_Search);
			waitForVisibility(insert_Search);
			insert_Search.sendKeys(search);
			insert_Search.sendKeys(Keys.ENTER);
		}catch (NoSuchElementException e){
			Reporter.log("tidak berhasil melakukan inputan");
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//img[@src='/assets/icon/Search_Result.svg']")
	@CacheLookup
	public WebElement img_SearchResult_Null;

	public void isSearchResultNullDisplayed(){
		try {
			waitElement();
			waitElementClickable(img_SearchResult_Null);
			waitForVisibility(img_SearchResult_Null);
			Boolean status = img_SearchResult_Null.isDisplayed();
			Assert.assertTrue(status);
		}catch (NoSuchElementException e){
			Reporter.log("Asset Image Pencarian tidak ditemukan, tidak dapat ditemukan");
			e.printStackTrace();
		}
	}

	//endregion





	@FindBy(id = "ematic_background_overlay")
	public WebElement overlayBG;
	public void clickUntukHilangkanOverlayHomePage(){
		try {
			waitElement();
			waitElementClickable(overlayBG);
			waitForVisibility(overlayBG);
			overlayBG.click();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@FindBy(name="Email")
	public WebElement userName;
	public void setUsername(String strUsername){
		try {
			waitElement();
			userName.sendKeys(strUsername);
			Reporter.log("kolom USERNAME berhasil diinput");
		} catch  (NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("Kolom NAMA tidak berhasil diinput");
			// TODO: handle exception
		}
	}

	@FindBy(name="Password")
	public  WebElement password;
	public void setPassword(String strPassword)
	{
		try {
			waitElement();
			password.sendKeys(strPassword);
			Reporter.log("Kolom PASSWORD berhasil diinput");
		} catch (NoSuchElementException e) {
			Reporter.log("Kolom PASSWORD tidak berhasil diinput!!");
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	@FindBy(xpath ="//*[@id=\"site-content\"]/div/div/div[1]/div/form/div[2]/button")
	public  WebElement login;
	public void clickSubmitLogin(){
		try {
			waitElement();
			login.click();
			Reporter.log("Tombol Submit untuk Login berhasil ditap");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("Tombol Submit untuk Login tidak berhasil ditap!");
			// TODO: handle exception
		}
	}


	@FindBy(xpath  = "//a[contains(.,'Masuk')]")
	public WebElement btnMasuk;
	public void clickTombolMasuk(){
		try {
			waitElement();
			waitForVisibility(btnMasuk);
			btnMasuk.click();
			System.out.println("Tombol Masuk berhasil ditap");
			Reporter.log("Tombol Masuk berhasil ditap");
		}catch (NoSuchElementException e){
			e.printStackTrace();
			Reporter.log("Tombol Masuk tidak berhasil ditap!");
			System.out.println("Tombol Masuk tidak berhasil ditap!");
		}
	}

	public void AlertOnLogin() throws java.util.NoSuchElementException {
		try {
			waitElementLong();
			alertLogin();
			Thread.sleep(10);

		}catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	//    @FindBy(name = "Mulai Belanja")
//    @FindBy(xpath = "//a[contains(.,'Mulai Belanja')]")
	@FindBy(xpath = "//span[text()='Mulai Belanja']")
	public WebElement btnMulaiBelanja;
	public void clickGuideMulaiBelanja(){
		try {
			waitElement();
			btnMulaiBelanja.click();
			Reporter.log("Guide mulai belanja berhasil ditap");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Guide mulai belanja tidak berhasil ditap");
		}
	}

	@FindBy(name = "search")
	public WebElement kolomSearch;
	public String getTextSearch(){
		waitElement();
		waitForVisibility(kolomSearch);
		return getAttribute(kolomSearch, "placeholder");
	}

//	@FindBy(xpath = "//*[text()='Tiket Wahana ']")
//	WebElement temp = driver.findElement(By.xpath("//img[@src='web/L001/images/IMAGENAME.jpg']"));
	@FindBy(xpath = "//img[@src='/Assets/image/virtual_logo.png']")
	public WebElement logoHalamanTiket;
	public void logoHalamanTiketIsDisplayed(){
		try {
			waitElement();
			waitElementClickable(logoHalamanTiket);
			waitForVisibility(logoHalamanTiket);
			Boolean status = logoHalamanTiket.isDisplayed();
			Assert.assertTrue(status);
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//img[@src='/static/media/travel_logo.88c90a9c.png']")
	public WebElement logoHalamanTravel;
	public void logoHalamanTravelIsDisplayed(){
		try {
			waitElement();
			waitElementClickable(logoHalamanTravel);
			waitForVisibility(logoHalamanTravel);
			Boolean status = logoHalamanTravel.isDisplayed();
			Assert.assertTrue(status);
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//img[@src='/Assets/image/logo.png']")
	public WebElement logoHalamanFood;
	public void logoHalamanFoodIsDisplayed(){
		try {
			waitElement();
			waitElementClickable(logoHalamanFood);
			waitForVisibility(logoHalamanFood);
			Boolean status = logoHalamanFood.isDisplayed();
			Assert.assertTrue(status);
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//img[@src='/Assets/image/header/logo_klik_mitra.png']")
	public WebElement logoHalamanMitra;
	public void logoHalamanMitraIsDisplayed(){
		try {
			waitElement();
			waitElementClickable(logoHalamanMitra);
			waitForVisibility(logoHalamanMitra);
			Boolean status = logoHalamanMitra.isDisplayed();
			Assert.assertTrue(status);
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}
	}
} 
