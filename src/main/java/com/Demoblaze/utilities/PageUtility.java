package com.Demoblaze.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

public class PageUtility {

	protected WebDriver driver;
	private JavascriptExecutor javascriptExecutor;
	WebDriverWait wait;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		this.javascriptExecutor = (JavascriptExecutor) driver;
	}

	/**
	 * method to click button with given timeout
	 */

	public void buttonClick(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator))).click();
	}

	/**
	 * method to enter data with given timeout
	 */
	public void setData(By locator, String text) {
		WebDriverWait wait = getWait();
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}

	private WebDriverWait getWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	/**
	 * method to Accept Alert
	 */

	public void action_acceptAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait for alert
			wait.until(ExpectedConditions.alertIsPresent()); // Ensure alert is present
			driver.switchTo().alert().accept(); // Accept alert
			System.out.println("Alert accepted successfully.");
		} catch (Exception e) {
			System.out.println("No alert found or unable to accept alert: " + e.getMessage());
		}
	}

	/**
	 * method to Scroll to an element
	 */

	public void scrollIntoViewAndClick(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		int attempts = 3; // Retry up to 3 times if stale element exception occurs

		for (int i = 0; i < attempts; i++) {
			try {
				// Wait for the element to be present in the DOM
				WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

				// Scroll element into view
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

				// Wait for element to be clickable and click
				element = wait.until(ExpectedConditions.elementToBeClickable(locator));
				element.click();

				System.out.println("Clicked on element successfully: " + locator);
				return; // Exit loop if click is successful

			} catch (StaleElementReferenceException e) {
				System.out.println("Stale element encountered, retrying... Attempt " + (i + 1));
			} catch (Exception e) {
				System.out.println("Unable to click on element: " + locator + " | Exception: " + e.getMessage());
				break; // Exit loop on non-stale exceptions
			}
		}
	}

	/**
	 * method to handle product Alert
	 */
	public void handleProductAddedAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // Wait for the alert
			System.out.println("Product Added Alert Found: " + alert.getText());
			alert.accept(); // Accept the alert
			System.out.println("Product Added Alert Accepted.");
		} catch (NoAlertPresentException e) {
			System.out.println("No 'Product Added' alert present.");
		} catch (TimeoutException e) {
			System.out.println("Timed out waiting for 'Product Added' alert.");
		}
	}

}
