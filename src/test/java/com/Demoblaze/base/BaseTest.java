package com.Demoblaze.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Demoblaze.utilities.ScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	ScreenShot screenShot = new ScreenShot();

	@BeforeMethod
	@Parameters("Browser")
	public void initializeDriver(String browser) throws InterruptedException {
		if (browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup(); 
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true); 
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser type");
			return;
		}

		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");

		Thread.sleep(5000);

	}

	@AfterMethod(alwaysRun = true)
	public void terminateBrowser(ITestResult itestresult) {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			screenShot.takeScreenShot(driver, itestresult.getName());
		}
		driver.close();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
