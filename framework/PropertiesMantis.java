package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertiesMantis {
	public static void main(String[] args)throws IOException,InterruptedException {
		Properties prop=new Properties();
		
		InputStream input=new FileInputStream("C:\\Users\\pramila_dey\\eclipse-workspace\\Selenium\\Mantis.properties");
		
		prop.load(input);
		String s1=prop.getProperty("username");
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.mantisbt.org/bugs/login_page.php?return=%2Fbugs%2Fview.php%3Fid%3D14815");
		Thread.sleep(3000);
		
		
		driver.findElement(By.name("username")).sendKeys(s1);
		//driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.name("password")).sendKeys(password);
		//driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.close();
		

}}
