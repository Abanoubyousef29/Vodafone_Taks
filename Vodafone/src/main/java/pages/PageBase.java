package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {


	public PageBase (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//method to click on an element
	protected static void clickButton(WebElement button) 
	{
		button.click();
	}

	//method to set value to text box
	protected static void setTextBox(WebElement TexBox , String value) 
	{
		TexBox.sendKeys(value);
	}

	//method to clear text box
	protected static void clearTextBox(WebElement TexBox) 
	{
		TexBox.clear();
	}

	//method to select from drop down menu based on visible text
	protected static void selectFromDropDownMenu(WebElement dropDownMenu , String value) 
	{
		Select selectedItem = new Select(dropDownMenu);
		selectedItem.selectByVisibleText(value);
	}


	//method to generate random string
	public String generateRandomString()
	{
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String randomString = "" ;
		int lenght = 6;
		char[] text = new char[6];


		Random random = new Random();

		//create an array (text[]) with random alphabet
		for ( int i=0 ; i<lenght ; i++ )
		{
			text[i] = alphabet.charAt(random.nextInt(alphabet.length()));
		}

		//convert the array to string
		for ( int i=0 ; i<text.length ; i++ )
		{
			randomString +=text[i];
		}

		return randomString;

	}

	public String[] changeListToArray(List<WebElement> webElementlist) 
	{
		List<String> List = new ArrayList<String>() ;
		for (int i=0; i< 20 ;i++)
		{
			List.add(webElementlist.get(i).getText().toString());
		}
		String[] returnString = List.toArray(new String[0]);

		return returnString ;
	}

}
