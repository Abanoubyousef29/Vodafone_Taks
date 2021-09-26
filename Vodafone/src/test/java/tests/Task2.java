package tests;


import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPageResult;

public class Task2 extends TestBase {

	HomePage homeObject;
	SearchPageResult SearchPageResultObject ;
	

	@Test()
	public void getSearchResultIntoExcel()
	{
		homeObject = new HomePage(driver);
		SearchPageResultObject = new SearchPageResult(driver);
		
		
		homeObject.changeToEnglishLanguage();
		homeObject.SearchForAnItem("iphone");
		SearchPageResultObject.storeTittleAndPricesArrayToExcel();
	
	}	
	
	
}