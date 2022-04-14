package com.opencart.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.opencart.test.*;
public class CommonPage {
	static Actions action;
	public static void moveToElement(WebElement element,WebDriver driver)
	{
		action =new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public void click(WebElement element)
	{
		element.click();
	}

	public void clear(WebElement element)
	{
		element.clear();
	}

	public void setText(String text,WebElement element)
	{
		element.sendKeys(text);
	}

	public static void selectByIndex(WebElement sort, int num)
	{
		Select s=new Select(sort);
		s.selectByIndex(num);
	}
	
	
}
