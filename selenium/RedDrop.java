package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RedDrop {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://www.redbus.in/");
		w.findElement(By.id("manageHeaderdd")).click();
		 //w.findElements(By.id("manageHeaderdd")).click();
		w.findElement(By.xpath("//*[@id=\"hmb\"]/div[2]/ul/li[2]")).click();
		//*[@id="root"]/div/div[2]/div[1]/div[1]/div/input
		w.findElement(By.name("tin")).sendKeys("102");
		w.findElement(By.name("email")).sendKeys("@gmail.com");
		w.findElement(By.className("form-select-passenger-container")).click();
		//w.findElement(By.className("button-comp-lbl.bg-color-d84e55")).click();
		
		
		//w.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div")).submit();
		//Select s=new Select(w.findElement(By.xpath("//*[@id=\\\\\\\"root\\\\\\\"]/div/div[2]/div[2]/div")));
		//s.selectByValue("INR");
		
		
		
		Thread.sleep(3000);
		w.navigate().back();
		w.close();
		

}}
