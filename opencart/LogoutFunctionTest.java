package opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogoutFunctionTest {
	WebDriver driver=null;
	@Test(priority=1)
	public void DriverSetup() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		driver=new ChromeDriver();

		driver.manage().window().maximize();

	}
	

}
