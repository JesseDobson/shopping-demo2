package org.naic.mfl.se.challenge.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingOptionsPage {

	public static void proceed(WebDriver driver, WebDriverWait wait) {
		
		driver.findElement(By.name("processCarrier")).click();	
		
	}

	public static void agree(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();
		
	}

}
