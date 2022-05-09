package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginData {
public static void main(String[]args) throws IOException {
		
		File src =new File("C:\\Users\\pramila_dey\\Documents\\newfiledetails.xlsx");
		
		FileInputStream fileinput=new FileInputStream(src);
		Workbook wb=new XSSFWorkbook(fileinput);
		
		XSSFSheet sheet1=(XSSFSheet) wb.getSheetAt(0);
		String s1=sheet1.getRow(1).getCell(0).getStringCellValue();
		String s2=sheet1.getRow(1).getCell(1).getStringCellValue();
		//System.out.println(sheet1.getRow(0).getCell(0).getStringCellValue());
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://www.facebook.com/");
		w.findElement(By.name("email")).sendKeys(s1);
		w.findElement(By.name("pass")).sendKeys(s2);
		w.findElement(By.name("login")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wb.close();
		w.navigate().back();
		w.close();
		
		
		
		

}}
