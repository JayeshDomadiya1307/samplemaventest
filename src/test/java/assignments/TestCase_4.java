package assignments;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import browserlaunch.BrowserLaunch;
import org.junit.*;

public class TestCase_4 {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = BrowserLaunch.getChromeBrowser();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.TAB);
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(0));
		driver.get("https://www.google.com/");
	
		driver.switchTo().window(tabs.get(1));
		driver.get("https://www.jiomart.com/");
		
		driver.switchTo().window(tabs.get(2));
		driver.get("https://www.amazon.in/");
		
		String amazonPage = driver.getCurrentUrl();
		String amazonPageVerification = "https://www.amazon.in/";
		
		Assert.assertEquals(amazonPageVerification, amazonPage);
		driver.close();
		System.out.println("Amazon page is verified and tab is closed!");
		
		driver.switchTo().window(tabs.get(1));
		String jiomartPage = driver.getCurrentUrl();
		String jiomartPageVerification = "https://www.jiomart.com/";
		Assert.assertEquals(jiomartPageVerification, jiomartPage);
		driver.close();
		System.out.println("Jiomart page is verified and tab is closed!");
		
		driver.switchTo().window(tabs.get(0));
		String googlePage = driver.getCurrentUrl();
		String googlePageVerification = "https://www.google.com/";
		Assert.assertEquals(googlePageVerification, googlePage);
		driver.close();
		System.out.println("Google page is verified and tab is closed!");
		
		System.out.println("Test case 4 is completed!");
	}

}
