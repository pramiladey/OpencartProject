package opencart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Regisration

{
	static String name;
	
	public static void main(String[] args) throws InterruptedException, IOException
	{ 
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		File src =new File("C:\\\\Users\\\\pramila_dey\\\\eclipse-workspace\\\\Selenium\\\\registration.xlsx");

		FileInputStream fileinput=new FileInputStream(src);
		Workbook wb=new XSSFWorkbook(fileinput);
		//String s1=sheet.getRow(1).getCell(1).getStringCellValue();

		XSSFSheet sheet=(XSSFSheet) wb.getSheetAt(0);
		String s1=sheet.getRow(0).getCell(1).getStringCellValue();
		FileOutputStream fos=new FileOutputStream("C:\\Users\\pramila_dey\\eclipse-workspace\\Selenium\\registration.xlsx");
		//WebElement elemnt;

		XSSFCell cell= sheet.getRow(1).createCell(1);
		Date ele = null;
		cell.setCellValue(ele);
		wb.write(fos);


		driver.get("http://localhost/Opencartapp");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a")).click();

		//Open register module
		Thread.sleep(2000);
		driver.findElement(By.linkText("Register")).click();

		//Fill the data
		WebElement ele1= driver.findElement(By.id("input-firstname"));
		ele1.sendKeys(s1);
		 
		 
		 
		//name.sendKeys(s1);


		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();

		driver.findElement(By.id("input-lastname")).sendKeys("Dey");
		Thread.sleep(2000);

		driver.findElement(By.id("input-email")).sendKeys("Pam@gmail.com");

		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");

		driver.findElement(By.id("input-password")).sendKeys("Pramila");

		driver.findElement(By.id("input-confirm")).sendKeys("Pramila");
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//input[@name='newsletter'])[2]")).click();

		driver.findElement(By.name("agree")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(2000);

		driver.close();
	}



}

