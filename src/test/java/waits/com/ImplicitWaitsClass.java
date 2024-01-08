package waits.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import browserlaunch.BrowserLaunch;

public class ImplicitWaitsClass {

	public static WebDriver driver;

	public static void waitForAllElement(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public static void main(String[] args) {

		driver = BrowserLaunch.getChromeBrowser();

		ImplicitWaitsClass.waitForAllElement(15);

		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Jayesh");
		driver.findElement(By.name("lastname")).sendKeys("Domadiya");
		

	}

}
