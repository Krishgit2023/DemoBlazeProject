package com.Demoblaze.ObjectRepository;

import org.openqa.selenium.By;

public class LogoutPage_Obj {

	public By Btn_logout(String text) {
		return By.xpath("//a[contains(text(),'" + text + "')]");
	}

}
