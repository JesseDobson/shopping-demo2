package org.naic.mfl.se.challenge.objectrepo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
	public static void clickLogout(WebDriver driver, WebDriverWait wait) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout"))).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
}
