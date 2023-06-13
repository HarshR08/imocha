package com.imocha.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.imocha.pageObjects.LoginPage;


public class TC_CreateTest extends BaseClass {
	
	@Test
	public void createTest() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("login successfully");
		
		Thread.sleep(5000);
		
		// Locating the Main Menu (Parent element)
		WebElement myTest = driver.findElement(By.xpath("//span[normalize-space()='My Tests']"));

		//Instantiating Actions class
		Actions actions = new Actions(driver);

		//Hovering on main menu
		actions.moveToElement(myTest);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.xpath("//li[@id='lnkMytestmenu']//a[normalize-space()='My Tests']"));

		//To mouseover on sub menu
		actions.moveToElement(subMenu);

		//build()- used to compile all the actions into a single step 
		actions.click().build().perform();
		
		boolean res = driver.getPageSource().contains("My Tests");
		
		if(res==true) {
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver,"createTest");
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.cssSelector("#btnCreateNewTest")).click();
		logger.info("clicked on create new test");
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("div[id='section2'] div h3[class='mb-1 mt-1']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("#TestName")).sendKeys("Image Proctoring");
		Thread.sleep(5000);
		logger.info("entered name");
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/button[1]")).click();
		logger.info("clicked create test");
		
		Thread.sleep(10000);
		
		
	}
	

}
