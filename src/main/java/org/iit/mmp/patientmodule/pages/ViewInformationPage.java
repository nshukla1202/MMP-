package org.iit.mmp.patientmodule.pages;

import java.util.concurrent.TimeUnit;

import org.iit.mmp.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ViewInformationPage extends TestBase {

	WebDriver driver;


	By  Navigate_InformationTab= By.xpath("//a[@href='information.php']");
	By ValidateText=By.xpath("//div[@class='panel-title']");



	public ViewInformationPage(WebDriver driver) 
	{

		this.driver=driver;
	}
	//@Test
	public void NavigatetoAndClickInformationTab() throws InterruptedException
	{


		driver.findElement(Navigate_InformationTab).click();

	}


	//@Test
	public void validateText() throws InterruptedException 
	{



		ViewInformationPage ViewinfoPage= new ViewInformationPage(driver);
		SoftAssert sa=new SoftAssert();
		String actualText=driver.findElement(ValidateText).getText();

		String expectedText="Manage My Patient (MMP) is a medical practice management solution that boosts productivity by automating the day-to-day tasks that can slow an office manager down. Central delivers much more than medical billing software. Sure, it has the tools to help generate cleaner claims and reduce denials, but our easy-to-use practice management software also streamlines your workflow to deliver seamless handoffs across departments.\r\n" + 
				"Manage My Patient (MMP) becomes your practice’s command center, delivering robust, real-time analytics through customizable reports and dashboards to ensure you know how your business is performing on the metrics that matter most.";

		sa.assertEquals(actualText, expectedText);


		

	}






}
