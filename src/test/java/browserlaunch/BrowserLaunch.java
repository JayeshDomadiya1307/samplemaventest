package browserlaunch;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {

	public static WebDriver driver;
	
	
	public static void waitForSeconds(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Why I'm getting an error for WebDriverManager and no chromedriver() ==>
	// Solution: Need to put the code inside the method and can't run with class
	// directly

	public static WebDriver getChromeBrowser() {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static void main(String[] args) {
		
		BrowserLaunch.getChromeBrowser();
		driver.get("https://www.udemy.com/");
		waitForSeconds(2);
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.TAB);
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	
		WebDriver tab1 = driver.switchTo().window(tabs.get(1));
		tab1.get("https://www.facebook.com/");
		WebDriver tab2 = driver.switchTo().window(tabs.get(2));
		tab2.get("https://www.google.com/");
		WebDriver tab3 = driver.switchTo().window(tabs.get(3));
		tab3.get("https://www.techivp.com/");
		
//		tab1.get("https://www.facebook.com/");
//		tab2.get("https://www.google.com/");
//		tab3.get("https://www.techivp.com/");
//		
		waitForSeconds(5);
		
		driver.quit();

	}

}
