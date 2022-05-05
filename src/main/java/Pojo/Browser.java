package Pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
	public static WebDriver OpenBrowser(String url) {
		ChromeOptions options = new ChromeOptions();//class of selenium
		options.addArguments("--disable-notifications");//to disble notifications
		System.setProperty("webdriver.chrome.driver", "D:\\automation\\Zeroda\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		
		
		return driver;
	}
}
