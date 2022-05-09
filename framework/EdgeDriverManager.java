package framework;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverManager {

	public static void main(String[] args) {
		EdgeOptions edgeOptions = new EdgeOptions();
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver(edgeOptions);
		driver.manage().window().maximize();
		
		// Navigate to the demoqa website
		driver.get("https://www.google.com");
		
		driver.quit();

}
}