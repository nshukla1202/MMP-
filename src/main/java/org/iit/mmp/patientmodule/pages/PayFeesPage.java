package org.iit.mmp.patientmodule.pages;

import org.iit.mmp.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PayFeesPage {
	WebDriver driver;
	Utility util;
	
	
	
	By PayNow=By.xpath("//button[contains(text(),'Pay Now')]");
	By EnterPayment=By.xpath("//select[@id='amount']");
    By Conituebtn=By.xpath("//input[@type='submit']");
    By nameId=By.id("name");
    By cardName=By.id("card_name");
    By cardNumber=By.id("cid");
    By ExpirationDate=By.xpath("//select[@id='cardMonth']/option[@value='07']");
    By month=By.xpath("//select[@id='cardMonth']/option[@value='07']");
    By ExpirationMonth=By.id("cardMonth");
   //  By ExpirationYear=By.xpath("//select[@id='cardYear']/option[@value='25']");
    By ExpirationYear=By.id("cardYear");
    By EnterCvv=By.id("cvv");
    By Submitbutton=By.xpath("//input[@type='button']");
  
    		

	public  PayFeesPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void ClickOnPayNow() {
		// TODO Auto-generated method stub
		driver.findElement(PayNow).click();
		
	}

	public void SelectPayment()
	{
		//driver.findElement(EnterPayment).click();
		String amount="$11";
		new Select(driver.findElement(EnterPayment)).selectByVisibleText(amount);
		
	}
	
	public void ClickOnContinue() {
		driver.findElement(Conituebtn).click();
		
	}
	
	public void CardDetails() throws InterruptedException {
		
		driver.findElement(nameId).sendKeys("User Test");
		String card="Visa";
		new Select(driver.findElement(cardName)).selectByVisibleText(card);
		
		driver.findElement(cardNumber).sendKeys("4111111111111111");
		Thread.sleep(3000);
	  // new Select(driver.findElement(month)).selectByIndex(6);
		driver.findElement(ExpirationDate).click();
		//String month="July(07)";
		System.out.println("month");
		//new Select(driver.findElement(ExpirationMonth)).getAllSelectedOptions();
		
	//List<WebElement> listMonth=
		new Select(driver.findElement(month)).selectByVisibleText("July(07)");
		//String year="2025";
		driver.findElement(ExpirationYear).click();
		new Select(driver.findElement(ExpirationYear)).selectByVisibleText("2025");
		driver.findElement(EnterCvv).sendKeys("123");
		Thread.sleep(2000);
		driver.findElement(Submitbutton).click();
	}
	
	
	

}
