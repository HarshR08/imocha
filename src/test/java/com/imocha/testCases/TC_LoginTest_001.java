package com.imocha.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.imocha.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException, InterruptedException {

		LoginPage lp1 = new LoginPage(driver);
		driver.manage().window().maximize();
		lp1.setUserName(username);
		lp1.clickContinue();
		Thread.sleep(5000);
		lp1.setPassword(password);
		lp1.clickSubmit();
		logger.info("login successfully");

        // Add explicit wait after login process completes
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust the timeout as per your requirement
        wait.until(ExpectedConditions.titleContains("Dashboard"));

        if(driver.getTitle().contains("Dashboards")) {
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
