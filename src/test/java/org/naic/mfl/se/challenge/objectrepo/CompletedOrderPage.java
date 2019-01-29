package org.naic.mfl.se.challenge.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompletedOrderPage {

	public static void waitOrderConfirmationHeader(WebDriver driver, WebDriverWait wait) {
		// TODO Auto-generated method stub
		
	}

	public static String getHeading(WebDriver driver, WebDriverWait wait) {
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		
		return heading.getText();
	}

	public static boolean verifyShipping4thStep(WebDriver driver, WebDriverWait wait) {
		
		return driver.findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed();
	}

	public static boolean verifyPayment5thStep(WebDriver driver, WebDriverWait wait) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed();
	}

	public static boolean verifyOrderCompleteMessage(WebDriver driver, String message) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText().contains(message);
	}

	public static boolean verifyOrderCompleteController(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl().contains("controller=order-confirmation");
	}

}
