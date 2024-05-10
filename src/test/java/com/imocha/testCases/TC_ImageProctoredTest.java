package com.imocha.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.imocha.pageObjects.TestPlatform;

public class TC_ImageProctoredTest extends BaseClass {
	@Test
	public void IPTest() throws InterruptedException, IOException {
		TestPlatform lp1 = new TestPlatform(driver);

		driver.get("https://test.imocha.io/AuthenticateKey?id=da0792e2f2");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Test"));

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Test";

		Assert.assertEquals(actualTitle, expectedTitle, "The page title is not matching hence quitting");

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		lp1.setCandidateName(candname);
		lp1.setEmail(email);
		Thread.sleep(5000);
		lp1.clickCheckbox();
		lp1.clickAuthenticate();
		Thread.sleep(5000);
		logger.info("authentication done");

	}

}
