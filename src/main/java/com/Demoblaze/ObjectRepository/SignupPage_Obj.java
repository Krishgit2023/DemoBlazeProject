package com.Demoblaze.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage_Obj {

	public By Btn_Signup(String text) {
		return By.xpath("//a[contains(text(),'" + text + "')]");
	}

	public By Ele_usernameField(String text) {
		return By.xpath("//input[@id='" + text + "']");
	}

	public By Ele_passwordField(String text) {
		return By.xpath("//input[@id='" + text + "']");
	}

	public By Btn_SignUp(String text) {
		return By.xpath("//button[contains(text(),'" + text + "')]");
	}

}
