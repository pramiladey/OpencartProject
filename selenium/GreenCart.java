package selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenCart {
	public static void main(String[] args) throws InterruptedException{
		//String product;
System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
		
		WebDriver w=new ChromeDriver();
		w.manage().window().maximize();
		//w.get("https://www.voot.com");
		
		//List <String> list=new ArrayList<String>();
		//list.add("Cucumber");
		//list.add("Broclli");
		//for(String product: list) {
			//System.out.println(""+product);
			
		//}
		String[] itemsNeeded= {"Cucumber","Brocolli","Cauliflower","Beatroot","Carrot","Tomato","Beans"};
		w.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		GreenCart gc=new GreenCart();
		gc.addItem(w,itemsNeeded);
		w.findElement(By.id("root")).click();
		w.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		w.findElement(By.xpath("//*[@class='promocode']")).sendKeys("pam");
		w.findElement(By.cssSelector("button.promoBtn")).click();
		
		WebDriverWait w1=new WebDriverWait(w,5);
		System.out.println(w.findElement(By.cssSelector("span.promoInfo")).getText());
		
		Thread.sleep(5000);
		w.navigate().back();
		w.close();
	}
	public void addItem(WebDriver driver1, String[] itemsNeeded) {
		int j=0;
		List<WebElement> products=driver1.findElements(By.cssSelector("div.product"));
		System.out.println("itemsNeeded.length: "+itemsNeeded.length);
		System.out.println("products.length: "+products.size());
		for(int i=0;i<products.size();i++) {
			String[] name=products.get(i).getText().split("-");
			String formattedName=name[0].trim();
			List itemsNeededList=Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(formattedName)) {
				j++;
				driver1.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				
				if(j==3) {
					break;
				}
			}
		
		
	}}}
		
		
		
	


