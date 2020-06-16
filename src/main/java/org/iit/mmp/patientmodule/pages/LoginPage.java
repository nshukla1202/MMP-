package org.iit.mmp.patientmodule.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	WebDriver driver;

	By usernameLocator=By.id("username");
	By passwordLocator=By.id("password");

	By ClickOnSignIn=By.name("submit");
	By UserFirstName =By.xpath("//i[@class='fa fa fa-dashboard']");

	public LoginPage(WebDriver driver) {

		this.driver=driver;

		//this means current class object.

	}


	public boolean LoginUser(String username,String password) throws InterruptedException {

		driver.findElement(usernameLocator).sendKeys(username);

		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(ClickOnSignIn);
		driver.findElement(ClickOnSignIn).click();
		Thread.sleep(2000);

		return driver.findElement(UserFirstName).isDisplayed();





	}
	
	public boolean randomLogin(String username,String password)
	{
		driver.findElement(usernameLocator).sendKeys(username);

		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(ClickOnSignIn).click();
		return driver.switchTo().alert() != null;
		
	}
	
	

	public void CloseBrowser()
	{
		driver.close();
	}


	

}






