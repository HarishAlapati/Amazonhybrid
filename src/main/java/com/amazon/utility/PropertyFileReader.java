package com.amazon.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	//public static Properties prop;
	public static Properties LoadFile() throws IOException
	{
		//prop=new Properties();
		FileInputStream fis=new FileInputStream(".\\config.properties");
		//return fis;

		Properties prop=new Properties();
		prop.load(fis);
		return prop;
	}
}
