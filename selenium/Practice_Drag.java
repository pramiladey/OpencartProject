package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice_Drag {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("http://demo.guru99.com/test/drag_drop.html");
		
		//w.switchTo().frame(w.findElement(By.id("g-container-main")));
		w.findElement(By.xpath("//*[@id=\"fourth\"]")).click();
		
		//w.switchTo().frame(w.findElement(By.xpath("//*[@id=\"g-mainbar\"]/div/div/div/div/div/div/table/tbody/tr/td[1]/h3")));
		
		Actions a=new Actions(w);
		
		WebElement src=w.findElement(By.xpath("//*[@id=\"fourth\"]"));
		WebElement dst=w.findElement(By.xpath("//*[@id=\"shoppingCart4\"]/h3"));
		
		 a.dragAndDrop(src, dst).build().perform();
		 Thread.sleep(3000);
		  w.navigate().back();
		  w.close();

}}
