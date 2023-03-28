package com.imocha.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.imocha.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException, InterruptedException {

		driver.manage().window().maximize();
		
		logger.info("Url opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();

		Thread.sleep(5000);
		//assertTrue(driver.getTitle().contains("Dashboard"));
		
		if(driver.getTitle().equals("Dashboard")) {
		     Assert.assertTrue(true);
		     logger.info("Login test passed");
		}
		 else {
		     captureScreen(driver, "loginTest");
		     Assert.assertTrue(false);
		     logger.info("Login test failed");
		 }
		

		}

}