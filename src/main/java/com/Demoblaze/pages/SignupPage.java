package com.Demoblaze.pages;

import org.openqa.selenium.WebDriver;

import com.Demoblaze.ObjectRepository.SignupPage_Obj;
import com.Demoblaze.utilities.PageUtility;

public class SignupPage extends PageUtility {

	PageUtility pageUtility;

	public SignupPage(WebDriver driver) {
		super(driver);
		pageUtility = new PageUtility(driver);
	}

	public void SignupFunctionality(String userName, String passWord) throws InterruptedException {
		SignupPage_Obj signupPage_Obj = new SignupPage_Obj();
		pageUtility.buttonClick(signupPage_Obj.Btn_Signup("Sign up"));
		pageUtility.setData(signupPage_Obj.Ele_usernameField("sign-username"), userName);
		pageUtility.setData(signupPage_Obj.Ele_passwordField("sign-password"), passWord);
		pageUtility.buttonClick(signupPage_Obj.Btn_SignUp("Sign up"));
		pageUtility.action_acceptAlert();
	}
}
