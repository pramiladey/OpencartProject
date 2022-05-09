package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragNDrop {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://jqueryui.com/droppable/");
		
		w.switchTo().frame(w.findElement(By.xpath("//*[@class='demo-frame']")));
		w.findElement(By.id("draggable")).click();
		
		Actions a=new Actions(w);
		
		WebElement src=w.findElement(By.id("draggable"));
		WebElement dst=w.findElement(By.id("droppable"));
		
		 a.dragAndDrop(src, dst).build().perform();
		 Thread.sleep(3000);
		  w.navigate().back();
		  w.close();
		
		
	   
		

}}
