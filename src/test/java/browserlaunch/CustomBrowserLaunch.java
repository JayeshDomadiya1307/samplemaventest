package browserlaunch;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomBrowserLaunch {

	public static WebDriver driver;

	public static WebDriver getCustomChromeDriver() {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		Map<String, Object> prefsMap = new HashMap<String, Object>();

		// To know the path of the project dynamically
		String projectPath = System.getProperty("user.dir");
		prefsMap.put("download.default_directory", projectPath + "\\DownloadFiles");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("incognito");
//		options.addArguments("headless");
		options.addArguments("--disable-notifications");
		options.addArguments("--disblae-extensions");
		options.addArguments("--disable-popup-blocking");

		options.setExperimentalOption("prefs", prefsMap);

		driver = new ChromeDriver(options);

		return driver;

	}

	public static void main(String[] args) {
		
		driver = getCustomChromeDriver();
		
		driver.get("https://www.facebook.com/");
		BrowserLaunch.waitForSeconds(2);
		System.out.println("URL is opened the Facebook with customer browser");
		
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();
		System.out.println("Clicked on login");
		BrowserLaunch.waitForSeconds(3);
		
		driver.navigate().back();
		System.out.println("Navigate back");
		BrowserLaunch.waitForSeconds(2);
		
		driver.navigate().to("https://www.google.com/");
		System.out.println("URL is opened the Google with customer browser");
		BrowserLaunch.waitForSeconds(2);
		
		driver.navigate().refresh();
		System.out.println("Page Refresh");
		BrowserLaunch.waitForSeconds(2);
		driver.navigate().back();
		System.out.println("Navigate back");
		BrowserLaunch.waitForSeconds(2);
		driver.navigate().forward();
		System.out.println("Navigate Forward");
		BrowserLaunch.waitForSeconds(2);
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_a_download");
		
	}

}
