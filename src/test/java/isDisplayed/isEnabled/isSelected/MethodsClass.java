package isDisplayed.isEnabled.isSelected;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import browserlaunch.BrowserLaunch;
import browserlaunch.CustomBrowserLaunch;

public class MethodsClass {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = CustomBrowserLaunch.getCustomChromeDriver();
		
		driver.get("https://www.facebook.com/");
		BrowserLaunch.waitForSeconds(3);
		
		WebElement createNewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		
		System.out.println(createNewAccount.isDisplayed());
		createNewAccount.click();
		BrowserLaunch.waitForSeconds(3);
		
		WebElement genderInput = driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input"));
		
		System.out.println(genderInput.isSelected());
		System.out.println(genderInput.isEnabled());
		genderInput.click();	
		BrowserLaunch.waitForSeconds(3);
	
		System.out.println(genderInput.getAttribute("checked")); 
		

		System.out.println(genderInput.isSelected());
		System.out.println(genderInput.isEnabled());
		System.out.println(genderInput.getAttribute("checked"));
		BrowserLaunch.waitForSeconds(3);
		
		
		driver.quit();

	}

}
