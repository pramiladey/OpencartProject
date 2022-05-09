package opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchFunctionApp {
	
	public void Search(WebElement element,WebDriver driver) {
		driver.manage().window().maximize();

		driver.get("http://localhost/opencartapp/");

		//search functionality of opencart
		element=driver.findElement(By.name("search"));
		element.sendKeys("laptop");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		
		driver.findElement(By.name("description")).click();
		
		Select s = new Select(driver.findElement(By.name("category_id")));
		s.selectByIndex(2);
		
		driver.findElement(By.name("sub_category")).click();
		
		driver.findElement(By.id("button-search")).click();
		
		driver.close();
		
	}
	public static void main(String[] args) {
		SearchFunctionApp app=new SearchFunctionApp();
		WebElement element = null;
		WebDriver driver = null;
		app.Search(element, driver);
	}

}
