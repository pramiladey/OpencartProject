package selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilites {
	public static void main(String[] args) throws InterruptedException{
		DesiredCapabilities ch=DesiredCapabilities.chrome();
		ch.acceptInsecureCerts();
		
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		
		ChromeOptions options=new ChromeOptions();
		
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		options.merge(ch);
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22780/nz-vs-ind-3rd-odi-india-tour-of-new-zealand-2020");
		Thread.sleep(3000);
		driver.navigate().back();
		driver.close();
		
		
	
	}

}
