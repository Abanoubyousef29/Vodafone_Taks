package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy (id = "twotabsearchtextbox")
	WebElement searchBox ;

	@FindBy (id = "nav-search-submit-button")
	WebElement searchIcon ;

	@FindBy (xpath = "//span[@class='icp-nav-flag icp-nav-flag-eg']")
	WebElement changeLanguageIcon ;


	
	//That is the Relative Xpath but it never found the element (xpath = "//input[@value='en_AE']")
	@FindBy (xpath = "//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[2]/div/label/i")
	WebElement selectEnglish ;
	
	@FindBy (xpath = "//input[@class='a-button-input']")
	WebElement saveChanges ;

	public void changeToEnglishLanguage()
	{
		clickButton(changeLanguageIcon);
		clickButton(selectEnglish);
		clickButton(saveChanges);
	}

	public void SearchForAnItem(String searchItem) 
	{
		setTextBox(searchBox, searchItem);
		clickButton(searchIcon);
	}


}
