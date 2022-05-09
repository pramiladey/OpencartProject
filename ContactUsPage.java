/**
 * 
 */
package com.psl.OpenCart.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.psl.OpenCart.commons.SeleniumImplementation;



public class ContactUsPage {
	
	SeleniumImplementation selenium;
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[1]/a/i")
	WebElement ContactIcon;
	@FindBy(xpath="//*[@id=\"input-name\"]")
	WebElement NameTextBox;
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement EmailTextBox;
	@FindBy(xpath="//*[@id=\"input-enquiry\"]")
	WebElement EnquiryTextBox;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input")
	WebElement SubmitContactForm;
	@FindBy(id="content")
	WebElement displaymsg;
	
    //constructor
	public ContactUsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		selenium=new SeleniumImplementation();
	}
	
	
	public void validContactform(WebDriver driver) throws IOException, InterruptedException
	{
		selenium.click(ContactIcon);
		
		Properties p=new Properties();
		FileInputStream fis = null;
		try {
		fis = new FileInputStream("ContactUsFormDetails.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		p.load(fis);
				
		selenium.moveToElement(NameTextBox, driver);
		selenium.clear(NameTextBox);
		selenium.setText(p.getProperty("username"), NameTextBox);
		selenium.moveToElement(EmailTextBox, driver);
		selenium.clear(EmailTextBox);
		selenium.setText(p.getProperty("email"), EmailTextBox);
		selenium.moveToElement(EnquiryTextBox, driver);
		selenium.clear(EnquiryTextBox);
		selenium.setText(p.getProperty("query"), EnquiryTextBox);
		selenium.click(SubmitContactForm);
		selenium.validateTExt1(displaymsg, driver,"Your enquiry has been successfully sent to the store owner!");
	}
	
	
	public void InvalidContactform(WebDriver driver) throws IOException, InterruptedException
	{
		selenium.click(ContactIcon);
		
		Properties p=new Properties();
		FileInputStream fis = null;
		try {
		fis = new FileInputStream("ContactUsFormDetails.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		p.load(fis);
				
		selenium.moveToElement(NameTextBox, driver);
		selenium.clear(NameTextBox);
		selenium.setText(p.getProperty("username1"), NameTextBox);
		selenium.moveToElement(EmailTextBox, driver);
		selenium.clear(EmailTextBox);
		selenium.setText(p.getProperty("email1"), EmailTextBox);
		selenium.moveToElement(EnquiryTextBox, driver);
		selenium.clear(EnquiryTextBox);
		selenium.setText(p.getProperty("query"), EnquiryTextBox);
		selenium.click(SubmitContactForm);
		selenium.InvalidateTExt(displaymsg, driver,"E-Mail Address does not appear to be valid!");
	}

}
