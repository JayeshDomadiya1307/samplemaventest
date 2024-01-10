package action.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import browserlaunch.BrowserLaunch;

public class Draggable {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = BrowserLaunch.getChromeBrowser();
		driver.get("https://jqueryui.com/draggable/");
		BrowserLaunch.waitForSeconds(3);
		
		driver.switchTo().frame(0);
		WebElement draggable = driver.findElement(By.id("draggable"));
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(draggable).moveByOffset(50, 50).build().perform();
		BrowserLaunch.waitForSeconds(5);
		
		System.out.println("Element is dragged first time");
		
		actions.moveToElement(draggable).clickAndHold().moveByOffset(200, 200).build().perform();
		System.out.println("Element is dragged Second time");
		BrowserLaunch.waitForSeconds(5);
		
		actions.moveToElement(draggable).clickAndHold().moveByOffset(-150, -100).build().perform();
		System.out.println("Element is dragged third time to reverse");
		
		driver.switchTo().defaultContent();
		
		BrowserLaunch.waitForSeconds(5);
		
		driver.quit();
		
	}

}
