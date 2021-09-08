package com.amazon.reuseableComponents;


import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.utility.PropertyFileReader;

public class ReusableComponents {
	public static  WebDriver driver;
	public static Properties prop;
	public static Logger logger;

	public WebDriver initializedriver() throws IOException
	{
		/*prop=new Properties();
		prop.load(PropertyFileReader.LoadFile());*/
		prop=PropertyFileReader.LoadFile();
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		ReusableMethods.Implicitwait(driver);
		logger = Logger.getLogger("Amazon");
		PropertyConfigurator.configure("log4j.properties");
		return driver;
	}
	
	public static void OpenUrl()
	{
		driver.get(prop.getProperty("url"));
	}
	
	public void getScreenshots(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\screenshots\\"+result+"screenshot.png"));
	}
}
