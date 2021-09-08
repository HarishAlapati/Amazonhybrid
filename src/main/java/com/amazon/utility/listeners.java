package com.amazon.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.amazon.reuseableComponents.ReusableComponents;


public class listeners implements ITestListener {
	ReusableComponents b=new ReusableComponents();


	public void onTestFailure(ITestResult result) {
		try {
			b.getScreenshots(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
	

