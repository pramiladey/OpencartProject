package com.opencart.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WishlistTest {
	WebDriver driver=null;
	@Test(priority = 1)
	public void openBrowserTest(){
	System.setProperty("webdriver.chrome.driver","D:\\Frameworks\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	//Open Website
	driver.get("http://localhost/Opencart");
	}
	 @Test(priority =2)
	 public void addingToWishList() {
		 driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div/div[3]/button[2]")).click();
		 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			
			driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[4]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[2]")).click();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	 }
	 @Test(priority =3)
	 public void openWishList() throws InterruptedException, Throwable {
//		 File input= new File("D:/Frameworks/login.xlsx");
//			
//			FileInputStream fis = new FileInputStream(input);
//			Workbook wb = new XSSFWorkbook(fis);
//			
//			XSSFSheet s1 = (XSSFSheet) wb.getSheetAt(0);
//			String email=s1.getRow(1).getCell(0).getStringCellValue();
//			String pwd=s1.getRow(1).getCell(1).getStringCellValue();
//		 
		 driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]/span")).click();
		 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			
			driver.findElement(By.id("input-email")).sendKeys("");
			driver.findElement(By.id("input-password")).sendKeys("");
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input[1]")).click();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			
			driver.navigate().back();
			
			//wb.close();
	 }
	 @Test( priority =4) 
	 public void removeItemFromwishList() throws Throwable{ 
		 driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]/span")).click();
		 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

}
	 
}