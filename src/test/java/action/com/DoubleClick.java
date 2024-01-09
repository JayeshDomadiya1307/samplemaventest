package action.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import browserlaunch.BrowserLaunch;

public class DoubleClick {

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = BrowserLaunch.getChromeBrowser();
		driver.get("https://selenium08.blogspot.com/2019/11/double-click.html");
		BrowserLaunch.waitForSeconds(5);

		Actions actions = new Actions(driver);

		WebElement doubleClickBtn = driver
				.findElement(By.xpath("//button[text()='Double-Click me to see Alert message']"));

		actions.doubleClick(doubleClickBtn).build().perform();
		driver.switchTo().alert().accept();
		System.out.println("Double clicked on element and alert is accepted!");

		actions.moveToElement(doubleClickBtn).doubleClick().build().perform();
		driver.switchTo().alert().accept();
		System.out.println("Double clicked on element AGAIN and alert is accepted!");

		BrowserLaunch.waitForSeconds(5);
		driver.quit();
	}

}
