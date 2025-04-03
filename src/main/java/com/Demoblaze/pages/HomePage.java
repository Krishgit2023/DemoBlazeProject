package com.Demoblaze.pages;

import org.openqa.selenium.WebDriver;

import com.Demoblaze.ObjectRepository.CartPage_Obj;
import com.Demoblaze.ObjectRepository.LoginPage_Obj;
import com.Demoblaze.ObjectRepository.LogoutPage_Obj;
import com.Demoblaze.ObjectRepository.SignupPage_Obj;
import com.Demoblaze.utilities.PageUtility;

import TestData.CommonData;

public class HomePage extends PageUtility {

	PageUtility pageUtility;

	public HomePage(WebDriver driver) {
		super(driver);
		pageUtility = new PageUtility(driver);
	}

	// <summary>
	// Test Case Title : SignUp and do a purchase.
	// Automation ID : TC01_HomePage
	// </summary>

	public void TC01_HomePage() throws InterruptedException {
		SignupPage signupPage = new SignupPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		CartPage cartPage = new CartPage(driver);
		LogoutPage logoutPage = new LogoutPage(driver);
		LoginPage_Obj loginPage_Obj = new LoginPage_Obj();
		SignupPage_Obj signupPage_Obj = new SignupPage_Obj();
		CartPage_Obj cartPage_Obj = new CartPage_Obj();
		LogoutPage_Obj logoutPage_Obj = new LogoutPage_Obj();
		CommonData CommonData = new CommonData();

		// SignUp to DemoBlaze
		signupPage.SignupFunctionality(CommonData.UserName, CommonData.PassWord);

		// Login to demoBlaze and select product
		loginPage.LoginFunctionality(CommonData.UserName, CommonData.PassWord);

		// Navigate to cart and place order
		cartPage.checkoutFunctionality(CommonData.name, CommonData.country, CommonData.city, CommonData.card,
				CommonData.month, CommonData.year);

		// Logout and close the browser
		logoutPage.logoutFunctionality();

	}

}
