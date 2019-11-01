package com.actitime.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
@FindBy(xpath="//div[text()='TASKS']")
private WebElement timeTracklbl;
public WebElement gettimeTracklbl()
{
return timeTracklbl;
}

@FindBy(xpath="//a[text()='Logout']")
private WebElement logoutlink;
public WebElement getlogoutlink()
{
return logoutlink;
}
}
