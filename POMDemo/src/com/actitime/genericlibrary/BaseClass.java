package com.actitime.genericlibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.actitime.objectrepository.Home;
import com.actitime.objectrepository.Login;
public class BaseClass{
	public static WebDriver driver=null;
	FileLib lib=new FileLib();
	WeDriverCommLib comlib=new WeDriverCommLib();
	
	
	@BeforeClass
	public void configBC() throws IOException
	{
		System.out.println("==========OPEN BROWSER===========");
		String browser=lib.getPropertyFileData("browser");
		if(browser.equals("firefox"))
		{
			//System.setProperty("WebDriver.gecko.driver", "./resources/geckodriver.exe");
		driver=new FirefoxDriver();
		}
		else if(browser.equals("chrome"))
		{
		
			driver=new ChromeDriver();
		}
	}
	@BeforeMethod
	public void configBM() throws IOException, InterruptedException
	{
		System.out.println("==========PERFORM LOG-IN===========");
		String url=lib.getPropertyFileData("url");
		String uname=lib.getPropertyFileData("UName");
		String password=lib.getPropertyFileData("Password");
		comlib.waitForPageLoad();
		driver.get(url);
		Login log=PageFactory.initElements(driver, Login.class);
		log.getUserEdt().sendKeys(uname);
		log.getPwdEdt().sendKeys(password);
		log.getLoginBtn().click();
		Thread.sleep(1000);
		Home hm=PageFactory.initElements(driver, Home.class);
		//comlib.waitForElementClickable(hm.gettimeTracklbl());
		Assert.assertEquals(hm.gettimeTracklbl().getText(), "TASKS");
		System.out.println("=========LOG-IN SUCCESS=========");
	}
	@AfterMethod
	public void configAM()
	{
		Home hm1=PageFactory.initElements(driver, Home.class);
		hm1.getlogoutlink().click();
		System.out.println("=========LOG-OUT SUCCESS==========");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("=========BROWSER CLOSE==========");
		driver.quit();
	}
}
