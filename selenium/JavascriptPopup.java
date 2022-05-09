package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptPopup {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		
		

		WebDriver w=new ChromeDriver();
		w.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		w.manage().window().maximize();
		WebElement frame1=w.findElement(By.id("iframeResult"));
		w.switchTo().frame(frame1);
		w.findElement(By.xpath("/html/body/button")).click();
		w.switchTo().alert().sendKeys("RCV Academy");
		w.switchTo().alert().accept();
		w.switchTo().parentFrame();
		System.out.println(w.getTitle());
	

}
}
