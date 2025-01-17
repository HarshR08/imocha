package com.imocha.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
		lp.clickContinue();
		Thread.sleep(5000);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("login successfully");

		Thread.sleep(5000);
		WebElement myTest = driver.findElement(By.xpath("//span[normalize-space()='My Tests']")); // Locating the Main
																									// Menu (Parent
																									// element)

		Actions actions = new Actions(driver); // Instantiating Actions class
		actions.moveToElement(myTest); // Hovering on main menu
		WebElement subMenu = driver
				.findElement(By.xpath("//ul[@class='nav']//li[@id='lnkMyTests']//ul//a[normalize-space()='My Tests']")); // Locating
																															// the
																															// element
																															// from
																															// Sub
																															// Menu
		actions.moveToElement(subMenu);

		actions.click().build().perform(); // build()- used to compile all the actions into a single step
		boolean res = driver.getPageSource().contains("My Tests");

		if (res == true) {
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "createTest");
			Assert.assertTrue(false);
		}

		driver.findElement(By.cssSelector("#btnCreateNewTest")).click();
		logger.info("clicked on create new test");
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("div[id='section1'] div h3[class='mb-1 mt-1']")).click();
		Thread.sleep(5000);

//		driver.findElement(By.cssSelector("#TestName")).sendKeys("Image Proctoring");
//		Thread.sleep(5000);
//		logger.info("entered name");
//		
//		driver.findElement(By.cssSelector("#btnCreateTest")).click();
//		logger.info("clicked create test");
//		
//		Thread.sleep(10000);
//		
//		driver.findElement(By.cssSelector(".btn.btn-secondary-imocha.pull-right.mt-0-5")).click();
//		logger.info("clicked on add skill button");
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		Select drpQtype = new Select(driver.findElement(By.cssSelector("#QuestionType")));
//		drpQtype.selectByVisibleText("MCQs, MAQs, Descriptive, File Upload, FIB, T/F");
//
//		Thread.sleep(5000);
//		Select drpStype = new Select(driver.findElement(By.id("select2-SelectSkills-container")));
//		drpStype.selectByIndex(0);

//		WebElement dropdownElement = driver.findElement(By.cssSelector("div[id='section1'] span[role='combobox']"));
//		
//		Select readyTest = new Select(dropdownElement);
//		readyTest.selectByIndex(2);

		driver.findElement(By.cssSelector("div[id='section1'] span[role='combobox']")).click();
		Thread.sleep(5000);

		WebElement inputField = driver.findElement(By.cssSelector("input[role='textbox']"));

		String inputString = "Account Executive";
		inputField.sendKeys(inputString);
		logger.info("entered the test name");

		inputField.sendKeys(Keys.ENTER);
		logger.info("pressed enter");
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("#btnCreateTest")).click();
		logger.info("clicked create test");
		Thread.sleep(10000);

		driver.findElement(By.cssSelector("#publishtestbtn")).click();
		Thread.sleep(5000);
		logger.info("publish button clicked");

		driver.findElement(By.cssSelector("#publish-test-yes")).click();
		Thread.sleep(5000);
		logger.info("Publish test clicked");

		driver.findElement(By.cssSelector("#InviteCandidatesTab")).click();
		Thread.sleep(3000);
		logger.info("Invite tab clicked");

		driver.findElement(By.xpath("//u[@id='btnCreateNewLink']")).click();
		Thread.sleep(3000);
		logger.info("Create new link clicked");

		driver.findElement(By.cssSelector("#LinkName")).sendKeys("New Link");
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("input[value='0']")).click();
		logger.info("Open Link radio button clicked");

		driver.findElement(By.cssSelector("#btnCreateLink")).click();
		Thread.sleep(3000);
		logger.info("Save button clicked");

		// Check if the expected text is present in the modal
		String modalText = driver.findElement(By.cssSelector("div[id='inviteDemo'] div[class='modal-content']"))
				.getText();
		boolean isTextPresent = modalText.contains("Test link");

		// Example assertion based on modal text
		if (isTextPresent) {
			Assert.assertTrue(true);
			logger.info("Modal text assertion passed");
		} else {
			captureScreen(driver, "createTest");
			Assert.assertTrue(false);
			logger.info("Modal text assertion failed");
		}

	}

}