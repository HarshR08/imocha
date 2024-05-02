package com.imocha.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.imocha.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUername();
	public String password = readconfig.getPassword();
	public String firefoxpath = readconfig.getFirefoxPath();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = Logger.getLogger("BaseClass.class");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("driver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("driver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("edge")) {
			System.setProperty("driver.edge.driver", readconfig.getEdgePath());
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new EdgeDriver(options);
		}
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");

		System.out.println("user.dir");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
}
