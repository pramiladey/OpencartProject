package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ReadExcel {
		

public static void main(String[]args) throws IOException {
		
		File src =new File("C:\\Users\\pramila_dey\\Documents\\Clothes.xlsx");
		
		FileInputStream fileinput=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fileinput);
		
		XSSFSheet sheet1=(XSSFSheet) wb.getSheetAt(0);
		String s1=sheet1.getRow(2).getCell(0).getStringCellValue();
		String s2=sheet1.getRow(1).getCell(1).getStringCellValue();
		//System.out.println(sheet1.getRow(0).getCell(0).getStringCellValue());
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		//w.get("https://www.flipkart.com/");
		//w.findElement(By.className("q")).click();
		//w.findElement(By.xpath("")).sendKeys(s1);
		//w.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]")).sendKeys(s2);
		//w.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
		w.get("https://www.amazon.com/");
		w.findElement(By.id("twotabsearchtextbox")).sendKeys(s1);
		//WebElement pwd=w.findElement(By.id("pass"));
		w.findElement(By.id("nav-search-submit-button")).click();
		
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
