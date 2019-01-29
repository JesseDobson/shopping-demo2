package org.naic.mfl.se.challenge.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentDetailsPage {

	public static void selectPaymentType(WebDriver driver, WebDriverWait wait, String paymentType) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(paymentType))).click();
		
	}

}
