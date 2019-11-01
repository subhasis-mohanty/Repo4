package com.actitime.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Task {
	@FindBy(xpath="//a[text()='Projects & Customers']")
	private WebElement projandcuslink;
	@FindBy(xpath="//span[text()='Create Customer']")
	private WebElement crtcusbtn;
	@FindBy(xpath="//span[text()='Create Project']")
	private WebElement crtprojbtn;
	@FindBy(id="customerLightBox_nameField")
	private WebElement cusNmtxt;
	@FindBy(id="customerLightBox_descriptionField")
	private WebElement cusDesctxt;
	@FindBy(xpath="//div[@class='buttonIcon']//span[text()='Create Customer']")
	private WebElement crtcusinbtn;
	@FindBy(xpath="//span[@class='successmsg']")
	private WebElement cuscrtseccessmsg;
	public WebElement getprojandcuslink()
	{
		return projandcuslink;
	}
	
	public WebElement getcrtcusbtn()
	{
		return crtcusbtn;
	}
	public WebElement getcusNmtxt()
	{
		return cusNmtxt;
	}
	public WebElement getcusDesctxt()
	{
		return cusDesctxt;
	}
	public WebElement getcrtcusinbtn()
	{
		return crtcusinbtn;
	}
	public WebElement getcuscrtseccessmsg()
	{
		return cuscrtseccessmsg;
	}
}
