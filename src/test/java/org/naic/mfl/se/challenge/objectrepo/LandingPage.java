package org.naic.mfl.se.challenge.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	public static WebElement returnHeading(WebDriver driver, WebDriverWait wait) {
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		return heading;
	}

	public static String getHeadingText(WebDriver driver) {
		return driver.findElement(By.className("page-heading")).getText();
		
	}

	public static void waitForVisibilityofHeaderThenClick(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'My account')]"))).click();
		
	}

	public static String getFullName(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.className("account")).getText();
	}

	public static boolean getAccountWelcome(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.className("info-account")).getText().contains("Welcome to your account.");
	}

	public static boolean verifyLogoutButton(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.findElement(By.className("logout")).isDisplayed();
	}

	public static boolean verifyUrlContainsController(WebDriver driver) {
		return driver.getCurrentUrl().contains("controller=my-account");
	}

	public static void clickLink(WebDriver driver, WebDriverWait wait, String linkText) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText))).click();
		
	}
	
}
