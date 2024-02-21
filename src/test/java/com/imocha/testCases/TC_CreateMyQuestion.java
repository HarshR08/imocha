package com.imocha.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.imocha.pageObjects.LoginPage;

public class TC_CreateMyQuestion extends BaseClass{
	@Test
	public void createMyQuestion() throws InterruptedException, IOException{
		
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		lp.setUserName(username);
		lp.clickContinue();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("login successfully");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Dashboard"));
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Dashboard";
		
		Assert.assertEquals(actualTitle, expectedTitle, "The page title is not matching hence quitting");
		
		WebElement threeDots = driver.findElement(By.xpath("//a[@class='nav-dot w-0px']")); // Locating the Main Menu (Parent element)
		Actions actions = new Actions(driver); //Instantiating Actions class
		actions.moveToElement(threeDots); //Hovering on main menu
		WebElement subMenu = driver.findElement(By.xpath("//ul[@class='nav-dot-menu']//li[@id='lnkMyQuestions']//a")); // Locating the element from Sub Menu
		actions.moveToElement(subMenu);
		
		actions.click().build().perform(); //build()- used to compile all the actions into a single step 
		boolean res = driver.getPageSource().contains("My Questions");
		
		if(res==true) {
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver,"createMyQuestion");
			Assert.assertTrue(false);
		}	
	}

}
