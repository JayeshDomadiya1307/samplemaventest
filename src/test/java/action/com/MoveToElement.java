package action.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import browserlaunch.BrowserLaunch;

public class MoveToElement {

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = BrowserLaunch.getChromeBrowser();
		
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		
		System.out.println(width);
		System.out.println(height);
		
		driver.get("https://www.facebook.com/");
		
		WebElement element = driver.findElement(By.id("email"));
        
        Point location = element.getLocation();
        System.out.println("X, Y - coordinates : " + location); 

		Actions actions = new Actions(driver);
		
		actions.moveByOffset(1057, 148).sendKeys("Moved to element using co-ordinates").build().perform();
		
		BrowserLaunch.waitForSeconds(5);
		driver.quit();
		

	}

}
