package waits.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browserlaunch.BrowserLaunch;

public class ExplicitWaitsClass {

	public static void explicitWaitFor(int sec, By xpath) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.presenceOfElementLocated(xpath));

	}

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = BrowserLaunch.getChromeBrowser();

		driver.get("https://www.facebook.com/");
		WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createAccount.click();
		
		// Here I'm using explicit wait for the element by function
		ExplicitWaitsClass.explicitWaitFor(5, By.name("firstname"));

		driver.findElement(By.name("firstname")).sendKeys("Jayesh");
		driver.findElement(By.name("lastname")).sendKeys("Domadiya");

	}

}
