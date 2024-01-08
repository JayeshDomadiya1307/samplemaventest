package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import browserlaunch.BrowserLaunch;

import java.time.Duration;

import org.junit.*;

public class TestCase_5 {

	public static WebDriver driver;
	
	public static void JSClick(WebDriver driver, WebElement ele, int timeout) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click()", ele);
		
		BrowserLaunch.waitForSeconds(timeout);
	}

	public static void main(String[] args) {

		driver = BrowserLaunch.getChromeBrowser();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.jiomart.com/");

		WebElement cartButton = driver
				.findElement(By.xpath("//img[@src=\"https://www.jiomart.com/assets/ds2web/jds-icons/cart-icon.svg\"]"));
//		cartButton.click();

		 JSClick(driver, cartButton , 2);
		
		
		BrowserLaunch.waitForSeconds(2);

		Boolean emptyCart = true;
		String placeholderText = driver.findElement(By.xpath("//div[text()='Your Cart is Empty!']")).getText();
		String emptyCartText = "Your Cart is Empty!";

		if (emptyCart) {
			Assert.assertEquals(emptyCartText, placeholderText);
		} else {
			System.out.println("Cart is not empty!");
		}

		System.out.println("Execution is completed!");

		BrowserLaunch.waitForSeconds(5);
		driver.close();
	}

}
