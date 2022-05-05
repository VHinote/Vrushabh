package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.Zerodalogin;
import Pojo.Browser;
import Utility.Excel;

public class LoginTest {
   
WebDriver driver;
	
	@BeforeMethod
	public void callbrowser() {
		 driver = Browser.OpenBrowser("https://kite.zerodha.com/");
	}
	
	@Test
	public void testing1() throws IOException, InterruptedException {
		
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
}
