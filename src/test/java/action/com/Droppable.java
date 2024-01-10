package action.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import browserlaunch.BrowserLaunch;

public class Droppable {

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = BrowserLaunch.getChromeBrowser();
		driver.get("https://jqueryui.com/droppable/");
		BrowserLaunch.waitForSeconds(3);

		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement targetToDrop = driver.findElement(By.id("droppable"));

		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, targetToDrop).build().perform();
		System.out.println("Element is dragged first time");
		BrowserLaunch.waitForSeconds(5);
		driver.switchTo().defaultContent();

		driver.navigate().refresh();

		driver.switchTo().frame(0);
		source = driver.findElement(By.id("draggable"));
		targetToDrop = driver.findElement(By.id("droppable"));

		actions.click(source).release(targetToDrop).build().perform();
		BrowserLaunch.waitForSeconds(5);

		driver.navigate().refresh();

		driver.switchTo().frame(0);
		source = driver.findElement(By.id("draggable"));
		targetToDrop = driver.findElement(By.id("droppable"));
		Point location = targetToDrop.getLocation();
		System.out.println("X, Y - coordinates : " + location);

		// This is not working and no error is throwing, needs to know the reason
		actions.dragAndDropBy(source, 150, 15);
		System.out.println("Element moved to given offset");

		driver.switchTo().defaultContent();

		BrowserLaunch.waitForSeconds(5);

		driver.quit();

	}

}
