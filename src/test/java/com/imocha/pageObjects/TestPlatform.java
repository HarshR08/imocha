package com.imocha.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPlatform {

	WebDriver ldriver;

	public TestPlatform(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Enter full name']")
	@CacheLookup
	WebElement txtCandidateName;

	@FindBy(xpath = "//input[@placeholder='Enter email address']")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(xpath = "(//input[@title='consent'])[1]")
	@CacheLookup
	WebElement checkBox;

	@FindBy(xpath = "//button[normalize-space()='Authenticate']")
	@CacheLookup
	WebElement btnAuthenticate;

	public void setCandidateName(String name) {
		txtCandidateName.sendKeys(name);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void clickCheckbox() {
		checkBox.click();
	}

	public void clickAuthenticate() {
		btnAuthenticate.click();
	}

}
