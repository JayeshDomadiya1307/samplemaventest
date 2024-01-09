package action.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import browserlaunch.BrowserLaunch;

public class RightClick {

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = BrowserLaunch.getChromeBrowser();
		driver.get("https://selenium08.blogspot.com/2019/12/right-click.html");
		BrowserLaunch.waitForSeconds(5);

		Actions actions = new Actions(driver);

		WebElement rightClickBtn = driver.findElement(By.xpath("//div[contains(text(),'Context / Right click for Menu')]"));

		actions.contextClick(rightClickBtn).build().perform();
		BrowserLaunch.waitForSeconds(5);
		
		System.out.println("Right clicked on element!");

		BrowserLaunch.waitForSeconds(5);
		driver.quit();
	}

}
