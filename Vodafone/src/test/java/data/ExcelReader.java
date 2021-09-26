package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream Fis = null ; 

	public FileInputStream GetFileInputStream() 
	{
		// create String to store the location of the excel sheet
		String FilePath = System.getProperty("user.dir")+"/src/test/java/Data/VodaReader.xlsx"; 
		File SrcFile = new File(FilePath);	

		try 
		{
			Fis = new FileInputStream(SrcFile);

		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Test Data file not found. treminating Process !! : Check file path of TestData");
			System.exit(0);
		}
		return Fis ; 
	}

	public Object[][] GetExcelDataFromSheetNumber (int sheetNumber) throws IOException
	{
		Fis = GetFileInputStream(); 
		
		//to read the whole Excel Project
		XSSFWorkbook WorkBook = new XSSFWorkbook(Fis);
		
		// to read the Excel Sheet ( first sheet )
		XSSFSheet Sheet = WorkBook.getSheetAt(sheetNumber); 

		// number of rows of the excel sheet
		int TotalNumberOfRows = (Sheet.getLastRowNum()+1);

		// number of columns
		int TotalNumberOfColumns = 10 ; 

		String[][] ArrayExcelData = new String[TotalNumberOfRows][TotalNumberOfColumns] ; 

		//For Loops To get the cell
		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfColumns; j++) {
				XSSFRow Row = Sheet.getRow(i);
				ArrayExcelData[i][j] = Row.getCell(j).toString();
			}
		}


		WorkBook.close();
		return ArrayExcelData; 
	}
}
