package com.actitime.taskTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.genericlibrary.BaseClass;
import com.actitime.objectrepository.Home;
import com.actitime.objectrepository.Task;
@Listeners(com.actitime.genericlibrary.ListenerImp.class)
public class TaskTest extends BaseClass{
	
	@Test(dataProvider="getExcelData",dataProviderClass=com.actitime.genericlibrary.FileLib.class)
	public void createCustomerTest(String cusName,String cusDesc)
	{
		
		Home home=PageFactory.initElements(driver, Home.class);
		home.gettimeTracklbl().click();
		//Thread.sleep(1000);
		System.out.println("===========TASK CLICK=========");
		Task tsk=PageFactory.initElements(driver,Task.class);
		tsk.getprojandcuslink().click();
		System.out.println("===========PROJECTS AND CUSTOMERS CLICK=========");
		tsk.getcrtcusbtn().click();
		tsk.getcusNmtxt().sendKeys(cusName);
		tsk.getcusDesctxt().sendKeys(cusDesc);
		tsk.getcrtcusinbtn().click();
		String esptVal="Customer \""+cusName+"\""+" has been successfully created.";
		Assert.assertEquals(tsk.getcuscrtseccessmsg().getText(), esptVal);
		System.out.println("========CUSTOMER CREATE SUCCESSFULLY=========");
	}

}
