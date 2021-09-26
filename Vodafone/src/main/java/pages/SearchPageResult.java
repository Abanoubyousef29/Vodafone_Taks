package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import data.ExcelWriter;



public class SearchPageResult extends PageBase {


	public SearchPageResult(WebDriver driver) {
		super(driver);
	}


	@FindBy (xpath = "//a[@class='a-link-normal a-text-normal']")
	List<WebElement> searchTittleList ;

	@FindBy (xpath = "//span[@class='a-price-whole']")
	List<WebElement> searchPriceList ;
	
	
	String [] TittleArray;

	public void storeTittleAndPricesArrayToExcel() 
	{
		TittleArray = changeListToArray(searchTittleList);
		
		try {
			ExcelWriter.writeIntoExcel(TittleArray,0,1);
		} catch (Exception e) {
			System.out.println("Check That Error "+ e.getMessage());
		}
		
		TittleArray = null;

		TittleArray = changeListToArray(searchPriceList);

		try {
			ExcelWriter.writeIntoExcel(TittleArray,0,3);
		} catch (Exception e) {
			System.out.println("Check That Error"+ e.getMessage());
		}
		TittleArray = null;
	}
}
