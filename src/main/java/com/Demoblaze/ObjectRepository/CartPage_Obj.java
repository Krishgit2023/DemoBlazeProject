package com.Demoblaze.ObjectRepository;

import org.openqa.selenium.By;

public class CartPage_Obj {

	public By Btn_cart(String text) {
		return By.xpath("//a[contains(text(),'" + text + "')]");
	}

	public By Btn_placeOrder(String text) {
		return By.xpath("//button[contains(text(),'" + text + "')]");
	}

	public By Ele_orderName(String text) {
		return (By.xpath("//input[@id='" + text + "']"));
	}

	public By Ele_orderCountry(String text) {
		return (By.xpath("//input[@id='" + text + "']"));
	}

	public By Ele_orderCity(String text) {
		return (By.xpath("//input[@id='" + text + "']"));
	}

	public By Ele_orderCard(String text) {
		return (By.xpath("//input[@id='" + text + "']"));
	}

	public By Ele_orderMonth(String text) {
		return (By.xpath("//input[@id='" + text + "']"));
	}

	public By Ele_orderYear(String text) {
		return (By.xpath("//input[@id='" + text + "']"));
	}

	public By Btn_purchase(String text) {
		return By.xpath("//button[contains(text(),'" + text + "')]");
	}

	public By Btn_purchaseCompleted(String text) {
		return By.xpath("//button[contains(text(),'" + text + "')]");
	}

}
