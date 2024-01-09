package relativelocator.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import browserlaunch.BrowserLaunch;

// This needs to import to use relative locators in selenium 4
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import static org.openqa.selenium.support.locators.RelativeLocator.with;;

public class RelativeLocatorClass {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = BrowserLaunch.getChromeBrowser();
		driver.get("https://www.facebook.com/");
		BrowserLaunch.waitForSeconds(3);
		
		WebElement createNewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createNewAccount.click();
		BrowserLaunch.waitForSeconds(3);
		
		WebElement male = driver.findElement(By.xpath("//label[text()='Male']"));
		WebElement female = driver.findElement(with(By.xpath("//input[@value='1']")).toLeftOf(male));
		female.click();
		BrowserLaunch.waitForSeconds(3);
		
		WebElement custom = driver.findElement(with(By.xpath("//input[@value='-1']")).toRightOf(male));
		custom.click();
		BrowserLaunch.waitForSeconds(3);
		
		WebElement crossPopup = driver.findElement(By.xpath("//div[@class='_8ien']//div/../img"));
		crossPopup.click();
		BrowserLaunch.waitForSeconds(3);
		
		WebElement password = driver.findElement(By.id("pass"));
		WebElement email = driver.findElement(with(By.tagName("input")).above(password));
		email.sendKeys("This is email address element find by relative locators");
		BrowserLaunch.waitForSeconds(3);
		
		WebElement forgotPassword = driver.findElement(with(By.xpath("//a[text()='Forgotten password?']")).below(password));
//		loginBtn.click();
		
		// Open the clicking link in new window or tab
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(forgotPassword).keyUp(Keys.CONTROL).build().perform();
		BrowserLaunch.waitForSeconds(3);
		
		WebElement loginBtn = driver.findElement(with(By.tagName("button")).near(password));
		loginBtn.click();
		BrowserLaunch.waitForSeconds(3);
		
		driver.quit();
	}

}
