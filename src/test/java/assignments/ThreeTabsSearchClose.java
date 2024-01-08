package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import browserlaunch.BrowserLaunch;

import java.util.ArrayList;

import org.junit.Assert;

public class ThreeTabsSearchClose {

	public static void getSearchResult(String searchInput) {
		driver.get("https://www.google.com/");
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.sendKeys(searchInput);
		search.sendKeys(Keys.ENTER);

		WebElement searchResult = driver.findElement(By.xpath("//div[@role='heading' and text()='" + searchInput
				+ "'] | //span[@role='heading' and text()='" + searchInput + "' ] "));

		String searchResultText = searchResult.getText();
		Assert.assertEquals(searchResultText, searchInput);
		System.out.println("Search result is: " + searchInput);

	}

	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = BrowserLaunch.getChromeBrowser();
		BrowserLaunch.waitForSeconds(2);

		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.TAB);

		/*
		 * driver.get("https://www.google.com/"); WebElement search =
		 * driver.findElement(By.id("APjFqb")); search.sendKeys("Surat");
		 * search.sendKeys(Keys.ENTER);
		 * 
		 * String searchResult =
		 * driver.findElement(By.xpath("//span[@role='heading' and text()='Surat']")).
		 * getText(); Assert.assertEquals(searchResult, "Surat");
		 * System.out.println("Search result is verified");
		 */

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(0));
		getSearchResult("Surat");

		driver.switchTo().window(tabs.get(1));
		getSearchResult("London");

		driver.switchTo().window(tabs.get(2));
		getSearchResult("India");

	}

}
