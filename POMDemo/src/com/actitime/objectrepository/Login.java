package com.actitime.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
@FindBy(id="username")
private WebElement userEdt;
@FindBy(name="pwd")
private WebElement pwdEdt;
@FindBy(id="loginButton")
private WebElement loginBtn;

public WebElement getUserEdt()
{
	return userEdt;
}
public WebElement getPwdEdt()
{
	return pwdEdt;
}
public WebElement getLoginBtn()
{
	return loginBtn;
}
}
