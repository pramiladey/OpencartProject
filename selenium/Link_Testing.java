package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Link_Testing {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://orchidrepublic.com/blogs/news/types-yellow-flowers-meanings");
		
		List<WebElement> ls=w.findElements(By.tagName("a"));
		int sz=ls.size();
		
		Thread.sleep(5000);
		System.out.println("total links are" +sz);
		 
		for(int i=0;i<sz;i++) {
			ls=w.findElements(By.tagName("a"));
			System.out.println(ls.get(i).getText());
			ls.get(i).click();
			w.navigate().back();
		}
		w.close();
		
		

}}
