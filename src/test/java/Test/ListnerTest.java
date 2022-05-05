package Test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.Scrrenshots;

public class ListnerTest extends Base implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("Started"+  result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("My Test is succesful"+ result.getName());
	}
	
	public void onTestfailure(ITestResult result) {
		try {
			Scrrenshots.takeScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onTestskiped(ITestResult result) {
		System.out.println("My test is skipped"+ result.getName());
	}

}
