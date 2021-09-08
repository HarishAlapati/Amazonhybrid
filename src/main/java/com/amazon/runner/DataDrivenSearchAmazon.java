package com.amazon.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.pageObjects.HomepageObjects;
import com.amazon.reuseableComponents.ReusableComponents;
import com.amazon.reuseableComponents.ReusableMethods;
import com.amazon.utility.ExcelReader;
import com.amazon.utility.PropertyFileReader;



public class DataDrivenSearchAmazon extends ReusableComponents {


@Test(dataProvider="datas")
public  void SearchAmazon(String search) throws IOException
{
	driver=initializedriver();

	HomepageObjects ho=new HomepageObjects(driver);
	OpenUrl();

	ho.SearchBox().sendKeys(search);

	ho.SearchButton().click();
	ReusableMethods.Implicitwait(driver);
}
//ExcelReader e=new ExcelReader();
@DataProvider
public Object[][] datas() throws IOException
{
	/*Properties prop=new Properties();
	prop.load(PropertyFileReader.LoadFile());*/
	prop=PropertyFileReader.LoadFile();
	String p=prop.getProperty("path");
	String file=prop.getProperty("fileName");
	String sheet=prop.getProperty("sheetName");
	//ArrayList a=ExcelReader.readExcel("C:\\Users\\saiha\\Documents","Demodata.xlsx","Test");
	//Object[] data=a.toArray();
	Object[][] data=ExcelReader.readExcel(p,file,sheet);
	
	return data;
}


/*@AfterTest
public void closeDriver()
{
	driver.close();
}*/
@AfterMethod
public void closeDriverM()
{
	driver.close();
}

}
