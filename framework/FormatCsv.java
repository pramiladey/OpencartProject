package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class FormatCsv {
public static void main(String[]args) throws IOException, CsvValidationException,InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");



	      WebDriver driver=new ChromeDriver();
	       driver.manage().window().maximize();
	
       //WebDriver driver=new ChromeDriver();
		
		String csvFileName="C:\\Users\\pramila_dey\\Documents\\readData.csv";
		String username;
		String password;
		CSVReader reader=new CSVReader(new FileReader(csvFileName));
		String[] row=null;
		//String[] row=null;
		while((row = reader.readNext()) !=null) {
		  
			
			driver.get("https://www.facebook.com/");
			Thread.sleep(3000);
			username=row[0];
			password=row[1];
			driver.findElement(By.name("email")).sendKeys(username);
			driver.findElement(By.name("pass")).sendKeys(password);
			driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
			
		}
		reader.close();
		driver.close();
}}
