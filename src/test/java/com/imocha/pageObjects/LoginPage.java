package com.imocha.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//input[@id='EmailId']")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(xpath = "//input[@id='Password']")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='frmSubmitBtn']")
	@CacheLookup
	WebElement btnContinue;

	@FindBy(xpath = "//input[@value='Login']")
	@CacheLookup
	WebElement btnLogin;

	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickContinue() {
		btnContinue.click();
	}

	public void clickSubmit() {
		btnLogin.click();
	}

}
