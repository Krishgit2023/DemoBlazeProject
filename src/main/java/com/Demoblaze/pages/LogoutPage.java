package com.Demoblaze.pages;

import org.openqa.selenium.WebDriver;

import com.Demoblaze.ObjectRepository.LogoutPage_Obj;
import com.Demoblaze.utilities.PageUtility;

public class LogoutPage extends PageUtility {

	PageUtility pageUtility;

	public LogoutPage(WebDriver driver) {
		super(driver);
		pageUtility = new PageUtility(driver);
	}

	public void logoutFunctionality() {
		LogoutPage_Obj logoutPageObj = new LogoutPage_Obj();
		pageUtility.buttonClick(logoutPageObj.Btn_logout("Log out"));

	}

}
