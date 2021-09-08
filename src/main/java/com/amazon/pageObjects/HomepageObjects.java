package com.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.uistore.HomepageObjectsui;

public class HomepageObjects {
		// This class invoke HomepageObjectsui class for locators and return webelements form this class
	WebDriver driver;
	
	HomepageObjectsui hl=new HomepageObjectsui();
	
	public HomepageObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement SearchBox()
	{
		return driver.findElement(hl.search);
	}
	
	public WebElement SearchButton()
	{
		return driver.findElement(hl.submit);
	}
}
