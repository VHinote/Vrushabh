package Test;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.Kite;
import Pojo.Browser;

public class Homepage {
	WebDriver driver;
	
	@BeforeMethod
	public void lunchbrowser() {
		driver = Browser.OpenBrowser("https://kite.zerodha.com/");
	}
	
	@Test
	public void test() {
		Kite kite = new Kite(driver);
		kite.clickonSignup();
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		String actualtitle = kite.getpagetitle(driver);
		String expectedtitle = "Signup and open a Zerodha trading and demat account online and start investing – Zerodha";
		Assert.assertEquals(actualtitle, expectedtitle);//hard assert wil stop execution at  this point
		Assert.assertTrue(kite.logoisdisplayed());//pass
		kite.entremobilenumber("8888702438");
		
	}
	
	@Test
	public void test2() {
		Kite kite = new Kite(driver);
		kite.clickonSignup();
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		String actualtitle = kite.getpagetitle(driver);
		String expectedtitle = "Signup and open a Zerodha trading and demat account online and start investing – Zerodha";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualtitle, expectedtitle );
		softassert.assertFalse(kite.logoisdisplayed());
		kite.entremobilenumber("8888702438");
		softassert.assertAll(); // shows all the captured failure
	}

}
