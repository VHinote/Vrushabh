package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Scrrenshots {
public static void takeScreenshot(WebDriver driver, String name) throws IOException {
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("D:\\automation\\Zeroda\\Scrrenshot"+name+".jpg");
		
		FileHandler.copy(source, destination);

	}
}
