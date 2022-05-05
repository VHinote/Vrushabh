package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.Buyshare;
import POM.Zerodalogin;
import Pojo.Browser;
import Utility.Excel;
import Utility.Reports;
import Utility.Scrrenshots;
@Listeners(ListnerTest.class)
public class Buy extends Base {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public void setReports() {
		reports =Reports.addReport();
		
	}
	
	
	@BeforeMethod
	public void cbrowser() throws IOException, InterruptedException {
	
		driver = Browser.OpenBrowser("https://kite.zerodha.com/");
		String Username = Excel.getTestData(0, 1, "Credensial");
		String password = Excel.getTestData(1, 1, "Credensial");
		String pinnum = Excel.getTestData(2, 1, "Credensial");
		
		Zerodalogin zerodalogin = new Zerodalogin(driver);
		zerodalogin.enterUserName(Username);
		zerodalogin.enterPassWord(password);
		zerodalogin.clickonSubmit();
	    Thread.sleep(2000);
		zerodalogin.enterPin(pinnum);
		zerodalogin.clickonLogin();
	}
	
	@Test
	public void buyshare() throws InterruptedException   {
		test=reports.createTest("buyshare");
		
		Buyshare buysh = new Buyshare(driver);
		
		buysh.selectstockfromlist(driver,"TATAMOTORS");
	    buysh.clickbuy();
	
	}
	@Test 
	public void Search() throws InterruptedException
	{
		test=reports.createTest("Search");
		Buyshare Riya = new Buyshare(driver);
		Riya.Searchpath(driver, "TATACOFFEE");
	   
	}
	
	@AfterMethod
	public void captureResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		else {
			test.log(Status.SKIP, result.getTestName());
		}
	}
	
	@AfterClass
	public void flushResults() {
		reports.flush();
	}
	
	

}
