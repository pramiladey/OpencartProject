package opencart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OpenCartProject {
	public static void main(String[] args) throws InterruptedException, IOException{

		File src =new File("C:\\Users\\pramila_dey\\eclipse-workspace\\Selenium\\OpenCart_ReadData.xlsx");

		FileInputStream fileinput=new FileInputStream(src);
		Workbook wb=new XSSFWorkbook(fileinput);

		XSSFSheet sheet1=(XSSFSheet) wb.getSheetAt(0);
		//String s1=sheet1.getRow(1).getCell(1).getStringCellValue();
		//String s2=sheet1.getRow(1).getCell(2).getStringCellValue();
		String s3=sheet1.getRow(2).getCell(1).getStringCellValue();
		String s4=sheet1.getRow(2).getCell(2).getStringCellValue();
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/opencartapp/");

		//login with valid username and password
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		WebElement elemnt1= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		Actions a=new Actions(driver);
		a.moveToElement(elemnt1).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys(s3);
		driver.findElement(By.name("password")).sendKeys(s4);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(2000);
		//driver.navigate().back();

		wb.close();


		//search function
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("laptop");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);

		//desktop functionality
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")).click();
		Thread.sleep(2000);

		Select s = new Select(driver.findElement(By.id("input-sort")));
		s.selectByIndex(3);
		Thread.sleep(2000);

		WebElement list=driver.findElement(By.id("list-view"));
		list.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")).click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		Select s1 = new Select(driver.findElement(By.id("input-option226")));
		s1.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(2000);
		Alert alert1=driver.switchTo().alert();
		Thread.sleep(2000);
		alert1.accept();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);

		//mp3 functionality
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[8]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Show All MP3 Players')]")).click();
		Thread.sleep(2000);

		//Sorting 
		Select s2 = new Select(driver.findElement(By.id("input-sort")));
		s2.selectByIndex(2);
		Thread.sleep(2000);

		//Show in List
		driver.findElement(By.id("list-view")).click();
		Thread.sleep(2000);

		//Select iPod Touch
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")).click();
		Thread.sleep(2000);
		//Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);

		//Add to cart

		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(2000);
		//Alert alert1=driver.switchTo().alert();
		Thread.sleep(2000);
		alert1.accept();
		Thread.sleep(2000);


		//logout function
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		Thread.sleep(2000);

		WebElement elemnttt= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a"));
		Actions a2=new Actions(driver);
		a.moveToElement(elemnttt).click().perform();
		Thread.sleep(2000);
		driver.close();

	}}





