package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

	public static void writeIntoExcel(String [] arr,int sheetNumber,int columnNumber)throws IOException
	{
		String FilePath = System.getProperty("user.dir")+"/src/test/java/Data/voda.xlsx";
		File file = new File(FilePath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(sheetNumber);

		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFFont font = workbook.createFont();
		XSSFCellStyle style = workbook.createCellStyle();

		font.setFontName("Comic Sans Ms");
		font.setFontHeight(11.0);
		font.setBold(true);


		for (int i=0;i<20;i++)
		{
			row = sheet.getRow(i);
			if (row==null)
			{
				row = sheet.createRow(i);
			}


			cell=row.getCell(columnNumber);
			if (cell==null)
			{
				cell = row.createCell(columnNumber);
			}


			style.setFont(font);
			cell.setCellStyle(style);
			cell.setCellValue(arr[i]);
		}

		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		workbook.close();
		System.out.println("END OF WRITING DATA IN EXCEL");
	}

}
