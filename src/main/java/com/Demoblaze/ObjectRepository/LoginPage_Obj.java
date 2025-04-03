package com.Demoblaze.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_Obj {

	public By Btn_login(String text) {
		return By.xpath("//a[contains(text(),'" + text + "')]");
	}

	public By Ele_loginUsername(String text) {
		return By.xpath("//input[@id='" + text + "']");
	}

	public By Ele_loginPassword(String text) {
		return By.xpath("//input[@id='" + text + "']");
	}

	public By Btn_loggedin(String text) {
		return By.xpath("//button[contains(text(),'" + text + "')]");
	}

	public By Ele_Product(String text) {
		return By.xpath("//a[contains(text(),'" + text + "')]");
	}

	public By Btn_addToCart(String text) {
		return By.xpath("//a[contains(text(),'" + text + "')]");
	}

}
