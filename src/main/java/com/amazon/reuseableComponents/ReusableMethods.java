package com.amazon.reuseableComponents;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.utility.PropertyFileReader;

public class ReusableMethods {
	
	
	public static void Implicitwait(WebDriver driver) throws IOException
	{
	
		int wait=Integer.parseInt(ReusableComponents.prop.getProperty("waits"));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}

	
	
	
}
