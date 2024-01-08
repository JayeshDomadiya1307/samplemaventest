package assignments;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import browserlaunch.BrowserLaunch;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenURLForIndividualTabs {

	public static WebDriver driver;

	public static void main(String[] args) {

		/*
		 * If we call the static method getChromeBrowser() from BrowserLaunch class,
		 * it's throwing an error at run time for NullPointerException --> We need to store the  BrowserLaunch.getChromeBrowser() in driver with the variable in same class.
		 * 
		 * BrowserLaunch.getChromeBrowser("https://www.facebook.com/");
		 */

		driver = BrowserLaunch.getChromeBrowser();
		BrowserLaunch.waitForSeconds(2);

		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.TAB);

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(0));
		driver.get("https://www.facebook.com/");
		BrowserLaunch.waitForSeconds(2);

		driver.switchTo().window(tabs.get(1));
		driver.get("https://www.google.com/");
		BrowserLaunch.waitForSeconds(2);

		driver.switchTo().window(tabs.get(2));
		driver.get("https://www.techivp.com/");

		BrowserLaunch.waitForSeconds(2);

	}

}
