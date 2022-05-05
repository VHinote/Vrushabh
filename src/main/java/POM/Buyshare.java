package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buyshare {
	 @FindBy(xpath="//input[@icon=\"search\"]")private WebElement Search;
	@FindBy(xpath="span[text()='TATACOFFEE']")private WebElement share;
    @FindBy(xpath="//button[@class='button-blue buy']")private WebElement buy;
    @FindBy(xpath="//div[@class=\"vddl-list list-flat\"]//span//span//span[@class=\"nice-name\"]")private List<WebElement> stocks;
    
    public Buyshare(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    public void gotoshare(WebDriver driver) throws InterruptedException {
    	Thread.sleep(5000);
    	Actions action = new Actions(driver);
    	action.moveToElement(share);
    	action.perform();
    }
    
    public void selectstockfromlist(WebDriver driver,String share) throws InterruptedException {
    	Thread.sleep(2000);
    	for(int a=0; a<stocks.size();a++) {
    		String text= stocks.get(a).getText();
    		if(text.equalsIgnoreCase(share)) {
    			Actions action = new Actions(driver);
    			action.moveToElement(stocks.get(a));
    			action.perform();
    		}
    		
    	}
    	 
    	
    }
    public void Searchpath(WebDriver driver , String ShareName) throws InterruptedException
    {
   	Thread.sleep(2000);
   	Search.sendKeys(ShareName); 
   	Actions action =new Actions (driver);
   	action.moveToElement(share);
   	action.perform();
    }
    
    public void clickbuy() {
    	buy.click();
    }
    
    
}
