package alert.com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import browserlaunch.BrowserLaunch;

public class AlertClass {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = BrowserLaunch.getChromeBrowser();
		driver.get("https://selenium08.blogspot.com/2019/07/alert-test.html");
		
		BrowserLaunch.waitForSeconds(3);
		
		WebElement simpleAlert = driver.findElement(By.id("simple"));
		simpleAlert.click();
		BrowserLaunch.waitForSeconds(5);
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		BrowserLaunch.waitForSeconds(5);
		
		
		WebElement confirmAlert = driver.findElement(By.id("confirm"));
		confirmAlert.click();
		alert.accept();
		BrowserLaunch.waitForSeconds(5);
		
		WebElement confirmAcceptMsg = driver.findElement(By.xpath("//div[text()='You Accepted Alert!']"));
		
		if(confirmAcceptMsg.getText().equals("You Accepted Alert!'")) {
			System.out.println("Alert Accepted!");
		} else {
			System.out.println("Alert is NOT Accepted!");
		}
		
		
		confirmAlert = driver.findElement(By.id("confirm"));
		confirmAlert.click();
		alert.dismiss();
		BrowserLaunch.waitForSeconds(2);
		
		WebElement promptAlert = driver.findElement(By.id("prompt"));
		promptAlert.click();
		
		String inputPromptMessage =  "Jayesh Domadiya";
		
		alert.sendKeys(inputPromptMessage);
		
		alert.accept();
		BrowserLaunch.waitForSeconds(5);
		
		String promptAlertString = "Hello "+inputPromptMessage+"! How are you today?";
		
		WebElement promptAcceptMessage = driver.findElement(By.xpath("//div[text() = 'Hello "+inputPromptMessage+"! How are you today?'']"));
		
		if(promptAcceptMessage.getText().equals(promptAlertString)) {
			System.out.println("Prompt Alert Accepted and Input is passed");
		} else {
			System.out.println("Prompt alert is not matched with the input");
		}
		
		BrowserLaunch.waitForSeconds(5);
		
		driver.quit();

	}

}
