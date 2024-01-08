package capabilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.dockerjava.api.model.Driver;

import browserlaunch.BrowserLaunch;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CapabilitiesClass {

	public static WebDriver driver;

	public static WebDriver browserData() {

		WebDriverManager.chromedriver().setup();

		Map<String, Object> prefsMap = new HashMap<String, Object>();
		// To know the path of the project dynamically
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		// Path: C:\Users\dell\eclipse-workspace\samplemaventest\DownloadFiles
		
		prefsMap.put("download.default_directory", projectPath + "/DownloadFiles");
//		prefsMap.put("download.default_directory", "C:\\Users\\dell\\eclipse-workspace\\samplemaventest\\DownloadFiles");

		ChromeOptions options = new ChromeOptions();

		options.addArguments("disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("disable-popup-blocking");
//		options.addArguments("headless");
//		options.addArguments("incognito");
		options.addArguments("disable-notifications");
		options.setExperimentalOption("prefs", prefsMap);

		driver = new ChromeDriver(options);
		Capabilities capsCapabilities = ((RemoteWebDriver) driver).getCapabilities();

		String browserName = capsCapabilities.getBrowserName();
		String browserVersion = capsCapabilities.getBrowserVersion();
		String browserOS = capsCapabilities.getPlatformName().name();

		String osName2 = System.getProperty("os.name");

		System.out.println("Browser Name: " + browserName);
		System.out.println("Browser Version: " + browserVersion);
		System.out.println("Browser OS: " + browserOS);
		System.out.println("Browser OS 2: " + osName2);

		
		return driver;
	}

	public static void main(String[] args) {

		driver = CapabilitiesClass.browserData();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_a_download");
//		BrowserLaunch.waitForSeconds(5);
		
		driver.switchTo().frame(1);
		
		WebElement imageToDownload =  driver.findElement(By.xpath("//img[@alt='W3Schools']"));
		imageToDownload.click();
		BrowserLaunch.waitForSeconds(2);
		
		/*
		 * WebElement imageToClick =
		 * driver.findElement(By.xpath("//img[@alt='W3Schools']"));
		 * driver.switchTo().frame(imageToClick); BrowserLaunch.waitForSeconds(5);
		 * 
		 * driver.switchTo().frame("iframeResult"); WebElement imageToStore =
		 * driver.findElement(By.xpath("//img[@alt='W3Schools']"));
		 * imageToStore.click();
		 * 
		 * JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		 * jsExecutor.executeScript("arguments[0].click()", imageToDownload);
		 */
		
		
		driver.switchTo().defaultContent();
		WebElement websiteBtn =  driver.findElement(By.id("getwebsitebtn"));
		websiteBtn.click();
		
		BrowserLaunch.waitForSeconds(2);
		driver.quit();
	}

}
