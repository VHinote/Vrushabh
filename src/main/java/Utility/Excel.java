package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
public static String getTestData(int row, int cell, String Sheetname) throws IOException {
		
		FileInputStream File = new FileInputStream ("D:\\automation\\Zeroda\\src\\test\\resources\\Book1.xlsx");
		String value = WorkbookFactory.create(File).getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
		System.out.println(value);
		return value;
	}
	

}
