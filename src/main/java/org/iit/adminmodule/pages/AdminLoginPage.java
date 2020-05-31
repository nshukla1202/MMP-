package org.iit.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {
	WebDriver driver;


	By Adminusername=By.id("username");
	By Adminpassword=By.id("password");
	By SignInButton=By.name("admin");

	By AdminPortal=By.xpath("//h3[@class='panel-title']");

	public AdminLoginPage(WebDriver driver) {

		this.driver=driver;

	}

	public boolean LoginUser(String username,String password) throws InterruptedException {

		driver.findElement(Adminusername).sendKeys(username);

		driver.findElement(Adminpassword).sendKeys(password);
		driver.findElement(SignInButton);
		driver.findElement(SignInButton).click();
		Thread.sleep(2000);

		return driver.findElement(AdminPortal).isDisplayed();
	}




}
