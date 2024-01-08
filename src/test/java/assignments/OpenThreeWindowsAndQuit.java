package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import browserlaunch.BrowserLaunch;

public class OpenThreeWindowsAndQuit {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = BrowserLaunch.getChromeBrowser();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		BrowserLaunch.waitForSeconds(5);
		
		driver.quit();
		
		System.out.println("All windows sessions is closed with Quit");

	}

}
