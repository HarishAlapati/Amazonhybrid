package com.amazon.runner;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.amazon.pageObjects.HomepageObjects;
import com.amazon.reuseableComponents.ReusableComponents;
import com.amazon.reuseableComponents.ReusableMethods;



public class TestRunner extends ReusableComponents {
@Test
public  void SearchAmazon() throws IOException
{
	driver=initializedriver();
	logger.info("Driver called 1");
	HomepageObjects ho=new HomepageObjects(driver);
	OpenUrl();
	logger.debug("opened the amazon url");
	ho.SearchBox().sendKeys(prop.getProperty("search"));
	logger.info("Search whatever you need");
	ho.SearchButton().click();
	logger.info("You clicked on search button");
	ReusableMethods.Implicitwait(driver);
}
@Test
public  void checkTitle()
{
	Assert.assertEquals(driver.getTitle(),"Amazon.in : iphone 11");
	logger.info("Checking title matching");
}


@AfterTest
public void closeDriver()
{
	driver.close();
	driver=null;
	logger.info("Browser closed");
}

}
