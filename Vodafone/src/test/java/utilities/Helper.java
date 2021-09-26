package utilities;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper {

	// Method to take screenshot when the test cases fail
	public static void captureScreenshot(WebDriver driver , String screenshotname) throws IOException 
	{
		Path dest = Paths.get("./ScreenShots",screenshotname+"gh.png"); 
		
		//take screenshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//copy the screen shot to another file
		FileUtils.copyFile(scrFile, new File(dest.toString()));
	}
}
