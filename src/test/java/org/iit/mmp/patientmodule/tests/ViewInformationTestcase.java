package org.iit.mmp.patientmodule.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class ViewInformationTestcase {

	static WebDriver driver;
	


	@Test(description="US_005 View the Information",groups={"US_005","regression","sanity","patientmodule"})
	public void ValidateformationMsg() throws InterruptedException
	{
		instantiateDriver();
		launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		Login();
		NavigatetoInformationTab();
		ValidateText();
	}
	public void Launchsite()
	{
		instantiateDriver();
		launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");

	}
   @BeforeMethod
	public void instantiateDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
	}


	public void launchApplicationURL(String url)
	{
		driver.get(url);

	}

	@Parameters({"username","password"})
	@Test
	public void Login() throws InterruptedException 
	{

		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Test
	public void NavigatetoInformationTab() throws InterruptedException
	{
		//driver.findElement(By.xpath("//span[contains(text(),'Information')]")).click();

		System.out.println("Entering in this method");

		WebElement e=driver.findElement(By.xpath("//a[@href='information.php']"));


		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		e.click();


		System.out.println("Exiting from this method");


	}

	@Test
	public void ValidateText() throws InterruptedException 
	{

		SoftAssert sa=new SoftAssert();

		String expectedText="";

		String actualText= driver.findElement(By.xpath("//div[@class='panel-title']")).getText();
        System.out.println(" total "+ actualText);
		sa.assertEquals(actualText, expectedText);
        sa.assertAll();

	}

	@AfterMethod   
	public void CloseBrowser()
	{
		driver.close();
	}


}
