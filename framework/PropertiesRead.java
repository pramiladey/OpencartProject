package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertiesRead {

	public static void main(String[] args)throws IOException,InterruptedException {
		Properties prop=new Properties();
		
		InputStream input=new FileInputStream("C:\\Users\\pramila_dey\\eclipse-workspace\\Selenium\\TicketDetails");
		
		prop.load(input);
		String s1=prop.getProperty("Ticket-no");
		String s2=prop.getProperty("email");
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://www.redbus.in/");
		w.findElement(By.id("manageHeaderdd")).click();
		w.findElement(By.xpath("//*[@id=\"hmb\"]/div[2]/ul/li[2]")).click();
		w.findElement(By.name("tin")).sendKeys(s1);
		w.findElement(By.name("email")).sendKeys(s2);
		w.findElement(By.className("form-select-passenger-container")).click();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//wb.close();
		w.navigate().back();
		w.close();
		

		
}
}


