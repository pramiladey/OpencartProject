package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge_Test {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.edge.driver", "D://edgedriver_win64//msedgedriver.exe");
		
		WebDriver w=new EdgeDriver();
		w.manage().window().maximize();
		w.get("https://www.facebook.com");
		System.out.println(w.getTitle());
		System.out.println(w.getCurrentUrl());
		System.out.println(w.getPageSource());
		Thread.sleep(5000);
		w.navigate().back();
		w.quit();
		

}}
