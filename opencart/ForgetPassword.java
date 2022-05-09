package opencart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ForgetPassword {
	public static void main(String[] args) throws InterruptedException, IOException{
		
       //taking input from excel sheet
		File src =new File("C:\\Users\\pramila_dey\\eclipse-workspace\\Selenium\\OpenCart_ReadData.xlsx");

		FileInputStream fileinput=new FileInputStream(src);
		Workbook wb=new XSSFWorkbook(fileinput);

		XSSFSheet sheet1=(XSSFSheet) wb.getSheetAt(0);
		String s1=sheet1.getRow(1).getCell(1).getStringCellValue();
		String s2=sheet1.getRow(1).getCell(2).getStringCellValue();
		
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//link for open cart
		driver.get("http://localhost/opencartapp/");
		//my account module
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		Thread.sleep(2000);

		WebElement elemnt= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		Actions a=new Actions(driver);
		a.moveToElement(elemnt).click().perform();
		Thread.sleep(2000);
		//login page

		driver.findElement(By.name("email")).sendKeys(s1);
		driver.findElement(By.name("password")).sendKeys(s2);
		//click on forgot password
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")).click();
		
		driver.findElement(By.name("email")).sendKeys("pramiladey65@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		

		wb.close();

		driver.close();


}}
