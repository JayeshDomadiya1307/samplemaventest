package screenshot.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import browserlaunch.BrowserLaunch;

public class ScreenshotClass {

	public static WebDriver driver;

	public static void takeScreenshot(WebDriver driver, String screenshotName) {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath = "C:\\Users\\dell\\eclipse-workspace\\samplemaventest\\ScreenshotsFolder\\";

		File destinationFile = new File(screenshotPath + screenshotName);

		try {
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			System.out.println("Failed to copy the screenshot");
			e.printStackTrace();
		}

	}

	public static void takeScreenshotOfElement(WebElement element, String screenshotName) {

		TakesScreenshot screenshot = (TakesScreenshot) element;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath = "C:\\Users\\dell\\eclipse-workspace\\samplemaventest\\ScreenshotsFolder\\";

		File destinationFile = new File(screenshotPath + screenshotName);

		try {
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			System.out.println("Failed to copy the screenshot");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		driver = BrowserLaunch.getChromeBrowser();
		driver.get("https://www.facebook.com/");
		System.out.println("URL :" + driver.getCurrentUrl());
		BrowserLaunch.waitForSeconds(3); 

		/*
		 * TakesScreenshot screenshot = (TakesScreenshot) driver; File sourceFile =
		 * screenshot.getScreenshotAs(OutputType.FILE);
		 * 
		 * File destinationFile = new File(
		 * "C:\\Users\\dell\\eclipse-workspace\\samplemaventest\\ScreenshotsFolder\\" + "
		 * homepageScreenshot.png");
		 * 
		 * try { FileUtils.copyFile(sourceFile, destinationFile); } catch (IOException
		 * e) { System.out.println("Failed to copy the screenshot");
		 * e.printStackTrace(); }
		 */

		if (driver.getCurrentUrl().equals("https://www.facebook.com/")) {
			System.out.println("Test Passed!");
			takeScreenshot(driver, "homepage.png");
		} else {
			System.out.println("Test Failed!");
//			takeScreenshot(driver, "homepage.png");
		}

		WebElement createNewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createNewAccount.click();
		System.out.println("Clicked : " + createNewAccount.getText());
		takeScreenshot(driver, "createNewAccountButton.png");
		BrowserLaunch.waitForSeconds(3);

		driver.navigate().to("https://www.facebook.com/");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("Jayesh Domadiya taking email address screenshot!");
		BrowserLaunch.waitForSeconds(3);
		takeScreenshotOfElement(emailField, "emailAddressField.png");
		BrowserLaunch.waitForSeconds(3);
		
		WebElement loginCorousel = driver.findElement(By.className("_8esn"));
		takeScreenshotOfElement(loginCorousel, "loginFields.png");

		driver.navigate().to("https://www.google.com/");
		System.out.println("URL :" + driver.getCurrentUrl());
		BrowserLaunch.waitForSeconds(3);
		takeScreenshot(driver, "googlePage.png");
		
		BrowserLaunch.waitForSeconds(3);
		driver.quit();

	}

}
