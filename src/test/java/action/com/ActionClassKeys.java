package action.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import browserlaunch.BrowserLaunch;

public class ActionClassKeys {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = BrowserLaunch.getChromeBrowser();
		driver.get("https://www.facebook.com/");
		
		Actions actions = new Actions(driver);
		
		actions.keyDown(Keys.SHIFT).sendKeys("jayeshdomadiya1307@gmail.com").keyUp(Keys.SHIFT).build().perform();
		BrowserLaunch.waitForSeconds(3);
		
		actions.keyDown(Keys.TAB).build().perform();
		actions.sendKeys("I moved to password").build().perform();
		BrowserLaunch.waitForSeconds(3);
		
		WebElement loginBtn = driver.findElement(By.name("login"));
		actions.click(loginBtn).build().perform();
		
		WebElement instaBtn = driver.findElement(By.xpath("//a[text()='Instagram']"));
		actions.moveToElement(instaBtn).click().build().perform();
		BrowserLaunch.waitForSeconds(5);
		
		actions.click();
		BrowserLaunch.waitForSeconds(5);
		
		actions.sendKeys("This is default triggered focus");
		BrowserLaunch.waitForSeconds(3);
		
		BrowserLaunch.waitForSeconds(3);
		
		driver.quit();
		

	}

}
