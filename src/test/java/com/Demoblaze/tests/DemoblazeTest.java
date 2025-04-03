package com.Demoblaze.tests;

import com.Demoblaze.base.BaseTest;
import com.Demoblaze.pages.HomePage;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoblazeTest extends BaseTest {

	private static final Logger logger = LogManager.getLogger(DemoblazeTest.class);

	@Test
	public void TC01_DemoblazeTest() throws Exception {
		logger.info("Test Case Started: TC01_DemoblazeTest");

		try {
			HomePage homePage = new HomePage(getDriver()); 
			logger.info("Navigating to Home Page...");

			homePage.TC01_HomePage();
			logger.info("Successfully executed TC01_HomePage.");
		} catch (Exception e) {
			logger.error("Test Case Failed: " + e.getMessage(), e);
			throw e; 
		}

		logger.info("Test Case Completed: TC01_DemoblazeTest");
	}
}
