package com.Demoblaze.pages;

import org.openqa.selenium.WebDriver;

import com.Demoblaze.ObjectRepository.LoginPage_Obj;
import com.Demoblaze.ObjectRepository.SignupPage_Obj;
import com.Demoblaze.utilities.PageUtility;

import TestData.HomepageTestdata;

public class LoginPage extends PageUtility {

	PageUtility pageUtility;

	public LoginPage(WebDriver driver) {
		super(driver);
		pageUtility = new PageUtility(driver);
	}

	public void LoginFunctionality(String userName, String passWord) throws InterruptedException {
		LoginPage_Obj loginPage_Obj = new LoginPage_Obj();
		HomepageTestdata homepageTestdata = new HomepageTestdata();
		pageUtility.buttonClick(loginPage_Obj.Btn_login("Log in"));
		pageUtility.setData(loginPage_Obj.Ele_loginUsername("loginusername"), userName);
		pageUtility.setData(loginPage_Obj.Ele_loginPassword("loginpassword"), passWord);
		pageUtility.buttonClick(loginPage_Obj.Btn_loggedin("Log in"));
		pageUtility.scrollIntoViewAndClick(loginPage_Obj.Ele_Product("Samsung galaxy s6"));
		pageUtility.buttonClick(loginPage_Obj.Btn_addToCart("Add to cart"));
		pageUtility.action_acceptAlert();
		pageUtility.handleProductAddedAlert();

	}

}
