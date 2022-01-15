package testClass;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObject.ObjectPage_Search;
import utils.Utility;

public class SearchTest extends Utility {
	 ObjectPage_Search objSearch;


	@Test (priority = 1, description = "TS01-EP01 - Validate page already opened")
	public void page_Validate(){
		try {
//			driver.navigate().to("https://skillacademy.com/");
			objSearch  = new ObjectPage_Search(driver);
			objSearch.isLogoDisplayed();
			objSearch.isBannerDisplayed();
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Validasi Halaman Gagal, beberapa element tidak dapat ditemukan");
		}
	}

	@Test(priority = 2, description = "TS01-EP02 - Search Test Scenario = Success")
	public void searchCourse_Success(){
		try {
			objSearch = new ObjectPage_Search(driver);
			Thread.sleep(500);
			objSearch.setInsert_Search("Keyword");

//			String actualtext = objSearch.get_TextSearhResult();
//			String expectedText = " Hasil untuk ";
//
//			Assert.assertEquals(actualtext, expectedText);
//			System.out.println("Actualtext: "+actualtext);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	@Test(priority = 2, description = "TS01-EP02 - Search Test Scenario = Failed")
	public void searchCourse_Failed(){
		try {
			objSearch = new ObjectPage_Search(driver);
			Thread.sleep(500);
			objSearch.setInsert_Search("1234567890");
			objSearch.isSearchResultNullDisplayed();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}



		
} 


