package waits.com;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import browserlaunch.BrowserLaunch;

public class FluentWaitClass {

	public static WebDriver driver;


	public static void main(String[] args) {

		driver = BrowserLaunch.getChromeBrowser();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
		
		driver.findElement(By.name("firstname")).sendKeys("Jayesh");
		driver.findElement(By.name("lastname")).sendKeys("Domadiya");
		

	}

}
