package select.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import browserlaunch.BrowserLaunch;

public class SelectClass {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		driver = BrowserLaunch.getChromeBrowser();
		driver.get("https://www.facebook.com/");
		BrowserLaunch.waitForSeconds(3);
		
		WebElement createNewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createNewAccount.click();
		BrowserLaunch.waitForSeconds(3);
		
		WebElement day = driver.findElement(By.id("day"));
		Select select = new Select(day);
		select.selectByIndex(10);
		BrowserLaunch.waitForSeconds(3);
		
		WebElement month = driver.findElement(By.id("month"));
		select = new Select(month);
		select.selectByValue("12");
		BrowserLaunch.waitForSeconds(3);
		
		WebElement year = driver.findElement(By.id("year"));
		select = new Select(year);
		select.selectByVisibleText("1986");
		
		BrowserLaunch.waitForSeconds(3);
		driver.quit();
		
		
	}

}
