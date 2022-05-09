package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewTest {
	public static void main(String[]args) throws IOException {
		
		File src =new File("C:\\Users\\pramila_dey\\Documents\\newfiledetails.xlsx");
		
		FileInputStream fileinput=new FileInputStream(src);
		Workbook wb=new XSSFWorkbook(fileinput);
		
		XSSFSheet sheet1=(XSSFSheet) wb.getSheetAt(0);
		//System.out.println(sheet1.getRow(2).getCell(0).getStringCellValue());
		//System.out.println(sheet1.getRow(0).getCell(0).getStringCellValue());
		
		//sheet1.getRow(0).createCell(2).setCellValue("city");
		int row_count=sheet1.getLastRowNum();
		System.out.println("total rows are" +row_count);
		for(int i=0;i<row_count;i++) {
			String row=sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println(row);
		}
		wb.close();
		
	}

}


