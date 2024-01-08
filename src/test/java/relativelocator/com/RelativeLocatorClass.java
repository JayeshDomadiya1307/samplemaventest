package relativelocator.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browserlaunch.BrowserLaunch;

// This needs to import to use relative locators in selenium 4
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorClass {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = BrowserLaunch.getChromeBrowser();
		driver.get("https://www.facebook.com/");
		BrowserLaunch.waitForSeconds(3);
		
		WebElement createNewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createNewAccount.click();
		BrowserLaunch.waitForSeconds(3);
		
		

	}

}
