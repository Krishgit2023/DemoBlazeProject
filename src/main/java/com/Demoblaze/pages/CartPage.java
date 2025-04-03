package com.Demoblaze.pages;

import org.openqa.selenium.WebDriver;

import com.Demoblaze.ObjectRepository.CartPage_Obj;
import com.Demoblaze.utilities.PageUtility;

public class CartPage extends PageUtility {

	PageUtility pageUtility;

	public CartPage(WebDriver driver) {
		super(driver);
		pageUtility = new PageUtility(driver);
	}

	public void checkoutFunctionality(String name, String country, String city, String card, String month, String year)
			throws InterruptedException {
		CartPage_Obj cartPage_Obj = new CartPage_Obj();
		pageUtility.buttonClick(cartPage_Obj.Btn_cart("Cart"));
		pageUtility.buttonClick(cartPage_Obj.Btn_placeOrder("Place Order"));
		pageUtility.setData(cartPage_Obj.Ele_orderName("name"), name);
		pageUtility.setData(cartPage_Obj.Ele_orderCountry("country"), country);
		pageUtility.setData(cartPage_Obj.Ele_orderCity("city"), city);
		pageUtility.setData(cartPage_Obj.Ele_orderCard("card"), card);
		pageUtility.setData(cartPage_Obj.Ele_orderMonth("month"), month);
		pageUtility.setData(cartPage_Obj.Ele_orderYear("year"), year);
		pageUtility.buttonClick(cartPage_Obj.Btn_purchase("Purchase"));
		pageUtility.buttonClick(cartPage_Obj.Btn_purchaseCompleted("OK"));
		driver.navigate().refresh();
	}

}
