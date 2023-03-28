package com.imocha.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_CreateTest extends BaseClass {
	
	@Test
	public void createTest() {
		
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
		
		logger.info("My Tests Opened");
		
	}
	

}
